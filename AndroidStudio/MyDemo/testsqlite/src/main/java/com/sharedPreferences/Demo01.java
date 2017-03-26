package com.sharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

/**
 * Created by YR on 2015/6/16.
 */
public class Demo01 extends Activity {
    private  EditText editText;
    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo01);

        editText = (EditText)findViewById(R.id.edit_demo01);
        button = (Button)findViewById(R.id.btn_demo01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("mySharedPreferences",MODE_PRIVATE);
                String str = editText.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("editText",str);
                editor.commit();
                Toast.makeText(Demo01.this,"保存成功",Toast.LENGTH_LONG).show();
            }
        });
        button2 = (Button) findViewById(R.id.btn_demo01Read);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Context context=null;
                try {
                   context= createPackageContext("com.testsqlit",MODE_PRIVATE);
                } catch (PackageManager.NameNotFoundException e) {
                    System.out.println("文件名不能找到！");
                    e.printStackTrace();
                }*/
                SharedPreferences sp = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);
                Toast.makeText(Demo01.this,sp.getString("editText","null"),Toast.LENGTH_SHORT).show();
                //测试外部存储卡位置
                File file = Environment.getDataDirectory();
                if(file.exists()){
                    editText.setText("外部存储卡位置："+file.getAbsolutePath()+"可写？"+file.canWrite());
                }
            }
        });
    }
}
