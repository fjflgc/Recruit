package wlt.com.newjob.entity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import wlt.com.newjob.R;
import wlt.com.newjob.bean.Firm;

public class SearchActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private  EditText etSearch;
    private    ListView  jobList;
    List<Firm> result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toast.makeText(SearchActivity.this,"敬请期待。。。",Toast.LENGTH_SHORT).show();

         etSearch= (EditText)findViewById(R.id.etSearch);
//          btSearch=(Button) findViewById(R.id.btnSearch);
         jobList=(ListView)findViewById(R.id.job_list1);
         jobList.setOnItemClickListener(this);
         etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Toast.makeText(SearchActivity.this,"gaibian",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println(s+"....................");
                final ArrayList<Firm> f2=null;
                final BmobQuery<Firm> query=new BmobQuery<Firm>();
                result=new ArrayList<Firm>();
                query.addWhereEqualTo("job_name",s);
                query.setLimit(50);
                query.findObjects(new FindListener<Firm>() {
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
                            class JobAdapter extends BaseAdapter {
                                private Context context;
                                public JobAdapter(Context context){
                                    this.context=context;
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
                                    View v=null;
                                    if (convertView==null){
                                        LayoutInflater lf=LayoutInflater.from(context);
                                        v=View.inflate(SearchActivity.this,R.layout.job_list,null);
                                        viewHolder=new ViewHolder();
                                        viewHolder.tv_firm= (TextView) v.findViewById(R.id.firm_name);
                                        viewHolder.tv_jname= (TextView) v.findViewById(R.id.job_name);
                                        viewHolder.tv_jtime= (TextView) v.findViewById(R.id.job_wage);

                                        v.setTag(viewHolder);
                                    }else{
                                        v=convertView;
                                        viewHolder= (ViewHolder) v.getTag();
                                    }
                                    viewHolder.tv_firm.setText(firm[position]);
                                    viewHolder.tv_jname.setText(job_name[position]);
                                    viewHolder.tv_jtime.setText(job_time[position]);
                                    return v;
                                }
                                class ViewHolder{
                                    TextView tv_firm;
                                    TextView tv_jname;
                                    TextView tv_jtime;
                                }
                            }
                            jobList.setAdapter(new JobAdapter(SearchActivity.this));
                        }
                    }
                });
            }
        });
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(SearchActivity.this,JobDetailActivity.class);
        Bundle b=new Bundle();
        Firm re=result.get(position);

        b.putString("job_name",re.getJob_name());
        b.putString("jtime",re.getCreatedAt());
        b.putString("job_type",re.getJob_type());
        b.putString("address",re.getAddress());
        b.putString("job_describe",re.getJob_describe());
        b.putString("job_tel",re.getJob_tel());
        intent.putExtras(b);
        startActivity(intent);
    }
}
