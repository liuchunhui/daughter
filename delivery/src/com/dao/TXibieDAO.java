package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXibie;

/**
 * Data access object (DAO) for domain model class TXibie.
 * 
 * @see com.model.TXibie
 * @author MyEclipse Persistence Tools
 */

public class TXibieDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TXibieDAO.class);

	// property constants
	public static final String XIBIE_BIANHAO = "xibieBianhao";

	public static final String XIBIE_NAME = "xibieName";

	public static final String XIBIE_JIANJIE = "xibieJianjie";

	public static final String XIBIE_DEL = "xibieDel";

	public static final String XIBIE_XUYUAN_ID = "xibieXuyuanId";

	public static final String XIBIE_ONE1 = "xibieOne1";

	public static final String XIBIE_ONE2 = "xibieOne2";

	public static final String XIBIE_ONE3 = "xibieOne3";

	public static final String XIBIE_ONE4 = "xibieOne4";

	public static final String XIBIE_ONE5 = "xibieOne5";

	public static final String XIBIE_ONE6 = "xibieOne6";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TXibie transientInstance)
	{
		log.debug("saving TXibie instance");
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

	public void delete(TXibie persistentInstance)
	{
		log.debug("deleting TXibie instance");
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

	public TXibie findById(Integer id)
	{
		log.debug("getting TXibie instance with id: " + id);
		try
		{
			TXibie instance = (TXibie) getHibernateTemplate().get(
					"com.model.TXibie", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXibie instance)
	{
		log.debug("finding TXibie instance by example");
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
		log.debug("finding TXibie instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TXibie as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByXibieBianhao(Object xibieBianhao)
	{
		return findByProperty(XIBIE_BIANHAO, xibieBianhao);
	}

	public List findByXibieName(Object xibieName)
	{
		return findByProperty(XIBIE_NAME, xibieName);
	}

	public List findByXibieJianjie(Object xibieJianjie)
	{
		return findByProperty(XIBIE_JIANJIE, xibieJianjie);
	}

	public List findByXibieDel(Object xibieDel)
	{
		return findByProperty(XIBIE_DEL, xibieDel);
	}

	public List findByXibieXuyuanId(Object xibieXuyuanId)
	{
		return findByProperty(XIBIE_XUYUAN_ID, xibieXuyuanId);
	}

	public List findByXibieOne1(Object xibieOne1)
	{
		return findByProperty(XIBIE_ONE1, xibieOne1);
	}

	public List findByXibieOne2(Object xibieOne2)
	{
		return findByProperty(XIBIE_ONE2, xibieOne2);
	}

	public List findByXibieOne3(Object xibieOne3)
	{
		return findByProperty(XIBIE_ONE3, xibieOne3);
	}

	public List findByXibieOne4(Object xibieOne4)
	{
		return findByProperty(XIBIE_ONE4, xibieOne4);
	}

	public List findByXibieOne5(Object xibieOne5)
	{
		return findByProperty(XIBIE_ONE5, xibieOne5);
	}

	public List findByXibieOne6(Object xibieOne6)
	{
		return findByProperty(XIBIE_ONE6, xibieOne6);
	}

	public List findAll()
	{
		log.debug("finding all TXibie instances");
		try
		{
			String queryString = "from TXibie";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXibie merge(TXibie detachedInstance)
	{
		log.debug("merging TXibie instance");
		try
		{
			TXibie result = (TXibie) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXibie instance)
	{
		log.debug("attaching dirty TXibie instance");
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

	public void attachClean(TXibie instance)
	{
		log.debug("attaching clean TXibie instance");
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

	public static TXibieDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TXibieDAO) ctx.getBean("TXibieDAO");
	}
}