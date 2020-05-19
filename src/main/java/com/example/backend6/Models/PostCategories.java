package com.example.backend6.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PostCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String Name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postcategories")
    private Set<Post> Posts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public Set<Post> getPosts() {
        return Posts;
    }

    public void setPosts(Set<Post> posts) {
        Posts = posts;
    }
}


