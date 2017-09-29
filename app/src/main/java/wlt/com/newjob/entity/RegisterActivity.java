package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import wlt.com.newjob.R;
import wlt.com.newjob.bean.User;

/**
 * Created by Administrator on 2017/5/11.
 */
public class RegisterActivity extends Activity implements View.OnClickListener {
    EditText ed1,ed2,ed2_2,ed_email;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ed1= (EditText) findViewById(R.id.r_uname);
        ed2= (EditText) findViewById(R.id.r_pwd);
        ed2_2= (EditText) findViewById(R.id.r_rpwd);
        ed_email= (EditText) findViewById(R.id.r_email);
        btn1= (Button) findViewById(R.id.r_btn);
        btn2= (Button) findViewById(R.id.r_rbtn);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.r_btn:
                final String username=ed1.getText().toString();
                final String password=ed2.getText().toString();
                final String repassword=ed2_2.getText().toString();
                final String email=ed_email.getText().toString();
                if (username.isEmpty() || password.isEmpty()||repassword.isEmpty()||email.isEmpty()){
                    Toast.makeText(this, "密码或账号不能为空！", Toast.LENGTH_SHORT).show();
                }else if (!repassword.equals(password)){
                    Toast.makeText(RegisterActivity.this,"两次输入的密码不一样，请重新输入!",Toast.LENGTH_SHORT).show();

                }else  if(!wlt.com.newjob.Util.Util.isEmailValid(email)){
                    Toast.makeText(RegisterActivity.this,"请输入正确的邮箱！",Toast.LENGTH_SHORT).show();
                } else{
                    final User u=new User();
                    u.setUsername(username);
                    u.setPassword(password);
                    u.setTel(email);
                    u. signUp(new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if (e==null){
                                Intent intent2=new Intent(getApplication(),MyInfoActivity.class);
                                startActivity(intent2);
                                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                break;
            case R.id.r_rbtn:
                Intent in=new Intent(getApplication(),LoginActivity.class);
                startActivity(in);
                finish();
                break;
            default:
                break;
        }
    }
}
