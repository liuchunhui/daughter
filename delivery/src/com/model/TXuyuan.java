package com.model;

import java.util.Date;

public class TXuyuan implements java.io.Serializable
{
	private Integer xuyuanId;
	private String xuyuanBianhao;
	private String xuyuanName;
	private String xuyuanJianjie;
	private String xuyuanDel;
	private String xuyuanOne1;
	private String xuyuanOne2;
	private String xuyuanOne3;
	private String xuyuanOne4;
	private Integer xuyuanOne5;
	private Integer xuyuanOne6;
	private Date xuyuanOne7;
	private Date xuyuanOne8;

	// Constructors

	/** default constructor */
	public TXuyuan() {}

	/** full constructor */
	public TXuyuan(String xuyuanBianhao, String xuyuanName,
			String xuyuanJianjie, String xuyuanDel, String xuyuanOne1,
			String xuyuanOne2, String xuyuanOne3, String xuyuanOne4,
			Integer xuyuanOne5, Integer xuyuanOne6, Date xuyuanOne7,
			Date xuyuanOne8) {
		this.xuyuanBianhao = xuyuanBianhao;
		this.xuyuanName = xuyuanName;
		this.xuyuanJianjie = xuyuanJianjie;
		this.xuyuanDel = xuyuanDel;
		this.xuyuanOne1 = xuyuanOne1;
		this.xuyuanOne2 = xuyuanOne2;
		this.xuyuanOne3 = xuyuanOne3;
		this.xuyuanOne4 = xuyuanOne4;
		this.xuyuanOne5 = xuyuanOne5;
		this.xuyuanOne6 = xuyuanOne6;
		this.xuyuanOne7 = xuyuanOne7;
		this.xuyuanOne8 = xuyuanOne8;
	}

	// Property accessors

	public Integer getXuyuanId()
	{
		return this.xuyuanId;
	}

	public void setXuyuanId(Integer xuyuanId)
	{
		this.xuyuanId = xuyuanId;
	}

	public String getXuyuanBianhao()
	{
		return this.xuyuanBianhao;
	}

	public void setXuyuanBianhao(String xuyuanBianhao)
	{
		this.xuyuanBianhao = xuyuanBianhao;
	}

	public String getXuyuanName()
	{
		return this.xuyuanName;
	}

	public void setXuyuanName(String xuyuanName)
	{
		this.xuyuanName = xuyuanName;
	}

	public String getXuyuanJianjie()
	{
		return this.xuyuanJianjie;
	}

	public void setXuyuanJianjie(String xuyuanJianjie)
	{
		this.xuyuanJianjie = xuyuanJianjie;
	}

	public String getXuyuanDel()
	{
		return this.xuyuanDel;
	}

	public void setXuyuanDel(String xuyuanDel)
	{
		this.xuyuanDel = xuyuanDel;
	}

	public String getXuyuanOne1()
	{
		return this.xuyuanOne1;
	}

	public void setXuyuanOne1(String xuyuanOne1)
	{
		this.xuyuanOne1 = xuyuanOne1;
	}

	public String getXuyuanOne2()
	{
		return this.xuyuanOne2;
	}

	public void setXuyuanOne2(String xuyuanOne2)
	{
		this.xuyuanOne2 = xuyuanOne2;
	}

	public String getXuyuanOne3()
	{
		return this.xuyuanOne3;
	}

	public void setXuyuanOne3(String xuyuanOne3)
	{
		this.xuyuanOne3 = xuyuanOne3;
	}

	public String getXuyuanOne4()
	{
		return this.xuyuanOne4;
	}

	public void setXuyuanOne4(String xuyuanOne4)
	{
		this.xuyuanOne4 = xuyuanOne4;
	}

	public Integer getXuyuanOne5()
	{
		return this.xuyuanOne5;
	}

	public void setXuyuanOne5(Integer xuyuanOne5)
	{
		this.xuyuanOne5 = xuyuanOne5;
	}

	public Integer getXuyuanOne6()
	{
		return this.xuyuanOne6;
	}

	public void setXuyuanOne6(Integer xuyuanOne6)
	{
		this.xuyuanOne6 = xuyuanOne6;
	}

	public Date getXuyuanOne7()
	{
		return this.xuyuanOne7;
	}

	public void setXuyuanOne7(Date xuyuanOne7)
	{
		this.xuyuanOne7 = xuyuanOne7;
	}

	public Date getXuyuanOne8()
	{
		return this.xuyuanOne8;
	}

	public void setXuyuanOne8(Date xuyuanOne8)
	{
		this.xuyuanOne8 = xuyuanOne8;
	}

}