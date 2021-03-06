package com.cpf.mapper.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.TraPersonalspecial;

public interface TraPersonalspecialMapper {
    List<TraPersonalspecial> selectBestPersonalSpecialid(@Param("beginIndex") int beginIndex,@Param("size") int size);
    List<TraPersonalspecial> findPersonalSpecialList(@Param("specialName") String specialName,@Param("status") String status,@Param("beginIndex") int beginIndex,@Param("endIndex") int endIndex);
	int findPersonalSpecialListCount(@Param("specialName") String specialName,@Param("status") String status);
	TraPersonalspecial selectPersonalById(@Param("zcId") String zcId);

	List<TraPersonalspecial> selectPersonalListByUserid(@Param("userInfoId") String userInfoId,@Param("beginIndex") int beginIndex,@Param("size") int size);
	int selectPersonalListByUseridCount(@Param("userInfoId") String userInfoId);

}
