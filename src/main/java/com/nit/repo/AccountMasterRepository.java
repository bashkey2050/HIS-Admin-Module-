package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.Entity.AccountMasterEntity;


public interface AccountMasterRepository extends JpaRepository<AccountMasterEntity, Integer> {

	@Query(value= "select acc_Id from AccountMasterEntity where acc_Id=:email;",nativeQuery=true)
	public Boolean CheckEmail(String email);
	


	public AccountMasterEntity findByUserPwd(String tempPwd);


}
