package com.model;

import java.util.Date;
public class TStu implements java.io.Serializable
{
	private Integer stuId;
	private String stuXuehao;
	private String stuRealname;
	private String stuSex;
	private String stuAge;
	private String stuCard;
	private Integer banjiId;
	private Integer zhuanyeId;
	private Integer xibieId;
	private Integer xuyuanId;
	private String loginName;
	private String loginPw;
	private String stuDel;
	private String stuOne1;
	private String stuOne2;
	private String stuOne3;
	private String stuOne4;
	private Date stuOne5;
	private Date stuOne6;
	private Integer stuOne7;
	private Integer stuOne8;

	// Constructors

	/** default constructor */
	public TStu() {}

	/** full constructor */
	public TStu(String stuXuehao, String stuRealname, String stuSex,
			String stuAge, String stuCard, Integer banjiId, Integer zhuanyeId,
			Integer xibieId, Integer xuyuanId, String loginName,
			String loginPw, String stuDel, String stuOne1, String stuOne2,
			String stuOne3, String stuOne4, Date stuOne5, Date stuOne6,
			Integer stuOne7, Integer stuOne8) {
		this.stuXuehao = stuXuehao;
		this.stuRealname = stuRealname;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuCard = stuCard;
		this.banjiId = banjiId;
		this.zhuanyeId = zhuanyeId;
		this.xibieId = xibieId;
		this.xuyuanId = xuyuanId;
		this.loginName = loginName;
		this.loginPw = loginPw;
		this.stuDel = stuDel;
		this.stuOne1 = stuOne1;
		this.stuOne2 = stuOne2;
		this.stuOne3 = stuOne3;
		this.stuOne4 = stuOne4;
		this.stuOne5 = stuOne5;
		this.stuOne6 = stuOne6;
		this.stuOne7 = stuOne7;
		this.stuOne8 = stuOne8;
	}

	// Property accessors

	public Integer getStuId()
	{
		return this.stuId;
	}

	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}

	public String getStuXuehao()
	{
		return this.stuXuehao;
	}

	public void setStuXuehao(String stuXuehao)
	{
		this.stuXuehao = stuXuehao;
	}

	public String getStuRealname()
	{
		return this.stuRealname;
	}

	public void setStuRealname(String stuRealname)
	{
		this.stuRealname = stuRealname;
	}

	public String getStuSex()
	{
		return this.stuSex;
	}

	public void setStuSex(String stuSex)
	{
		this.stuSex = stuSex;
	}

	public String getStuAge()
	{
		return this.stuAge;
	}

	public void setStuAge(String stuAge)
	{
		this.stuAge = stuAge;
	}

	public String getStuCard()
	{
		return this.stuCard;
	}

	public void setStuCard(String stuCard)
	{
		this.stuCard = stuCard;
	}

	public Integer getBanjiId()
	{
		return this.banjiId;
	}

	public void setBanjiId(Integer banjiId)
	{
		this.banjiId = banjiId;
	}

	public Integer getZhuanyeId()
	{
		return this.zhuanyeId;
	}

	public void setZhuanyeId(Integer zhuanyeId)
	{
		this.zhuanyeId = zhuanyeId;
	}

	public Integer getXibieId()
	{
		return this.xibieId;
	}

	public void setXibieId(Integer xibieId)
	{
		this.xibieId = xibieId;
	}

	public Integer getXuyuanId()
	{
		return this.xuyuanId;
	}

	public void setXuyuanId(Integer xuyuanId)
	{
		this.xuyuanId = xuyuanId;
	}

	public String getLoginName()
	{
		return this.loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getLoginPw()
	{
		return this.loginPw;
	}

	public void setLoginPw(String loginPw)
	{
		this.loginPw = loginPw;
	}

	public String getStuDel()
	{
		return this.stuDel;
	}

	public void setStuDel(String stuDel)
	{
		this.stuDel = stuDel;
	}

	public String getStuOne1()
	{
		return this.stuOne1;
	}

	public void setStuOne1(String stuOne1)
	{
		this.stuOne1 = stuOne1;
	}

	public String getStuOne2()
	{
		return this.stuOne2;
	}

	public void setStuOne2(String stuOne2)
	{
		this.stuOne2 = stuOne2;
	}

	public String getStuOne3()
	{
		return this.stuOne3;
	}

	public void setStuOne3(String stuOne3)
	{
		this.stuOne3 = stuOne3;
	}

	public String getStuOne4()
	{
		return this.stuOne4;
	}

	public void setStuOne4(String stuOne4)
	{
		this.stuOne4 = stuOne4;
	}

	public Date getStuOne5()
	{
		return this.stuOne5;
	}

	public void setStuOne5(Date stuOne5)
	{
		this.stuOne5 = stuOne5;
	}

	public Date getStuOne6()
	{
		return this.stuOne6;
	}

	public void setStuOne6(Date stuOne6)
	{
		this.stuOne6 = stuOne6;
	}

	public Integer getStuOne7()
	{
		return this.stuOne7;
	}

	public void setStuOne7(Integer stuOne7)
	{
		this.stuOne7 = stuOne7;
	}

	public Integer getStuOne8()
	{
		return this.stuOne8;
	}

	public void setStuOne8(Integer stuOne8)
	{
		this.stuOne8 = stuOne8;
	}
}