package com.techprimers.cache.cache;

import com.techprimers.cache.model.Users;
import com.techprimers.cache.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UsersCache {

//    @Autowired
//    UsersRepository usersRepository;
//
//    @Cacheable(value = "usersCache")
//    //@Cacheable(value = "usersCache", key = "#name")
//    public Users getUser(String name) {
//    	try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println("Retrieving from Database for name: " + name);
//        return usersRepository.findByName(name);
//    }
}
