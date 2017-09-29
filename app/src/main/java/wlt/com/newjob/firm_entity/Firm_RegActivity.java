package wlt.com.newjob.firm_entity;

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
import wlt.com.newjob.entity.FirmLoginActivity;

/**
 * Created by Administrator on 2017/6/2.
 */

public class Firm_RegActivity extends Activity implements View.OnClickListener {
    EditText e_name, e_pwd, e_email, e_rpwd;
    Button e_re, e_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firm_reg);
        loadData();
    }

    private void loadData() {
        e_name = (EditText) findViewById(R.id.fa_name);
        e_pwd = (EditText) findViewById(R.id.fa_pwd);
        e_rpwd = (EditText) findViewById(R.id.fa_rpwd);
        e_email = (EditText) findViewById(R.id.fa_email);
        e_re = (Button) findViewById(R.id.fa_btn);
        e_back = (Button) findViewById(R.id.fa_rbtn);
        e_re.setOnClickListener(this);
        e_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fa_btn:
                final String username = e_name.getText().toString();
                final String password = e_pwd.getText().toString();
                final String repassword = e_rpwd.getText().toString();
                final String email = e_email.getText().toString();
                if (username.isEmpty() || password.isEmpty() || repassword.isEmpty() || email.isEmpty()) {
                    Toast.makeText(this, "密码或账号不能为空！", Toast.LENGTH_SHORT).show();
                } else if (!repassword.equals(password)) {
                    Toast.makeText(Firm_RegActivity.this, "两次输入的密码不一样，请重新输入!", Toast.LENGTH_SHORT).show();

                } else if (!wlt.com.newjob.Util.Util.isEmailValid(email)) {
                    Toast.makeText(Firm_RegActivity.this, "请输入正确的邮箱号码！", Toast.LENGTH_SHORT).show();
                } else {
                    final User u = new User();
                    u.setUsername(username);
                    u.setPassword(password);
//                    u.setEmailVerified(email);
                    u.setEmail(email);
                    u.signUp(new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if (e == null) {
                                Toast.makeText(Firm_RegActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                                Intent intent2 = new Intent(Firm_RegActivity.this, FirmInfoActivity.class);
                                startActivity(intent2);
                            } else {
                                Toast.makeText(Firm_RegActivity.this, "您的邮箱已注册，请换个账号吧！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    break;
//
                }
            case R.id.fa_rbtn:
                Intent intent1=new Intent(Firm_RegActivity.this,FirmLoginActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}