package com.lwl.activemq.domain;

import java.io.Serializable;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String title;
	
	private String content;
	
	private String url;
	
	private String author;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", url=" + url + ", author=" + author + "]";
	}
	
}
