package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TTea;

/**
 * Data access object (DAO) for domain model class TTea.
 * 
 * @see com.model.TTea
 * @author MyEclipse Persistence Tools
 */

public class TTeaDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TTeaDAO.class);

	// property constants
	public static final String TEA_BIANHAO = "teaBianhao";

	public static final String TEA_REALNAME = "teaRealname";

	public static final String TEA_SEX = "teaSex";

	public static final String TEA_AGE = "teaAge";

	public static final String TEA_TEL = "teaTel";

	public static final String TEA_ADDRESS = "teaAddress";

	public static final String TEA_JIANLI = "teaJianli";

	public static final String KECHENG_ID = "kechengId";

	public static final String XIBIE_ID = "xibieId";

	public static final String XUYUAN_ID = "xuyuanId";

	public static final String LOGIN_NAME = "loginName";

	public static final String LOGIN_PW = "loginPw";

	public static final String TEA_DEL = "teaDel";

	public static final String TEA_ONE1 = "teaOne1";

	public static final String TEA_ONE2 = "teaOne2";

	public static final String TEA_ONE3 = "teaOne3";

	public static final String TEA_ONE4 = "teaOne4";

	public static final String TEA_ONE7 = "teaOne7";

	public static final String TEA_ONE8 = "teaOne8";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TTea transientInstance)
	{
		log.debug("saving TTea instance");
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

	public void delete(TTea persistentInstance)
	{
		log.debug("deleting TTea instance");
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

	public TTea findById(Integer id)
	{
		log.debug("getting TTea instance with id: " + id);
		try
		{
			TTea instance = (TTea) getHibernateTemplate().get("com.model.TTea",
					id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TTea instance)
	{
		log.debug("finding TTea instance by example");
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
		log.debug("finding TTea instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TTea as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTeaBianhao(Object teaBianhao)
	{
		return findByProperty(TEA_BIANHAO, teaBianhao);
	}

	public List findByTeaRealname(Object teaRealname)
	{
		return findByProperty(TEA_REALNAME, teaRealname);
	}

	public List findByTeaSex(Object teaSex)
	{
		return findByProperty(TEA_SEX, teaSex);
	}

	public List findByTeaAge(Object teaAge)
	{
		return findByProperty(TEA_AGE, teaAge);
	}

	public List findByTeaTel(Object teaTel)
	{
		return findByProperty(TEA_TEL, teaTel);
	}

	public List findByTeaAddress(Object teaAddress)
	{
		return findByProperty(TEA_ADDRESS, teaAddress);
	}

	public List findByTeaJianli(Object teaJianli)
	{
		return findByProperty(TEA_JIANLI, teaJianli);
	}

	public List findByKechengId(Object kechengId)
	{
		return findByProperty(KECHENG_ID, kechengId);
	}

	public List findByXibieId(Object xibieId)
	{
		return findByProperty(XIBIE_ID, xibieId);
	}

	public List findByXuyuanId(Object xuyuanId)
	{
		return findByProperty(XUYUAN_ID, xuyuanId);
	}

	public List findByLoginName(Object loginName)
	{
		return findByProperty(LOGIN_NAME, loginName);
	}

	public List findByLoginPw(Object loginPw)
	{
		return findByProperty(LOGIN_PW, loginPw);
	}

	public List findByTeaDel(Object teaDel)
	{
		return findByProperty(TEA_DEL, teaDel);
	}

	public List findByTeaOne1(Object teaOne1)
	{
		return findByProperty(TEA_ONE1, teaOne1);
	}

	public List findByTeaOne2(Object teaOne2)
	{
		return findByProperty(TEA_ONE2, teaOne2);
	}

	public List findByTeaOne3(Object teaOne3)
	{
		return findByProperty(TEA_ONE3, teaOne3);
	}

	public List findByTeaOne4(Object teaOne4)
	{
		return findByProperty(TEA_ONE4, teaOne4);
	}

	public List findByTeaOne7(Object teaOne7)
	{
		return findByProperty(TEA_ONE7, teaOne7);
	}

	public List findByTeaOne8(Object teaOne8)
	{
		return findByProperty(TEA_ONE8, teaOne8);
	}

	public List findAll()
	{
		log.debug("finding all TTea instances");
		try
		{
			String queryString = "from TTea";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTea merge(TTea detachedInstance)
	{
		log.debug("merging TTea instance");
		try
		{
			TTea result = (TTea) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTea instance)
	{
		log.debug("attaching dirty TTea instance");
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

	public void attachClean(TTea instance)
	{
		log.debug("attaching clean TTea instance");
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

	public static TTeaDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TTeaDAO) ctx.getBean("TTeaDAO");
	}
}