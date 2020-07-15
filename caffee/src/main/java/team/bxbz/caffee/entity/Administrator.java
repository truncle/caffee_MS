package team.bxbz.caffee.entity;

import org.springframework.stereotype.Component;

@Component
public class Administrator {
    private String ad_ID;//管理员账号
    private String ad_password;//密码
    private String ad_tele;//电话
    private String ad_email;//邮箱

    //构造方法
    public Administrator() {
    }

    public Administrator(String ad_ID, String ad_password, String ad_tele, String ad_email) {
        this.ad_ID = ad_ID;
        this.ad_password = ad_password;
        this.ad_tele = ad_tele;
        this.ad_email = ad_email;
    }

    //get方法
    public String getAd_ID() {
        return ad_ID;
    }

    public String getAd_password() {
        return ad_password;
    }

    public String getAd_tele() {
        return ad_tele;
    }

    public String getAd_email() {
        return ad_email;
    }

    //set方法
    public void setAd_ID(String ad_ID) {
        this.ad_ID = ad_ID;
    }

    public void setAd_password(String ad_password) {
        this.ad_password = ad_password;
    }

    public void setAd_tele(String ad_tele) {
        this.ad_tele = ad_tele;
    }

    public void setAd_email(String ad_email) {
        this.ad_email = ad_email;
    }
}
