package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import wlt.com.newjob.R;
import wlt.com.newjob.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/11.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    Button lbtn,lrbtn,l_forget,l_visit,l_firm,l_person;
    EditText ed_user,ed_pwd;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SysApplication.getInstance().addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initview();
    }

    private void initview() {
        lbtn= (Button) findViewById(R.id.l_btn);//登录
        lrbtn= (Button) findViewById(R.id.l_rbtn);//注册
        l_forget= (Button) findViewById(R.id.l_forget);
        l_visit= (Button) findViewById(R.id.l_visit);
        l_firm= (Button) findViewById(R.id.l_firm);
        l_person= (Button) findViewById(R.id.l_person);
        ed_user= (EditText) findViewById(R.id.l_uname);//输入账号
        ed_pwd= (EditText) findViewById(R.id.l_pwd);//输入密码
        lbtn.setOnClickListener(this);
        lrbtn.setOnClickListener(this);
        l_forget.setOnClickListener(this);
        l_visit.setOnClickListener(this);
        l_firm.setOnClickListener(this);
        l_person.setOnClickListener(this);
    }
    private long exitTime = 0;


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.l_person:
                Intent intent=new Intent(LoginActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.l_firm:
                Intent intent1=new Intent(LoginActivity.this,FirmLoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.l_btn:
                final String username1 = ed_user.getText().toString();
                final String password1 = ed_pwd.getText().toString();
                if (username1.isEmpty() || password1.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "密码或账号不能为空", Toast.LENGTH_SHORT).show();
                }else if (username1.equals("admin")&&password1.equals("admin")){


                            Intent intent2=new Intent(LoginActivity.this,MainActivity.class);
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                          startActivity(intent2);


                }else{
                    Toast.makeText(LoginActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
                }
//                final BmobUser u2 = new BmobUser();
//                u2.setUsername(username1);
//                u2.setPassword(password1);
//                u2.login(new SaveListener<User>() {
//                    @Override
//                    public void done(User user, BmobException e) {
//                        if (e == null) {
////                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
////                            //MODE_PRIVATE为默认模式，表示该文件为私有数据，只能被应用本身访问
////                            sp=getSharedPreferences("login",MODE_PRIVATE);
////                            sp.edit().putString("name",username1).commit();
//                            Intent intent1=new Intent(LoginActivity.this,MainActivity.class);
//                            startActivity(intent1);
//                        } else {
//                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
//                            Intent intent2=new Intent(LoginActivity.this,MainActivity.class);
//                            Log.e("TAG", e.toString());
//
////                            Toast.makeText(LoginActivity.this, "登录失败"+e.getMessage()+e.getErrorCode(), Toast.LENGTH_SHORT).show();
//                            startActivity(intent2);
//                        }
//                    }
//                });
                break;
            case R.id.l_rbtn:
                Intent intent4 =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent4);
                break;
            case R.id.l_forget:
                Intent intent2=new Intent(LoginActivity.this,ForgetPwdActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.l_visit:
                Intent intent3=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent3);
                finish();
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
//                finish();
                SysApplication.getInstance().exit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
