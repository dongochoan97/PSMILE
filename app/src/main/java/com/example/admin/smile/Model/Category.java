package com.example.admin.smile.Model;

public class Category {
    String title;
    String threadnew;
    String content;
    String date;

    public Category(String title, String threadnew, String content, String date) {
        this.title = title;
        this.threadnew = threadnew;
        this.content = content;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThreadnew() {
        return threadnew;
    }

    public void setThreadnew(String threadnew) {
        this.threadnew = threadnew;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
