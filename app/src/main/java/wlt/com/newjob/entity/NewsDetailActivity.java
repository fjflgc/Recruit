package wlt.com.newjob.entity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import wlt.com.newjob.R;

/**
 * Created by Administrator on 2017/5/11.
 */
public class NewsDetailActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        loadData();
    }

    private void loadData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String type=bundle.getString("news_type");
        String title=bundle.getString("news_title");
        String time=bundle.getString("news_time");
        String content=bundle.getString("r_content");
        String author=bundle.getString("news_author");
        String address=bundle.getString("news_address");
        String addtime=bundle.getString("news_addtime");

        TextView nt= (TextView) findViewById(R.id.tv_news_title);
        nt.setText(title);
        TextView ntype= (TextView) findViewById(R.id.tv_news_type);
        ntype.setText(type);
        TextView ntime= (TextView) findViewById(R.id.tv_news_time);
        ntime.setText(time);
        TextView nconten= (TextView) findViewById(R.id.r_content);
        nconten.setText(content);
        TextView na= (TextView) findViewById(R.id.tv_news_author);
        na.setText(author);
        TextView nadd= (TextView) findViewById(R.id.tv_news_address);
        nadd.setText(address);
        TextView adt= (TextView) findViewById(R.id.tv_news_addtime);
        adt.setText(addtime);
    }

}
