package com.gopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gopi.entity.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role , Long>{

	@Transactional(timeout=10)
	void deleteByRoleid(Long l);
	
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	default <S extends Role> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
}


