package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import wlt.com.newjob.R;
import wlt.com.newjob.bean.Suggestion;

/**
 * Created by Administrator on 2017/5/11.
 */
public class SuggestionActivity extends Activity implements View.OnClickListener {
    EditText s_content,s_tel;
    Button s_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sugestion);
        s_content= (EditText) findViewById(R.id.suggestion_content);
        s_tel= (EditText) findViewById(R.id.suggestion_tel);
        s_btn= (Button) findViewById(R.id.s_btn);
        s_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String content=s_content.getText().toString();
        final String tel=s_tel.getText().toString();
        if (content.isEmpty() || tel.isEmpty()){
            Toast.makeText(this, "建议或联系电话不能为空！", Toast.LENGTH_SHORT).show();
        }
        final Suggestion s= new Suggestion();
        s.setContent(content);
        s.setTel(tel);
        s.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e==null){
                   Toast.makeText(SuggestionActivity.this,"创建数据成功",Toast.LENGTH_SHORT).show();
                   Intent in=new Intent(SuggestionActivity.this, MainActivity.class);
                    startActivity(in);
                }else {
//                    Toast.makeText(SuggestionActivity.this,"创建数据失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
