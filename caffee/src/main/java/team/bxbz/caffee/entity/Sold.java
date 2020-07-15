package team.bxbz.caffee.entity;

import org.springframework.stereotype.Component;

@Component
public class Sold {
    private String food_name;//餐点名称
    private Integer sold_amount;//销售数量

    public Sold() {
    }

    public Sold(String food_name, Integer sold_amount) {
        this.food_name = food_name;
        this.sold_amount = sold_amount;
    }

    public String getFood_name() {
        return food_name;
    }

    public Integer getSold_amount() {
        return sold_amount;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setSold_amount(Integer sold_amount) {
        this.sold_amount = sold_amount;
    }
}
