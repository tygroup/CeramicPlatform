package com.cpf.mapper.transaction;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.cpf.beans.transaction.TraProductFiles;
import com.cpf.mapper.BaseMapper;

public interface TraProductFilesMapper extends BaseMapper<TraProductFiles, String>{
  
   void deleteFilesByProductid(@Param("productId")String productId);
    
    /**
     * 根据品种id查询商品的图片列表
     */
    List<TraProductFiles> selectPicByProductionId(@Param("productId")String productId);
}