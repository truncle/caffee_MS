package team.bxbz.caffee.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Order {
    private Integer order_id;//订单号 设置为自增主键
    private String user_id;//用户号
    private String food_name;//餐点名称
    private Double food_price;//餐点单价
    private Integer food_amount;//餐点数量
    private Double total_price;//总价
    private Timestamp create_time;//时间

    //构造方法
    public Order() {
    }

    public Order(String user_id, String food_name, Double food_price, int food_amount, Double total_price) {
        this.user_id = user_id;
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_amount = food_amount;
        this.total_price = total_price;
    }

    public Order(Integer order_id, String user_id, String food_name, Double food_price, int food_amount, Double total_price) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_amount = food_amount;
        this.total_price = total_price;
    }

    //set方法
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setFood_price(Double food_price) {
        this.food_price = food_price;
    }

    public void setFood_amount(int food_amount) {
        this.food_amount = food_amount;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public void setCreate_time(Timestamp create_time) { this.create_time = create_time; }

    //get方法
    public Integer getOrder_id() {
        return order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public int getFood_amount() {
        return food_amount;
    }

    public double getFood_price() {
        return food_price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public Timestamp getCreate_time() { return create_time; }
}
