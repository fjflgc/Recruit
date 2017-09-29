package wlt.com.newjob.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/5/11.
 */

public class Firm extends BmobObject{
    private String firm;
    private String job_type;
    private String job_name;
    private String job_describe;
    private String address;
    private String job_tel;
    private String wage;

    public Firm(String firm,String job_type,String job_name,String job_describe,String address,String job_tel,String wage){
        this.firm=firm;
        this.job_type=job_type;
        this.job_name=job_name;
        this.job_describe=job_describe;
        this.address=address;
        this.job_tel=job_tel;
        this.wage=wage;
    }
    public Firm(){};

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getJob_describe() {
        return job_describe;
    }

    public void setJob_describe(String job_describe) {
        this.job_describe = job_describe;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob_tel() {
        return job_tel;
    }

    public void setJob_tel(String job_tel) {
        this.job_tel = job_tel;
    }

}
