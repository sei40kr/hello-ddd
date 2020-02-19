package me.yong_ju.hello_ddd.domain.service;

import me.yong_ju.hello_ddd.domain.entity.User;
import me.yong_ju.hello_ddd.domain.repository.IUserRepository;

public class UserService {
	private final IUserRepository userRepository;

	public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
	}

    public boolean exists(User anUser) {
        // TODO implement this
        return false;
    }
}
