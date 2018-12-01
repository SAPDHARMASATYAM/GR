/**
 * 
 */
package com.gateranker.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gateranker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserNameAndPassword (String userName, String password);

	public List<User> findAllByIsUserActive(Boolean active);

}
