package com.cpf.mapper.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.TraPersonalspecial;

public interface TraPersonalspecialMapper {
    List<TraPersonalspecial> selectBestPersonalSpecialid(@Param("count") int count);
    List<TraPersonalspecial> findPersonalSpecialList(@Param("specialName") String specialName,@Param("status") String status,@Param("beginIndex") int beginIndex,@Param("endIndex") int endIndex);
	int findPersonalSpecialListCount(@Param("specialName") String specialName,@Param("status") String status);
	List<TraPersonalspecial> selectPersonalById(@Param("zcId") String zcId);
}