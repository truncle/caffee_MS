package team.bxbz.caffee.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//管理员信息表
@Entity
@Table(name = "admin")
public class Administrator {
    @Id
    @Column(name = "admin_id")
    private int admin_id;//管理员ID

    @Column(name = "admin_phone")
    private String admin_phone;//管理员电话

    @Column(name = "admin_email")
    private String admin_email;//管理员邮箱

    @Column(name = "admin_password")
    private String admin_password;//管理员密码

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }
}
