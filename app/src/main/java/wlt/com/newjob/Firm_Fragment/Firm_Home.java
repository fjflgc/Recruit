package wlt.com.newjob.Firm_Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import wlt.com.newjob.R;
import wlt.com.newjob.bean.Resum;
import wlt.com.newjob.entity.AddResumActivity;
import wlt.com.newjob.firm_entity.FirmRContentActivity;

import static wlt.com.newjob.R.id.rl_sname;

/**
 * Created by Administrator on 2017/6/2.
 */

public class Firm_Home extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    Button add;
    ListView resum_list;
    List<Resum> resum;
    final String[] R_Time = new String[] { "发布时间1", "发布时间2", "发布时间3","发布时间4", "发布时间5" };
    final String[] F_Name = new String[] { "名字1", "名字2", "名字3","名字4", "名字5" };
    final String[] F_Age = new String[] { "年龄1", "年龄2", "年龄3","年龄4", "年龄5" };
    final String[] F_School = new String[] { "学校1", "学校2", "学校3","学校4", "学校5" };
    final String[] F_Majority = new String[] { "专业1", "专业2", "专业3","专业4", "专业5" };
    final int[] F_Tel = new int[] { 111,222,333,444,555 };
    final String[] F_Job = new String[] { "求职岗位1", "求职岗位2", "求职岗位3","求职岗位4", "求职岗位5" };
    final String[] F_Ex = new String[] { "经历1", "经历2", "经历3","经历4", "经历5" };
    final String[] F_Describe = new String[] { "职业技能1", "职业技能2", "职业技能3","职业技能4", "职业技能5" };

    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //搜索框
    private EditText etSearch;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.a,
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3,
            R.drawable.bg4
    };
    //存放图片的标题
    private String[]  titles = new String[]{
            "信达天下，自强不息",
            "以优异成绩迎接党的十九大胜利召开",
            "华为携手世界500强企业数字化转型",
            "招最好的人，让优秀人才脱颖而出",
            "让天下没有难做的生意"
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;

    private static final int DEL_ITEM=0x1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.firm_index,null);
        resum_list= (ListView) view.findViewById(R.id.f_list);
        resum_list.setOnItemClickListener(this);
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("rl_name", F_Name[0]);
        map1.put("rl_sname", F_School[0]);
        map1.put("r_time",R_Time[0]);
        data.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("rl_name", F_Name[1]);
        map2.put("rl_sname", F_School[1]);
        map2.put("r_time",R_Time[1]);
        data.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("rl_name", F_Name[2]);
        map3.put("rl_sname", F_School[2]);
        map3.put("r_time",R_Time[2]);
        data.add(map3);
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("rl_name", F_Name[3]);
        map4.put("rl_sname", F_School[3]);
        map4.put("r_time",R_Time[3]);
        data.add(map4);
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("rl_name", F_Name[4]);
        map5.put("rl_sname", F_School[4]);
        map5.put("r_time",R_Time[4]);
        data.add(map5);
        resum_list.setAdapter(new SimpleAdapter(getContext(), data, R.layout.resum_list,new String[] { "rl_name", "rl_sname","r_time" }, new int[] { R.id.rl_name, rl_sname, R.id.r_time}));
        resum_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Bundle bundle = new Bundle();
                bundle.putString("f_name", F_Name[arg2]);
                bundle.putString("f_age", F_Age[arg2]);
                bundle.putString("f_school", F_School[arg2]);
                bundle.putString("f_majority", F_Majority[arg2]);
                bundle.putInt("f_tel", F_Tel[arg2]);
                bundle.putString("f_job", F_Job[arg2]);
                bundle.putString("f_ex", F_Ex[arg2]);
                bundle.putString("f_describe", F_Describe[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getActivity(), FirmRContentActivity.class);
                startActivity(intent);
            }
        });
//        getResumInfo();
//        findView();

        mViewPaper = (ViewPager) view.findViewById(R.id.vp);
        //显示的图片
        images = new ArrayList<ImageView>();
        final String [] URI=new String[]{"http://www.njupt.edu.cn/","http://theory.people.com.cn/n1/2017/0701/c40531-29376368.html","http://www.huawei.com/cn/","http://home.baidu.com/home/index/join_us","https://job.alibaba.com/zhaopin/index.htm"};

        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(URI[finalI]));
                    startActivity(intent);
                }
            });
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(view.findViewById(R.id.dot_0));
        dots.add(view.findViewById(R.id.dot_1));
        dots.add(view.findViewById(R.id.dot_2));
        dots.add(view.findViewById(R.id.dot_3));
       dots.add(view.findViewById(R.id.dot_4));

        title = (TextView) view.findViewById(R.id.title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            final String [] URI=new String[]{"http://www.njupt.edu.cn/","https://www.bilibili.com/","https://www.bilibili.com/","https://www.bilibili.com/","https://www.bilibili.com/"};


            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_focused);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        return view;
    }

    public void getResumInfo(){
        final ArrayList<Resum> r=null;
        resum=new ArrayList<Resum>();
        final BmobQuery<Resum> b=new BmobQuery<>();
        b.order("-createdAt");//按照时间降序
        b.findObjects(new FindListener<Resum>() {
            @Override
            public void done(final List<Resum> list, BmobException e) {
                if (e==null){
                    resum.addAll(list);
                    System.out.println("查询成功"+list.get(0).getName()+","+list.get(0).getSchool());
                    final String[] rname=new String[list.size()];
                    final String[] rschool=new String[list.size()];
                    final String[] rmajority=new String[list.size()];
                    final String[] rintroduce=new String[list.size()];
                    final String[] rtime=new String[list.size()];
                    final String[] rage=new String[list.size()];
                    final String[] rjwant=new String[list.size()];
                    final String[] rtel=new String[list.size()];
                    final String[] rexperience=new String[list.size()];

                    for (int j=0;j<list.size();j++){
                        rname[j]=list.get(j).getName();
                        rschool[j]=list.get(j).getSchool();
                        rmajority[j]=list.get(j).getMajority();
                        rintroduce[j]=list.get(j).getIntroduce();
                        rtime[j]=list.get(j).getCreatedAt();
                        rage[j]=list.get(j).getAge();
                        rjwant[j]=list.get(j).getJob_wanted();
                        rtel[j]=list.get(j).getTelephone();
                        rexperience[j]=list.get(j).getR_experience();
                    }
                    class ResumAdapter extends BaseAdapter{
                        private Context context;
                        public ResumAdapter(Context context){
                            this.context=context;
                        }

                        @Override
                        public int getCount() {
                            return rname.length;
                        }

                        @Override
                        public Object getItem(int position) {
                            return rname[position];
                        }

                        @Override
                        public long getItemId(int position) {
                            return position;
                        }

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            ViewHolder viewHolder;
                            View v=null;
                            if (convertView==null){
                                LayoutInflater lf=LayoutInflater.from(context);
                                v=View.inflate(getContext(),R.layout.resum_list,null);
                                viewHolder=new ViewHolder();
                                viewHolder.t_rname= (TextView) v.findViewById(R.id.rl_name);
                                viewHolder.t_sname= (TextView) v.findViewById(rl_sname);
                                viewHolder.t_time= (TextView) v.findViewById(R.id.r_time);
                                v.setTag(viewHolder);
                            } else {
                                v=convertView;
                                viewHolder= (ViewHolder) v.getTag();
                            }

                            viewHolder.t_rname.setText(rname[position]);
                            viewHolder.t_sname.setText(rschool[position]);
                            viewHolder.t_time.setText(rtime[position]);
                            return v;
                        }
                        class ViewHolder{
                            TextView t_rname;
                            TextView t_sname;
                            TextView t_time;
                        }
                    }
                    resum_list.setAdapter(new ResumAdapter(getContext()));
                }
            }
        });
    }

    private void findView(){
        resum_list= (ListView) resum_list.findViewById(R.id.f_list);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(), AddResumActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent1 = new Intent(getContext(), FirmRContentActivity.class);
        Bundle bundle = new Bundle();
        Resum re = resum.get(position);
        bundle.putString("r_name", re.getName());
        bundle.putString("r_school", re.getSchool());
        bundle.putString("r_majority", re.getMajority());
        bundle.putString("r_introduce", re.getIntroduce());
        bundle.putString("r_age", re.getAge());
        bundle.putString("r_tel", re.getTelephone());
        bundle.putString("r_jw",re.getJob_wanted());
        bundle.putString("r_ex",re.getR_experience());
        intent1.putExtras(bundle);
        startActivity(intent1);
    }
    /*
    * 自定义Adapter
    * @author liuyazhuang
    *
            */
    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//			super.destroyItem(container, position, object);
//			view.removeView(view.getChildAt(position));
//			view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }

    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);

        }
    }
    /**
     * 接收子线程传递过来的数据
     */
    private android.os.Handler mHandler=new android.os.Handler(){
        public void handlerMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        };
    };
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }
//    private Handler mHandler = new Handler(){
//        public void handleMessage(android.os.Message msg) {
//            mViewPaper.setCurrentItem(currentItem);
//        };
//    };
//    @Override
//    protected void onStop() {
//        TODO Auto-generated method stub
//        super.onStop();
//    }

}
