package wlt.com.newjob.firm_entity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wlt.com.newjob.R;

import static wlt.com.newjob.R.drawable.tel;

/**
 * Created by Administrator on 2017/6/2.
 */
public class FirmRContentActivity extends Activity implements View.OnClickListener {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firm_rcontent);
        btn= (Button) findViewById(R.id.f_certify);
        btn.setOnClickListener(this);
        loadData();
    }
    private void loadData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        String name=bundle.getString("f_name");
        String school=bundle.getString("f_school");
        String majority=bundle.getString("f_majority");
        String introduce=bundle.getString("f_describe");
        String age=bundle.getString("f_age");
        String job=bundle.getString("f_job");
        int tel=bundle.getInt("f_tel");
        String ex=bundle.getString("f_ex");



        t1= (TextView) findViewById(R.id.f_name);
        t1.setText(name);
        t2= (TextView) findViewById(R.id.f_school);
        t2.setText(school);
        t3= (TextView) findViewById(R.id.f_majority);
        t3.setText(majority);
        t4= (TextView) findViewById(R.id.f_describe);
        t4.setText(introduce);
        t5= (TextView) findViewById(R.id.f_age);
        t5.setText(age);
        t6= (TextView) findViewById(R.id.f_job);
        t6.setText(job);
        t7= (TextView) findViewById(R.id.f_tel);
        t7.setText(""+tel);
        t8= (TextView) findViewById(R.id.f_ex);
        t8.setText(ex);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +tel ));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
