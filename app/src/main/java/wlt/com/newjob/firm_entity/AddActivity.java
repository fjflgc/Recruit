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
import wlt.com.newjob.bean.Firm;

/**
 * Created by Administrator on 2017/6/2.
 */

public class AddActivity extends Activity implements View.OnClickListener {
    EditText e_name,e_wage,e_type,e_tel,e_address,e_firm,e_describe;
    Button lbtn,cbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firm_add);
        loadData();
    }

    private void loadData() {
        e_name= (EditText) findViewById(R.id.fa_name);
        e_wage= (EditText) findViewById(R.id.fa_wage);
        e_type= (EditText) findViewById(R.id.fa_jobtype);
        e_tel= (EditText) findViewById(R.id.fa_tel);
        e_address= (EditText) findViewById(R.id.fa_address);
        e_describe= (EditText) findViewById(R.id.fa_discribe);
        e_firm= (EditText) findViewById(R.id.fa_firm);
        lbtn= (Button) findViewById(R.id.fa_certify);
        cbtn= (Button) findViewById(R.id.fa_cancel);
        lbtn.setOnClickListener(this);
        cbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fa_certify:
                Firm f= new Firm();
                final String name=e_name.getText().toString();
                final String wage=e_name.getText().toString();
                final String type=e_type.getText().toString();
                final String tel=e_tel.getText().toString();
                final String address=e_address.getText().toString();
                final String describe=e_describe.getText().toString();
                final String firm=e_firm.getText().toString();
                if (name.isEmpty()||wage.isEmpty()||type.isEmpty()||tel.isEmpty()||address.isEmpty()||describe.isEmpty()||firm.isEmpty()){
                    Toast.makeText(AddActivity.this,"请将招聘信息填写完整!",Toast.LENGTH_SHORT).show();
                }else {
                    f.setJob_name(name);
                    f.setWage(wage);
                    f.setJob_type(type);
                    f.setJob_tel(tel);
                    f.setAddress(address);
                    f.setFirm(firm);
                    f.setJob_describe(describe);
                    f.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e==null){
                                Toast.makeText(AddActivity.this,"创建招聘信息成功!",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(AddActivity.this, AddActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(AddActivity.this,"创建招聘信息失败！",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
            case R.id.fa_cancel:
                Intent intent1=new Intent(AddActivity.this,AddActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
