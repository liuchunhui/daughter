package com.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

/**
 * 公告
 * Created by huihui on 16-6-5.
 */
@Entity
@Table(name = "annunciate")
public class Annunciate {

    /**
     * 主键
     */
    @Id @Column(name = "annunciate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公告标题
     */
    @Column(nullable = false)
    private String title;

    /**
     * 公告内容
     */
    @Column(nullable = false)
    private String content;

    /**
     * 公告创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    // contructor
    public Annunciate () {}
    public Annunciate(String title,
                      String content,
                      String creator,
                      Date createTime,
                      Date updateTime) {
        this.title = title;
        this.content = content;
        this.creator = creator;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString () {
        return "id: " + id + " title: " + title + " content: " + content + " creator: " + creator;
    }

    // get /set 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
