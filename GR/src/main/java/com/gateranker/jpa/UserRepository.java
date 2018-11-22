/**
 * 
 */
package com.gateranker.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gateranker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByEmailIdAndPasswordAndIsUserActive (String emailId, String password, Boolean active);

	public List<User> findAllByIsUserActive(Boolean active);
//	
//	 @Modifying
//	 @Query("update user set password = :password where emailId = :emailId and active = true")
//	 int updatePasswordByEmailId(@Param("password") String password, @Param("emailId") String emailId);

}
