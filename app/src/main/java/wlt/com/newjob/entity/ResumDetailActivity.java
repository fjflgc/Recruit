package wlt.com.newjob.entity;

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
import wlt.com.newjob.bean.Resum;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ResumDetailActivity extends Activity implements View.OnClickListener {
    private EditText t1,t2,t3,t4,t5,t6,t7,t8;
    private Button btn;
    private String name,school,majority,introduce,age,job,tel,ex;
    private static Resum resum;
    private static String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resum_content);
        btn= (Button) findViewById(R.id.rd_cetify);
        btn.setOnClickListener(this);
        loadData();
    }

    private void loadData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        name=bundle.getString("r_name");
        school=bundle.getString("r_school");
        majority=bundle.getString("r_majority");
        introduce=bundle.getString("r_introduce");
        age=bundle.getString("r_age");
        job=bundle.getString("r_jw");
        tel=bundle.getString("r_tel");
        ex=bundle.getString("r_ex");
        id=bundle.getString("r_id");

        t1= (EditText) findViewById(R.id.rd_name);
        t1.setText(name);
        t2= (EditText) findViewById(R.id.rd_school);
        t2.setText(school);
        t3= (EditText) findViewById(R.id.rd_majority);
        t3.setText(majority);
        t4= (EditText) findViewById(R.id.rd_describe);
        t4.setText(introduce);
        t5= (EditText) findViewById(R.id.rd_age);
        t5.setText(age);
        t6= (EditText) findViewById(R.id.rd_job);
        t6.setText(job);
        t7= (EditText) findViewById(R.id.rd_tel);
        t7.setText(tel);
        t8= (EditText) findViewById(R.id.rd_ex);
        t8.setText(ex);
        System.out.println("=========="+id);
    }
    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.rd_cetify:
              Resum resum1=new Resum();
               final String rname=t1.getText().toString();
               final String rschool=t2.getText().toString();
               final String rmajority=t3.getText().toString();
               final String rintroduce=t4.getText().toString();
               final String rage=t5.getText().toString();
               final String rjob=t6.getText().toString();
               final String rtel=t7.getText().toString();
               final String rex=t8.getText().toString();
               if (rname.isEmpty()||rschool.isEmpty()||rmajority.isEmpty()||rintroduce.isEmpty()||rage.isEmpty()||rjob.isEmpty()||rtel.isEmpty()||rex.isEmpty()){
                   Toast.makeText(ResumDetailActivity.this,"不能为空!",Toast.LENGTH_SHORT).show();
               }else {
                   System.out.println("-------------,"+resum);
                   resum1.setName(rname);
                   resum1.setSchool(rschool);
                   resum1.setMajority(rmajority);
                   resum1.setIntroduce(rintroduce);
                   resum1.setAge(rage);
                   resum1.setJob_wanted(rjob);
                   resum1.setTelephone(rtel);
                   resum1.setR_experience(rex);
                   resum1.update(id, new UpdateListener() {
                       @Override
                       public void done(BmobException e) {
                           if (e==null){
                               Toast.makeText(ResumDetailActivity.this,"修改成功！",Toast.LENGTH_SHORT).show();
                               Intent intent=new Intent(ResumDetailActivity.this,MainActivity.class);
                               startActivity(intent);
                           }else {
                               Toast.makeText(ResumDetailActivity.this,"修改失败!",Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
               break;
           default:
               break;
       }
    }
}
