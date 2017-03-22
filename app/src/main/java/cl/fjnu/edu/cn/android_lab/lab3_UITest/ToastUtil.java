package cl.fjnu.edu.cn.android_lab.lab3_UITest;

import android.content.Context;
import android.view.Gravity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cl.fjnu.edu.cn.R;


public class ToastUtil extends Toast
{
    private static Toast mToast;

    public ToastUtil(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, CharSequence text,
                                 int duration) {
        Toast result = new Toast(context);
        try {
            // 获取LayoutInflater对象
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 由layout文件创建一个View对象
            View layout = inflater.inflate(R.layout.aty_toast_layout, null);

            // 实例化TextView对象
            TextView textView = (TextView) layout.findViewById(R.id.tvMessage);
            textView.setText(text);

            result.setView(layout);
            result.setGravity(Gravity.CENTER_HORIZONTAL, 0, 350);
            result.setDuration(duration);
        }catch(InflateException e){
            e.printStackTrace();
        }
        return result;
    }
    public static void showToast(Context context, String content) {

        mToast = ToastUtil.makeText(context, content, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
