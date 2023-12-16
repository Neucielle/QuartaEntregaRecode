package com.agenciadeviagens.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agenciadeviagens.models.User;

import jakarta.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Transactional
	@Modifying
	@Query(nativeQuery= true, value= "INSERT INTO user_travel (user_id, travel_id) VALUES (:userId, :travelId)")
	void addRelationship(@Param("userId") Long userId, @Param("travelId") Long travelId);
	
	
	
	@Query(nativeQuery= true, 
			value = "SELECT DISTINCT c.user_name, s.travel_name "
			+ " FROM user_travel as usr"
			+ " INNER JOIN user as c"
			+ " ON c.id = usr.user_id"
			+ " INNER JOIN travel as s"
			+ " ON s.id = usr.travel_id"
			)
	List<Object> findAllRels();
	
}
