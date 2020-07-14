package team.bxbz.caffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.bxbz.caffee.entity.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    //删除订单
    int deleteByOrderID(Integer orderID);

    //插入订单
    int insert(Order record);

    //按订单号查询订单
    Order selectByOrderID(Integer orderID);

    //按用户号查询订单
    List<Order> selectByUserID(String userID);

    //按订单号更新订单
    int updateByOrderID(Order record);

    //查询所有
    List<Order> selectAll();

}
