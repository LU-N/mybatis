package com.mapper;

import com.domain.User;

import java.util.List;

/**
 * @author JinLu
 */
public interface UserMapper {

    public List<User> findByCondition(User user);

    /**
     * findByIds
     * @param ids
     * @return
     */
    public List<User> findByIds(List<Integer> ids);


}
