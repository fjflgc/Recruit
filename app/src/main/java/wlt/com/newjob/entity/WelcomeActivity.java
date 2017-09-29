package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import cn.bmob.v3.Bmob;
import wlt.com.newjob.R;

/**
 * Created by Administrator on 2017/5/10.
 */
//页面启动并跳转至首页面
public class WelcomeActivity extends Activity {

    private final long SPLASH_LENGTH = 1000;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Bmob.initialize(this, "c8ab36629b4f91ff527209514b70a4c9");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_LENGTH);

    }
}