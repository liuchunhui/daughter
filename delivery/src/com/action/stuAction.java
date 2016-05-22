package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBanjiDAO;
import com.dao.TStuDAO;
import com.dao.TXibieDAO;
import com.dao.TXuyuanDAO;
import com.dao.TZhuanyeDAO;
import com.model.TBanji;
import com.model.TStu;
import com.model.TXibie;
import com.model.TZhuanye;
import com.opensymphony.xwork2.ActionSupport;

public class stuAction extends ActionSupport
{

	private int stuId;
	private String stuXuehao;
	private String stuRealname;
	private String stuSex;
	private String stuAge;
	private String stuCard;
	private String loginName;
	private String loginPw;
    private int banjiId;
	private String message;
	private String path;
	private TXuyuanDAO xuyuanDAO;
	private TXibieDAO xibieDAO;
	private TZhuanyeDAO zhuanyeDAO;
	private TBanjiDAO banjiDAO;
	private TStuDAO stuDAO;
	
	
	public String stuMana()
	{
		String sql="from TStu where stuDel='no' and banjiId="+banjiId;
		List stuList=stuDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("stuList", stuList);
		request.put("banjiId", banjiId);
		return ActionSupport.SUCCESS;
	}
	
	public String stuAdd()
	{
		TStu stu=new TStu();
		stu.setStuXuehao(stuXuehao);
		stu.setStuRealname(stuRealname);
		stu.setStuSex(stuSex);
		stu.setStuAge(stuAge);
		stu.setStuCard(stuCard);
		stu.setLoginName(loginName);
		stu.setLoginPw(loginPw);
		stu.setStuDel("no");
		stu.setBanjiId(banjiId);
		TBanji banji=banjiDAO.findById(banjiId);
		TZhuanye zhuanye=zhuanyeDAO.findById(banji.getZhuanyeId());
		TXibie xibie=xibieDAO.findById(zhuanye.getXibieId());
		stu.setZhuanyeId(zhuanye.getZhuanyeId());
		stu.setXibieId(xibie.getXibieId());
		stu.setXuyuanId(xibie.getXuyuanId());
		
		stuDAO.save(stu);
		this.setMessage("添加学生信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	public String stuDel()
	{
		TStu stu=stuDAO.findById(stuId);
		stu.setStuDel("yes");
		stuDAO.attachDirty(stu);
		this.setMessage("删除学生信息成功");
		this.setPath("xuyuanMana.action");
		return "succeed";
	}
	
	public String stuEditPre()
	{
		TStu stu=stuDAO.findById(stuId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("stu", stu);
		return ActionSupport.SUCCESS;
	}
	
	public String stuEdit()
	{
		TStu stu=stuDAO.findById(stuId);
		stu.setStuXuehao(stuXuehao);
		stu.setStuRealname(stuRealname);
		stu.setStuSex(stuSex);
		stu.setStuAge(stuAge);
		stu.setStuCard(stuCard);
		stu.setLoginName(loginName);
		stu.setLoginPw(loginPw);
		stuDAO.attachDirty(stu);
		this.setMessage("更新学生信息成功");
		this.setPath("xuyuanMana.action");
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
	public int getBanjiId()
	{
		return banjiId;
	}
	public void setBanjiId(int banjiId)
	{
		this.banjiId = banjiId;
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
	public String getStuAge()
	{
		return stuAge;
	}
	public void setStuAge(String stuAge)
	{
		this.stuAge = stuAge;
	}
	public String getStuCard()
	{
		return stuCard;
	}
	public void setStuCard(String stuCard)
	{
		this.stuCard = stuCard;
	}
	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}
	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}
	public int getStuId()
	{
		return stuId;
	}
	public void setStuId(int stuId)
	{
		this.stuId = stuId;
	}
	public String getStuRealname()
	{
		return stuRealname;
	}
	public void setStuRealname(String stuRealname)
	{
		this.stuRealname = stuRealname;
	}
	public String getStuSex()
	{
		return stuSex;
	}
	public void setStuSex(String stuSex)
	{
		this.stuSex = stuSex;
	}
	public String getStuXuehao()
	{
		return stuXuehao;
	}
	public void setStuXuehao(String stuXuehao)
	{
		this.stuXuehao = stuXuehao;
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
}
