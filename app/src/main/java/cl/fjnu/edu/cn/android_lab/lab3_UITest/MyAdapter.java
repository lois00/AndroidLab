package cl.fjnu.edu.cn.android_lab.lab3_UITest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import cl.fjnu.edu.cn.R;


/**
 * Created by Administrator on 2017-03-18.
 */

public class MyAdapter extends SimpleAdapter {//自定义MyAdapter类，继承自SimpleAdapter

    private List<Map<String,Object>> mList;//listview列表，存放map集合，其中包含图标和文本内容
    private Context mContext;//上下文环境变量
    private int[] mItemState;//用来记录item的状态，1表示选中，0表示未选中
    private boolean itemMultiCheckable = false;//listItem的多选框是否可见

    static class ViewHolder {//自定义控件集合
        ImageView vhIcon;//列表项中的图片
        TextView vhNum;//列表项中的文本
        CheckBox vhItem_selected;//列表项中的多选框
    }
    public MyAdapter(Context context, List<Map<String,Object>> data, int resource,
                      String[] from, int[] to) {
        super(context, data, resource, from, to);
        mList = data;
        mContext = context;
        mItemState = new int[mList.size()];
        for(int i=0; i<mItemState.length;i++){
            mItemState[i]=0;//初始化item的状态为未选中
        }
    }

    /**
     *    ListView中的每一个Item显示都需要Adapter调用一次getView的方法，这个方法会传入一个convertView的参数，
     * 返回的View就是这个Item显示的View。
     *    如果当Item的数量足够大，再为每一个Item都创建一个View对象，必将占用很多内存，创建View对象
     * （mInflater.inflate(R.layout.lv_item, null);从xml中生成View，这是属于IO操作）也是耗时操作，
     * 所以必将影响性能。Android提供了一个叫做Recycler(反复循环器)的构件，就是当ListView的Item从上方
     * 滚出屏幕视角之外，对应Item的View会被缓存到Recycler中，相应的会从下方生成一个Item，而此时调用的
     * getView中的convertView参数就是滚出屏幕的Item的View，所以说如果能重用这个convertView，就会大大改善性能。
     *    一个屏幕最多显示7个Item，如果当Item1滑出屏幕，此时Item1 的View被添加进Recycler中，相应的在下部要
     * 产生一个Item8，这时调用getView方法，convertView参数就是Item1 的View。
     *    在getView方法中的操作是这样的：先从xml中创建view对象（inflate操作，我们采用了重用convertView方法优化），
     * 然后在这个view去findViewById，找到每一个子View，如：一个TextView等。这里的findViewById操作是一个
     * 树查找过程，也是一个耗时的操作，所以这里也需要优化，就是使用viewHolder，把每一个子View都放在Holder中，
     * 当第一次创建convertView对象时，把这些子view找出来。然后用convertView的setTag将viewHolder设置到Tag中，
     * 以便系统第二次绘制ListView时从Tag中取出。当第二次重用convertView时，只需从convertView中getTag取出来就可以。
     *
     * @param position  当前item的位置
     * @param convertView  滑出屏幕的item的View
     * @param parent
     * @return  返回item要显示的view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        /**
         * 当convertView为空，即初始化创建时，我们就将生成的布局利用setTag()保存在convertView中，
         * 当convertView利用回收机制回收过来让我们再次使用时，我们通过getTag()将保存的布局取出来，
         * 重新将布局里的各个控件重新赋值就可以了。这里就利用了android-listView的回收机制。
         */
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.aty_context_menu_action_mode, parent, false);//加载布局
            vh.vhNum = (TextView) convertView.findViewById(R.id.num);//初始化控件容器集合
            vh.vhIcon = (ImageView) convertView.findViewById(R.id.icon);
            vh.vhItem_selected = (CheckBox)convertView.findViewById(R.id.item_select);
            convertView.setTag(vh);//设置控件集到convertView
        } else {
            vh = (ViewHolder) convertView.getTag();//取出缓存的布局重新给布局里的各个控件赋值
        }
        //设置checkbox是否可见
        if(itemMultiCheckable){
            vh.vhItem_selected.setVisibility(View.VISIBLE);
            if(getItemState()[position] == 1){
                vh.vhItem_selected.setChecked(true);
            }else{
                vh.vhItem_selected.setChecked(false);
            }
        }else{
            vh.vhItem_selected.setVisibility(View.GONE);
        }
        //控件赋值
        vh.vhIcon.setImageResource(R.mipmap.ic_launcher);//设置列表项中显示的图标
        vh.vhNum.setText(getItem(position));//设置列表项中显示的文本内容
        return convertView;
    }

    @Override
    public int getCount() {//返回列表项的数目
        return mList.size();
    }

    public int[] getItemState(){//返回当前listItem的状态数组
        return mItemState;
    }

    public  int getCheckedItemCount(){//返回被选中的列表项的数目
        int count = 0;
        for(int i : mItemState){
            if(i == 1)
                count++;
        }
        return  count;
    }

    public void setItemMultiCheckable(boolean flag) {
        itemMultiCheckable = flag;
    }

    @Override
    public long getItemId(int position) {//返回列表项ID
        return position;
    }

    @Override
    public String getItem(int position) {//返回指定列表项的文本内容
        Map<String,Object> item = mList.get(position);
        String value = (String)item.get("num");//获取列表项的num数值
        return value;
    }

    public void checkAll() {//全选所有列表项
        for (int i = 0; i < mItemState.length; i++) {
            mItemState[i] = 1;
        }
    }

    public void unCheckAll() {//全不选所有列表项
        for (int i = 0; i < mItemState.length; i++) {
            mItemState[i] = 0;
        }
    }

    public boolean isAllChecked() {//判断是否所有列表项都被选中
        for (int i : mItemState) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    public void deleteSelectedItems() {//删除所有被选中列表项
        for (int i = mItemState.length - 1; i >= 0; i--) {
            if (mItemState[i] == 1) {//判断如果该列表项已被选中，则将它从列表中移除
                mList.remove(i);
            }
        }
        notifyDataSetChanged();//刷新item列表
        mItemState = new int[mList.size()];
        for (int i : mItemState) {
            i = 0;//重置当前剩余列表项为未选中
        }
    }
}

