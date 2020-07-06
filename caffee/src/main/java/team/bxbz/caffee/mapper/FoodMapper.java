package team.bxbz.caffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.bxbz.caffee.entity.Food;

import java.util.List;

@Mapper
public interface FoodMapper {
    //删除餐点
    int deleteByName(String name);

    //插入餐点
    int insert(Food record);

    //按餐点名称查询餐点
    Food selectByName(String name);

    //按餐点名称更新餐点
    int updateByName(Food record);

    //查找所有餐点
    List<Food> selectAll();

    //按餐点类型查询餐点
    List<Food> selectByType(String type);
}
