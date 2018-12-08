/**
 * 
 */
package com.gateranker.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.jpa.model.NamesOnly;
import com.gateranker.jpa.model.User;
/**
 * @author Sap Dharma Satyam
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserNameAndPassword (String userName, String password);
	
	public NamesOnly findByUserName(String userName); 

}
