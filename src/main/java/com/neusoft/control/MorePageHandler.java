package com.neusoft.control;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.po.Message;
import com.neusoft.po.MessageReply;
import com.neusoft.service.MessageService;

@Controller
public class MorePageHandler {
		@Autowired
		private MessageService messageService;
		
		@RequestMapping(value="/more/pullrefresh")
		@ResponseBody
		public List<Message> pullrefresh_handler(HttpServletRequest request,String pubtime,int type) throws Exception{
			System.out.println("........MorePageHandler.......pullrefresh_handler()........");
			//String pubtime = "2019-00-00 00:00:00";
		//	int type = 0;
			System.out.println("pubtime:"+pubtime);
			System.out.println("type:"+type);
			int qid = 1;
			List<Message> messages = messageService.selectFrontEndMessages(qid,pubtime,type);
			return messages;
		}
		
		@RequestMapping(value="/more/good")
		@ResponseBody
		public String responsegood_handler(int mid,int type) throws Exception{
			System.out.println("........MorePageHandler.......responsegood_handler()........");
			String nickname = "千阳";
			boolean isOK = messageService.updateMessageLike(type, mid, nickname);
			if(isOK){
				return "{\"result\":true}";
			}
			else{
				return "{\"result\":false}";
			}
		}
		
		@RequestMapping(value="/more/comment")
		@ResponseBody
		public String responsecomment_handler(String content,int mid) throws Exception{
			System.out.println("........MorePageHandler.......responsecomment_handler()........");
			MessageReply messageReply = new MessageReply();
			messageReply.setMid(mid);
			messageReply.setContent(content);
			messageReply.setNickName("千阳");
			boolean isOK = messageService.saveMessageReply(messageReply);
			if(isOK){
				return "{\"result\":true}";
			}
			else{
				return "{\"result\":false}";
			}
		}
		
		@RequestMapping(value="/more/morecomment")
		@ResponseBody
		public List<MessageReply> responsemorecomment_handler(String pubtime,int type,int mid) throws Exception{
			System.out.println("........MorePageHandler.......responsemorecomment_handler()........");
			List<MessageReply> morereplys = messageService.selectMoreMessageReplys(mid, pubtime, type);
			return morereplys;
		}		
}
