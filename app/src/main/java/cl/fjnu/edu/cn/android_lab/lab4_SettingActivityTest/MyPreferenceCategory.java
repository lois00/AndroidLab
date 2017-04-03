package cl.fjnu.edu.cn.android_lab.lab4_SettingActivityTest;

import android.content.Context;
import android.graphics.Color;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-04-03.
 */

public class MyPreferenceCategory extends PreferenceCategory{
    public MyPreferenceCategory(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            tv.setTextSize(12);
            tv.setAllCaps(false);
            tv.setTextColor(Color.parseColor("#34b5e5"));//#09998c
        }
    }
}
