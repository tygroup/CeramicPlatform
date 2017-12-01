package com.cpf.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.RelNewsView;
import com.cpf.beans.system.SysNews;

public interface MessageService {
	public List<RelNewsView> selectUserMessage(String userId,String newsType,int beginIndex,int endIndex);
	public int selectUserMessageCount(String userId,String newsType);
	public int selectUnreadMessageCount(String userId);
	
	public SysNews selectMessageById(String newsId);
	public int updateMessageStatus(String viewId);
}
