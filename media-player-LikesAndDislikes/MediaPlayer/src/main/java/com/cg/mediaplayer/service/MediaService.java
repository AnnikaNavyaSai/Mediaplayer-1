package com.cg.mediaplayer.service;

import com.cg.mediaplayer.entites.Media;

public interface MediaService {

	public void addLike(Media media);

	public void addDislike(Media media);
	public void removeLike(int videoId);
	public void removeDislike(int videoId);

	public int getTotalLikes(int videoId);
	 
	public int getTotalDislikes(int videoId);
}

