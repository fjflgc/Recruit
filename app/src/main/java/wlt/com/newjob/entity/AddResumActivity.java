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
import wlt.com.newjob.bean.Resum;

/**
 * Created by Administrator on 2017/5/11.
 */
public class AddResumActivity extends Activity implements View.OnClickListener {
    EditText rname,rschool,rmajority,rintroduce,rjobw,rtel,rexperience,rage;
    Button certify,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);
        rname= (EditText) findViewById(R.id.r_name);
        rschool= (EditText) findViewById(R.id.r_school);
        rmajority= (EditText) findViewById(R.id.r_majority);
        rintroduce= (EditText) findViewById(R.id.r_introduce);
        rjobw= (EditText) findViewById(R.id.r_job);
        rtel= (EditText) findViewById(R.id.r_tel);
        rage= (EditText) findViewById(R.id.age);
        rexperience= (EditText) findViewById(R.id.r_experience);
        certify= (Button) findViewById(R.id.r_certify);
        cancel= (Button) findViewById(R.id.r_cancel);
        certify.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.r_certify:
                Resum resum = new Resum();
                final String name = rname.getText().toString();
                final String school = rschool.getText().toString();
                final String majority = rmajority.getText().toString();
                final String introduce = rintroduce.getText().toString();
                final String job_want = rjobw.getText().toString();
                final String tel = rtel.getText().toString();
                final String age=rage.getText().toString();
                final String experience = rexperience.getText().toString();
                if (name.isEmpty() || age.isEmpty()||school.isEmpty() || majority.isEmpty() || introduce.isEmpty() || job_want.isEmpty() || tel.isEmpty() || experience.isEmpty()) {
                    Toast.makeText(AddResumActivity.this, "请将信息填写完整！", Toast.LENGTH_SHORT).show();
                } else {
                    resum.setName(name);
                    resum.setSchool(school);
                    resum.setMajority(majority);
                    resum.setIntroduce(introduce);
                    resum.setR_experience(experience);
                    resum.setJob_wanted(job_want);
                    resum.setTelephone(tel);
                    resum.setAge(age);
                    resum.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Toast.makeText(AddResumActivity.this, "创建简历成功", Toast.LENGTH_SHORT).show();
                                Intent in = new Intent(AddResumActivity.this, AddResumActivity.class);
                                startActivity(in);
                            } else {
                                Toast.makeText(AddResumActivity.this, "创建简历成功", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                    break;
                    case R.id.r_cancel:
                        Intent in2 = new Intent(AddResumActivity.this, AddResumActivity.class);
                        startActivity(in2);
                        break;
                    default:
                        break;
                }
        }

}
