package me.yong_ju.example_project_with_unit_of_work.domain.service;

import me.yong_ju.example_project_with_unit_of_work.domain.entity.User;
import me.yong_ju.example_project_with_unit_of_work.domain.repository.IUserRepository;

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
