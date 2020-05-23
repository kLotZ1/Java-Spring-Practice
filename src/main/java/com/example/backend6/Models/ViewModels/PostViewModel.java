package com.example.backend6.Models.ViewModels;

import com.example.backend6.Models.PostCategories;

public class PostViewModel {

    private String Text;

    private String Title;

    private PostCategories postcategory;

    public PostCategories getPostcategory() {
        return postcategory;
    }

    public void setPostcategory(PostCategories postcategory) {
        this.postcategory = postcategory;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }



}
