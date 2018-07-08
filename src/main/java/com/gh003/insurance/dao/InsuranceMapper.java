package com.gh003.insurance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gh003.insurance.entity.Insurance;

@Mapper
public interface InsuranceMapper {
    /**
     *
     * @mbggenerated
     */
    int insert(Insurance record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Insurance record);

    /**
     *
     * @mbggenerated
     */
    Insurance selectByPrimaryKey(Integer orderid);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Insurance record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Insurance record);
    
    List<Insurance> selectBySalerId(Integer salerid);
    
    List<Insurance> selectAllInsurance();
    
    
    
    
}