package com.gh003.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gh003.user.entity.User;
@Mapper
public interface UserMapper {
    /**
     *
     * @mbggenerated
     */
    int insert(User record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     *
     * @mbggenerated
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    
    User selectByPrimaryName(String name);
    User selectByPrimaryPassword(String password);
    
    
    List<User> selectByNameToList(String name);
    List<User> selectByPasswordToList(String password);
    List<User> selectByPasswordFillter(String password);
    List<User> selectAllUser();
    
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);
    int deleteUser(int id);

    List<User> findUserByNameAndPasswd(String name, String password);
	
}