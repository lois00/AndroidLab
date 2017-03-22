package cl.fjnu.edu.cn.android_lab.lab3_UITest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import cl.fjnu.edu.cn.R;

public class Aty_CustomMenuWithXML extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_custom_menu_with_xml);
        tv = (TextView)findViewById(R.id.tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.isCheckable())
            item.setChecked(true);
        switch(item.getItemId())
        {
            case R.id.font_10:
                tv.setTextSize(10*2);
                break;

            case R.id.font_16:
                tv.setTextSize(16*2);
                break;

            case R.id.font_20:
                tv.setTextSize(20*2);
                break;

            case R.id.color_red:
                tv.setTextColor(Color.RED);
                break;

            case R.id.color_black:
                tv.setTextColor(Color.BLACK);
                break;

            case R.id.plain_item:
                Toast.makeText(this, "您单击了普通菜单项", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        return true;
    }
}
