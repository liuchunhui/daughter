package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TKechengDAO;
import com.model.TKecheng;
import com.opensymphony.xwork2.ActionSupport;

public class kechengAction extends ActionSupport
{
	private int kechengId;
	private String kechengBianhao;
	private String kechengName;
	private String kechengXueshi;
	private int kechengLeixing;
	private TKechengDAO kechengDAO;
	private String message;
	private String path;

	public String kechengAdd()
	{
		TKecheng kecheng=new TKecheng();
		kecheng.setKechengBianhao(kechengBianhao);
		kecheng.setKechengLeixing(kechengLeixing);
		kecheng.setKechengName(kechengName);
		kecheng.setKechengXueshi(kechengXueshi);
		kecheng.setKechengDel("no");
		kechengDAO.save(kecheng);
		this.setMessage("添加课程成功");
		this.setPath("kechengManage.action");
		return "succeed";
	}
	public String kechengManage()
	{
		String sql = "from TKecheng where kechengDel='no'";
		List kechengList=kechengDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kechengList", kechengList);
		return ActionSupport.SUCCESS;
	}
	public String kechengDel()
	{
		TKecheng kecheng=kechengDAO.findById(kechengId);
		kecheng.setKechengDel("yes");
		kechengDAO.getHibernateTemplate().update(kecheng);
		this.setMessage("删除课程成功");
		this.setPath("kechengManage.action");
		return "succeed";
	}
	
	
	public String kechengEditPre()
	{
		TKecheng kecheng=kechengDAO.findById(kechengId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kecheng", kecheng);
		return ActionSupport.SUCCESS;
	}
	
	public String kechengEdit()
	{
		TKecheng kecheng=kechengDAO.findById(kechengId);
		kecheng.setKechengBianhao(kechengBianhao);
		kecheng.setKechengLeixing(kechengLeixing);
		kecheng.setKechengName(kechengName);
		kecheng.setKechengXueshi(kechengXueshi);
		kechengDAO.attachDirty(kecheng);
		this.setMessage("更新课程成功");
		this.setPath("kechengManage.action");
		return "succeed";
	}
	
	public String kechengAllAll()
	{
		String sql = "from TKecheng where kechengDel='no'";
		List kechengList=kechengDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kechengList", kechengList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String kechengSearch()
	{
		String sql = "from TKecheng where kechengDel='no' and kechengName like '%"+kechengName.trim()+"%'";
		List kechengList=kechengDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kechengList", kechengList);
		return ActionSupport.SUCCESS;
	}

	public String getKechengBianhao()
	{
		return kechengBianhao;
	}
	public void setKechengBianhao(String kechengBianhao)
	{
		this.kechengBianhao = kechengBianhao;
	}
	public TKechengDAO getKechengDAO()
	{
		return kechengDAO;
	}
	public void setKechengDAO(TKechengDAO kechengDAO)
	{
		this.kechengDAO = kechengDAO;
	}
	public int getKechengId()
	{
		return kechengId;
	}
	public void setKechengId(int kechengId)
	{
		this.kechengId = kechengId;
	}
	public int getKechengLeixing()
	{
		return kechengLeixing;
	}
	public void setKechengLeixing(int kechengLeixing)
	{
		this.kechengLeixing = kechengLeixing;
	}
	public String getKechengName()
	{
		return kechengName;
	}
	public void setKechengName(String kechengName)
	{
		this.kechengName = kechengName;
	}
	public String getKechengXueshi()
	{
		return kechengXueshi;
	}
	public void setKechengXueshi(String kechengXueshi)
	{
		this.kechengXueshi = kechengXueshi;
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
	
}
