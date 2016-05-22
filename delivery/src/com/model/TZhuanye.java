package com.model;

import java.util.Date;

public class TZhuanye implements java.io.Serializable
{
	private Integer zhuanyeId;
	private String zhuanyeBianhao;
	private String zhuanyeName;
	private String zhuanyeJieshao;
	private String zhuanyeDel;
	private Integer xibieId;
	private Integer xuyuanId;
	private String zhuanyeOne1;
	private String zhuanyeOne2;
	private String zhuanyeOne3;
	private String zhuanyeOne4;
	private Integer zhuanyeOne5;
	private Integer zhuanyeOne6;
	private Date zhuanyeOne7;
	private Date zhuanyeOne8;

	// Constructors

	/** default constructor */
	public TZhuanye() {}

	/** full constructor */
	public TZhuanye(String zhuanyeBianhao, String zhuanyeName,
			String zhuanyeDel, Integer xibieId, Integer xuyuanId,
			String zhuanyeOne1, String zhuanyeOne2, String zhuanyeOne3,
			String zhuanyeOne4, Integer zhuanyeOne5, Integer zhuanyeOne6,
			Date zhuanyeOne7, Date zhuanyeOne8) {
		this.zhuanyeBianhao = zhuanyeBianhao;
		this.zhuanyeName = zhuanyeName;
		this.zhuanyeDel = zhuanyeDel;
		this.xibieId = xibieId;
		this.xuyuanId = xuyuanId;
		this.zhuanyeOne1 = zhuanyeOne1;
		this.zhuanyeOne2 = zhuanyeOne2;
		this.zhuanyeOne3 = zhuanyeOne3;
		this.zhuanyeOne4 = zhuanyeOne4;
		this.zhuanyeOne5 = zhuanyeOne5;
		this.zhuanyeOne6 = zhuanyeOne6;
		this.zhuanyeOne7 = zhuanyeOne7;
		this.zhuanyeOne8 = zhuanyeOne8;
	}

	// Property accessors

	public Integer getZhuanyeId()
	{
		return this.zhuanyeId;
	}

	public String getZhuanyeJieshao()
	{
		return zhuanyeJieshao;
	}

	public void setZhuanyeJieshao(String zhuanyeJieshao)
	{
		this.zhuanyeJieshao = zhuanyeJieshao;
	}

	public void setZhuanyeId(Integer zhuanyeId)
	{
		this.zhuanyeId = zhuanyeId;
	}

	public String getZhuanyeBianhao()
	{
		return this.zhuanyeBianhao;
	}

	public void setZhuanyeBianhao(String zhuanyeBianhao)
	{
		this.zhuanyeBianhao = zhuanyeBianhao;
	}

	public String getZhuanyeName()
	{
		return this.zhuanyeName;
	}

	public void setZhuanyeName(String zhuanyeName)
	{
		this.zhuanyeName = zhuanyeName;
	}

	public String getZhuanyeDel()
	{
		return this.zhuanyeDel;
	}

	public void setZhuanyeDel(String zhuanyeDel)
	{
		this.zhuanyeDel = zhuanyeDel;
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

	public String getZhuanyeOne1()
	{
		return this.zhuanyeOne1;
	}

	public void setZhuanyeOne1(String zhuanyeOne1)
	{
		this.zhuanyeOne1 = zhuanyeOne1;
	}

	public String getZhuanyeOne2()
	{
		return this.zhuanyeOne2;
	}

	public void setZhuanyeOne2(String zhuanyeOne2)
	{
		this.zhuanyeOne2 = zhuanyeOne2;
	}

	public String getZhuanyeOne3()
	{
		return this.zhuanyeOne3;
	}

	public void setZhuanyeOne3(String zhuanyeOne3)
	{
		this.zhuanyeOne3 = zhuanyeOne3;
	}

	public String getZhuanyeOne4()
	{
		return this.zhuanyeOne4;
	}

	public void setZhuanyeOne4(String zhuanyeOne4)
	{
		this.zhuanyeOne4 = zhuanyeOne4;
	}

	public Integer getZhuanyeOne5()
	{
		return this.zhuanyeOne5;
	}

	public void setZhuanyeOne5(Integer zhuanyeOne5)
	{
		this.zhuanyeOne5 = zhuanyeOne5;
	}

	public Integer getZhuanyeOne6()
	{
		return this.zhuanyeOne6;
	}

	public void setZhuanyeOne6(Integer zhuanyeOne6)
	{
		this.zhuanyeOne6 = zhuanyeOne6;
	}

	public Date getZhuanyeOne7()
	{
		return this.zhuanyeOne7;
	}

	public void setZhuanyeOne7(Date zhuanyeOne7)
	{
		this.zhuanyeOne7 = zhuanyeOne7;
	}

	public Date getZhuanyeOne8()
	{
		return this.zhuanyeOne8;
	}

	public void setZhuanyeOne8(Date zhuanyeOne8)
	{
		this.zhuanyeOne8 = zhuanyeOne8;
	}

}