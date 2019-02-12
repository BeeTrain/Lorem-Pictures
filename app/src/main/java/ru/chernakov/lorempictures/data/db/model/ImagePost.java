package ru.chernakov.lorempictures.data.db.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

import ru.chernakov.lorempictures.data.db.AppDB;

@Table(database = AppDB.class, name = ImagePost.TABLE_NAME)
public class ImagePost extends BaseModel {
	public static final String TABLE_NAME = "image_posts";

	@PrimaryKey
	@Unique
	@Column(name = "id")
	private int id;

	@Column(name = "filename")
	private String filename;

	@Column(name = "format")
	private String format;

	@Column(name = "width")
	private int width;

	@Column(name = "height")
	private int height;

	@Column(name = "author")
	private String author;

	@Column(name = "authorUrl")
	private String authorUrl;

	@Column(name = "postUrl")
	private String postUrl;

	public ImagePost() {

	}

	public ImagePost(int id, String filename, String format,
					 int width, int height, String author, String authorUrl, String postUrl) {
		this.id = id;
		this.filename = filename;
		this.format = format;
		this.width = width;
		this.height = height;
		this.author = author;
		this.authorUrl = authorUrl;
		this.postUrl = postUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorUrl() {
		return authorUrl;
	}

	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}
}
