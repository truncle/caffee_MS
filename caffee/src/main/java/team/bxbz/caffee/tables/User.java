package team.bxbz.caffee.tables;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//用户信息表
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private int user_id;//用户ID

    @Column(name = "user_phone")
    private String user_phone;//用户电话

    @Column(name = "user_email")
    private String user_email;//用户邮箱

    @Column(name = "user_password")
    private String user_password;//用户密码

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
