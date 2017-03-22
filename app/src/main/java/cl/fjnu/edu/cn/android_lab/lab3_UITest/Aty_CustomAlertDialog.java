package cl.fjnu.edu.cn.android_lab.lab3_UITest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;

import cl.fjnu.edu.cn.R;


public class Aty_CustomAlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_custom_alert_dialog_main);
    }

    public void customView(View source){
        TableLayout loginForm = (TableLayout) getLayoutInflater()
                .inflate(R.layout.aty_login,null);
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.dog)//设置对话框的图标
                .setTitle("test")//设置对话框的标题
                .setView(loginForm)//设置对话框显示的View对象
                //为对话框设置一个“取消”按钮，并做监听处理
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //取消事件处理
                    }
                })
                //为对话框设置一个“登录”按钮，并做监听处理
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //登录事件处理
                    }
                })
                .create()//创建对话框
                .show();//显示对话框
    }

}
