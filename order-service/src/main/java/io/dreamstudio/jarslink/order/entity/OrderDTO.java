package io.dreamstudio.jarslink.order.entity;

import java.util.Date;

/**
 * @author Ricky Fung
 */
public class OrderDTO {
    private Long id;
    private String orderNo;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
