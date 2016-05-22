package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBanjiDAO;
import com.dao.TXibieDAO;
import com.dao.TXuyuanDAO;
import com.dao.TZhuanyeDAO;
import com.model.TBanji;
import com.model.TXibie;
import com.model.TXuyuan;
import com.model.TZhuanye;
import com.opensymphony.xwork2.ActionSupport;

public class zhuanyeAction extends ActionSupport
{
	private int zhuanyeId;
	private String zhuanyeBianhao;
	private String zhuanyeName;
	private String zhuanyeJieshao;
	private int xibieId;
	private String message;
	private String path;
	private TXuyuanDAO xuyuanDAO;
	private TXibieDAO xibieDAO;
	private TZhuanyeDAO zhuanyeDAO;
	private TBanjiDAO banjiDAO;
	
	public String zhuanyeMana()
	{
		String sql="from TZhuanye where zhuanyeDel='no' and xibieId="+xibieId;
		List zhuanyeList=zhuanyeDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhuanyeList", zhuanyeList);
		request.put("xibieId", xibieId);
		return ActionSupport.SUCCESS;
	}

	public String zhuanyeAdd()
	{
		TZhuanye zhuanye=new TZhuanye();
		zhuanye.setZhuanyeBianhao(zhuanyeBianhao);
		zhuanye.setZhuanyeName(zhuanyeName);
		zhuanye.setZhuanyeJieshao(zhuanyeJieshao);
		zhuanye.setZhuanyeDel("no");
		zhuanye.setXibieId(xibieId);
		TXibie xibie=xibieDAO.findById(xibieId);
		zhuanye.setXuyuanId(xibie.getXuyuanId());
		zhuanyeDAO.save(zhuanye);
		this.setMessage("添加专业信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	public String zhuanyeEditPre()
	{
		TZhuanye zhuanye=zhuanyeDAO.findById(zhuanyeId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhuanye", zhuanye);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zhuanyeEdit()
	{
		TZhuanye zhuanye=zhuanyeDAO.findById(zhuanyeId);
		zhuanye.setZhuanyeBianhao(zhuanyeBianhao);
		zhuanye.setZhuanyeName(zhuanyeName);
		zhuanye.setZhuanyeJieshao(zhuanyeJieshao);
		zhuanyeDAO.attachDirty(zhuanye);
		this.setMessage("更新专业信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	public String zhuanyeDel()
	{
		String sql="from TBanji where banjiDel='no' and zhuanyeId="+zhuanyeId;
		List banjiList=banjiDAO.getHibernateTemplate().find(sql);
		if(banjiList.size()>0)
		{
			this.setMessage("该专业下有班级信息,请删除班级信息");
			this.setPath("xuyuanMana.action");
		}
		else
		{
			TZhuanye zhuanye=zhuanyeDAO.findById(zhuanyeId);
			zhuanye.setZhuanyeDel("yes");
			zhuanyeDAO.getHibernateTemplate().update(zhuanye);
			this.setMessage("删除专业信息成功");
			this.setPath("xuyuanMana.action");
		}
		return "succeed";
	}

	public TBanjiDAO getBanjiDAO()
	{
		return banjiDAO;
	}
	public void setBanjiDAO(TBanjiDAO banjiDAO)
	{
		this.banjiDAO = banjiDAO;
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
	public TXibieDAO getXibieDAO()
	{
		return xibieDAO;
	}
	public void setXibieDAO(TXibieDAO xibieDAO)
	{
		this.xibieDAO = xibieDAO;
	}
	public String getZhuanyeJieshao()
	{
		return zhuanyeJieshao;
	}
	public void setZhuanyeJieshao(String zhuanyeJieshao)
	{
		this.zhuanyeJieshao = zhuanyeJieshao;
	}
	public TXuyuanDAO getXuyuanDAO()
	{
		return xuyuanDAO;
	}
	public void setXuyuanDAO(TXuyuanDAO xuyuanDAO)
	{
		this.xuyuanDAO = xuyuanDAO;
	}
	public int getXibieId()
	{
		return xibieId;
	}
	public void setXibieId(int xibieId)
	{
		this.xibieId = xibieId;
	}
	public String getZhuanyeBianhao()
	{
		return zhuanyeBianhao;
	}
	public void setZhuanyeBianhao(String zhuanyeBianhao)
	{
		this.zhuanyeBianhao = zhuanyeBianhao;
	}
	public TZhuanyeDAO getZhuanyeDAO()
	{
		return zhuanyeDAO;
	}
	public void setZhuanyeDAO(TZhuanyeDAO zhuanyeDAO)
	{
		this.zhuanyeDAO = zhuanyeDAO;
	}
	public int getZhuanyeId()
	{
		return zhuanyeId;
	}
	public void setZhuanyeId(int zhuanyeId)
	{
		this.zhuanyeId = zhuanyeId;
	}
	public String getZhuanyeName()
	{
		return zhuanyeName;
	}
	public void setZhuanyeName(String zhuanyeName)
	{
		this.zhuanyeName = zhuanyeName;
	}
}
