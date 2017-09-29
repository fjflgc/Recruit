package wlt.com.newjob.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wlt.com.newjob.R;
import wlt.com.newjob.bean.News;
import wlt.com.newjob.entity.NewsDetailActivity;

import static wlt.com.newjob.R.id.news_title;

/**
 * Created by Administrator on 2017/5/10.
 */

public class Message_Fragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {
    ListView news_list;
    List<News> news;
    final String[] News_Title = new String[] { "海能达校园招聘", "广发银行信用卡中心校园招聘", "爱立信校园招聘","途牛旅游网校园招聘", "嘉环科技校园招聘" };
    final String[] News_Time = new String[] { "2017-9-1", "2017-8-30", "2017-8-18","2017-9-21", "2017-9-22" };
    final String[] News_Author = new String[] { "海能达通信股份有限公司", "广发银行", "爱立信公司","途牛旅游网", "南京嘉环科技有限公司" };
    final String[] News_Type = new String[] { "校园招聘", "校园招聘", "校园招聘","校园招聘", "校园招聘" };
    final String[] News_Address = new String[] { "	南京-河海大学江宁校区", "未定", "南邮三牌楼校区","网申", "南京农业大学" };
    final String[] News_Addtime = new String[] { "09月02日-10月31日", "09月01日-11月30日", "08月28日-12月31日","09月19日-03月19日", "10月20日" };
    final String[] R_Content = new String[] { "工学 经济学 管理学", "经济学 教育学相关类", "经济学 理学 工学 管理学","信息工程相关类 网络工程相关类", "管理科学与工程相关类" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news, null);
        news_list= (ListView) view.findViewById(R.id.news_list);
        news_list.setOnItemClickListener(this);
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("news_type", News_Type[0]);
        map1.put("news_title", News_Title[0]);
        map1.put("news_date",News_Addtime[0] );
        data.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("news_type", News_Type[1]);
        map2.put("news_title", News_Title[1]);
        map2.put("news_date",News_Addtime[1] );
        data.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("news_type", News_Type[2]);
        map3.put("news_title", News_Title[2]);
        map3.put("news_date",News_Addtime[2] );
        data.add(map3);
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("news_type", News_Type[3]);
        map4.put("news_title", News_Title[3]);
        map4.put("news_date",News_Addtime[3] );
        data.add(map4);
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("news_type", News_Type[4]);
        map5.put("news_title", News_Title[4]);
        map5.put("news_date",News_Addtime[4] );
        data.add(map5);

        news_list.setAdapter(new SimpleAdapter(getContext(), data, R.layout.news_list,new String[] { "news_type", "news_title","news_date" }, new int[] { R.id.news_type, news_title, R.id.news_date}));
        news_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Bundle bundle = new Bundle();
                bundle.putString("news_title", News_Title[arg2]);
                bundle.putString("news_time", News_Time[arg2]);
                bundle.putString("news_author", News_Author[arg2]);
                bundle.putString("news_type", News_Type[arg2]);
                bundle.putString("news_address", News_Address[arg2]);
                bundle.putString("news_addtime", News_Addtime[arg2]);
                bundle.putString("r_content", R_Content[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getActivity(), NewsDetailActivity.class);

                startActivity(intent);
            }
        });
        return view;

    }








    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getContext(),NewsDetailActivity.class);
        Bundle bundle=new Bundle();
        News n=news.get(position);

        bundle.putString("n_type",n.getNews_type());
        bundle.putString("n_title",n.getNews_title());
        bundle.putString("n_time",n.getCreatedAt());
        bundle.putString("n_content",n.getNews_content());
        bundle.putString("n_author",n.getAuthor());
        bundle.putString("n_address",n.getAddress());
        bundle.putString("n_addtime",n.getNews_addtime());
        intent.putExtras(bundle);
        startActivity(intent);

    }


}