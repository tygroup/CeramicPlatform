package com.cpf.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.RelNewsView;

public interface RelNewsViewMapper {
	List<RelNewsView> selectUserMessage(@Param("userId") String userId,@Param("newsType") String newsType,
			@Param("beginIndex") int beginIndex,@Param("endIndex") int endIndex);
	int selectUserMessageCount(@Param("userId") String userId,@Param("newsType") String newsType);
	int selectUnreadMessageCount(@Param("userId") String userId);
	int updateMessageStatus(@Param("viewId") String viewId);
}