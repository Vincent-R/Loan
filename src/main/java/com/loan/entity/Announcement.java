package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_announcement")
public class Announcement {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "release_time")
    private String release_time;

    @Basic
    @Column(name = "image_url")
    private String image_url;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "attachment_url")
    private String attachment_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachment_url() {
        return attachment_url;
    }

    public void setAttachment_url(String attachment_url) {
        this.attachment_url = attachment_url;
    }
}
