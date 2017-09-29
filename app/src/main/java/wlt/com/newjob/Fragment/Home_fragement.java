package wlt.com.newjob.Fragment;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import wlt.com.newjob.Adapter.Job_Adapter;
import wlt.com.newjob.R;
import wlt.com.newjob.bean.Firm;
import wlt.com.newjob.bean.Job;
import wlt.com.newjob.entity.FirstJobActivity;
import wlt.com.newjob.entity.FourthJobActivity;
import wlt.com.newjob.entity.JobDetailActivity;
import wlt.com.newjob.entity.SearchActivity;
import wlt.com.newjob.entity.SecondJobActivity;
import wlt.com.newjob.entity.ThirdJobActivity;

/**
 * Created by Administrator on 2017/5/10.
 */

public class Home_fragement extends Fragment implements AdapterView.OnItemClickListener{
    ListView job_list;
    List<Firm> result;
    private List<Job> jobList=new ArrayList<>();

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_index, null);
        initJobs();//初始化职业数据
        final Job_Adapter job_adapter=new Job_Adapter(getContext(),R.layout.job_item,jobList);
        job_list = (ListView) view.findViewById(R.id.job_list);
        job_list.setAdapter(job_adapter);
         etSearch= (EditText) view.findViewById(R.id.etSearch) ;
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.print("dianjiale");
                startActivity(new Intent(getActivity(),SearchActivity.class));
            }
        });



        job_list.setOnItemClickListener(this);
        getJobInfo();
        findView();
 final String [] URI=new String[]{"http://www.njupt.edu.cn/","http://theory.people.com.cn/n1/2017/0701/c40531-29376368.html","http://www.huawei.com/cn/","http://home.baidu.com/home/index/join_us","https://job.alibaba.com/zhaopin/index.htm"};

        mViewPaper = (ViewPager) view.findViewById(R.id.vp);
        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
            final int finalI = i;
            final int finalI1 = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(URI[finalI1]));
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
        job_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), demos[position].demoClass);
                startActivity(intent);
            }
        });

        return view;
    }

    private void initJobs() {

        Job job1=new Job("JAVA开发工程师","宜信大数据创新中心","发布于2017-09-26");
        jobList.add(job1);
        Job job2=new Job("PHP开发工程师","北京奇虎科技有限公司","发布于2017-09-22");
        jobList.add(job2);
        Job job3=new Job("C++开发工程师","顺网科技股份有限公司","发布于2017-09-14");
        jobList.add(job3);
        Job job4=new Job("高级Android开发","北京爱奇艺科技有限公司","发布于2017-09-18");
        jobList.add(job4);
    }

    public List<Job> getJobList() {
        return jobList;
    }


    //把每个activity转成class
    private static class DemoInfo {
        private final Class<? extends android.app.Activity> demoClass;

        public DemoInfo(Class<? extends android.app.Activity> demoClass) {
            this.demoClass = demoClass;
        }
    }

    //把每个activity转成xxx.class
    private static final DemoInfo[] demos = {
            new DemoInfo(FirstJobActivity.class),
            new DemoInfo(SecondJobActivity.class),
            new DemoInfo(ThirdJobActivity.class),
            new DemoInfo(FourthJobActivity.class),
//            new DemoInfo(FifthGameActivity.class),
//            new DemoInfo(SixthGameActivity.class)
    };
    public void getJobInfo(){
        final ArrayList<Firm> f2=null;
        result=new ArrayList<Firm>();
        final BmobQuery<Firm> bq=new BmobQuery<>();
        bq.order("-createdAt");//按照时间降序
//        bq.setLimit(5);
//        bq.setSkip(5);
        bq.findObjects(new FindListener<Firm>() {
            @Override
            public void done(List<Firm> list, BmobException e) {
                if (e==null){
                    result.addAll(list);
                    System.out.println("查询成功，"+list.get(0).getFirm()+","+list.get(0).getJob_name());

                    final String[] firm=new String[list.size()];
                    final String[] job_type=new String[list.size()];
                    final String[] job_name=new String[list.size()];
                    final String[] job_tel=new String[list.size()];
                    final String[] address=new String[list.size()];
                    final String[] job_time=new String[list.size()];

                    for (int i=0;i<list.size();i++){
                        firm[i]=list.get(i).getFirm();
                        job_type[i]=list.get(i).getJob_type();
                        job_name[i]=list.get(i).getJob_name();
                        job_tel[i]=list.get(i).getJob_tel();
                        address[i]=list.get(i).getAddress();
                        job_time[i]=list.get(i).getCreatedAt();
                    }
//                    class JobAdapter extends BaseAdapter{
//                        private Context context;
//                        public JobAdapter(Context context){
//                            this.context=context;
//                        }
//                        @Override
//                        public int getCount() {
//                            return firm.length;
//                        }
//
//                        @Override
//                        public Object getItem(int position) {
//                            return firm[position];
//                        }
//
//                        @Override
//                        public long getItemId(int position) {
//                            return position;
//                        }
//
//                        @Override
//                        public View getView(int position, View convertView, ViewGroup parent) {
//                            ViewHolder viewHolder;
//                            View v=null;
//                            if (convertView==null){
//                                LayoutInflater lf=LayoutInflater.from(context);
//                                v=View.inflate(getContext(),R.layout.job_list,null);
//                                viewHolder=new ViewHolder();
//                                viewHolder.tv_firm= (TextView) v.findViewById(R.id.firm_name);
//                                viewHolder.tv_jname= (TextView) v.findViewById(R.id.job_name);
//                                viewHolder.tv_jtime= (TextView) v.findViewById(R.id.job_time);
//
//                                v.setTag(viewHolder);
//                            }else{
//                                v=convertView;
//                                viewHolder= (ViewHolder) v.getTag();
//                            }
//                            viewHolder.tv_firm.setText(firm[position]);
//                            viewHolder.tv_jname.setText(job_name[position]);
//                            viewHolder.tv_jtime.setText(job_time[position]);
//                            return v;
//                        }
//                        class ViewHolder{
//                            TextView tv_firm;
//                            TextView tv_jname;
//                            TextView tv_jtime;
//                        }
//                    }

                }
            }
        });
    }

    private void findView(){
        job_list= (ListView) job_list.findViewById(R.id.job_list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getContext(),JobDetailActivity.class);
//        Bundle b=new Bundle();
//        Firm re=result.get(position);

//        b.putString("job_name",re.getJob_name());
//        b.putString("jtime",re.getCreatedAt());
//        b.putString("job_type",re.getJob_type());
//        b.putString("address",re.getAddress());
//        b.putString("job_describe",re.getJob_describe());
//        b.putString("job_tel",re.getJob_tel());
//        b.putString("firm_name",re.getFirm());
//        intent.putExtras(b);
       startActivity(intent);
    }
    /**
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
