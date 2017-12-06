package com.cpf.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.system.RelNewsView;
import com.cpf.beans.system.SysNews;
import com.cpf.mapper.system.RelNewsViewMapper;
import com.cpf.mapper.system.SysNewsMapper;
import com.cpf.service.system.MessageService;
@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private RelNewsViewMapper relNewsViewMapper;
	@Autowired
	private SysNewsMapper sysNewsMapper;
	
	@Override
	public List<RelNewsView> selectUserMessage(String userId, String newsType,
			int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return relNewsViewMapper.selectUserMessage(userId, newsType, beginIndex, endIndex);
	}
	@Override
	public int selectUserMessageCount(String userId,String newsType){
		return relNewsViewMapper.selectUserMessageCount(userId, newsType);
	}

	@Override
	public int selectUnreadMessageCount(String userId) {
		// TODO Auto-generated method stub
		return relNewsViewMapper.selectUnreadMessageCount(userId);
	}
	@Override
	public SysNews selectMessageById(String newsId) {
		// TODO Auto-generated method stub
		return sysNewsMapper.selectMessageById(newsId);
	}
	@Override
	public int updateMessageStatus(String viewId) {
		// TODO Auto-generated method stub
		return relNewsViewMapper.updateMessageStatus(viewId);
	}
	public int saveNews(SysNews news) {
		// TODO Auto-generated method stub
		return sysNewsMapper.saveNews(news);
	}
	
	
	
	
}
