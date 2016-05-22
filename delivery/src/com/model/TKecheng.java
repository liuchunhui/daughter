package com.model;

import java.util.Date;
public class TKecheng implements java.io.Serializable {

	private Integer kechengId;
	private String kechengBianhao;
	private String kechengName;
	private String kechengXueshi;
	private Integer kechengLeixing;
	private String kechengDel;
	private String kechengO1;
	private String kechengO2;
	private String kechengO3;
	private Integer kechengO4;
	private Integer kechengO5;
	private Date kechengO6;
	private Date kechengO7;
	private Long kechengO8;
	private Long kechengO9;

	// Constructors

	/** default constructor */
	public TKecheng() {}

	/** full constructor */
	public TKecheng(String kechengBianhao, String kechengName,
			String kechengXueshi, Integer kechengLeixing, String kechengO1,
			String kechengO2, String kechengO3, Integer kechengO4,
			Integer kechengO5, Date kechengO6, Date kechengO7, Long kechengO8,
			Long kechengO9) {
		this.kechengBianhao = kechengBianhao;
		this.kechengName = kechengName;
		this.kechengXueshi = kechengXueshi;
		this.kechengLeixing = kechengLeixing;
		this.kechengO1 = kechengO1;
		this.kechengO2 = kechengO2;
		this.kechengO3 = kechengO3;
		this.kechengO4 = kechengO4;
		this.kechengO5 = kechengO5;
		this.kechengO6 = kechengO6;
		this.kechengO7 = kechengO7;
		this.kechengO8 = kechengO8;
		this.kechengO9 = kechengO9;
	}

	// Property accessors

	public Integer getKechengId()
	{
		return this.kechengId;
	}

	public void setKechengId(Integer kechengId)
	{
		this.kechengId = kechengId;
	}

	public String getKechengBianhao()
	{
		return this.kechengBianhao;
	}

	public void setKechengBianhao(String kechengBianhao)
	{
		this.kechengBianhao = kechengBianhao;
	}

	public String getKechengName()
	{
		return this.kechengName;
	}

	public void setKechengName(String kechengName)
	{
		this.kechengName = kechengName;
	}


	public String getKechengDel()
	{
		return kechengDel;
	}

	public void setKechengDel(String kechengDel)
	{
		this.kechengDel = kechengDel;
	}

	public String getKechengXueshi()
	{
		return this.kechengXueshi;
	}

	public void setKechengXueshi(String kechengXueshi)
	{
		this.kechengXueshi = kechengXueshi;
	}

	public Integer getKechengLeixing()
	{
		return this.kechengLeixing;
	}

	public void setKechengLeixing(Integer kechengLeixing)
	{
		this.kechengLeixing = kechengLeixing;
	}

	public String getKechengO1()
	{
		return this.kechengO1;
	}

	public void setKechengO1(String kechengO1)
	{
		this.kechengO1 = kechengO1;
	}

	public String getKechengO2()
	{
		return this.kechengO2;
	}

	public void setKechengO2(String kechengO2)
	{
		this.kechengO2 = kechengO2;
	}

	public String getKechengO3()
	{
		return this.kechengO3;
	}

	public void setKechengO3(String kechengO3)
	{
		this.kechengO3 = kechengO3;
	}

	public Integer getKechengO4()
	{
		return this.kechengO4;
	}

	public void setKechengO4(Integer kechengO4)
	{
		this.kechengO4 = kechengO4;
	}

	public Integer getKechengO5()
	{
		return this.kechengO5;
	}

	public void setKechengO5(Integer kechengO5)
	{
		this.kechengO5 = kechengO5;
	}

	public Date getKechengO6()
	{
		return this.kechengO6;
	}

	public void setKechengO6(Date kechengO6)
	{
		this.kechengO6 = kechengO6;
	}

	public Date getKechengO7()
	{
		return this.kechengO7;
	}

	public void setKechengO7(Date kechengO7)
	{
		this.kechengO7 = kechengO7;
	}

	public Long getKechengO8()
	{
		return this.kechengO8;
	}

	public void setKechengO8(Long kechengO8)
	{
		this.kechengO8 = kechengO8;
	}

	public Long getKechengO9()
	{
		return this.kechengO9;
	}

	public void setKechengO9(Long kechengO9)
	{
		this.kechengO9 = kechengO9;
	}
}