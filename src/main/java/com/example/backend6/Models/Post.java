package com.example.backend6.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String Title;

    private String Text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postcategories_id")
    private PostCategories postcategories;

    private Date Created;

    private Date Modified;

    public void setText(String text) {
        Text = text;
    }

    public Date getModified() {
        return Modified;
    }

    public void setModified(Date modified) {
        Modified = modified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public String getText() {
        return Text;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }


    public PostCategories getPostcategories() { return postcategories; }

    public void setPostcategories(PostCategories postcategories) { this.postcategories = postcategories; }
}
