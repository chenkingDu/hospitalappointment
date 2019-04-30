package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Responds;

public class RespondsDao extends HibernateDaoSupport {
	
	private static final Log log = LogFactory.getLog(RespondsDao.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(Responds transientInstance)
	{
		try
		{
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re)
		{
			throw re;
		}
	}

	public void delete(Responds persistentInstance)
	{
		try
		{
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re)
		{
			throw re;
		}
	}

	public Responds findById(java.lang.Integer id)
	{
		log.debug("getting Responds instance with id: " + id);
		try
		{
			Responds instance = (Responds) getHibernateTemplate().get(
					"com.model.Responds", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Responds instance)
	{
		log.debug("finding Responds instance by example");
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
		log.debug("finding Responds instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Responds as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all Responds instances");
		try
		{
			String queryString = "from Responds";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Responds merge(Responds detachedInstance)
	{
		log.debug("merging Responds instance");
		try
		{
			Responds result = (Responds) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Responds instance)
	{
		log.debug("attaching dirty Responds instance");
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

	public void attachClean(Responds instance)
	{
		log.debug("attaching clean Responds instance");
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

	public static RespondsDao getFromApplicationContext(ApplicationContext ctx)
	{
		return (RespondsDao) ctx.getBean("RespondsDao");
	}
}
