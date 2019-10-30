package com.dao;


import com.domain.User;

import java.util.List;

/**
 * @author JinLu
 */
public interface UserMapper {
    public List<User> findByCondition(User user);
}
