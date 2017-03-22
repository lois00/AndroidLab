package cl.fjnu.edu.cn.android_lab.lab3_UITest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.fjnu.edu.cn.R;


public class Aty_SimpleAdapter extends AppCompatActivity {

    //定义两个数组，分别存放listitem中的姓名数据和头像数据
    private String[] names = new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] headers = new int[]
            {R.drawable.lion, R.drawable.tiger,R.drawable.monkey,R.drawable.dog
                    ,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_simple_adapter_main);

        //创建一个list集合，集合中存放map集合
        final List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i=0;i<names.length;i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("name", names[i]);
            listItem.put("header",headers[i]);
            listItems.add(listItem);
        }

        //创建一个simpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.aty_simple_adapter
                ,new String[]{"name","header"},new int[]{R.id.name,R.id.header});
        ListView list = (ListView) findViewById(R.id.myList);
        list.setAdapter(simpleAdapter);
        //给listitem设置监听事件
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String info = parent.getItemAtPosition(position).toString();
                //截取item中的姓名信息
                int begin = info.lastIndexOf("=");
                int end = info.lastIndexOf("}");
                String result = info.substring(begin+1,end);
                //使用自定义的Toast工具类来显示toast信息
                ToastUtil.showToast(getApplicationContext(), result);
            }
        });
    }

}
