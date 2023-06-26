package com.cg.mediaplayer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mediaplayer.entites.Media;
import com.cg.mediaplayer.service.MediaService;

@RestController
@RequestMapping("/media")
public class MediaController {
	@Autowired
    private MediaService mediaService;  
    @PostMapping("/like")
    public void addLike(@RequestBody Media media) {
        mediaService.addLike(media);
    }
    @GetMapping("/like/{id}")
    public int getTotalLikes(@PathVariable("id") int videoId) {
        int likesCount = mediaService.getTotalLikes(videoId);
        
        return likesCount;
    }
    @GetMapping("/dislike/{id}")
    public int getTotalDislikes(@PathVariable("id") int videoId) {
        int dislikesCount = mediaService.getTotalDislikes(videoId);
        
        return dislikesCount;
    }
	
    
    @PostMapping("/dislike")
    public void addDislike(@RequestBody Media media) {
        mediaService.addDislike(media);
    }

@DeleteMapping("/{id}/like")
public void removeLike(@PathVariable("id") int videoId) {
    mediaService.removeLike(videoId);
}
@DeleteMapping("/{id}/dislike")
public void removeDislike(@PathVariable("id") int videoId) {
    mediaService.removeDislike(videoId);
}
}

