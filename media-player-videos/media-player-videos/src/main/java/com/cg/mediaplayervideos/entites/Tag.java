package com.cg.mediaplayervideos.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
	
	private int tagId;
	private String name;
	private int desId;
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDesId() {
		return desId;
	}
	public void setDesId(int desId) {
		this.desId = desId;
	}

}
