package com.cg.mediaplayervideos.service;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.cg.mediaplayervideos.entites.Videos;

public interface VideoService {
	
	public Videos uploadVideos(MultipartFile file, String videoName, int userId, String category  ) throws IOException;
	public long getViewCount(int videoId);
	public long incrementViewCount(int videoId);
	public String deleteVideos();  
	public String deleteVideoByUserId(int userId);	  
	public List<Videos> getAllVideos();  
	public List<Videos> getVideosById(int userId);  
	public List<Videos> searchByCategory(String category);
	Videos getVideoByVideoId(int videoId);
	Videos getVideoByVideoName(String videoName);
	byte[] downloadVideo(int videoId) throws IOException;
}