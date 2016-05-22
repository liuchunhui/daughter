package com.model;

import java.util.Date;
public class TTea implements java.io.Serializable
{
	private Integer teaId;
	private String teaBianhao;
	private String teaRealname;
	private String teaSex;
	private String teaAge;
	private String teaTel;
	private String teaAddress;
	private String teaJianli;
	private Integer kechengId;
	private Integer xibieId;
	private Integer xuyuanId;
	private String loginName;
	private String loginPw;
	private String teaDel;
	private String teaOne1;
	private String teaOne2;
	private String teaOne3;
	private String teaOne4;
	private Date teaOne5;
	private Date teaOne6;
	private Integer teaOne7;
	private Integer teaOne8;
	// Constructors

	/** default constructor */
	public TTea() {}

	/** full constructor */
	public TTea(String teaBianhao, String teaRealname, String teaSex,
			String teaAge, String teaTel, String teaAddress, String teaJianli,
			Integer kechengId, Integer xibieId, Integer xuyuanId,
			String loginName, String loginPw, String teaDel, String teaOne1,
			String teaOne2, String teaOne3, String teaOne4, Date teaOne5,
			Date teaOne6, Integer teaOne7, Integer teaOne8) {
		this.teaBianhao = teaBianhao;
		this.teaRealname = teaRealname;
		this.teaSex = teaSex;
		this.teaAge = teaAge;
		this.teaTel = teaTel;
		this.teaAddress = teaAddress;
		this.teaJianli = teaJianli;
		this.kechengId = kechengId;
		this.xibieId = xibieId;
		this.xuyuanId = xuyuanId;
		this.loginName = loginName;
		this.loginPw = loginPw;
		this.teaDel = teaDel;
		this.teaOne1 = teaOne1;
		this.teaOne2 = teaOne2;
		this.teaOne3 = teaOne3;
		this.teaOne4 = teaOne4;
		this.teaOne5 = teaOne5;
		this.teaOne6 = teaOne6;
		this.teaOne7 = teaOne7;
		this.teaOne8 = teaOne8;
	}

	// Property accessors

	public Integer getTeaId()
	{
		return this.teaId;
	}

	public void setTeaId(Integer teaId)
	{
		this.teaId = teaId;
	}

	public String getTeaBianhao()
	{
		return this.teaBianhao;
	}

	public void setTeaBianhao(String teaBianhao)
	{
		this.teaBianhao = teaBianhao;
	}

	public String getTeaRealname()
	{
		return this.teaRealname;
	}

	public void setTeaRealname(String teaRealname)
	{
		this.teaRealname = teaRealname;
	}

	public String getTeaSex()
	{
		return this.teaSex;
	}

	public void setTeaSex(String teaSex)
	{
		this.teaSex = teaSex;
	}

	public String getTeaAge()
	{
		return this.teaAge;
	}

	public void setTeaAge(String teaAge)
	{
		this.teaAge = teaAge;
	}

	public String getTeaTel()
	{
		return this.teaTel;
	}

	public void setTeaTel(String teaTel)
	{
		this.teaTel = teaTel;
	}

	public String getTeaAddress()
	{
		return this.teaAddress;
	}

	public void setTeaAddress(String teaAddress)
	{
		this.teaAddress = teaAddress;
	}

	public String getTeaJianli()
	{
		return this.teaJianli;
	}

	public void setTeaJianli(String teaJianli)
	{
		this.teaJianli = teaJianli;
	}

	public Integer getKechengId()
	{
		return this.kechengId;
	}

	public void setKechengId(Integer kechengId)
	{
		this.kechengId = kechengId;
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

	public String getTeaDel()
	{
		return this.teaDel;
	}

	public void setTeaDel(String teaDel)
	{
		this.teaDel = teaDel;
	}

	public String getTeaOne1()
	{
		return this.teaOne1;
	}

	public void setTeaOne1(String teaOne1)
	{
		this.teaOne1 = teaOne1;
	}

	public String getTeaOne2()
	{
		return this.teaOne2;
	}

	public void setTeaOne2(String teaOne2)
	{
		this.teaOne2 = teaOne2;
	}

	public String getTeaOne3()
	{
		return this.teaOne3;
	}

	public void setTeaOne3(String teaOne3)
	{
		this.teaOne3 = teaOne3;
	}

	public String getTeaOne4()
	{
		return this.teaOne4;
	}

	public void setTeaOne4(String teaOne4)
	{
		this.teaOne4 = teaOne4;
	}

	public Date getTeaOne5()
	{
		return this.teaOne5;
	}

	public void setTeaOne5(Date teaOne5)
	{
		this.teaOne5 = teaOne5;
	}

	public Date getTeaOne6()
	{
		return this.teaOne6;
	}

	public void setTeaOne6(Date teaOne6)
	{
		this.teaOne6 = teaOne6;
	}

	public Integer getTeaOne7()
	{
		return this.teaOne7;
	}

	public void setTeaOne7(Integer teaOne7)
	{
		this.teaOne7 = teaOne7;
	}

	public Integer getTeaOne8()
	{
		return this.teaOne8;
	}

	public void setTeaOne8(Integer teaOne8)
	{
		this.teaOne8 = teaOne8;
	}
}