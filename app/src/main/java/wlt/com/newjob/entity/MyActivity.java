package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wlt.com.newjob.R;

public class MyActivity extends Activity implements View.OnClickListener {
    Button msuggestion,mabout,mdevice,mback,minfo,mtest;

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_my);
        tv= (TextView) findViewById(R.id.my_index_login);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String u_name=bundle.getString("u_name");
        tv.setText(u_name);
        initView();
    }

    private void initView() {
        msuggestion= (Button) findViewById(R.id.my_suggestion);
        mabout= (Button) findViewById(R.id.my_about);
        mdevice= (Button) findViewById(R.id.my_device);
        mback= (Button) findViewById(R.id.my_back);
//        minfo= (Button) findViewById(R.id.my_info);
//        mtest= (Button) findViewById(R.id.my_test);
        mtest.setOnClickListener(this);
        msuggestion.setOnClickListener(this);
        mabout.setOnClickListener(this);
        mdevice.setOnClickListener(this);
        mback.setOnClickListener(this);
        minfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_suggestion:
                Intent in=new Intent(MyActivity.this,SuggestionActivity.class);
                startActivity(in);
                break;
            case R.id.my_about:
                Intent i1=new Intent(MyActivity.this,AboutActivity.class);
                startActivity(i1);
                break;
            case R.id.my_device:
                Intent i2=new Intent(MyActivity.this,DeviceAcitvity.class);
                startActivity(i2);
                break;
            case R.id.my_back:
                Intent i3=new Intent(MyActivity.this,LoginActivity.class);


            default:
                break;
        }

    }
}
