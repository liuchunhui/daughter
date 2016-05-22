package com.model;

import java.util.Date;

public class TBanji implements java.io.Serializable
{
	private Integer banjiId;
	private String banjiBianhao;
	private String banjiName;
	private String banjiRuxuenianfen;
	private Integer zhuanyeId;
	private Integer xibieId;
	private Integer xuyuanId;
	private String banjiDel;
	private String banjiOne1;
	private String banjiOne2;
	private String banjiOne3;
	private String banjiOne4;
	private Date banjiOne5;
	private Date banjiOne6;
	private Integer banjiOne7;
	private Integer banjiOne8;
	// Constructors

	/** default constructor */
	public TBanji()
	{
	}

	/** full constructor */
	public TBanji(String banjiBianhao, String banjiName,
			String banjiRuxuenianfen, Integer zhuanyeId, Integer xibieId,
			Integer xuyuanId, String banjiDel, String banjiOne1,
			String banjiOne2, String banjiOne3, String banjiOne4,
			Date banjiOne5, Date banjiOne6, Integer banjiOne7, Integer banjiOne8)
	{
		this.banjiBianhao = banjiBianhao;
		this.banjiName = banjiName;
		this.banjiRuxuenianfen = banjiRuxuenianfen;
		this.zhuanyeId = zhuanyeId;
		this.xibieId = xibieId;
		this.xuyuanId = xuyuanId;
		this.banjiDel = banjiDel;
		this.banjiOne1 = banjiOne1;
		this.banjiOne2 = banjiOne2;
		this.banjiOne3 = banjiOne3;
		this.banjiOne4 = banjiOne4;
		this.banjiOne5 = banjiOne5;
		this.banjiOne6 = banjiOne6;
		this.banjiOne7 = banjiOne7;
		this.banjiOne8 = banjiOne8;
	}

	// Property accessors

	public Integer getBanjiId()
	{
		return this.banjiId;
	}

	public void setBanjiId(Integer banjiId)
	{
		this.banjiId = banjiId;
	}

	public String getBanjiBianhao()
	{
		return this.banjiBianhao;
	}

	public void setBanjiBianhao(String banjiBianhao)
	{
		this.banjiBianhao = banjiBianhao;
	}

	public String getBanjiName()
	{
		return this.banjiName;
	}

	public void setBanjiName(String banjiName)
	{
		this.banjiName = banjiName;
	}

	public String getBanjiRuxuenianfen()
	{
		return this.banjiRuxuenianfen;
	}

	public void setBanjiRuxuenianfen(String banjiRuxuenianfen)
	{
		this.banjiRuxuenianfen = banjiRuxuenianfen;
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

	public String getBanjiDel()
	{
		return this.banjiDel;
	}

	public void setBanjiDel(String banjiDel)
	{
		this.banjiDel = banjiDel;
	}

	public String getBanjiOne1()
	{
		return this.banjiOne1;
	}

	public void setBanjiOne1(String banjiOne1)
	{
		this.banjiOne1 = banjiOne1;
	}

	public String getBanjiOne2()
	{
		return this.banjiOne2;
	}

	public void setBanjiOne2(String banjiOne2)
	{
		this.banjiOne2 = banjiOne2;
	}

	public String getBanjiOne3()
	{
		return this.banjiOne3;
	}

	public void setBanjiOne3(String banjiOne3)
	{
		this.banjiOne3 = banjiOne3;
	}

	public String getBanjiOne4()
	{
		return this.banjiOne4;
	}

	public void setBanjiOne4(String banjiOne4)
	{
		this.banjiOne4 = banjiOne4;
	}

	public Date getBanjiOne5()
	{
		return this.banjiOne5;
	}

	public void setBanjiOne5(Date banjiOne5)
	{
		this.banjiOne5 = banjiOne5;
	}

	public Date getBanjiOne6()
	{
		return this.banjiOne6;
	}

	public void setBanjiOne6(Date banjiOne6)
	{
		this.banjiOne6 = banjiOne6;
	}

	public Integer getBanjiOne7()
	{
		return this.banjiOne7;
	}

	public void setBanjiOne7(Integer banjiOne7)
	{
		this.banjiOne7 = banjiOne7;
	}

	public Integer getBanjiOne8()
	{
		return this.banjiOne8;
	}

	public void setBanjiOne8(Integer banjiOne8)
	{
		this.banjiOne8 = banjiOne8;
	}
}