package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Message;
 
/**
 * 
 * 留言保存数据库访问类
 * 
 */
public class MessageDao extends HibernateDaoSupport{
	
	private static final Log log = LogFactory.getLog(MessageDao.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(Message transientInstance)
	{
		log.debug("saving Message instance");
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

	public void delete(Message persistentInstance)
	{
		log.debug("deleting Message instance");
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

	public Message findById(java.lang.Integer id)
	{
		log.debug("getting Message instance with id: " + id);
		try
		{
			Message instance = (Message) getHibernateTemplate().get(
					"com.model.Message", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Message instance)
	{
		log.debug("finding Message instance by example");
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

	public List<Message> findByProperty(String propertyName, Object value)
	{
		log.debug("finding Message instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Message as model where model."
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
		log.debug("finding all Message instances");
		try
		{
			String queryString = "from Message";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Message merge(Message detachedInstance)
	{
		log.debug("merging Message instance");
		try
		{
			Message result = (Message) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Message instance)
	{
		log.debug("attaching dirty Message instance");
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

	public void attachClean(Message instance)
	{
		log.debug("attaching clean Message instance");
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

	public static MessageDao getFromApplicationContext(ApplicationContext ctx)
	{
		return (MessageDao) ctx.getBean("MessageDao");
	}
}