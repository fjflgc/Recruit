package wlt.com.newjob.Fragment;

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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;
import wlt.com.newjob.R;
import wlt.com.newjob.bean.Resum;
import wlt.com.newjob.entity.AddResumActivity;
import wlt.com.newjob.entity.ResumDetailActivity;

/**
 * Created by Administrator on 2017/5/10.
 */

public class Resume_Fragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    Button add;
    ListView resum_list;
    List<Resum> resum;

    private static final int DEL_ITEM=0x1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_resume,null);
        add= (Button) view.findViewById(R.id.add_resume);
        add.setOnClickListener(this);
//        resum_list= (ListView) view.findViewById(R.id.resum_list);
//        resum_list.setOnItemClickListener(this);
        getResumInfo();
        findView();

     //   this.registerForContextMenu(resum_list);//给ListView注册上下文菜单
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        getResumInfo();
    }

    public void getResumInfo(){
        final ArrayList<Resum> r=null;
        resum=new ArrayList<Resum>();
        final BmobQuery<Resum> b=new BmobQuery<>();
        b.order("-createdAt");//按照时间降序
//        BmobACL acl=new BmobACL();
//        acl.setWriteAccess(BmobUser.getCurrentUser(this),true);
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
                    final String[] rid=new String[list.size()];

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
                        rid[j]=list.get(j).getObjectId();
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
                                viewHolder.t_sname= (TextView) v.findViewById(R.id.rl_sname);
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
       // resum_list= (ListView) resum_list.findViewById(R.id.resum_list);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(), AddResumActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent1 = new Intent(getContext(), ResumDetailActivity.class);
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
        bundle.putString("r_id",re.getObjectId());
        intent1.putExtras(bundle);
        startActivity(intent1);
//        System.out.println("================"+re.getTelephone());

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(1,DEL_ITEM,100,"删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //System.out.println("jinru"+item.getItemId());
        switch (item.getItemId()){
            case DEL_ITEM:
                AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                View v=info.targetView;
                Resum rs=resum.get(item.getItemId()-1);
                //System.out.println(result.getObjectId()+";aaaa"+result.getName());
                //String objectId= String.valueOf(v.getTag());

                rs.delete(new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e==null){
                            getResumInfo();
                        }
                    }
                });
              break;
        }
        return super.onContextItemSelected(item);
    }
}
