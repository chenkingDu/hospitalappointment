package com.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.taglibs.standard.tag.el.fmt.MessageTag;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import sun.text.resources.FormatData;

import com.dao.MessageDao;
import com.dao.TKeshiDAO;
import com.dao.TUserDAO;
import com.jspsmart.upload.Request;
import com.model.Message;
import com.model.Responds;
import com.model.TKeshi;
import com.model.TUser;
import com.model.TZhuanjia;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class MessageAction extends ActionSupport
{
	private String title;
	private String content;
	public static int p;
	private TUserDAO tUserDao;
	private Integer nameId;
	private Integer messageId;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getNameId() {
		return nameId;
	}

	public void setNameId(Integer nameId) {
		this.nameId = nameId;
	}

	public TUserDAO gettUserDao() {
		return tUserDao;
	}

	public void settUserDao(TUserDAO tUserDao) {
		this.tUserDao = tUserDao;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	private MessageDao messageDao;
	
	private String message;
	private String path;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String messageAdd()
	{
		ActionContext ctx = ActionContext.getContext();
		Map session=ctx.getSession();
		TUser tUser = (TUser) session.get("user");
		
		Message message=new Message();
		message.setNameId((int) tUser.getUserId());
		message.setName(tUser.getUserRealname());
		message.setTitle(title);
		message.setContent(content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		message.setTime(sdf.format(new Date()));
		messageDao.save(message);
		this.setMessage("²Ù×÷³É¹¦");
		this.setPath("keshiMana.action");
		
		return messageAll();
	}
	
	public String messageAll()
	{
	   final String sql="from Message ";
		
	   List<Message> list = messageDao.getHibernateTemplate().executeFind(new HibernateCallback() {  
		   
			private int p = MessageAction.p;
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
			    Query query = session.createQuery(sql);
			    query.setFirstResult((p - 1) * 5);
			    query.setMaxResults(5);
			    List list = query.list();
			    return list;
		    }
			
	   });   
	   
	   List<Message> messages = new ArrayList<Message>();
	   for (Message message : list) {
		   TUser tUser = tUserDao.findById(message.getNameId());
		   Message m = new Message(
				   message.getId(),
				   tUser.getUserRealname(),
				   message.getTitle(),
				   message.getContent(),
				   message.getTime(),
				   message.getNameId()
		   );
		   messages.add(m);
	   }
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("list", messages);
		if(MessageAction.p >= 2){
			request.put("flag", 5);
		}else {
			request.put("flag", 0);
		}
		
		return ActionSupport.SUCCESS;
	}
	
	public String myMessage() {

		List<Message> list = messageDao.findByProperty("nameId", nameId);

		List<Message> messages = new ArrayList<Message>();
		for (Message message : list) {
			TUser tUser = tUserDao.findById(message.getNameId());
			Message m = new Message(message.getId(), tUser.getUserRealname(),
					message.getTitle(), message.getContent(),
					message.getTime(), message.getNameId());
			messages.add(m);
		}

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("list", messages);
		if (MessageAction.p >= 2) {
			request.put("flag", 5);
		} else {
			request.put("flag", 0);
		}

		return ActionSupport.SUCCESS;
	}
	
	public String messageDel(){
		Message message = messageDao.findById(messageId);
		messageDao.delete(message);
		return messageAll();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	

}
