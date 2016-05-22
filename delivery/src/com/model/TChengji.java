package com.model;

import java.util.Date;

public class TChengji implements java.io.Serializable {
	private Integer chengjiId;
	private Integer stuId;
	private Integer kechengId;
	private Integer kaoshifenshu;
	private String kaoshishijian;
	private String kaoshileixing;
	private String chengjiAddUser;
	private String chengjiOne1;
	private String chengjiOne2;
	private String chengjiOne3;
	private String chengjiOne4;
	private Date chengjiOne5;
	private Date chengjiOne6;
	private Integer chengjiOne7;
	private Integer chengjiOne8;

	// Constructors

	/** default constructor */
	public TChengji() {}

	/** full constructor */
	public TChengji(Integer stuId, Integer kechengId, Integer kaoshifenshu,
			String kaoshishijian, String kaoshileixing, String chengjiAddUser,
			String chengjiOne1, String chengjiOne2, String chengjiOne3,
			String chengjiOne4, Date chengjiOne5, Date chengjiOne6,
			Integer chengjiOne7, Integer chengjiOne8) {
		this.stuId = stuId;
		this.kechengId = kechengId;
		this.kaoshifenshu = kaoshifenshu;
		this.kaoshishijian = kaoshishijian;
		this.kaoshileixing = kaoshileixing;
		this.chengjiAddUser = chengjiAddUser;
		this.chengjiOne1 = chengjiOne1;
		this.chengjiOne2 = chengjiOne2;
		this.chengjiOne3 = chengjiOne3;
		this.chengjiOne4 = chengjiOne4;
		this.chengjiOne5 = chengjiOne5;
		this.chengjiOne6 = chengjiOne6;
		this.chengjiOne7 = chengjiOne7;
		this.chengjiOne8 = chengjiOne8;
	}

	// Property accessors

	public Integer getChengjiId()
	{
		return this.chengjiId;
	}

	public void setChengjiId(Integer chengjiId)
	{
		this.chengjiId = chengjiId;
	}

	public Integer getStuId()
	{
		return this.stuId;
	}

	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}

	public Integer getKechengId()
	{
		return this.kechengId;
	}

	public void setKechengId(Integer kechengId)
	{
		this.kechengId = kechengId;
	}

	public Integer getKaoshifenshu()
	{
		return this.kaoshifenshu;
	}

	public void setKaoshifenshu(Integer kaoshifenshu)
	{
		this.kaoshifenshu = kaoshifenshu;
	}

	public String getKaoshishijian()
	{
		return this.kaoshishijian;
	}

	public void setKaoshishijian(String kaoshishijian)
	{
		this.kaoshishijian = kaoshishijian;
	}

	public String getKaoshileixing()
	{
		return this.kaoshileixing;
	}

	public void setKaoshileixing(String kaoshileixing)
	{
		this.kaoshileixing = kaoshileixing;
	}

	public String getChengjiAddUser()
	{
		return this.chengjiAddUser;
	}

	public void setChengjiAddUser(String chengjiAddUser)
	{
		this.chengjiAddUser = chengjiAddUser;
	}

	public String getChengjiOne1()
	{
		return this.chengjiOne1;
	}

	public void setChengjiOne1(String chengjiOne1)
	{
		this.chengjiOne1 = chengjiOne1;
	}

	public String getChengjiOne2()
	{
		return this.chengjiOne2;
	}

	public void setChengjiOne2(String chengjiOne2)
	{
		this.chengjiOne2 = chengjiOne2;
	}

	public String getChengjiOne3()
	{
		return this.chengjiOne3;
	}

	public void setChengjiOne3(String chengjiOne3)
	{
		this.chengjiOne3 = chengjiOne3;
	}

	public String getChengjiOne4()
	{
		return this.chengjiOne4;
	}

	public void setChengjiOne4(String chengjiOne4)
	{
		this.chengjiOne4 = chengjiOne4;
	}

	public Date getChengjiOne5()
	{
		return this.chengjiOne5;
	}

	public void setChengjiOne5(Date chengjiOne5)
	{
		this.chengjiOne5 = chengjiOne5;
	}

	public Date getChengjiOne6()
	{
		return this.chengjiOne6;
	}

	public void setChengjiOne6(Date chengjiOne6)
	{
		this.chengjiOne6 = chengjiOne6;
	}

	public Integer getChengjiOne7()
	{
		return this.chengjiOne7;
	}

	public void setChengjiOne7(Integer chengjiOne7)
	{
		this.chengjiOne7 = chengjiOne7;
	}

	public Integer getChengjiOne8()
	{
		return this.chengjiOne8;
	}

	public void setChengjiOne8(Integer chengjiOne8)
	{
		this.chengjiOne8 = chengjiOne8;
	}
}