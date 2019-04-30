package com.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.dao.MessageDao;
import com.dao.RespondsDao;
import com.dao.TUserDAO;
import com.dto.RespondsDto;
import com.model.Message;
import com.model.Responds;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RespondsAction extends ActionSupport{

	private RespondsDao respondsDao;
	
	private MessageDao messageDao;
	
	private TUserDAO tUserDao;
	
	private String respond;
	
	private int messageId;
	
	public static int p = 1;
	
	public String respondsDetails()
	{
		Message message = messageDao.findById(messageId);
		
	    final String sql="from Responds where messageId = " + messageId;
	    List<Responds> list = respondsDao.getHibernateTemplate().executeFind(new HibernateCallback(){  
		   
			private int p = RespondsAction.p;

			public Object doInHibernate(Session session) throws HibernateException, SQLException {     
			    Query query = session.createQuery(sql);     
			    query.setFirstResult((p - 1) * 5);     
			    query.setMaxResults(5);     
			    List list = query.list();     
			    return list;     
		    }

		});   
	    
	    List<RespondsDto> respondsDtos = new ArrayList<RespondsDto>();
	    
	    for (Responds responds : list) {
	    	TUser tuser = tUserDao.findById(responds.getRenameId());
			RespondsDto respondsDto = new RespondsDto(
					responds.getId(),
					responds.getMessageId(),
					responds.getRespond(),
					responds.getTime(),
					responds.getRenameId(),
					tuser.getUserRealname()
			);
			respondsDtos.add(respondsDto);
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("list", respondsDtos);
		request.put("message", message);
		if(MessageAction.p >= 2){
			request.put("flag", 5);
		}else {
			request.put("flag", 0);
		}
			
		return "detailsSuccess";
	}
	
	public String respondsAdd(){
		
		ActionContext ctx = ActionContext.getContext();
		Map session=ctx.getSession(); 
		TUser tUser = (TUser) session.get("user");
		
		Responds responds = new Responds(
				messageId,
				respond,
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
				tUser.getUserId()
		);
		respondsDao.save(responds);
		
		return respondsDetails();
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public RespondsDao getRespondsDao() {
		return respondsDao;
	}

	public void setRespondsDao(RespondsDao respondsDao) {
		this.respondsDao = respondsDao;
	}

	public String getRespond() {
		return respond;
	}

	public void setRespond(String respond) {
		this.respond = respond;
	}

	public static int getP() {
		return p;
	}

	public static void setP(int p) {
		RespondsAction.p = p;
	}
	public TUserDAO gettUserDao() {
		return tUserDao;
	}

	public void settUserDao(TUserDAO tUserDao) {
		this.tUserDao = tUserDao;
	}
}
