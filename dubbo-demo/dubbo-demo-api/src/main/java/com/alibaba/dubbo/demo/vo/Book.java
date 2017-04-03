package com.alibaba.dubbo.demo.vo;

import java.util.ArrayList;

public class Book extends BasicVo {
    private static final long serialVersionUID = 1L;

    private Long bookId;
    private String title;
    private Double price;
    private java.sql.Date publishTime;
    private byte[] blobContent;
    private String textContent;

    private ArrayList<Book> aList;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public java.sql.Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(java.sql.Date publishTime) {
        this.publishTime = publishTime;
    }

    public byte[] getBlobContent() {
        return blobContent;
    }

    public void setBlobContent(byte[] blobContent) {
        this.blobContent = blobContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public ArrayList<Book> getaList() {
        return aList;
    }

    public void setaList(ArrayList<Book> aList) {
        this.aList = aList;
    }
}

/*List columns as follows:
"book_id", "title", "price", "publish_time", "blob_content", "text_content"
*/