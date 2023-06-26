package com.cg.MediaPlayerApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
	
	private int tagId;
	private String tagName;
	private int desId;
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String name) {
		this.tagName = name;
	}
	public int getDesId() {
		return desId;
	}
	public void setDesId(int desId) {
		this.desId = desId;
	}
	
	
}
