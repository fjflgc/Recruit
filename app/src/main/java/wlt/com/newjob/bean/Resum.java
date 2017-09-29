package wlt.com.newjob.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/5/11.
 */

public class Resum extends BmobObject {
    private String name;
    private String school;
    private String majority;
    private String introduce;
    private String age;
    private String job_wanted;
    private String telephone;
    private String r_experience;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getJob_wanted() {
        return job_wanted;
    }

    public void setJob_wanted(String job_wanted) {
        this.job_wanted = job_wanted;
    }


    public String getR_experience() {
        return r_experience;
    }

    public void setR_experience(String r_experience) {
        this.r_experience = r_experience;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajority() {
        return majority;
    }

    public void setMajority(String majority) {
        this.majority = majority;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


}
