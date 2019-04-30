package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TYongyao;

/**
 * A data access object (DAO) providing persistence and search support for
 * TYongyao entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TYongyao
 * @author MyEclipse Persistence Tools
 */

public class TYongyaoDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TYongyaoDAO.class);
	// property constants
	public static final String YAOPIN_ID = "yaopinId";
	public static final String SHULIANG = "shuliang";
	public static final String DANJIA = "danjia";
	public static final String ZONGJIA = "zongjia";
	public static final String JIUZHEN_ID = "jiuzhenId";

	protected void initDao() {
		// do nothing
	}

	public void save(TYongyao transientInstance) {
		log.debug("saving TYongyao instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TYongyao persistentInstance) {
		log.debug("deleting TYongyao instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TYongyao findById(java.lang.Integer id) {
		log.debug("getting TYongyao instance with id: " + id);
		try {
			TYongyao instance = (TYongyao) getHibernateTemplate().get(
					"com.model.TYongyao", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TYongyao instance) {
		log.debug("finding TYongyao instance by example");
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
		log.debug("finding TYongyao instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TYongyao as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByYaopinId(Object yaopinId) {
		return findByProperty(YAOPIN_ID, yaopinId);
	}

	public List findByShuliang(Object shuliang) {
		return findByProperty(SHULIANG, shuliang);
	}

	public List findByDanjia(Object danjia) {
		return findByProperty(DANJIA, danjia);
	}

	public List findByZongjia(Object zongjia) {
		return findByProperty(ZONGJIA, zongjia);
	}

	public List findByJiuzhenId(Object jiuzhenId) {
		return findByProperty(JIUZHEN_ID, jiuzhenId);
	}

	public List findAll() {
		log.debug("finding all TYongyao instances");
		try {
			String queryString = "from TYongyao";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TYongyao merge(TYongyao detachedInstance) {
		log.debug("merging TYongyao instance");
		try {
			TYongyao result = (TYongyao) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TYongyao instance) {
		log.debug("attaching dirty TYongyao instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TYongyao instance) {
		log.debug("attaching clean TYongyao instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TYongyaoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TYongyaoDAO) ctx.getBean("TYongyaoDAO");
	}
}