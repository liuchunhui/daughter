package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TXibieDAO;
import com.dao.TXuyuanDAO;
import com.dao.TZhuanyeDAO;
import com.model.TXibie;
import com.model.TXuyuan;
import com.opensymphony.xwork2.ActionSupport;

public class xibieAction extends ActionSupport
{
	private int xuyuanId;
	private int xibieId;
	private String xibieBianhao;
	private String xibieName;
	private String xibieJianjie;
	private TXibieDAO xibieDAO;
	private TZhuanyeDAO zhuanyeDAO;
	private String message;
	private String path;
	
	public String xibieAdd()
	{
		TXibie xibie=new TXibie();
		xibie.setXibieBianhao(xibieBianhao);
		xibie.setXibieName(xibieName);
		xibie.setXibieJianjie(xibieJianjie);
		xibie.setXibieDel("no");
		xibie.setXuyuanId(xuyuanId);
		xibieDAO.save(xibie);
		this.setMessage("添加系别信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	public String xibieMana()
	{
		String sql="from TXibie where xibieDel='no' and xuyuanId="+xuyuanId;
		List xibieList=xibieDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xibieList", xibieList);
		request.put("xuyuanId", xuyuanId);
		return ActionSupport.SUCCESS;
		
	}
	
	public String xibieEditPre()
	{
		TXibie xibie=xibieDAO.findById(xibieId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xibie", xibie);
		return ActionSupport.SUCCESS;
	}
	
	public String xibieEdit()
	{
		TXibie xibie=xibieDAO.findById(xibieId);
		xibie.setXibieBianhao(xibieBianhao);
		xibie.setXibieName(xibieName);
		xibie.setXibieJianjie(xibieJianjie);
		xibieDAO.attachDirty(xibie);
		this.setMessage("更新系别信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	
	public String xibieDel()
	{
		String sql="from TZhuanye where zhuanyeDel='no' and xibieId="+xibieId;
		List zhuanyeList=zhuanyeDAO.getHibernateTemplate().find(sql);
		if(zhuanyeList.size()>0)
		{
			this.setMessage("该系别下有专业信息,请删除该系别下的专业信息");
			this.setPath("xuyuanMana.action");
		}
		else
		{
			TXibie xibie=xibieDAO.findById(xibieId);
			xibie.setXibieDel("yes");
			xibieDAO.attachDirty(xibie);
			this.setMessage("删除系别信息成功");
			this.setPath("xuyuanMana.action");
		}
		return "succeed";
	}

	public TZhuanyeDAO getZhuanyeDAO()
	{
		return zhuanyeDAO;
	}

	public void setZhuanyeDAO(TZhuanyeDAO zhuanyeDAO)
	{
		this.zhuanyeDAO = zhuanyeDAO;
	}

	public String getMessage()
	{
		return message;
	}

	public String getXibieBianhao()
	{
		return xibieBianhao;
	}

	public void setXibieBianhao(String xibieBianhao)
	{
		this.xibieBianhao = xibieBianhao;
	}

	public String getXibieName()
	{
		return xibieName;
	}

	public void setXibieName(String xibieName)
	{
		this.xibieName = xibieName;
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

	public int getXibieId()
	{
		return xibieId;
	}

	public void setXibieId(int xibieId)
	{
		this.xibieId = xibieId;
	}

	public String getXibieJianjie()
	{
		return xibieJianjie;
	}

	public void setXibieJianjie(String xibieJianjie)
	{
		this.xibieJianjie = xibieJianjie;
	}

	public int getXuyuanId()
	{
		return xuyuanId;
	}

	public void setXuyuanId(int xuyuanId)
	{
		this.xuyuanId = xuyuanId;
	}
}
