package cl.fjnu.edu.cn.android_lab.lab5_IntentTest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cl.fjnu.edu.cn.R;

public class Aty_ImplicitIntent extends AppCompatActivity {
    private EditText etUrl;
    private Button btnLoadUrl;
    private String url;
//    final static String MY_ACTION =
//            "cl.fjnu.edu.cn.android_lab.lab5_IntentTest.intent.action.MY_ACTION";
//    final static String MY_CATEGORY =
//            "cl.fjnu.edu.cn.android_lab.lab5_IntentTest.intent.category.MY_CATEGORY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_implicit_intent);
        etUrl = (EditText) findViewById(R.id.etUrl);
        btnLoadUrl = (Button)findViewById(R.id.btnLoadUrl);
        btnLoadUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = etUrl.getText().toString();//获取输入框的值
                Uri uri = Uri.parse(url);//解析转换为uri
                Intent intent = new Intent();

                //intent.setAction(MY_ACTION);  //测试
                /**
                 * 如果此处action设置为自定义的action字符串（MY_ACTION），则不会调用系统自带的浏览器，直接启用系统中
                 * 含有<intent-filter>（子元素<action></action>的name属性与MY_ACTION匹配的）</intent-filter>
                 * 的那个activty。
                 */

                intent.setAction(Intent.ACTION_VIEW);//设置action属性
                /**
                 * 如果此处设置为系统定义的action常量(Intent.ACTION_VIEW)，则会弹出选择框，列出所有的浏览器（包括
                 * 系统浏览器和用户已安装的其他浏览器）供用户选择。
                 */
                intent.setData(uri);//传递一个Uri对象给下一个activity
                startActivity(intent);//启动activity
            }
        });
    }
}
