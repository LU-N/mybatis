package com.mapper;

import com.domain.Order;

import java.util.List;

/**
 * @author JinLu
 */
public interface OrderMapper {
    /**
     * findAll
     * @return
     */
    List<Order> findAll();
}
