package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import wlt.com.newjob.R;
import wlt.com.newjob.Util.SysApplication;
import wlt.com.newjob.firm_entity.FirmMainActivity;
import wlt.com.newjob.firm_entity.Firm_RegActivity;

/**
 * Created by Administrator on 2017/6/1.
 */
public class FirmLoginActivity extends Activity implements View.OnClickListener {
    private Button f_person, f_firm, f_login, f_reg, f_forget;
    private EditText f_name, f_pwd;
    private SharedPreferences f_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SysApplication.getInstance().addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firm_login);
        loadData();
    }

    private void loadData() {
        f_person = (Button) findViewById(R.id.f_person);
        f_firm = (Button) findViewById(R.id.f_firm);
        f_login = (Button) findViewById(R.id.f_login);
        f_reg = (Button) findViewById(R.id.f_reg);
        f_forget = (Button) findViewById(R.id.f_forget);
        f_name = (EditText) findViewById(R.id.f_uname);
        f_pwd = (EditText) findViewById(R.id.f_pwd);
        f_person.setOnClickListener(this);
        f_firm.setOnClickListener(this);
        f_login.setOnClickListener(this);
        f_reg.setOnClickListener(this);
        f_forget.setOnClickListener(this);
    }
    private long exitTime = 0;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f_person:
                Intent intent = new Intent(FirmLoginActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.f_firm:
                Intent intent1 = new Intent(FirmLoginActivity.this, FirmLoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.f_login:
                final String f_fname = f_name.getText().toString();
                final String f_fpwd = f_pwd.getText().toString();
                if (f_fname.isEmpty() || f_fpwd.isEmpty()) {
                    Toast.makeText(FirmLoginActivity.this, "账号或密码不能为空!", Toast.LENGTH_SHORT).show();
                } else if (f_fname.equals("admin")&&f_fpwd.equals("admin")) {

                    Toast.makeText(FirmLoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(FirmLoginActivity.this, FirmMainActivity.class);
                    startActivity(intent2);
                }else {
                    Toast.makeText(FirmLoginActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
                }
//                final BmobUser f=new BmobUser();
//                f.setUsername(f_fname);
//                f.setPassword(f_fpwd);
//                f.login(new SaveListener<User>() {
//                    @Override
//                    public void done(User user, BmobException e) {
//                        if(e==null){
//                            Toast.makeText(FirmLoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
//                            f_sp=getSharedPreferences("login",MODE_PRIVATE);
//                            f_sp.edit().putString("name",f_fname).commit();
//                            Intent intent2=new Intent(FirmLoginActivity.this, FirmMainActivity.class);
//                            startActivity(intent2);
//                        }else {
//                            Toast.makeText(FirmLoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
//                            Intent intent2=new Intent(FirmLoginActivity.this, FirmMainActivity.class);
//                            startActivity(intent2);
//                        }
//                    }
//                });

                break;
            case R.id.f_reg:
                Intent intent3 = new Intent(FirmLoginActivity.this, Firm_RegActivity.class);
                startActivity(intent3);
                break;
            case R.id.f_forget:
                Intent intent4 = new Intent(FirmLoginActivity.this, ForgetPwdActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
//                finish();
                SysApplication.getInstance().exit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
