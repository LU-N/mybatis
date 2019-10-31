package com.mapper;

import com.domain.User;

import java.util.List;

/**
 * @author JinLu
 */
public interface UserMapper {
    /**
     * findAll
     * @return
     */
    public List<User> findAll();
}
