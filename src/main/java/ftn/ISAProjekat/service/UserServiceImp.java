package ftn.ISAProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.ISAProjekat.model.Role;
import ftn.ISAProjekat.model.User;
import ftn.ISAProjekat.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(String email, String password) {
		
		User user = userRepository.findByEmail(email);
		
		if(user != null) {
			
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
    public User create(User user) throws Exception {
       
		user.setRole(Role.valueOf("CUSTOMER"));  
        User savedUser = userRepository.save(user);
        return savedUser;
    }

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
