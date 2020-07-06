package io.dreamstudio.jarslink.order.action;

import com.alipay.jarslink.api.Action;
import io.dreamstudio.jarslink.order.entity.OrderDTO;

import java.util.Date;
import java.util.UUID;

/**
 * @author Ricky Fung
 */
public class OrderAction implements Action<Long, OrderDTO> {

    @Override
    public OrderDTO execute(Long id) {
        OrderDTO orderDTO  = new OrderDTO();
        orderDTO.setId(id);
        orderDTO.setOrderNo(UUID.randomUUID().toString());
        orderDTO.setCreateTime(new Date());
        return orderDTO;
    }

    @Override
    public String getActionName() {
        return "order";
    }
}