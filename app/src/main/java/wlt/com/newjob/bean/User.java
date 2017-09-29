package wlt.com.newjob.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2017/5/9.
 */

public class User extends BmobUser{
    private String age;
    private String gender;
    private String tel;
    private String address;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailVerified(String email) {

    }
}
