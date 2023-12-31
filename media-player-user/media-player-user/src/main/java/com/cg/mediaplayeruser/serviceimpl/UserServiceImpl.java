package com.cg.mediaplayeruser.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.mediaplayeruser.entites.Users;
import com.cg.mediaplayeruser.entites.Videos;
import com.cg.mediaplayeruser.exception.UserAlreadyExistException;
import com.cg.mediaplayeruser.exception.UserNotFoundException;
import com.cg.mediaplayeruser.repository.UserRepositroy;
import com.cg.mediaplayeruser.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositroy userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(Users.class);
	
	@Override
	public Users addUser(Users user) throws UserAlreadyExistException {
		 if (userRepository.existsByEmail(user.getEmail())) {
		        throw new UserAlreadyExistException("User Already Exists");
		    }
		Users u = userRepository.save(user);
		return u;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> findAll = userRepository.findAll();
		for(Users user : findAll)
		{
			
		@SuppressWarnings("unchecked")
		List<Videos> videos = restTemplate.getForObject("http://VIDEO-SERVICE/videos/getvideo/"+user.getUserId(), List.class);
		logger.info("{}",videos);
		user.setVideos(videos);
		}
		return findAll;	 
	}

	@Override
	public Users getUserById(int userId) {
	 Users users = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Not Found"));
	 @SuppressWarnings("unchecked")
	List<Videos> userVideos = restTemplate.getForObject("http://VIDEO-SERVICE/videos/getvideo/"+users.getUserId(), List.class);
	 logger.info("{}", userVideos);
	 users.setVideos(userVideos);
	 return users;
	}

	@Override
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "all users are deleted";
	}

	@Override
	public String deleteByUserId(int userId) {
		logger.info("deleting resource.....");
		userRepository.deleteById(userId);
		logger.info("deleting is successful");
		 return "user details is deleted with the userId : " +userId;
	}	
}