package team.bxbz.caffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.bxbz.caffee.entity.Sold;

import java.util.List;

@Mapper
public interface SoldMapper {
    //插入数据
    int insert(Sold sold);

    //查询数据
    List<Sold> selectAll();

    //更新数据
    int updateByFoodName(Sold sold);

    //根据餐点名称查询
    Sold selectByFoodName(String food_name);
}
