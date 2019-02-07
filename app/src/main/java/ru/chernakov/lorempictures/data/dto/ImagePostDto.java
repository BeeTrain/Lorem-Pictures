package ru.chernakov.lorempictures.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ImagePostDto implements Parcelable {

	@SerializedName("id")
	private int id;

	@SerializedName("filename")
	private String filename;

	@SerializedName("format")
	private String format;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	@SerializedName("author")
	private String author;

	@SerializedName("author_url")
	private String author_url;

	@SerializedName("post_url")
	private String post_url;

	protected ImagePostDto(Parcel in) {
		id = in.readInt();
		filename = in.readString();
		format = in.readString();
		width = in.readInt();
		height = in.readInt();
		author = in.readString();
		author_url = in.readString();
		post_url = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(filename);
		dest.writeString(format);
		dest.writeInt(width);
		dest.writeInt(height);
		dest.writeString(author);
		dest.writeString(author_url);
		dest.writeString(post_url);
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<ImagePostDto> CREATOR = new Parcelable.Creator<ImagePostDto>() {
		@Override
		public ImagePostDto createFromParcel(Parcel in) {
			return new ImagePostDto(in);
		}

		@Override
		public ImagePostDto[] newArray(int size) {
			return new ImagePostDto[size];
		}
	};
}
