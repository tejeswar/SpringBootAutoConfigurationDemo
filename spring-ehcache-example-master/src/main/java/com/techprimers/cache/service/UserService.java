package com.techprimers.cache.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.techprimers.cache.model.Users;
import com.techprimers.cache.repository.UsersRepository;



@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAllUsers(){
		 Iterable<Users> iterable = usersRepository.findAll();
		
		List<Users> allUsers  = StreamSupport
		.stream(iterable.spliterator(), false)
		.collect(Collectors.toList());
		//System.out.println(allEmps);
		return allUsers;
	}
	
	public void insertDummyUsers() {
		 List<Users> usersList = new ArrayList<>();
	        usersList.add(new Users("Ajay", "Tech",123L));
	        usersList.add(new Users("Jaga", "HR",13L));
	        usersList.add(new Users("Balia", "Support",123L));
	        usersList.add(new Users("Hari", "Admin",13L));
	        usersRepository.saveAll(usersList);
	        
	}
	
	public void updateUser(Users user) {
		Optional<Users> optionalUser = usersRepository.findById(user.getId());
		Users singleUser = optionalUser.get();
		singleUser.setName(user.getName());
		singleUser.setSalary(user.getSalary());
		singleUser.setTeamName(user.getTeamName());
		
		usersRepository.save(singleUser);
	}
	
	 @Cacheable(value = "usersCache")
	    //@Cacheable(value = "usersCache", key = "#name")
	    public Users getUser(String name) {
	    	try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Retrieving from Database for name: " + name);
	        return usersRepository.findByName(name);
	    }
	
}
