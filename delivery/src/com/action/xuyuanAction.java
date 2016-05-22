package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TXibieDAO;
import com.dao.TXuyuanDAO;
import com.model.TXuyuan;
import com.opensymphony.xwork2.ActionSupport;

public class xuyuanAction extends ActionSupport
{
	private int xuyuanId;
	private String xuyuanBianhao;
	private String xuyuanName;
	private String xuyuanJianjie;
	private TXuyuanDAO xuyuanDAO;
	private TXibieDAO xibieDAO;
	private String message;
	private String path;
	
	public String xuyuanAdd()
	{
		TXuyuan xuyuan=new TXuyuan();
		xuyuan.setXuyuanBianhao(xuyuanBianhao);
		xuyuan.setXuyuanName(xuyuanName);
		xuyuan.setXuyuanJianjie(xuyuanJianjie);
		xuyuan.setXuyuanDel("no");
		xuyuanDAO.save(xuyuan);
		this.setMessage("添加学院信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	public String xuyuanMana()
	{
		String sql="from TXuyuan where xuyuanDel='no'";
		List xuyuanList=xuyuanDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xuyuanList", xuyuanList);
		return ActionSupport.SUCCESS;
	}
	
	public String xuyuanDel()
	{
		String sql="from TXibie where xibieDel='no' and xuyuanId="+xuyuanId;
		List xibieList=xibieDAO.getHibernateTemplate().find(sql);
		if(xibieList.size()>0)
		{
			this.setMessage("该学院下有系信息,请删除系信息");
			this.setPath("xuyuanMana.action");
		}
		
		else
		{
			TXuyuan xuyuan=xuyuanDAO.findById(xuyuanId);
			xuyuan.setXuyuanDel("yes");
			xuyuanDAO.attachDirty(xuyuan);
			this.setMessage("删除学院信息成功");
			this.setPath("xuyuanMana.action");
		}
		return "succeed";
	}
	
	
	public String xuyuanEditPre()
	{
		TXuyuan xuyuan=xuyuanDAO.findById(xuyuanId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xuyuan", xuyuan);
		return ActionSupport.SUCCESS;
	}
	
	public String xuyuanEdit()
	{
		TXuyuan xuyuan=xuyuanDAO.findById(xuyuanId);
		xuyuan.setXuyuanBianhao(xuyuanBianhao);
		xuyuan.setXuyuanName(xuyuanName);
		xuyuan.setXuyuanJianjie(xuyuanJianjie);
		xuyuan.setXuyuanDel("no");
		xuyuanDAO.attachDirty(xuyuan);
		this.setMessage("添加学院信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}

	public String getXuyuanBianhao()
	{
		return xuyuanBianhao;
	}
	public void setXuyuanBianhao(String xuyuanBianhao)
	{
		this.xuyuanBianhao = xuyuanBianhao;
	}
	public int getXuyuanId()
	{
		return xuyuanId;
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
	public TXibieDAO getXibieDAO()
	{
		return xibieDAO;
	}
	public void setXibieDAO(TXibieDAO xibieDAO)
	{
		this.xibieDAO = xibieDAO;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public TXuyuanDAO getXuyuanDAO()
	{
		return xuyuanDAO;
	}
	public void setXuyuanDAO(TXuyuanDAO xuyuanDAO)
	{
		this.xuyuanDAO = xuyuanDAO;
	}
	public void setXuyuanId(int xuyuanId)
	{
		this.xuyuanId = xuyuanId;
	}
	public String getXuyuanJianjie()
	{
		return xuyuanJianjie;
	}
	public void setXuyuanJianjie(String xuyuanJianjie)
	{
		this.xuyuanJianjie = xuyuanJianjie;
	}
	public String getXuyuanName()
	{
		return xuyuanName;
	}
	public void setXuyuanName(String xuyuanName)
	{
		this.xuyuanName = xuyuanName;
	}
}
