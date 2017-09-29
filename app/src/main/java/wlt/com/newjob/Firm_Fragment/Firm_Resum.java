package wlt.com.newjob.Firm_Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;
import wlt.com.newjob.R;
import wlt.com.newjob.bean.Firm;
import wlt.com.newjob.entity.FirmJobDetailActivity;
import wlt.com.newjob.firm_entity.AddActivity;

/**
 * Created by Administrator on 2017/6/2.
 */

public class Firm_Resum extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    Button add;
    ListView job_list;
    List<Firm> result;
    final String[] Fj_Name = new String[] { "职位名称1", "职位名称2", "职位名称3","职位名称4", "职位名称5" };
    final String[] Fj_Wage = new String[] { "薪资1", "薪资2", "薪资3","薪资4", "薪资5" };
    final String[] Fj_Jobtype = new String[] { "职位类别1", "职位类别2", "职位类别3","职位类别4", "职位类别5" };
    final String[] Fj_Tel = new String[] { "联系电话1", "联系电话2", "联系电话3","联系电话4", "联系电话5" };
    final String[] Fj_Address = new String[] { "工作地点1", "工作地点2", "工作地点3","工作地点4", "工作地点5" };
    final String[] Fj_Firm = new String[] { "公司名称1", "公司名称2", "公司名称3","公司名称4", "公司名称5" };
    final String[] Fj_Describe = new String[] { "岗位描述1", "岗位描述2", "岗位描述3","岗位描述4", "岗位描述5" };
    private static final int DEL_ITEM=0x1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firm_jhunt, null);
        job_list = (ListView) view.findViewById(R.id.fhunt_list);
        add= (Button) view.findViewById(R.id.f_add);
        add.setOnClickListener(this);
        job_list.setOnItemClickListener(this);
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("fj_name", Fj_Name[0]);
        map1.put("fj_firm", Fj_Firm[0]);
        map1.put("fj_wage", Fj_Wage[0]);
        data.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("fj_name", Fj_Name[1]);
        map2.put("fj_firm", Fj_Firm[1]);
        map2.put("fj_wage", Fj_Wage[1]);
        data.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("fj_name", Fj_Name[2]);
        map3.put("fj_firm", Fj_Firm[2]);
        map3.put("fj_wage", Fj_Wage[2]);
        data.add(map3);
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("fj_name", Fj_Name[3]);
        map4.put("fj_firm", Fj_Firm[3]);
        map4.put("fj_wage", Fj_Wage[3]);
        data.add(map4);
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("fj_name", Fj_Name[4]);
        map5.put("fj_firm", Fj_Firm[4]);
        map5.put("fj_wage", Fj_Wage[4]);
        data.add(map5);
        job_list.setAdapter(new SimpleAdapter(getContext(), data, R.layout.job_list,new String[] { "fj_name", "fj_firm","fj_wage" }, new int[] { R.id.job_name, R.id.firm_name, R.id.job_wage}));
        job_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Bundle bundle = new Bundle();
                bundle.putString("fj_name", Fj_Name[arg2]);
                bundle.putString("fj_wage", Fj_Wage[arg2]);
                bundle.putString("fj_jobtype", Fj_Jobtype[arg2]);
                bundle.putString("fj_tel", Fj_Tel[arg2]);
                bundle.putString("fj_address", Fj_Address[arg2]);
                bundle.putString("fj_firm", Fj_Firm[arg2]);
                bundle.putString("fj_describe", Fj_Describe[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getActivity(), FirmJobDetailActivity.class);
                startActivity(intent);
            }
        });
//        getJobInfo();
//        findView();

        this.registerForContextMenu(job_list);
        return view;
    }

    public void getJobInfo() {
        final ArrayList<Firm> f2 = null;
        result = new ArrayList<Firm>();
        final BmobQuery<Firm> bq = new BmobQuery<>();
        bq.order("-createdAt");//按照时间降序
        bq.findObjects(new FindListener<Firm>() {
            @Override
            public void done(List<Firm> list, BmobException e) {
                if (e == null) {
                    result.addAll(list);
                    System.out.println("查询成功，" + list.get(0).getFirm() + "," + list.get(0).getJob_name());

                    final String[] firm = new String[list.size()];
                    final String[] job_type = new String[list.size()];
                    final String[] job_name = new String[list.size()];
                    final String[] job_tel = new String[list.size()];
                    final String[] address = new String[list.size()];
                    final String[] job_time = new String[list.size()];
                    final String[] job_id=new String[list.size()];
                    final String[] job_wage=new String[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        firm[i] = list.get(i).getFirm();
                        job_type[i] = list.get(i).getJob_type();
                        job_name[i] = list.get(i).getJob_name();
                        job_tel[i] = list.get(i).getJob_tel();
                        address[i] = list.get(i).getAddress();
                        job_time[i] = list.get(i).getCreatedAt();
                        job_id[i]=list.get(i).getObjectId();
                        job_wage[i]=list.get(i).getWage();
                    }
                    class JobAdapter extends BaseAdapter {
                        private Context context;

                        public JobAdapter(Context context) {
                            this.context = context;
                        }

                        @Override
                        public int getCount() {
                            return firm.length;
                        }

                        @Override
                        public Object getItem(int position) {
                            return firm[position];
                        }

                        @Override
                        public long getItemId(int position) {
                            return position;
                        }

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            ViewHolder viewHolder;
                            View v = null;
                            if (convertView == null) {
                                LayoutInflater lf = LayoutInflater.from(context);
                                v = View.inflate(getContext(), R.layout.job_list, null);
                                viewHolder = new ViewHolder();
                                viewHolder.tv_firm = (TextView) v.findViewById(R.id.firm_name);
                                viewHolder.tv_jname = (TextView) v.findViewById(R.id.job_name);
                                viewHolder.tv_jtime = (TextView) v.findViewById(R.id.job_wage);

                                v.setTag(viewHolder);
                            } else {
                                v = convertView;
                                viewHolder = (ViewHolder) v.getTag();
                            }
                            viewHolder.tv_firm.setText(firm[position]);
                            viewHolder.tv_jname.setText(job_name[position]);
                            viewHolder.tv_jtime.setText(job_time[position]);
                            return v;
                        }

                        class ViewHolder {
                            TextView tv_firm;
                            TextView tv_jname;
                            TextView tv_jtime;
                        }
                    }
                    job_list.setAdapter(new JobAdapter(getContext()));
                }
            }
        });
    }

    private void findView(){
        job_list= (ListView) job_list.findViewById(R.id.fhunt_list);
    }

//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent=new Intent(getContext(),FJDetailActivity.class);
//        Bundle b=new Bundle();
//        Firm re=result.get(position);
//        b.putString("job_name",re.getJob_name());
//        b.putString("jwage",re.getWage());
//        b.putString("job_type",re.getJob_type());
//        b.putString("address",re.getAddress());
//        b.putString("job_describe",re.getJob_describe());
//        b.putString("job_tel",re.getJob_tel());
//        b.putString("job_id",re.getObjectId());
//        b.putString("firm_name",re.getFirm());
//        intent.putExtras(b);
//        startActivity(intent);
//    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(),AddActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(1,DEL_ITEM,100,"删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case DEL_ITEM:
                AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                View v=info.targetView;
                Firm result1=result.get(item.getItemId()-1);

                result1.delete(new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e==null){
                            getJobInfo();
                        }
                    }
                });
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}