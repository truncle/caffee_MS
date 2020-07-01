package team.bxbz.caffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.bxbz.caffee.entity.Order;

@Mapper
public interface OrderMapper {
    //删除订单
    int deleteByOrderID(String orderID);
    //插入订单
    int insert(Order record);
    //按订单号查询订单
    Order selectByOrderID(String orderID);
    //按用户号查询订单
    Order selectByUserID(String userID);
    //按订单号更新订单
    int updateByOrderID(Order record);
}
