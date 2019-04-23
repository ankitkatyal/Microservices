package com.restful.websevices.RestfulImplementation.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> userList = new ArrayList<User>();
	
	private static int userCount = 3;
	
	static {
		userList.add(new User(1,"Sam",new Date()));
		userList.add(new User(2,"Biling",new Date()));
		userList.add(new User(3,"Broad",new Date()));
		
	}

	public List<User> findAll(){
		return userList;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
			
		}
		userList.add(user);
		return user;
	}
	
	public User findOne(Integer userId) {
		for(User user:userList) {
			if(user.getId()==userId) {
				return user;
			}
		}
		return null;
	}
	
}
