package com.testintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by YR on 2015/6/16.
 * 发送短信
 */
public class TestSendMessage extends Activity {
    private EditText editNum;
    private EditText editMessage;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sendmessage);

        editNum = (EditText)findViewById(R.id.edit_number);
        editMessage = (EditText)findViewById(R.id.edit_message);
        btnSend = (Button)findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                String num = editNum.getText().toString();
                String msg = editMessage.getText().toString();
                Toast.makeText(TestSendMessage.this,"号码："+num+"内容："+msg,Toast.LENGTH_SHORT).show();
                intent.setData(Uri.parse("smsto:"+num));
                intent.putExtra("msg",msg);
                startActivity(intent);
            }
        });

    }
}
