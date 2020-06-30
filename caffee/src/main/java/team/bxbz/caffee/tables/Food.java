package team.bxbz.caffee.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//菜单表
@Entity
@Table(name = "food")
public class Food {
    @Id
    @Column(name = "food_name")
    private String food_name;//餐点名称

    @Column(name = "food_type")
    private String food_type;//餐点类型

    @Column(name = "food_stock")
    private int food_stock;//库存数量

    @Column(name = "food_price")
    private int food_price;//单价

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setFood_stock(int food_stock) {
        this.food_stock = food_stock;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }
}
