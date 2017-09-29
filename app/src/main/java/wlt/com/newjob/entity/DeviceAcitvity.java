package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import wlt.com.newjob.R;

/**
 * Created by Administrator on 2017/5/11.
 */
public class DeviceAcitvity extends Activity implements View.OnClickListener {
    Button d_refresh,d_agreement,d_notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        initView();
//        Toast.makeText(DeviceAcitvity.this,"正在开发中。。。。。",Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        d_refresh= (Button) findViewById(R.id.d_refresh);
        d_agreement= (Button) findViewById(R.id.d_agreement);
        d_notice= (Button) findViewById(R.id.d_notice);

        d_refresh.setOnClickListener(this);
        d_agreement.setOnClickListener(this);
        d_notice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.d_refresh:
                Toast.makeText(DeviceAcitvity.this,"已是最新版本",Toast.LENGTH_SHORT).show();
                break;
            case R.id.d_agreement:
                Intent intent=new Intent(DeviceAcitvity.this,AgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.d_notice:
                Toast.makeText(DeviceAcitvity.this,"暂无通知！",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
}
