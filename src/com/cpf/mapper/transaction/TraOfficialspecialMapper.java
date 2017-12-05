package com.cpf.mapper.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.TraOfficialspecial;

public interface TraOfficialspecialMapper {
	List<TraOfficialspecial> findBestSpecialList(@Param("beginIndex") int beginIndex,@Param("size") int size);
	List<TraOfficialspecial> findOfficialSpecialList(@Param("specialName") String specialName,@Param("status") String status
			,@Param("beginIndex") int beginIndex,@Param("endIndex") int endIndex);
	int findOfficialSpecialListCount(@Param("specialName") String specialName,@Param("status") String status);
	TraOfficialspecial findOfficialSpecialidById(@Param("zcId") String zcId);
}