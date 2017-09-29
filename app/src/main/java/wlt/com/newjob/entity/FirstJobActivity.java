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
 * Created by fjf on 2017/9/26.
 */

public class FirstJobActivity extends Activity implements View.OnClickListener{



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
            jwage.setText("20k-35k");
            phoneNumber="95183";
            TextView jn= (TextView) findViewById(R.id.job_name);
            jn.setText("JAVA开发工程师");
            TextView jtime= (TextView) findViewById(R.id.job_time1);
            jtime.setText("2017-9-26");
            TextView jtyep= (TextView) findViewById(job_type);
            jtyep.setText("金融  Java  数据结构");
            TextView jd= (TextView) findViewById(job_describe);
            jd.setText("参与互联网金融相关产品后台服务的设计和开发");
            TextView jtel= (TextView) findViewById(job_tel);
            jtel.setText(phoneNumber);
            TextView jad= (TextView) findViewById(R.id.job_address);
            jad.setText("北京 - 朝阳区 - 大望路 - 大望路东方梅地亚中心");
            TextView f_name= (TextView) findViewById(R.id.job_firm);
            f_name.setText("宜信大数据创新中心");

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
                    Uri uri = Uri.parse("http://www.creditease.cn/");
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent1);
                    break;
                default:
                    break;
            }

        }
    }


