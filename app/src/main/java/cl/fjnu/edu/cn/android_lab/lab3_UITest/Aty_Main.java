package cl.fjnu.edu.cn.android_lab.lab3_UITest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cl.fjnu.edu.cn.R;

public class Aty_Main extends AppCompatActivity {

    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main_lab3);
        tvResult = (TextView) findViewById(R.id.tvResult);
        findViewById(R.id.btnSimpleAdapterList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aty_Main.this,Aty_SimpleAdapter.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnCustomAlertDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aty_Main.this,Aty_CustomAlertDialog.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnXMLMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aty_Main.this,Aty_CustomMenuWithXML.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnActionModeMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aty_Main.this,Aty_ContextMenuActionMode.class);
                startActivity(i);
            }
        });
    }
}
