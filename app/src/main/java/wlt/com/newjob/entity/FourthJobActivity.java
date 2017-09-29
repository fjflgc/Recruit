package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wlt.com.newjob.R;

import static wlt.com.newjob.R.id.job_describe;
import static wlt.com.newjob.R.id.job_tel;
import static wlt.com.newjob.R.id.job_type;

/**
 * Created by fjf on 2017/9/27.
 */

public class FourthJobActivity extends Activity implements View.OnClickListener {
    Button job_contant;
    TextView tv_tel;
    private  static  String phoneNumber="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_detail);
        job_contant= (Button) findViewById(R.id.job_contant);
        tv_tel= (TextView) findViewById(job_tel);
        TextView job_firm=(TextView)findViewById(R.id.job_firm);
        job_contant.setOnClickListener(this);
        job_firm.setOnClickListener(this);
        loadData();
    }

    private void loadData() {
        TextView jwage=(TextView)findViewById(R.id.job_wage);
        jwage.setText("15k-30k");
        phoneNumber="010-62677171";
        TextView jn= (TextView) findViewById(R.id.job_name);
        jn.setText("Android开发工程师 ");
        TextView jtime= (TextView) findViewById(R.id.job_time1);
        jtime.setText("2017-09-18");
        TextView jtyep= (TextView) findViewById(job_type);
        jtyep.setText("Android  Java  客户端");
        TextView jd= (TextView) findViewById(job_describe);
        jd.setText("参与Android客户端产品软件开发全过程（实现、测试、维护）");
        TextView jtel= (TextView) findViewById(job_tel);
        jtel.setText(phoneNumber);
        TextView jad= (TextView) findViewById(R.id.job_address);
        jad.setText("北京市海淀区海淀北一街2号 爱奇艺创新大厦17层");
        TextView f_name= (TextView) findViewById(R.id.job_firm);
        f_name.setText("北京爱奇艺科技有限公司");

//        jad.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.job_contant:
                System.out.println("========="+phoneNumber);
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                phoneNumber="";
                break;
            case R.id.job_firm:
                Uri uri = Uri.parse("http://zhaopin.iqiyi.com/job-school.html");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent1);
                break;
            default:
                break;
        }

    }
}
