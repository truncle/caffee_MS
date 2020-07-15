package team.bxbz.caffee.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String userID;//用户账号
    private String password;//密码
    private String userTele;//电话
    private String userEmail;//邮箱

    //构造方法
    public User() {
    }

    public User(String userID, String password, String userTele, String userEmail) {
        this.userID = userID;
        this.password = password;
        this.userTele = userTele;
        this.userEmail = userEmail;
    }

    //get方法
    public String getUserID() {
        return userID;
    }

    public String getUserTele() { return userTele; }

    public String getPassword() {
        return password;
    }

    public String getUserEmail() { return userEmail; }

    //set方法
    public void setUserID(String userID) { this.userID = userID; }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserTele(String userTele) {
        this.userTele = userTele;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}