package com.cpf.controller.system;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.system.RelNewsView;
import com.cpf.beans.system.SysNews;
import com.cpf.service.system.MessageService;
import com.cpf.util.JsonFormat;
import com.cpf.util.Validators;

/**
 * 消息管理控制器
 * @author jll
 *	2017-11-30
 */
@RestController
@RequestMapping("message")
@Scope("prototype")
public class MessageController {
	@Resource
	private MessageService messageService;
	 
	/**
	 * 根据类型查询用户的消息
	 * @param cpage
	 * @param pageSize
	 * @param userId
	 * @param newsType
	 * @return
	 */
    @RequestMapping(value = "/myMessages", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectmyMessages(@RequestParam(value="cpage", required=true) String cpage,
    		@RequestParam(value="pageSize", required=true) String pageSize,
    		@RequestParam(value="userId", required=true) String userId,
    		@RequestParam(value="newsType", required=true) String newsType){
    	
    	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
            int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
            int endIndex = Integer.parseInt(pageSize);
    		List<RelNewsView> newsList = messageService.selectUserMessage(userId, newsType, beginIndex, endIndex);
    		int totalCount = messageService.selectUserMessageCount(userId, newsType);
    		return newsList!=null&&newsList.size()>0?new JsonFormat("000000","查询成功",totalCount,newsList):new JsonFormat("000001","无数据",0,null);
    	}else{
    		return new JsonFormat("000002","参数错误",null);	
    	}
    }
    
	 /**
     * 根据首页的消息数量
     * @param userId
     * @return
     */
    @RequestMapping(value = "/unreadMessageCount", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectUnreadMessagesCount(@RequestParam(value="userId", required=true) String userId ){
    	
    	if(!"".equals(userId)&&userId!=null){
    		int count = messageService.selectUnreadMessageCount(userId);
    		return  new JsonFormat("000000","查询成功",count);
    	}else{
    		return new JsonFormat("000002","参数错误",null);	
    	}
    }
    
	 /**
     * 根据id查询消息内容
     * @param count
     * @return
     */
    @RequestMapping(value = "/message", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectMessageByid(@RequestParam(value="newsId", required=true) String newsId ){
    	if(!"".equals(newsId)&&newsId!=null){
    		SysNews news = messageService.selectMessageById(newsId);
    		return news!=null?new JsonFormat("000000","查询成功",news):new JsonFormat("000001","无数据",null);
    	}else{
    		return new JsonFormat("000002","参数错误",null);	
    	}
    }
    
	 /**
     * 根据id把未读消息修改为已读
     * @param count
     * @return
     */
    @RequestMapping(value = "/setState", method= RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat upadteMessageState(@RequestBody Map<String,String> map ){
    	String viewId ="";
    	 if(map.containsKey("viewId")){
    		 viewId = map.get("viewId");
         }
    	if(!"".equals(viewId)&&viewId!=null){
    		int count = messageService.updateMessageStatus(viewId);
    		return count>0?new JsonFormat("000000","状态修改成功",null):new JsonFormat("000003","状态修改失败",null);
    	}else{
    		return new JsonFormat("000002","参数错误",null);	
    	}
    }
}
