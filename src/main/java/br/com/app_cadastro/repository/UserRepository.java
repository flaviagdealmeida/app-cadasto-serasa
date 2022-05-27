package br.com.app_cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.app_cadastro.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//JPQL
	@Query("SELECT u FROM User u WHERE u.userName =: userName")
	User findByUserName(@Param("userName") String userName);
}
