package wlt.com.newjob.firm_entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import wlt.com.newjob.R;
import wlt.com.newjob.bean.Firm;

/**
 * Created by Administrator on 2017/6/4.
 */

public class FJDetailActivity extends Activity implements View.OnClickListener {
    private Button certify,cancel;
    private EditText j_name;
    private EditText wage;
    private EditText type;
    private EditText tel;
    private EditText address;
    private EditText des;
    private EditText f_name;
    private String fj_name,f_wage,f_type,f_tel,f_address,f_des,ff_name,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firm_jdetail);
        loadData();
    }


    private void loadData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        fj_name=bundle.getString("fj_name");
       f_wage=bundle.getString("fj_wage");
       f_type=bundle.getString("fj_jobtype");
        f_tel=bundle.getString("fj_tel");
       f_address=bundle.getString("fj_address");
        f_des=bundle.getString("fj_describe");
       ff_name=bundle.getString("fj_firm");
       //id=bundle.getString("job_id");

        certify= (Button) findViewById(R.id.fj_certify);
        cancel= (Button) findViewById(R.id.fj_cancel);
        j_name= (EditText) findViewById(R.id.fj_name);
        wage= (EditText) findViewById(R.id.fj_wage);
        type= (EditText) findViewById(R.id.fj_jobtype);
        tel= (EditText) findViewById(R.id.fj_tel);
        address= (EditText) findViewById(R.id.fj_address);
        des= (EditText) findViewById(R.id.fj_discribe);
        f_name= (EditText) findViewById(R.id.fj_firm);
        certify.setOnClickListener(this);
        cancel.setOnClickListener(this);
        j_name.setText(fj_name);
        wage.setText(f_wage);
        type.setText(f_type);
        tel.setText(f_tel);
        address.setText(f_address);
        des.setText(f_des);
        f_name.setText(ff_name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fj_certify:
                Firm firm=new Firm();
                final String fn=j_name.getText().toString();
                final String w=wage.getText().toString();
                final String t=type.getText().toString();
                final String a=address.getText().toString();
                final String d=des.getText().toString();
                final String t1=tel.getText().toString();
                final String fn1=f_name.getText().toString();
                firm.setJob_name(fn);
                firm.setWage(w);
                firm.setJob_type(t);
                firm.setJob_tel(t1);
                firm.setAddress(a);
                firm.setJob_describe(d);
                firm.setFirm(fn1);
                firm.update(id, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e==null){
                            Toast.makeText(FJDetailActivity.this,"修改成功!",Toast.LENGTH_SHORT).show();
                            Intent intent1=new Intent(FJDetailActivity.this,FirmMainActivity.class);
                            startActivity(intent1);
                        }else {
                            Toast.makeText(FJDetailActivity.this,"修改成功!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.fj_cancel:
                finish();
                break;
            default:
                break;
        }
    }
}