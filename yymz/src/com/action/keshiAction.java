package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TKeshiDAO;
import com.dao.TZhuanjiaDAO;
import com.model.TKeshi;
import com.opensymphony.xwork2.ActionSupport;

public class keshiAction extends ActionSupport
{
	private int keshiId;
	private String keshiAnme;
	private String keshiJianjie;
	
	private String message;
	private String path;
	
	private TKeshiDAO keshiDAO;
	private TZhuanjiaDAO zhuanjiaDAO;
	
	public String keshiAdd()
	{
		TKeshi keshi=new TKeshi();
		keshi.setKeshiAnme(keshiAnme);
		keshi.setDel("no");
		keshiDAO.save(keshi);
		this.setMessage("�����ɹ�");
		this.setPath("keshiMana.action");
		return "succeed";
	}
	
	
	public String keshiMana()
	{
		String sql="from TKeshi where del='no'";
		List keshiList=keshiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("keshiList", keshiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String keshiDel()
	{
		TKeshi keshi=keshiDAO.findById(keshiId);
		keshi.setDel("yes");
		keshiDAO.attachDirty(keshi);
		this.setMessage("�����ɹ�");
		this.setPath("keshiMana.action");
		return "succeed";
	}
	
	
	public String keshiPre()
	{
		TKeshi keshi=keshiDAO.findById(keshiId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("keshi", keshi);
		return ActionSupport.SUCCESS;
	}
	
	
	public String keshiEdit()
	{
		TKeshi keshi=keshiDAO.findById(keshiId);
		
		keshi.setKeshiAnme(keshiAnme);
		keshi.setDel("no");
		keshiDAO.attachDirty(keshi);
		this.setMessage("�����ɹ�");
		this.setPath("keshiMana.action");
		return "succeed";
	}
	
	
	
	public String keshiAll()
	{
		String sql="from TKeshi where del='no'";
		List keshiList=keshiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("keshiList", keshiList);
		return ActionSupport.SUCCESS;
	}
	
	public String keshiSuoyou()
	{
		String sql="from TKeshi where del='no'";
		List keshiList=keshiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<keshiList.size();i++)
		{
			TKeshi keshi=(TKeshi)keshiList.get(i);
			keshi.setRenshu(get_renshu(keshi.getKeshiId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("keshiList", keshiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public int get_renshu(int keshiId)
	{
		String sql="from TZhuanjia where del='no' and keshiId="+keshiId;
		List zhuanjiaList =zhuanjiaDAO.getHibernateTemplate().find(sql);
		return zhuanjiaList.size();
	}

	public String getKeshiAnme()
	{
		return keshiAnme;
	}

	public void setKeshiAnme(String keshiAnme)
	{
		this.keshiAnme = keshiAnme;
	}

	public TKeshiDAO getKeshiDAO()
	{
		return keshiDAO;
	}

	public void setKeshiDAO(TKeshiDAO keshiDAO)
	{
		this.keshiDAO = keshiDAO;
	}

	public TZhuanjiaDAO getZhuanjiaDAO() {
		return zhuanjiaDAO;
	}


	public void setZhuanjiaDAO(TZhuanjiaDAO zhuanjiaDAO) {
		this.zhuanjiaDAO = zhuanjiaDAO;
	}


	public int getKeshiId()
	{
		return keshiId;
	}

	public void setKeshiId(int keshiId)
	{
		this.keshiId = keshiId;
	}

	public String getKeshiJianjie()
	{
		return keshiJianjie;
	}

	public void setKeshiJianjie(String keshiJianjie)
	{
		this.keshiJianjie = keshiJianjie;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
	

}
