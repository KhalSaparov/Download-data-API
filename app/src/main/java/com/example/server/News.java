package com.example.server;

import java.util.ArrayList;

public class News {
    String status;
    int totalResults;
    ArrayList<Post> articles;
    public News() {
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public ArrayList<Post> getArticles() {
        return articles;
    }
}

class Post {
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;
    String content;
    Source source;

    public Post() {
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public Source getSource() {
        return source;
    }
}

class Source {
    String id;
    String name;

    public Source() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
