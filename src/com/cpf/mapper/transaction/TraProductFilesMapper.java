package com.cpf.mapper.transaction;

import com.cpf.beans.transaction.TraProductFiles;

public interface TraProductFilesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_product_files
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String filesid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_product_files
     *
     * @mbggenerated
     */
    int insert(TraProductFiles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_product_files
     *
     * @mbggenerated
     */
    int insertSelective(TraProductFiles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_product_files
     *
     * @mbggenerated
     */
    TraProductFiles selectByPrimaryKey(String filesid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_product_files
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TraProductFiles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_product_files
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TraProductFiles record);
}