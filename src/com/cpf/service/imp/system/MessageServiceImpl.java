package com.cpf.service.imp.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.system.RelNewsView;
import com.cpf.beans.system.SysNews;
import com.cpf.mapper.system.RelNewsViewMapper;
import com.cpf.mapper.system.SysNewsMapper;
import com.cpf.service.system.MessageService;
@Service("messageService1")
public class MessageServiceImpl  {
	@Autowired
	private RelNewsViewMapper relNewsViewMapper;
	@Autowired
	private SysNewsMapper sysNewsMapper;
	
	public List<RelNewsView> selectUserMessage(String userId, String newsType,
			int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return relNewsViewMapper.selectUserMessage(userId, newsType, beginIndex, endIndex);
	}

	public int selectUserMessageCount(String userId,String newsType){
		return relNewsViewMapper.selectUserMessageCount(userId, newsType);
	}

	public int selectUnreadMessageCount(String userId) {
		// TODO Auto-generated method stub
		return relNewsViewMapper.selectUnreadMessageCount(userId);
	}

	public SysNews selectMessageById(String newsId) {
		// TODO Auto-generated method stub
		return sysNewsMapper.selectMessageById(newsId);
	}

	public int updateMessageStatus(String viewId) {
		// TODO Auto-generated method stub
		return relNewsViewMapper.updateMessageStatus(viewId);
	}
	
	
	
	
}
