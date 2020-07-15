package team.bxbz.caffee.entity;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    private Integer cart_id;//购物车号,自增主键,100000开始自增
    private String user_id;//用户号
    private String food_name;//餐点名称
    private Integer food_amount;//餐点数量
    private Double food_price;//餐点单价
    private Double total_price;//总价

    //构造方法
    public ShoppingCart() {
    }

    public ShoppingCart(String user_id, String food_name, Double food_price, int food_amount, Double total_price) {
        this.user_id = user_id;
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_amount = food_amount;
        this.total_price = total_price;
    }

    public ShoppingCart(Integer cart_id,String user_id, String food_name, Double food_price, int food_amount, Double total_price) {
        this.cart_id=cart_id;
        this.user_id = user_id;
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_amount = food_amount;
        this.total_price = total_price;
    }

    //set方法
    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setFood_amount(Integer food_amount) {
        this.food_amount = food_amount;
    }

    public void setFood_price(Double food_price) {
        this.food_price = food_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    //get方法
    public Integer getCart_id() {
        return cart_id;
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

    public double getTotal_price() { return total_price; }
}
