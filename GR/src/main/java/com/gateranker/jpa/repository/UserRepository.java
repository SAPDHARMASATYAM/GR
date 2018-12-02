/**
 * 
 */
package com.gateranker.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.jpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserNameAndPassword (String userName, String password);

}