package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TBanjiDAO;
import com.dao.TStuDAO;
import com.dao.TTeaDAO;
import com.dao.TXibieDAO;
import com.dao.TXuyuanDAO;
import com.dao.TZhuanyeDAO;
import com.model.TAdmin;
import com.model.TStu;
import com.model.TTea;

public class loginService
{
	private TAdminDAO adminDAO;
	private TTeaDAO teaDAO;
	private TStuDAO stuDAO;
	private TXuyuanDAO xuyuanDAO;
	
	private TXibieDAO xibieDAO;
	private TZhuanyeDAO zhuanyeDAO;
	private TBanjiDAO banjiDAO;
	
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}
	
	public TBanjiDAO getBanjiDAO()
	{
		return banjiDAO;
	}
	public void setBanjiDAO(TBanjiDAO banjiDAO)
	{
		this.banjiDAO = banjiDAO;
	}
	public TXibieDAO getXibieDAO()
	{
		return xibieDAO;
	}
	public void setXibieDAO(TXibieDAO xibieDAO)
	{
		this.xibieDAO = xibieDAO;
	}
	public TXuyuanDAO getXuyuanDAO()
	{
		return xuyuanDAO;
	}
	public void setXuyuanDAO(TXuyuanDAO xuyuanDAO)
	{
		this.xuyuanDAO = xuyuanDAO;
	}
	public TZhuanyeDAO getZhuanyeDAO()
	{
		return zhuanyeDAO;
	}
	public void setZhuanyeDAO(TZhuanyeDAO zhuanyeDAO)
	{
		this.zhuanyeDAO = zhuanyeDAO;
	}
	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}
	public TTeaDAO getTeaDAO()
	{
		return teaDAO;
	}
	public void setTeaDAO(TTeaDAO teaDAO)
	{
		this.teaDAO = teaDAO;
	}
	
	
	
	
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result=null;
		
		if(userType==0) // admin login
		{
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName,userPw};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
		if(userType==1)// teacher login
		{
			String sql="from TTea where teaDel='no' and loginName=? and loginPw=?";
			Object[] con={userName,userPw};
			List teaList=teaDAO.getHibernateTemplate().find(sql,con);
			if(teaList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TTea tea=(TTea)teaList.get(0);
				 session.setAttribute("userType", 1);
	             session.setAttribute("tea", tea);
	             result="yes";
			}
		}
		if(userType==2)//student login
		{
			String sql="from TStu where stuDel='no' and loginName=? and loginPw=?";
			Object[] con={userName,userPw};
			List stuList=stuDAO.getHibernateTemplate().find(sql,con);
			if(stuList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TStu stu=(TStu)stuList.get(0);
				 stu.setStuOne1(xuyuanDAO.findById(stu.getXuyuanId()).getXuyuanName());
				 stu.setStuOne2(xibieDAO.findById(stu.getXibieId()).getXibieName());
				 stu.setStuOne3(zhuanyeDAO.findById(stu.getZhuanyeId()).getZhuanyeName());
				 stu.setStuOne4(banjiDAO.findById(stu.getBanjiId()).getBanjiName());
				 session.setAttribute("userType", 2);
	             session.setAttribute("stu", stu);
	             result="yes";
			}
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }

}
