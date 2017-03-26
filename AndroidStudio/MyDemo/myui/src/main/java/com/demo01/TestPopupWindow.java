package com.demo01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.demo02.R;

/**
 * Created by YR on 2015/5/26.
 */
public class TestPopupWindow extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       View root = this.getLayoutInflater().inflate(R.layout.layout_popupwindow,null);
        final PopupWindow popup = new PopupWindow(root,280,360);
        Button button  = (Button) findViewById(R.id.btn_popupWindow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.showAsDropDown(v); //以下拉方式显示
                popup.showAtLocation(findViewById(R.id.btn_popupWindow), Gravity.CENTER,20,20);
            }
        });
        root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
    }
}
