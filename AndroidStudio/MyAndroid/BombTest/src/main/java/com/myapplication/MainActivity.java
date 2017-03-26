package com.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobPushManager;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;


public class MainActivity extends ActionBarActivity {
    private EditText editText1,editText2;
    private Button button,query,pushMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"0d8a89a0fa1907e52a915ad43b4b408e");

        //推送服务
        BmobInstallation.getCurrentInstallation(this).save();
        BmobPush.startWork(this,"0d8a89a0fa1907e52a915ad43b4b408e");

        editText1 = (EditText)findViewById(R.id.editText);
        editText2 =(EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        query = (Button) findViewById(R.id.qurey);
        //消息推送
        pushMessage  = (Button) findViewById(R.id.pushMessage);
    }
    public void submit(View view){
        String user = editText1.getText().toString();
        String text = editText2.getText().toString();
        if(user.equals("")||text.equals("")){
            return;
        }
        User u = new User();
        u.setUser(user);
        u.setText(text);
        u.save(MainActivity.this,new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(MainActivity.this,"保存失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void query(View view){

        BmobQuery<User> query = new BmobQuery<User>();
        query.findObjects(MainActivity.this,new FindListener<User>() {
            @Override
            public void onSuccess(List<User> users) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Query");
                String str = "";
                for(User u : users){
                    str += u.getUser()+":"+u.getText()+"\n";
                }
                builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setMessage(str);
                builder.create().show();
            }

            @Override
            public void onError(int i, String s) {

            }
        });

    }
    //消息推送
    public void pushMessage(View view){
        BmobPushManager push = new BmobPushManager(MainActivity.this);
        push.pushMessageAll("Test");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
