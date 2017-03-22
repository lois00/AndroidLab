package cl.fjnu.edu.cn.android_lab.lab2_LayoutTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cl.fjnu.edu.cn.R;

public class Aty_Skip extends AppCompatActivity {

    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_skip);
        tvResult = (TextView) findViewById(R.id.tvResult);
        findViewById(R.id.btnRelativeLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aty_Skip.this,Aty_RelativeLayout.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnLinearLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aty_Skip.this,Aty_LinearLayout.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnTableLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aty_Skip.this,Aty_TableLayout.class);
                startActivity(i);
            }
        });

    }

}
