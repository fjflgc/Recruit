package wlt.com.newjob.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/6/4.
 */

public class FirmInfo extends BmobObject{
    private String firm_name;
    private String firm_address;
    private String  firm_tel;
    private String firm_email;
    private String firm_development;
    private String firm_type;

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public String getFirm_address() {
        return firm_address;
    }

    public void setFirm_address(String firm_address) {
        this.firm_address = firm_address;
    }

    public String getFirm_tel() {
        return firm_tel;
    }

    public void setFirm_tel(String firm_tel) {
        this.firm_tel = firm_tel;
    }

    public String getFirm_email() {
        return firm_email;
    }

    public void setFirm_email(String firm_email) {
        this.firm_email = firm_email;
    }

    public String getFirm_development() {
        return firm_development;
    }

    public void setFirm_development(String firm_development) {
        this.firm_development = firm_development;
    }

    public String getFirm_type() {
        return firm_type;
    }

    public void setFirm_type(String firm_type) {
        this.firm_type = firm_type;
    }
}
