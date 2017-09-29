package wlt.com.newjob.Firm_Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import wlt.com.newjob.R;
import wlt.com.newjob.entity.AboutActivity;
import wlt.com.newjob.entity.DeviceAcitvity;
import wlt.com.newjob.entity.LoginActivity;
import wlt.com.newjob.entity.SuggestionActivity;

/**
 * Created by Administrator on 2017/6/2.
 */

public class Firm_My extends Fragment implements View.OnClickListener {

    Button msuggestion,mabout,mdevice,mback,confer;
    TextView mlogin;
    private  String mName;
    private SharedPreferences sp;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.firm_my, null);
        mlogin= (TextView) view.findViewById(R.id.f_index_login);
        //获得登录用户的用户名
//        sp=getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
//        String name=sp.getString("name","");
//        if(TextUtils.isEmpty(name)){//判断是否为空
//            Intent intent=new Intent(getContext(),LoginActivity.class);
//            startActivity(intent);
//        }
        mlogin.setText("企业登录");//将值显示在text中

        msuggestion = (Button) view.findViewById(R.id.f_suggestion);
        mabout = (Button) view.findViewById(R.id.f_about);
        mdevice = (Button) view.findViewById(R.id.f_device);
        mback = (Button)view.findViewById(R.id.f_back);
        confer= (Button) view.findViewById(R.id.f_firmcer);

        mlogin.setOnClickListener(this);
        msuggestion.setOnClickListener(this);
        mabout.setOnClickListener(this);
        mdevice.setOnClickListener(this);
        mback.setOnClickListener(this);
        confer.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.f_firmcer:
                Toast.makeText(getContext(),"敬请期待。。。",Toast.LENGTH_SHORT).show();
                break;
            case R.id.f_index_login:
                Intent i=new Intent(getContext(),LoginActivity.class);
                startActivity(i);
                break;
            case R.id.f_suggestion:
                Intent i1=new Intent(getContext(),SuggestionActivity.class);
                startActivity(i1);
                break;
            case R.id.f_device:
                Intent i2=new Intent(getContext(),DeviceAcitvity.class);
                startActivity(i2);
                break;
            case R.id.f_about:
                Intent i3=new Intent(getContext(),AboutActivity.class);
                startActivity(i3);
                break;
            case R.id.f_back:
                BmobUser.logOut();//清除缓存用户对象
                Intent i4=new Intent(getContext(),LoginActivity.class);
                startActivity(i4);

            default:
                break;
        }
    }
    public void getValue(String name){
        mName=name;
    }

}
