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

public class SecondJobActivity extends Activity implements View.OnClickListener{
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
        jwage.setText("12k-22k");
        phoneNumber="010-58781000";
        TextView jn= (TextView) findViewById(R.id.job_name);
        jn.setText("PHP开发工程师");
        TextView jtime= (TextView) findViewById(R.id.job_time1);
        jtime.setText("2017-09-22");
        TextView jtyep= (TextView) findViewById(job_type);
        jtyep.setText("MySQL  后端  php");
        TextView jd= (TextView) findViewById(job_describe);
        jd.setText("负责直播业务服务器端开发工作");
        TextView jtel= (TextView) findViewById(job_tel);
        jtel.setText(phoneNumber);
        TextView jad= (TextView) findViewById(R.id.job_address);
        jad.setText("北京 - 朝阳区 - 酒仙桥 - 酒仙桥路电子城国际电子总部");
        TextView f_name= (TextView) findViewById(R.id.job_firm);
        f_name.setText("北京奇虎科技有限公司");

//        jad.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.job_contant:
                System.out.println("========="+phoneNumber);
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
               // phoneNumber="";
                break;
            case R.id.job_firm:
                Uri uri = Uri.parse("http://campus.chinahr.com/2017/qihu360/index.html");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent1);
                break;
            default:
                break;
        }

    }
}
