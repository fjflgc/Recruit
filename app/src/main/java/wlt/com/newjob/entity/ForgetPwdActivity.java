package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import wlt.com.newjob.R;
import wlt.com.newjob.Util.Util;

/**
 * Created by Administrator on 2017/5/22.
 */
public class ForgetPwdActivity extends Activity implements View.OnClickListener {
    EditText f_email, f_user;
    Button f_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_pwd);
        initView();
    }

    private void initView() {
        f_user = (EditText) findViewById(R.id.f_user);
        f_email = (EditText) findViewById(R.id.f_pwd);
        f_btn = (Button) findViewById(R.id.f_btn);
        f_btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.f_btn:
                final String email=f_email.getText().toString();
                final String user=f_user.getText().toString();
                if (email.isEmpty()||user.isEmpty()){
                    Toast.makeText(ForgetPwdActivity.this,"输入信息不能为空",Toast.LENGTH_SHORT).show();
                }else if (!Util.isEmailValid(email)){
                    Toast.makeText(ForgetPwdActivity.this,"请输入有效的邮箱地址",Toast.LENGTH_SHORT).show();
                }else {
                    BmobUser.resetPasswordByEmail(email, new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e==null){
                                Toast.makeText(ForgetPwdActivity.this,"重置密码成功，请到"+email+"邮箱进行密码重置操作！",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(ForgetPwdActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(ForgetPwdActivity.this,"密码重置失败！",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            default:
                break;
        }
    }

}
