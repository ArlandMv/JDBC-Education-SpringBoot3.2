package com.mvprojects.SpringJDBC.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Idea {
    private int ideaId;
    private String title;
    private String how;
    private String why;
    private String category;

    public Idea() {
    }

    public Idea(String title, String how, String why, String category) {
        this.title = title;
        this.how = how;
        this.why = why;
        this.category = category;
    }

    public int getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(int ideaId) {
        this.ideaId = ideaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Idea{" +
                "ideaId=" + ideaId +
                ", title='" + title + '\'' +
                ", how='" + how + '\'' +
                ", why='" + why + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

