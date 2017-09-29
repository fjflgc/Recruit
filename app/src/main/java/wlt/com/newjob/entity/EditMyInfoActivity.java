package wlt.com.newjob.entity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import wlt.com.newjob.R;
import wlt.com.newjob.bean.UserInfo;

/**
 * Created by Administrator on 2017/5/22.
 */

public class EditMyInfoActivity extends Activity{

    EditText ed_name,ed_age,ed_gender,ed_tel,ed_address;
    private UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ed_myinfo);
        setCurUser();
        initView();
    }

    private void initView() {
        ed_name= (EditText) findViewById(R.id.ed_name);
        ed_age= (EditText) findViewById(R.id.ed_age);
        ed_gender= (EditText) findViewById(R.id.ed_gengder);
        ed_tel= (EditText) findViewById(R.id.ed_tel);
        ed_address= (EditText) findViewById(R.id.ed_address);

        ed_name.setText(userInfo.getU_name());
        ed_age.setText(userInfo.getU_age());
        ed_gender.setText(userInfo.getU_gender());
        ed_tel.setText(userInfo.getU_tel());
        ed_address.setText(userInfo.getU_address());
    }



    private void setCurUser() {
        
    }
}
