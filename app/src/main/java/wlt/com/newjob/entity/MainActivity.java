package wlt.com.newjob.entity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import wlt.com.newjob.Fragment.Home_fragement;
import wlt.com.newjob.Fragment.Message_Fragment;
import wlt.com.newjob.Fragment.My_Fragment;
import wlt.com.newjob.Fragment.Resume_Fragment;
import wlt.com.newjob.R;

/**
 * Created by Administrator on 2017/5/10.
 */

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    RadioButton nbtn;
    RadioGroup rg;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.footer);
        initView();
        fragmentManager = getSupportFragmentManager();//初始化FragmentMananger
        nbtn.setChecked(true);
        rg.setOnCheckedChangeListener(this);
        changeFragment(new Home_fragement(), true);
    }

    private void initView() {
        nbtn = (RadioButton) findViewById(R.id.main_home);
        rg = (RadioGroup) findViewById(R.id.g_footer);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_home:
                changeFragment(new Home_fragement(), true);
                break;
            case R.id.main_message:
                changeFragment(new Message_Fragment(), true);
                break;
            case R.id.main_resum:
                changeFragment(new Resume_Fragment(), true);
                break;
            case R.id.main_my:
                changeFragment(new My_Fragment(), true);
                break;

            default:
                break;
        }
    }

    //切换不同的Fragment
    public void changeFragment(Fragment fragement, boolean b) {
        //开启事物
        FragmentTransaction ft = fragmentManager.beginTransaction();
        //页面切换
        ft.replace(R.id.main_content, fragement);
        ft.commit();
    }

}


