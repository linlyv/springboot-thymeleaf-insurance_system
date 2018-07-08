package com.gh003.user.service;

import java.util.List;

import com.gh003.user.entity.User;

/**
 * 用户Service接口
 *
 * @author BAIYEQIYA
 * @date 2017/12/22 15:03
 * @since JDK 1.8
 */
public interface UserService {

    /**
     * 根据id获取用户数据
     *
     * @param id 用户id。
     * @return 返回对应的用户数据。
     * @throws Exception 如果查询出错。
     */
    User getById(int id) throws Exception;
    void save(User user);
	User getUserByName(String name);
	User getUserByPassword(String password);
	List<User> getUserListByName(String name);
	List<User> getUserListByPassword(String password);
}
