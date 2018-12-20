package org.linlinjava.litemall.core.rabbit.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 短消息对象
 * @author: xiaohoo
 * @date: 2018/12/19 17:09
 * @email: 1126457667@qq.com
 */
public class ShortMessage implements Serializable {
    private String title;   // 标题
    private String content; // 内容
    private String author;  // 作者
    private Date date;  // 日期

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
