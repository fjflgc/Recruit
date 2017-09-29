package wlt.com.newjob.bean;

/**
 * Created by fjf on 2017/9/24.
 */

public class Job {
    private String jobName;
    private String jobFirm;
    private String jobDate;
    public  Job(String jobName,String jobFirm,String jobDate){
        this.jobName=jobName;
        this.jobFirm=jobFirm;
        this.jobDate=jobDate;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobFirm() {
        return jobFirm;
    }

    public String getJobDate() {
        return jobDate;
    }
}
