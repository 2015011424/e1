package com.example.amy.helloworld;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btn = (Button) this.findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("请输入真实信息");//显示的消息内容
                // .setTitle("对话框");//对话框标题
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                     public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();
                     }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();
                    }
                });
                 builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();
                    }
                 });

                builder.show();
            }
        });

        Button button = (Button) findViewById(R.id.b2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                final View dialogview=inflater.inflate(R.layout.login_dialog, null);
                 builder.setView(dialogview)
                         .setTitle("Login")
                // Add action buttons
                .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        final EditText uid=(EditText)dialogview.findViewById(R.id.UId);
                        final EditText pwd=(EditText)dialogview.findViewById(R.id.pwd);
                        String u=uid.getText().toString();
                        String p=pwd.getText().toString();
                        if(u.equals("abc")&&p.equals("123")){
                            Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "用户名或密码错误！", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int id) {
                     Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();
                 }
                });
                builder.show();
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
