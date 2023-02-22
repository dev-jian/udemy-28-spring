package me.devjian.learnspringboot;

public class Course {
	
	private int id;
	
	private String subject;
	
	private String author;
	
	public Course(int i, String subject, String author) {
		super();
		this.id = i;
		this.subject = subject;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", subject=" + subject + ", author=" + author + "]";
	}
	
}
