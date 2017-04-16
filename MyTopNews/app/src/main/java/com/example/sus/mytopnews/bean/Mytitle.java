package com.example.sus.mytopnews.bean;

/**
 * Created by sus on 2017/4/12.
 */

public class Mytitle {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Mytitle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    private String uri;

}
