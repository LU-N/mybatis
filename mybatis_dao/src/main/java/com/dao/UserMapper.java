package com.dao;

import com.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author JinLu
 */
public interface UserMapper {
    /**
     * findAll
     * @return
     * @throws IOException
     */
    public List<User> findAll() throws IOException;

    /**
     * findById
     * @param id
     * @return
     */
    public User findById(int id);
}
