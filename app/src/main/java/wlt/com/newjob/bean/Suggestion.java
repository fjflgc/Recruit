package wlt.com.newjob.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/5/12.
 */

public class Suggestion extends BmobObject{
    private String content;
    private String tel;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
