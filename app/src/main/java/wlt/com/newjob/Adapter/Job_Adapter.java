package wlt.com.newjob.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wlt.com.newjob.R;
import wlt.com.newjob.bean.Job;

/**
 * Created by fjf on 2017/9/24.
 */

public class Job_Adapter extends ArrayAdapter<Job> {
    private int resourceId;
    private Context mContext;
    private List<String> mList = new ArrayList<>();

//    public int getCount() {
//        return mList.size();
//    }
//    @Override
//    public Job getItem(int i) {
//        return (Job) mList;}
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }

    public Job_Adapter( Context context,  int textViewResourceId,  List<Job> objects) {
        super(context, textViewResourceId, objects);
        resourceId=textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Job job=getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView jobName=(TextView)view.findViewById(R.id.jobName);
        TextView jobFirm=(TextView)view.findViewById(R.id.jobFirm);
        TextView jobDate=(TextView)view.findViewById(R.id.jobDate);
//        Button dtButton=(Button)view.findViewById(R.id.dtbutton);
        jobName.setText(job.getJobName());
        jobFirm.setText(job.getJobFirm());
        jobDate.setText(job.getJobDate());
//        dtButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Toast.makeText(getContext(),"123",Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;

    }
}
