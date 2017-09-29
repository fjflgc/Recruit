package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wlt.com.newjob.R;

import static wlt.com.newjob.R.id.job_tel;

/**
 * Created by Administrator on 2017/5/11.
 */
public class JobDetailActivity extends Activity implements View.OnClickListener {
    Button job_contant;
    TextView tv_tel;
    private  static  String phoneNumber="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_detail);
        job_contant= (Button) findViewById(R.id.job_contant);
        tv_tel= (TextView) findViewById(job_tel);
        job_contant.setOnClickListener(this);
        loadData();
    }

    private void loadData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        String job=bundle.getString("job_name");
        String time=bundle.getString("jtime");
        String job_type=bundle.getString("job_type");
        String job_add=bundle.getString("address");
        String job_describe=bundle.getString("job_describe");
        String job_tel=bundle.getString("job_tel");
        String firm_name=bundle.getString("firm_name");
         phoneNumber=job_tel;
        TextView jn= (TextView) findViewById(R.id.job_name);
        jn.setText(job);
        TextView jtime= (TextView) findViewById(R.id.job_time1);
        jtime.setText(time);
        TextView jtyep= (TextView) findViewById(R.id.job_type);
        jtyep.setText(job_type);
        TextView jd= (TextView) findViewById(R.id.job_describe);
        jd.setText(job_describe);
        TextView jtel= (TextView) findViewById(R.id.job_tel);
        jtel.setText(job_tel);
        TextView jad= (TextView) findViewById(R.id.job_address);
        jad.setText(job_add);
        TextView f_name= (TextView) findViewById(R.id.job_firm);
        f_name.setText(firm_name);
        f_name.setOnClickListener(this);
//        jad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.job_contant:
               System.out.println("========="+phoneNumber);
               Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneNumber));
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent);
               phoneNumber="";
               break;
           case R.id.job_firm:
               Uri uri = Uri.parse("http://http://job.suse.edu.cn/");
               Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
               startActivity(intent1);
               break;
           default:
               break;
       }

    }

//    @Override
//    public void onClick(View v) {
//        Intent intent=new Intent();
//        intent.setAction(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel"+jad));
//        startActivity(intent);
//    }
}
