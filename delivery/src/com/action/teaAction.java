package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TKechengDAO;
import com.dao.TTeaDAO;
import com.dao.TXibieDAO;
import com.dao.TXuyuanDAO;
import com.model.TTea;
import com.opensymphony.xwork2.ActionSupport;

public class teaAction extends ActionSupport
{
	private int teaId;
	private String teaBianhao;
	private String teaRealname;
	private String teaSex;
	private String teaAge;
	private String teaTel;
	private String teaAddress;
	private String teaJianli;
	private String loginName;
	private String loginPw;
	private int xibieId;
	private int kechengId;
	private String message;
	private String path;
	private TXuyuanDAO xuyuanDAO;
	private TXibieDAO xibieDAO;
	private TKechengDAO kechengDAO;
	private TTeaDAO teaDAO;

	public String teaAdd()
	{
		TTea tea=new TTea();
		tea.setTeaBianhao(teaBianhao);
		tea.setTeaRealname(teaRealname);
		tea.setTeaSex(teaSex);
		tea.setTeaAge(teaAge);
		tea.setTeaTel(teaTel);
		tea.setTeaAddress(teaAddress);
		tea.setTeaJianli(teaJianli);
		tea.setTeaDel("no");
		tea.setLoginName(loginName);
		tea.setLoginPw(loginPw);
		tea.setKechengId(kechengId);
		tea.setXibieId(xibieId);
		tea.setTeaOne1(kechengDAO.findById(kechengId).getKechengName());//teach course
		tea.setXuyuanId(xibieDAO.findById(xibieId).getXuyuanId());
		teaDAO.save(tea);
		this.setMessage("添加教师信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	
	public String teaMana()
	{
		String sql="from TTea where teaDel='no' and xibieId="+xibieId;
		List teaList=teaDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("teaList", teaList);
		request.put("xibieId", xibieId);
		return ActionSupport.SUCCESS;
		
	}
	
	public String teaDel()
	{
		TTea tea=teaDAO.findById(teaId);
		tea.setTeaDel("yes");
		teaDAO.attachDirty(tea);
		this.setMessage("删除教师信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	
	public String teaEditPre()
	{
		TTea tea=teaDAO.findById(teaId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("tea", tea);
		return ActionSupport.SUCCESS;
	}
	
	
	public String teaEdit()
	{
		TTea tea=teaDAO.findById(teaId);
		tea.setTeaBianhao(teaBianhao);
		tea.setTeaRealname(teaRealname);
		tea.setTeaSex(teaSex);
		tea.setTeaAge(teaAge);
		tea.setTeaTel(teaTel);
		tea.setTeaAddress(teaAddress);
		tea.setTeaJianli(teaJianli);
		tea.setLoginName(loginName);
		tea.setLoginPw(loginPw);
		tea.setKechengId(kechengId);
		tea.setTeaOne1(kechengDAO.findById(kechengId).getKechengName());//teach course
		teaDAO.attachDirty(tea);
		this.setMessage("更新教师信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}

	public int getKechengId()
	{
		return kechengId;
	}
	public void setKechengId(int kechengId)
	{
		this.kechengId = kechengId;
	}
	public String getLoginName()
	{
		return loginName;
	}
	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}
	public String getLoginPw()
	{
		return loginPw;
	}
	public TKechengDAO getKechengDAO()
	{
		return kechengDAO;
	}
	public TTeaDAO getTeaDAO()
	{
		return teaDAO;
	}
	public void setTeaDAO(TTeaDAO teaDAO)
	{
		this.teaDAO = teaDAO;
	}
	public void setKechengDAO(TKechengDAO kechengDAO)
	{
		this.kechengDAO = kechengDAO;
	}
	public void setLoginPw(String loginPw)
	{
		this.loginPw = loginPw;
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
	public String getTeaAddress()
	{
		return teaAddress;
	}
	public void setTeaAddress(String teaAddress)
	{
		this.teaAddress = teaAddress;
	}
	public String getTeaAge()
	{
		return teaAge;
	}
	public void setTeaAge(String teaAge)
	{
		this.teaAge = teaAge;
	}
	public String getTeaBianhao()
	{
		return teaBianhao;
	}
	public void setTeaBianhao(String teaBianhao)
	{
		this.teaBianhao = teaBianhao;
	}
	public int getTeaId()
	{
		return teaId;
	}
	public void setTeaId(int teaId)
	{
		this.teaId = teaId;
	}
	public String getTeaJianli()
	{
		return teaJianli;
	}
	public void setTeaJianli(String teaJianli)
	{
		this.teaJianli = teaJianli;
	}
	public String getTeaRealname()
	{
		return teaRealname;
	}
	public void setTeaRealname(String teaRealname)
	{
		this.teaRealname = teaRealname;
	}
	public String getTeaSex()
	{
		return teaSex;
	}
	public void setTeaSex(String teaSex)
	{
		this.teaSex = teaSex;
	}
	public String getTeaTel()
	{
		return teaTel;
	}
	public void setTeaTel(String teaTel)
	{
		this.teaTel = teaTel;
	}
	public TXibieDAO getXibieDAO()
	{
		return xibieDAO;
	}
	public void setXibieDAO(TXibieDAO xibieDAO)
	{
		this.xibieDAO = xibieDAO;
	}
	public int getXibieId()
	{
		return xibieId;
	}
	public void setXibieId(int xibieId)
	{
		this.xibieId = xibieId;
	}
	public TXuyuanDAO getXuyuanDAO()
	{
		return xuyuanDAO;
	}
	public void setXuyuanDAO(TXuyuanDAO xuyuanDAO)
	{
		this.xuyuanDAO = xuyuanDAO;
	}
}
