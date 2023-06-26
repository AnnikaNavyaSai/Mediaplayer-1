package com.cg.MediaPlayerApplication.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Description")
@Data
@AllArgsConstructor

@Getter
@Setter
public class Description {
	
	@Id
	@GeneratedValue
	private int desId;
	private String title;
	private String language;
	private String description;
	private int videoId;
	
	@Transient
	private List<Tag> tag;
	
	public Description(String title, String description) {
		this.title=title;
		this.description=description;
	}
	public Description(int desId, String title, String language, String description) {
	this.title=title;
	this.language=language;
	this.description=description;
	this.desId=desId;
	}
	
	public Description(){
		
	}

	public int getDesId() {
		return desId;
	}
	public void setDesId(int desId) {
		this.desId = desId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public List<Tag> getTag() {
		return tag;
	}
	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}
	
	
}