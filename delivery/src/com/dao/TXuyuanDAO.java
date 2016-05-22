package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXuyuan;

/**
 * Data access object (DAO) for domain model class TXuyuan.
 * 
 * @see com.model.TXuyuan
 * @author MyEclipse Persistence Tools
 */

public class TXuyuanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TXuyuanDAO.class);

	// property constants
	public static final String XUYUAN_BIANHAO = "xuyuanBianhao";

	public static final String XUYUAN_NAME = "xuyuanName";

	public static final String XUYUAN_JIANJIE = "xuyuanJianjie";

	public static final String XUYUAN_DEL = "xuyuanDel";

	public static final String XUYUAN_ONE1 = "xuyuanOne1";

	public static final String XUYUAN_ONE2 = "xuyuanOne2";

	public static final String XUYUAN_ONE3 = "xuyuanOne3";

	public static final String XUYUAN_ONE4 = "xuyuanOne4";

	public static final String XUYUAN_ONE5 = "xuyuanOne5";

	public static final String XUYUAN_ONE6 = "xuyuanOne6";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TXuyuan transientInstance)
	{
		log.debug("saving TXuyuan instance");
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

	public void delete(TXuyuan persistentInstance)
	{
		log.debug("deleting TXuyuan instance");
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

	public TXuyuan findById(Integer id)
	{
		log.debug("getting TXuyuan instance with id: " + id);
		try
		{
			TXuyuan instance = (TXuyuan) getHibernateTemplate().get(
					"com.model.TXuyuan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXuyuan instance)
	{
		log.debug("finding TXuyuan instance by example");
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
		log.debug("finding TXuyuan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TXuyuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByXuyuanBianhao(Object xuyuanBianhao)
	{
		return findByProperty(XUYUAN_BIANHAO, xuyuanBianhao);
	}

	public List findByXuyuanName(Object xuyuanName)
	{
		return findByProperty(XUYUAN_NAME, xuyuanName);
	}

	public List findByXuyuanJianjie(Object xuyuanJianjie)
	{
		return findByProperty(XUYUAN_JIANJIE, xuyuanJianjie);
	}

	public List findByXuyuanDel(Object xuyuanDel)
	{
		return findByProperty(XUYUAN_DEL, xuyuanDel);
	}

	public List findByXuyuanOne1(Object xuyuanOne1)
	{
		return findByProperty(XUYUAN_ONE1, xuyuanOne1);
	}

	public List findByXuyuanOne2(Object xuyuanOne2)
	{
		return findByProperty(XUYUAN_ONE2, xuyuanOne2);
	}

	public List findByXuyuanOne3(Object xuyuanOne3)
	{
		return findByProperty(XUYUAN_ONE3, xuyuanOne3);
	}

	public List findByXuyuanOne4(Object xuyuanOne4)
	{
		return findByProperty(XUYUAN_ONE4, xuyuanOne4);
	}

	public List findByXuyuanOne5(Object xuyuanOne5)
	{
		return findByProperty(XUYUAN_ONE5, xuyuanOne5);
	}

	public List findByXuyuanOne6(Object xuyuanOne6)
	{
		return findByProperty(XUYUAN_ONE6, xuyuanOne6);
	}

	public List findAll()
	{
		log.debug("finding all TXuyuan instances");
		try
		{
			String queryString = "from TXuyuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXuyuan merge(TXuyuan detachedInstance)
	{
		log.debug("merging TXuyuan instance");
		try
		{
			TXuyuan result = (TXuyuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXuyuan instance)
	{
		log.debug("attaching dirty TXuyuan instance");
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

	public void attachClean(TXuyuan instance)
	{
		log.debug("attaching clean TXuyuan instance");
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

	public static TXuyuanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TXuyuanDAO) ctx.getBean("TXuyuanDAO");
	}
}