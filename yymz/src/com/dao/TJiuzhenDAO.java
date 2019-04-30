package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TJiuzhen;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJiuzhen entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TJiuzhen
 * @author MyEclipse Persistence Tools
 */

public class TJiuzhenDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TJiuzhenDAO.class);
	// property constants
	public static final String BINGLIHAO = "binglihao";
	public static final String BINGQING = "bingqing";
	public static final String ZHENDUAN = "zhenduan";
	public static final String SHIJIAN = "shijian";
	public static final String ZHUANJIA_ID = "zhuanjiaId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TJiuzhen transientInstance)
	{
		log.debug("saving TJiuzhen instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJiuzhen persistentInstance)
	{
		log.debug("deleting TJiuzhen instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJiuzhen findById(java.lang.Integer id)
	{
		log.debug("getting TJiuzhen instance with id: " + id);
		try
		{
			TJiuzhen instance = (TJiuzhen) getHibernateTemplate().get(
					"com.model.TJiuzhen", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJiuzhen instance)
	{
		log.debug("finding TJiuzhen instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TJiuzhen instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TJiuzhen as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBinglihao(Object binglihao)
	{
		return findByProperty(BINGLIHAO, binglihao);
	}

	public List findByBingqing(Object bingqing)
	{
		return findByProperty(BINGQING, bingqing);
	}

	public List findByZhenduan(Object zhenduan)
	{
		return findByProperty(ZHENDUAN, zhenduan);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findByZhuanjiaId(Object zhuanjiaId)
	{
		return findByProperty(ZHUANJIA_ID, zhuanjiaId);
	}

	public List findAll()
	{
		log.debug("finding all TJiuzhen instances");
		try
		{
			String queryString = "from TJiuzhen";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJiuzhen merge(TJiuzhen detachedInstance)
	{
		log.debug("merging TJiuzhen instance");
		try
		{
			TJiuzhen result = (TJiuzhen) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJiuzhen instance)
	{
		log.debug("attaching dirty TJiuzhen instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJiuzhen instance)
	{
		log.debug("attaching clean TJiuzhen instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TJiuzhenDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TJiuzhenDAO) ctx.getBean("TJiuzhenDAO");
	}
}