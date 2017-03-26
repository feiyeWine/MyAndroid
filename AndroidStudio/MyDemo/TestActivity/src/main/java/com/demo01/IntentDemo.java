package com.demo01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by YR on 2015/5/31.
 * 测试带返回结果的intent
 */
public class IntentDemo extends Activity{
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_intent01);
        textView = (TextView) findViewById(R.id.tv_intent01);
        button = (Button)findViewById(R.id.btn_intent01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentDemo.this,IntentDemo02.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 1){
           textView.setText( data.getExtras().getString("intent"));
           // textView.setText("hihi");
            Toast.makeText(IntentDemo.this,"返回第一个intent",Toast.LENGTH_SHORT).show();
        }
    }
}
