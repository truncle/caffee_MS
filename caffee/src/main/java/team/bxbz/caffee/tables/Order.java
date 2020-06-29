package team.bxbz.caffee.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//订单信息表
@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "order_id")
    private int order_id;//订单ID

    @Column(name = "food_number")
    private int food_number;//餐点数量

    @Column(name = "food_name")
    private String food_name;//餐点名称

    @Column(name = "food_price")
    private int food_price;//餐点单价

    @Column(name = "total_price")
    private int total_price;//餐点总价

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public void setFood_number(int food_number) {
        this.food_number = food_number;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
