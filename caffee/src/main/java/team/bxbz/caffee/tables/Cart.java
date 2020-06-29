package team.bxbz.caffee.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//购物车信息表
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "cart_id")
    private int cart_id;//购物车ID

    @Column(name = "user_id")
    private int user_id;//用户ID

    @Column(name = "food_number")
    private int food_numbers;//餐点数量

    @Column(name = "food_price")
    private int food_price;//餐点单价

    @Column(name = "total_price")
    private int total_price;//餐点总价

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }

    public void setFood_numbers(int food_numbers) {
        this.food_numbers = food_numbers;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
