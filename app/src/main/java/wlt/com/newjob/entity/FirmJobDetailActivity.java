package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wlt.com.newjob.R;
import wlt.com.newjob.firm_entity.FJDetailActivity;

/**
 * Created by fjf on 2017/9/27.
 */

public class FirmJobDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firmjob_detail);
        Button fj_revise=(Button) findViewById(R.id.fj_revise);
        Button fj_cancel=(Button) findViewById(R.id.fj_cancel);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String type=bundle.getString("fj_name");
        String title=bundle.getString("fj_wage");
        String time=bundle.getString("fj_jobtype");
        String content=bundle.getString("fj_tel");
        String author=bundle.getString("fj_address");
        String address=bundle.getString("fj_firm");
        String addtime=bundle.getString("fj_describe");

        TextView nt= (TextView) findViewById(R.id.fj_name);
        nt.setText(title);
        final String a1=(String)nt.getText();

        TextView ntype= (TextView) findViewById(R.id.fj_wage);
        ntype.setText(type);
        final String a2=(String)ntype.getText();

        TextView ntime= (TextView) findViewById(R.id.fj_jobtype);
        ntime.setText(time);
        final String a3=(String)ntime.getText();

        TextView nconten= (TextView) findViewById(R.id.fj_tel);
        nconten.setText(content);
        final String a4=(String)nconten.getText();

        TextView na= (TextView) findViewById(R.id.fj_address);
        na.setText(author);
        final String a5=(String)na.getText().toString();

        TextView nadd= (TextView) findViewById(R.id.fj_firm);
        nadd.setText(address);
        final String a6=(String)nadd.getText().toString();

        TextView adt= (TextView) findViewById(R.id.fj_discribe);
        adt.setText(addtime);
        final String a7=(String)adt.getText().toString();

//        loadData();
        fj_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("fj_name",a1);
                bundle1.putString("fj_wage", a2);
                bundle1.putString("fj_jobtype",a3 );
               bundle1.putString("fj_tel",a4 );
               bundle1.putString("fj_address",a5);
               bundle1.putString("fj_firm",a6 );
               bundle1.putString("fj_describe",a7);
                Intent intent = new Intent();
                intent.putExtras(bundle1);
                intent.setClass(FirmJobDetailActivity.this, FJDetailActivity.class);
                startActivity(intent);

            }
        });

        fj_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   finish();

            }
        });
    }



//    private void loadData() {
//
//    }
}
