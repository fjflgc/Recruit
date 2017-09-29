package wlt.com.newjob.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.bmob.v3.BmobUser;
import wlt.com.newjob.R;
import wlt.com.newjob.entity.AboutActivity;
import wlt.com.newjob.entity.DeviceAcitvity;
import wlt.com.newjob.entity.LoginActivity;
import wlt.com.newjob.entity.SuggestionActivity;

/**
 * Created by Administrator on 2017/5/10.
 */

public class My_Fragment extends Fragment implements View.OnClickListener {

    Button msuggestion,mabout,mdevice,mback,minfo;
    TextView mlogin;
    private  String mName;
    private SharedPreferences sp;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.home_my, null);
        mlogin= (TextView) view.findViewById(R.id.my_index_login);
        //获得登录用户的用户名
        sp=getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        String name=sp.getString("name","");
//        if(TextUtils.isEmpty(name)){//判断是否为空
//            Intent  intent=new Intent(getContext(),LoginActivity.class);
//            startActivity(intent);
//        }
        mlogin.setText("登录账号");//将值显示在text中

        msuggestion = (Button) view.findViewById(R.id.my_suggestion);
        mabout = (Button) view.findViewById(R.id.my_about);
        mdevice = (Button) view.findViewById(R.id.my_device);
        mback = (Button)view.findViewById(R.id.my_back);

        mlogin.setOnClickListener(this);
        msuggestion.setOnClickListener(this);
        mabout.setOnClickListener(this);
        mdevice.setOnClickListener(this);
        mback.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_index_login:
                Intent i=new Intent(getContext(),LoginActivity.class);
                startActivity(i);
                break;
            case R.id.my_suggestion:
                Intent i1=new Intent(getContext(),SuggestionActivity.class);
                startActivity(i1);
                break;
            case R.id.my_device:
                Intent i2=new Intent(getContext(),DeviceAcitvity.class);
                startActivity(i2);
                break;
            case R.id.my_about:
                Intent i3=new Intent(getContext(),AboutActivity.class);
                startActivity(i3);
                break;
            case R.id.my_back:
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