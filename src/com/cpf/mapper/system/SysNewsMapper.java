package com.cpf.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.SysNews;

public interface SysNewsMapper {

	SysNews selectMessageById(@Param("newsId") String newsId);
	int saveNews(SysNews news);
}