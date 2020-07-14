package team.bxbz.caffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.bxbz.caffee.entity.ShoppingCart;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    //删除购物车
    int deleteByCartID(Integer cartID);

    //插入购物车
    int insert(ShoppingCart record);

    //按购物车号查询购物车
    ShoppingCart selectByCartID(Integer cartID);

    //按用户号查询购物车
    List<ShoppingCart> selectByUserID(String userID);

    //按购物车号更新购物车
    int updateByCartID(ShoppingCart record);
}
