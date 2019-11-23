package com.congee.mapper;
import com.congee.domain.Order;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface OrderMapper {
    Order saveOrder(Order order);
    Order findById(Integer oid);
}
