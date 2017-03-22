package cl.fjnu.edu.cn.android_lab.lab3_UITest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.fjnu.edu.cn.R;


public class Aty_ContextMenuActionMode extends AppCompatActivity {

    private MyAdapter myAdapter;
    private ListView mListView;

    //定义两个数组，分别存放listitem中的图标和数据
    private String[] nums = new String[]
            {"One", "Two", "Three", "Four", "Five", "six", "seven", "eight"};
    private int[] icons = new int[]
            {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
                    , R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
                    , R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_context_menu_action_mode_main);
        mListView = (ListView) findViewById(R.id.contextList);

        //创建一个list集合，集合中存放map集合
        final List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < nums.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("icon", icons[i]);//在map集合中加入图标
            listItem.put("num", nums[i]);//在map集合中加入文本
            listItems.add(listItem);
        }

        //创建一个自定义的适配器
        myAdapter = new MyAdapter(Aty_ContextMenuActionMode.this, listItems
                , R.id.aty_context_menu_action_mode
                , new String[]{"icon", "num"}, new int[]{R.id.num, R.id.icon});
        mListView.setAdapter(myAdapter);//给listview设置适配器

        MultiChoiceListener mMultiChoiceListener = new MultiChoiceListener();
        mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);//设置多选模式
        mListView.setMultiChoiceModeListener(mMultiChoiceListener);//设置多选模式监听器
    }

    //自定义多选监听器类，继承自AbsListView.MultiChoiceModeListener
    class MultiChoiceListener implements AbsListView.MultiChoiceModeListener{

        private TextView mSelectedItemCount;//显示已选中列表项的数目
        private View mMultiSelectionbarView;//actionmode上下文菜单布局中的view对象
        private boolean allCheckedMode;//是否为全选模式

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Log.d("tag","onCreateActionMode");
            allCheckedMode = false;
            mode.getMenuInflater().inflate(R.menu.actionmode,menu);
            if(mMultiSelectionbarView == null){
                mMultiSelectionbarView = LayoutInflater.from(Aty_ContextMenuActionMode.this)
                        .inflate(R.layout.actionmode_custom_view,null,false);//加载actionmode上下文菜单的布局
                mSelectedItemCount = (TextView)mMultiSelectionbarView.findViewById(R.id.item_select_count);
            }
            mode.setCustomView(mMultiSelectionbarView);
            mSelectedItemCount.setText(myAdapter.getCheckedItemCount()+"");//设置菜单文本内容
            ((TextView)mMultiSelectionbarView.findViewById(R.id.titleInfo)).setText(" selected");
            return true;
        }

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            Log.d("tag","onItemCheckedStateChanged");
            int checkedCount = 0;
            if(allCheckedMode){//如果处于全选模式，则已选择项取消选中；未选择项设为选中
                if(checked){
                    myAdapter.getItemState()[position] = 0;
                }else{
                    myAdapter.getItemState()[position] = 1;
                }
                checkedCount = myAdapter.getCheckedItemCount();
            }else {//如果处于非全选模式，则将当前选择项设为选中
                if(checked){
                    myAdapter.getItemState()[position] = 1;
                }else{
                    myAdapter.getItemState()[position] = 0;
                }
                checkedCount = myAdapter.getCheckedItemCount();
            }
            mSelectedItemCount.setText(checkedCount+"");//改变已选中列表项的数目值
            myAdapter.setItemMultiCheckable(true);//设置checkbox为可见
            myAdapter.notifyDataSetChanged();//当适配器内容改变时强制调用getView来刷新每个item的内容
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//            Log.d("tag","onActionItemClicked");
            switch (item.getItemId()){
                case R.id.menu_chooseAll://单击全选菜单
                    myAdapter.setItemMultiCheckable(true);
                    if(myAdapter.isAllChecked()){//如果已全选，则置为全不选
                        myAdapter.unCheckAll();
                        mListView.clearChoices();//清除所有选择
                        mode.finish();
                    } else {//否则，全选listitem
                        myAdapter.checkAll();
                        for(int i = 0;i<myAdapter.getCount();i++){
                            mListView.setSelection(i);
                        }
                        allCheckedMode = true;//全选模式置为true
                    }
                    myAdapter.notifyDataSetChanged();
                    mSelectedItemCount.setText(myAdapter.getCheckedItemCount()+"");//更新已选listitem的数目值
                    break;
                case R.id.menu_delete://单击删除菜单
                    myAdapter.deleteSelectedItems();
                    myAdapter.notifyDataSetChanged();
                    mode.finish();
                    break;
                default:
                    myAdapter.setItemMultiCheckable(false);
                    break;
            }
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//            Log.d("tag","onPrepareActionMode");
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
//            Log.d("tag","onDestroyActionMode");
            allCheckedMode = false;//全选模式置否
            myAdapter.unCheckAll();//所有listItem置为未选中
            myAdapter.setItemMultiCheckable(false);//退出actionmode模式时，将checkbox隐藏
        }
    }
}

//    private ActionMode.Callback amCallback = new ActionMode.Callback(){
//        @Override
//        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//            MenuInflater inflater = mode.getMenuInflater();
//            inflater.inflate(R.menu.actionmode,menu);
//            text = findViewById(R.id.showText);
//            return true;
//        }
//
//        @Override
//        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//            return false;
//        }
//
//        @Override
//        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//            boolean flag =false;
//            switch(item.getItemId()){
//                case R.id.showText:
//                    Toast.makeText(Aty_ContextMenuActionMode.this,"showText",Toast.LENGTH_SHORT).show();
//                    flag=true;
//                    break;
//                case R.id.menu_select:
//                    Toast.makeText(Aty_ContextMenuActionMode.this,"select",Toast.LENGTH_SHORT).show();
//                    flag = true;
//                    break;
//                case R.id.menu_delete:
//                    Toast.makeText(Aty_ContextMenuActionMode.this,"delete",Toast.LENGTH_SHORT).show();
//                    flag=true;
//                    break;
//            }
//
//            return flag;
//        }
//
//        @Override
//        public void onDestroyActionMode(ActionMode mode) {
//
//        }
//    };



