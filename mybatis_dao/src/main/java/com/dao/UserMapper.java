package com.dao;

import com.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author JinLu
 */
public interface UserMapper {
    public List<User> findAll() throws IOException;
}
