package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TYaopin;

/**
 * A data access object (DAO) providing persistence and search support for
 * TYaopin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TYaopin
 * @author MyEclipse Persistence Tools
 */

public class TYaopinDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TYaopinDAO.class);
	// property constants
	public static final String MINGCHENG = "mingcheng";
	public static final String DANWEI = "danwei";
	public static final String GUIGE = "guige";
	public static final String CHANGJIA = "changjia";
	public static final String DANJAI = "danjai";
	public static final String DEL = "del";

	protected void initDao() {
		// do nothing
	}

	public void save(TYaopin transientInstance) {
		log.debug("saving TYaopin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TYaopin persistentInstance) {
		log.debug("deleting TYaopin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TYaopin findById(java.lang.Integer id) {
		log.debug("getting TYaopin instance with id: " + id);
		try {
			TYaopin instance = (TYaopin) getHibernateTemplate().get(
					"com.model.TYaopin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TYaopin instance) {
		log.debug("finding TYaopin instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TYaopin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TYaopin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMingcheng(Object mingcheng) {
		return findByProperty(MINGCHENG, mingcheng);
	}

	public List findByDanwei(Object danwei) {
		return findByProperty(DANWEI, danwei);
	}

	public List findByGuige(Object guige) {
		return findByProperty(GUIGE, guige);
	}

	public List findByChangjia(Object changjia) {
		return findByProperty(CHANGJIA, changjia);
	}

	public List findByDanjai(Object danjai) {
		return findByProperty(DANJAI, danjai);
	}

	public List findByDel(Object del) {
		return findByProperty(DEL, del);
	}

	public List findAll() {
		log.debug("finding all TYaopin instances");
		try {
			String queryString = "from TYaopin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TYaopin merge(TYaopin detachedInstance) {
		log.debug("merging TYaopin instance");
		try {
			TYaopin result = (TYaopin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TYaopin instance) {
		log.debug("attaching dirty TYaopin instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TYaopin instance) {
		log.debug("attaching clean TYaopin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TYaopinDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TYaopinDAO) ctx.getBean("TYaopinDAO");
	}
}