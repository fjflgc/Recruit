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
import wlt.com.newjob.Util.Util;
import wlt.com.newjob.bean.FirmInfo;
import wlt.com.newjob.entity.FirmLoginActivity;

/**
 * Created by Administrator on 2017/6/4.
 */

public class FirmInfoActivity extends Activity implements View.OnClickListener {
    EditText name,type,address,dev,tel,email;
    Button certify,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firm_info);
        loadData();

    }

    private void loadData() {
        name= (EditText) findViewById(R.id.fi_name);
        type= (EditText) findViewById(R.id.fi_type);
        address= (EditText) findViewById(R.id.fi_address);
        dev= (EditText) findViewById(R.id.fi_development);
        tel= (EditText) findViewById(R.id.fi_tel);
        email= (EditText) findViewById(R.id.fi_email);
        certify= (Button) findViewById(R.id.fi_certify);
        cancel= (Button) findViewById(R.id.fi_cancel);
        certify.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fi_certify:
                final String f_name=name.getText().toString();
                final String f_type=type.getText().toString();
                final String f_add=address.getText().toString();
                final String f_dev=dev.getText().toString();
                final String f_tel=tel.getText().toString();
                final String f_email=email.getText().toString();
               if (f_name.isEmpty()||f_type.isEmpty()||f_add.isEmpty()||f_dev.isEmpty()||f_tel.isEmpty()||f_email.isEmpty()){
                   Toast.makeText(FirmInfoActivity.this,"填写不能为空！",Toast.LENGTH_SHORT).show();
               }else if (!Util.isEmailValid(f_email)){
                   Toast.makeText(FirmInfoActivity.this,"请填写正确的邮箱！",Toast.LENGTH_SHORT).show();
               }else if (!Util.isPhoneNumberValid(f_tel)){
                   Toast.makeText(FirmInfoActivity.this,"请填写正确的电话号码！",Toast.LENGTH_SHORT).show();
               }else {
                   FirmInfo firmInfo=new FirmInfo();
                   firmInfo.setFirm_name(f_name);
                   firmInfo.setFirm_type(f_type);
                   firmInfo.setFirm_address(f_add);
                   firmInfo.setFirm_development(f_dev);
                   firmInfo.setFirm_tel(f_tel);
                   firmInfo.setFirm_email(f_email);
                   firmInfo.save(new SaveListener<String>() {
                       @Override
                       public void done(String s, BmobException e) {
                           if (e==null){
                               Toast.makeText(FirmInfoActivity.this,"创建成功,返回登录页面登录吧!",Toast.LENGTH_SHORT).show();
                               Intent intent=new Intent(FirmInfoActivity.this, FirmLoginActivity.class);
                               startActivity(intent);
                           }else {
                               Toast.makeText(FirmInfoActivity.this,"创建失败！",Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
                break;
            case R.id.fi_cancel:
                Intent intent1=new Intent(FirmInfoActivity.this,Firm_RegActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
