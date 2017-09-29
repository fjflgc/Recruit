package wlt.com.newjob.firm_entity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import wlt.com.newjob.Firm_Fragment.Firm_Home;
import wlt.com.newjob.Firm_Fragment.Firm_My;
import wlt.com.newjob.Firm_Fragment.Firm_Resum;
import wlt.com.newjob.R;

/**
 * Created by Administrator on 2017/6/1.
 */

public class FirmMainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    RadioButton nbtn;
    RadioGroup rg;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firm_footer);
        initView();
        fragmentManager = getSupportFragmentManager();//初始化FragmentMananger
        nbtn.setChecked(true);
        rg.setOnCheckedChangeListener(this);
        changeFragment(new Firm_Home(), true);
    }

    private void initView() {
        nbtn = (RadioButton) findViewById(R.id.f_home);
        rg = (RadioGroup) findViewById(R.id.f_footer);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.f_home:
                changeFragment(new Firm_Home(), true);
                break;
            case R.id.f_resum:
                changeFragment(new Firm_Resum(), true);
                break;
            case R.id.f_my:
                changeFragment(new Firm_My(), true);
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
        ft.replace(R.id.f_content, fragement);
        ft.commit();
    }
    }
