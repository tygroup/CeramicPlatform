package com.cpf.mapper.system;

import com.cpf.beans.system.SysCollect;

public interface SysCollectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_collect
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String collectid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_collect
     *
     * @mbggenerated
     */
    int insert(SysCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_collect
     *
     * @mbggenerated
     */
    int insertSelective(SysCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_collect
     *
     * @mbggenerated
     */
    SysCollect selectByPrimaryKey(String collectid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_collect
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_collect
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysCollect record);
}