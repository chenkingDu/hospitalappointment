package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TGuahaoDAO;
import com.dao.TJiuzhenDAO;
import com.dao.TKeshiDAO;
import com.dao.TUserDAO;
import com.dao.TYaopinDAO;
import com.dao.TYongyaoDAO;
import com.dao.TZhuanjiaDAO;
import com.model.TGuahao;
import com.model.TJiuzhen;
import com.model.TKeshi;
import com.model.TUser;
import com.model.TYaopin;
import com.model.TYongyao;
import com.model.TZhuanjia;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class jiuzhenAction extends ActionSupport
{
	private Integer id;
	private String binglihao;
	private String bingqing;
	private String zhenduan;
	
	private String shijian;
	private Integer zhuanjiaId;
	private Integer guahaoId;
	
	private TJiuzhenDAO jiuzhenDAO;
	private TYongyaoDAO yongyaoDAO;
	private TYaopinDAO yaopinDAO; 
	private TGuahaoDAO guahaoDAO;
	private TUserDAO userDAO;
	
	public String jiuzhenAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TZhuanjia zhuanjia=(TZhuanjia)session.get("zhuanjia");
		
		String sql="from TJiuzhen where binglihao=?";
		Object[] c={binglihao.trim()};
		List jiuzhenList=jiuzhenDAO.getHibernateTemplate().find(sql,c);
		if(jiuzhenList.size()>0)
		{
			Map request=(Map)ServletActionContext.getContext().get("request");
			request.put("msg", "病历号重复，添加失败");
			return "msg";
		}
		
		
		String sql1="from TJiuzhen where guahaoId=?";
		Object[] c1={guahaoId};
		List jiuzhenList1=jiuzhenDAO.getHibernateTemplate().find(sql1,c1);
		if(jiuzhenList1.size()>0)
		{
			Map request=(Map)ServletActionContext.getContext().get("request");
			request.put("msg", "已经就诊过。请不要重复就诊，请点击‘就诊查看’可以看到就诊信息");
			return "msg";
		}
		
		
		TJiuzhen jiuzhen=new TJiuzhen();
		
		//jiuzhen.setId(id);
		jiuzhen.setBinglihao(binglihao);
		jiuzhen.setBingqing(bingqing);
		jiuzhen.setZhenduan(zhenduan);
		
		jiuzhen.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		jiuzhen.setZhuanjiaId(zhuanjia.getId());
		jiuzhen.setGuahaoId(guahaoId);
		
		jiuzhenDAO.save(jiuzhen);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加完毕");
		return "msg";
	}
	
	
	public String jiuzhenMana()
	{
		String sql="from TJiuzhen where guahaoId=?";
		Object[] c={guahaoId};
		List jiuzhenList=jiuzhenDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<jiuzhenList.size();i++)
		{
			TJiuzhen jiuzhen=(TJiuzhen)jiuzhenList.get(i);
			
			String sql1="from TYongyao where jiuzhenId="+jiuzhen.getId();
			List yongyaoList=yongyaoDAO.getHibernateTemplate().find(sql1); 
			for(int j=0;j<yongyaoList.size();j++)
			{
				TYongyao yongyao=(TYongyao)yongyaoList.get(j);
				yongyao.setYaopin(yaopinDAO.findById(yongyao.getYaopinId()));
			}
			jiuzhen.setYongyaoList(yongyaoList);
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jiuzhenList", jiuzhenList);
		
		
		
		return ActionSupport.SUCCESS;
	}

	
	public String jiuzhenDel()
	{
		TJiuzhen jiuzhen=jiuzhenDAO.findById(id);
		jiuzhenDAO.delete(jiuzhen);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "就诊信息删除完毕");
		return "msg";
		
	}
	
	
	public String jiuzhenRes()
	{
		String sql="from TJiuzhen where binglihao =?";
		Object[] c={binglihao.trim()};
		List jiuzhenList=jiuzhenDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<jiuzhenList.size();i++)
		{
			TJiuzhen jiuzhen=(TJiuzhen)jiuzhenList.get(i);
			
			String sql1="from TYongyao where jiuzhenId="+jiuzhen.getId();
			List yongyaoList=yongyaoDAO.getHibernateTemplate().find(sql1); 
			for(int j=0;j<yongyaoList.size();j++)
			{
				TYongyao yongyao=(TYongyao)yongyaoList.get(j);
				yongyao.setYaopin(yaopinDAO.findById(yongyao.getYaopinId()));
			}
			jiuzhen.setYongyaoList(yongyaoList);
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jiuzhenList", jiuzhenList);
		
		request.put("binglihao", binglihao);
		return ActionSupport.SUCCESS;
	}
	
	
	public String koufei()
	{
		int zongjia=0;
		
		String sql="from TJiuzhen where binglihao =?";
		Object[] c={binglihao.trim()};
		List jiuzhenList=jiuzhenDAO.getHibernateTemplate().find(sql,c);
		
		TJiuzhen jiuzhen=(TJiuzhen)jiuzhenList.get(0);
		int guahaoId=jiuzhen.getGuahaoId();
		TGuahao guahao=guahaoDAO.findById(guahaoId);
		int userId=guahao.getUserId();
		TUser user=userDAO.findById(userId);
		
		
			
		String sql1="from TYongyao where jiuzhenId="+jiuzhen.getId();
		List yongyaoList=yongyaoDAO.getHibernateTemplate().find(sql1); 
		for(int j=0;j<yongyaoList.size();j++)
		{
			TYongyao yongyao=(TYongyao)yongyaoList.get(j);
			zongjia=zongjia+yongyao.getZongjia();
		}
		
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		if(zongjia>user.getUserYue())
		{
			request.put("msg", "用户余额不足，请先联系管理员充值后扣费");
			return "msg";
		}
		
		user.setUserYue(user.getUserYue()-zongjia);
		userDAO.attachDirty(user);
		request.put("msg", "扣费成功");
		return "msg";
	}


	
	public String jiuzhenChaxun()
	{
		
		
		String sql="from TJiuzhen where guahaoId =?";
		Object[] c={guahaoId};
		List jiuzhenList=jiuzhenDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<jiuzhenList.size();i++)
		{
			TJiuzhen jiuzhen=(TJiuzhen)jiuzhenList.get(i);
			
			String sql1="from TYongyao where jiuzhenId="+jiuzhen.getId();
			List yongyaoList=yongyaoDAO.getHibernateTemplate().find(sql1); 
			for(int j=0;j<yongyaoList.size();j++)
			{
				TYongyao yongyao=(TYongyao)yongyaoList.get(j);
				yongyao.setYaopin(yaopinDAO.findById(yongyao.getYaopinId()));
			}
			jiuzhen.setYongyaoList(yongyaoList);
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("jiuzhenList", jiuzhenList);
		
		return ActionSupport.SUCCESS;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBinglihao() {
		return binglihao;
	}


	public void setBinglihao(String binglihao) {
		this.binglihao = binglihao;
	}


	public TGuahaoDAO getGuahaoDAO() {
		return guahaoDAO;
	}


	public void setGuahaoDAO(TGuahaoDAO guahaoDAO) {
		this.guahaoDAO = guahaoDAO;
	}


	public TUserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public String getBingqing() {
		return bingqing;
	}


	public TYongyaoDAO getYongyaoDAO() {
		return yongyaoDAO;
	}


	public void setYongyaoDAO(TYongyaoDAO yongyaoDAO) {
		this.yongyaoDAO = yongyaoDAO;
	}


	public TYaopinDAO getYaopinDAO() {
		return yaopinDAO;
	}


	public void setYaopinDAO(TYaopinDAO yaopinDAO) {
		this.yaopinDAO = yaopinDAO;
	}


	public void setBingqing(String bingqing) {
		this.bingqing = bingqing;
	}


	public String getZhenduan() {
		return zhenduan;
	}


	public void setZhenduan(String zhenduan) {
		this.zhenduan = zhenduan;
	}


	public String getShijian() {
		return shijian;
	}


	public void setShijian(String shijian) {
		this.shijian = shijian;
	}


	public Integer getZhuanjiaId() {
		return zhuanjiaId;
	}


	public void setZhuanjiaId(Integer zhuanjiaId) {
		this.zhuanjiaId = zhuanjiaId;
	}


	public Integer getGuahaoId() {
		return guahaoId;
	}


	public void setGuahaoId(Integer guahaoId) {
		this.guahaoId = guahaoId;
	}


	public TJiuzhenDAO getJiuzhenDAO() {
		return jiuzhenDAO;
	}


	public void setJiuzhenDAO(TJiuzhenDAO jiuzhenDAO) {
		this.jiuzhenDAO = jiuzhenDAO;
	}
	
}
