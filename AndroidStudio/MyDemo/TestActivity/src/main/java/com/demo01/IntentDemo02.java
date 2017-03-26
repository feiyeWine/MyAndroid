package com.demo01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by YR on 2015/5/31.
 */
public class IntentDemo02 extends Activity {
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_intent02);
        textView = (TextView) findViewById(R.id.tv_intent02);
        button = (Button)findViewById(R.id.btn_intent02);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentDemo02.this,IntentDemo.class);
                Bundle bundle = new Bundle();
                bundle.putString("intent","已跳转过intent2");
                intent.putExtras(bundle);
                IntentDemo02.this.setResult(1,intent);
                startActivity(intent);
                IntentDemo02.this.finish();
            }
        });

    }
}
