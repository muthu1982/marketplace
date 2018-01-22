package com.marketplace.repo;

import org.springframework.data.repository.CrudRepository;

import com.marketplace.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity,Integer>{

	public UserEntity getUserByEmailId(String emailId);
}
