package com.model;

import java.util.Date;

public class TXibie implements java.io.Serializable {
	private Integer xibieId;
	private String xibieBianhao;
	private String xibieName;
	private String xibieJianjie;
	private String xibieDel;
	private Integer xuyuanId;
	private String xibieOne1;
	private String xibieOne2;
	private String xibieOne3;
	private String xibieOne4;
	private Integer xibieOne5;
	private Integer xibieOne6;
	private Date xibieOne7;
	private Date xibieOne8;

	// Constructors

	/** default constructor */
	public TXibie() {}

	/** full constructor */
	public TXibie(String xibieBianhao, String xibieName, String xibieJianjie,
			String xibieDel, Integer xibieXuyuanId, String xibieOne1,
			String xibieOne2, String xibieOne3, String xibieOne4,
			Integer xibieOne5, Integer xibieOne6, Date xibieOne7, Date xibieOne8) {
		this.xibieBianhao = xibieBianhao;
		this.xibieName = xibieName;
		this.xibieJianjie = xibieJianjie;
		this.xibieDel = xibieDel;
		this.xibieOne1 = xibieOne1;
		this.xibieOne2 = xibieOne2;
		this.xibieOne3 = xibieOne3;
		this.xibieOne4 = xibieOne4;
		this.xibieOne5 = xibieOne5;
		this.xibieOne6 = xibieOne6;
		this.xibieOne7 = xibieOne7;
		this.xibieOne8 = xibieOne8;
	}

	// Property accessors

	public Integer getXibieId()
	{
		return this.xibieId;
	}

	public void setXibieId(Integer xibieId)
	{
		this.xibieId = xibieId;
	}

	public String getXibieBianhao()
	{
		return this.xibieBianhao;
	}

	public void setXibieBianhao(String xibieBianhao)
	{
		this.xibieBianhao = xibieBianhao;
	}

	public String getXibieName()
	{
		return this.xibieName;
	}

	public void setXibieName(String xibieName)
	{
		this.xibieName = xibieName;
	}

	public String getXibieJianjie()
	{
		return this.xibieJianjie;
	}

	public void setXibieJianjie(String xibieJianjie)
	{
		this.xibieJianjie = xibieJianjie;
	}

	public String getXibieDel()
	{
		return this.xibieDel;
	}

	public void setXibieDel(String xibieDel)
	{
		this.xibieDel = xibieDel;
	}

	public Integer getXuyuanId()
	{
		return xuyuanId;
	}

	public void setXuyuanId(Integer xuyuanId)
	{
		this.xuyuanId = xuyuanId;
	}

	public String getXibieOne1()
	{
		return this.xibieOne1;
	}

	public void setXibieOne1(String xibieOne1)
	{
		this.xibieOne1 = xibieOne1;
	}

	public String getXibieOne2()
	{
		return this.xibieOne2;
	}

	public void setXibieOne2(String xibieOne2)
	{
		this.xibieOne2 = xibieOne2;
	}

	public String getXibieOne3()
	{
		return this.xibieOne3;
	}

	public void setXibieOne3(String xibieOne3)
	{
		this.xibieOne3 = xibieOne3;
	}

	public String getXibieOne4()
	{
		return this.xibieOne4;
	}

	public void setXibieOne4(String xibieOne4)
	{
		this.xibieOne4 = xibieOne4;
	}

	public Integer getXibieOne5()
	{
		return this.xibieOne5;
	}

	public void setXibieOne5(Integer xibieOne5)
	{
		this.xibieOne5 = xibieOne5;
	}

	public Integer getXibieOne6()
	{
		return this.xibieOne6;
	}

	public void setXibieOne6(Integer xibieOne6)
	{
		this.xibieOne6 = xibieOne6;
	}

	public Date getXibieOne7()
	{
		return this.xibieOne7;
	}

	public void setXibieOne7(Date xibieOne7)
	{
		this.xibieOne7 = xibieOne7;
	}

	public Date getXibieOne8()
	{
		return this.xibieOne8;
	}

	public void setXibieOne8(Date xibieOne8)
	{
		this.xibieOne8 = xibieOne8;
	}

}