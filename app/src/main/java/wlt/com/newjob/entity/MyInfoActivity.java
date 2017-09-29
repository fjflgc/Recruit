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
import wlt.com.newjob.bean.UserInfo;

/**
 * Created by Administrator on 2017/5/20.
 */

public class MyInfoActivity extends Activity implements View.OnClickListener {
    EditText u_name,u_age,u_gender,u_tel,u_address;
    Button u_certify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);
        initView();

    }

    private void initView() {
        u_name= (EditText) findViewById(R.id.u_name);
        u_age= (EditText) findViewById(R.id.u_age);
        u_gender= (EditText) findViewById(R.id.u_gengder);
        u_tel= (EditText) findViewById(R.id.u_tel);
        u_address= (EditText) findViewById(R.id.u_address);
        u_certify= (Button) findViewById(R.id.u_certify);
        u_certify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        final String username1 = ed_user.getText().toString();

        String name=u_name.getText().toString();
        String age=u_age.getText().toString();
        String gender=u_gender.getText().toString();
        String tel=u_tel.getText().toString();
        String address=u_address.getText().toString();
        if (name.isEmpty()||age.isEmpty()||gender.isEmpty()||tel.isEmpty()||address.isEmpty()){
            Toast.makeText(MyInfoActivity.this,"信息不能为空！", Toast.LENGTH_SHORT).show();
        }else {
//            final BmobUser u2 = new BmobUser();
//            u2.setUsername(username1);
            final UserInfo u=new UserInfo();
            u.setU_name(name);
            u.setU_age(age);
            u.setU_gender(gender);
            u.setU_tel(tel);
            u.setU_address(address);
            u.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e==null){
                        Toast.makeText(MyInfoActivity.this,"成功",Toast.LENGTH_SHORT).show();
                        Intent in=new Intent(MyInfoActivity.this,MainActivity.class);
                        startActivity(in);
                    }else {
                        Toast.makeText(MyInfoActivity.this,"失败",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
