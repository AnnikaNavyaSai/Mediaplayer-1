package com.mediaplayer.controller;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediaplayer.entity.Comment;
import com.mediaplayer.service.CommentService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService service;
	Logger logger = LoggerFactory.getLogger(CommentController.class);

	@PostMapping("/{userId}/{videoId}")
	public Comment addcomment(@RequestBody Comment c,@PathVariable("userId") int userId,@PathVariable("videoId") int videoId) {

		Comment comment = service.addnewComment(c,userId, videoId);
		return comment;
	}

	@GetMapping("/video/{videoId}")
	public List<Comment> listAllComments(@PathVariable("videoId") int videoId) {
		logger.info("{} for get", videoId);
		return service.allComments(videoId);
	}

	@DeleteMapping("/{commentId}/delete")
	public String deleteComment(@PathVariable("commentId") int commentId) {
		logger.info("{} for delete", commentId);
		return service.deleteComment(commentId);
	}

	@GetMapping("/favicon.ico")
	public void handleFaviconRequest(HttpServletResponse response) throws IOException {
		// Set the status of the response to 204 (No Content)
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
	@GetMapping("/{userId}/users")
	public List<Comment> getByUserId(@PathVariable("userId") int userId)
	{
		return service.getByUserId(userId);
	}
	}