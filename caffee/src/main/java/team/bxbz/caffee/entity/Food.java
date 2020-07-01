package team.bxbz.caffee.entity;

import org.springframework.stereotype.Component;

@Component
public class Food {
    private String name;//餐点名称
    private String type;//餐点类型
    private Integer amount;//库存数量
    private Double price;//餐点单价

    //构造函数
    public Food() { }
    public Food(String name, String type, int amount, double price) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.price = price;
    }

    //get方法
    public String getName() { return name; }
    public String getType() { return type; }
    public int getAmount() { return amount; }
    public double getPrice() { return price; }

    //set方法
    public void setName(String name) { this.name = name; }
    public void setAmount(Integer amount) { this.amount = amount; }
    public void setPrice(Double price) { this.price = price; }
    public void setType(String type) { this.type = type; }

    //toString
    public String toString(){
        return "name:"+name+"\namount:"+amount+"\nprice:"+price+"\ntype:"+type;
    }
}
