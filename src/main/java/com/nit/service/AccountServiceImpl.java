package com.nit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.Entity.AccountMasterEntity;
import com.nit.constants.AppConstants;
import com.nit.model.AccountRequest;
import com.nit.repo.AccountMasterRepository;
import com.nit.util.EmailUtils;
import com.nit.util.PwdUtils;



@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMasterRepository accRepo;
	@Autowired
	private EmailUtils emailUtils;

	/*@Override
	public Integer SaveAccount(AccountRequest req) {
		AccountMasterEntity acc = new AccountMasterEntity();
		BeanUtils.copyProperties(req, acc);
		
          AccountMasterEntity entity=accRepo.save(acc);
          if(entity!=null) {
		
		return entity.getAcc_Id();
	}
		return null;

}*/

	@Override
	public boolean saveUserAcc(AccountRequest req) {
		req.setUserPwd(PwdUtils.generateTempPwd(AppConstants.TEMP_PWD_LENGTH));
		req.setAccStatus(AppConstants.LOCKED_STR);
		
		AccountMasterEntity entity = new AccountMasterEntity();
		BeanUtils.copyProperties(req, entity);
		AccountMasterEntity savedEntity = accRepo.save(entity);
		
		if(savedEntity.getAcc_Id() != null) {
			
			return emailUtils.sendUserAccUnlockEmail(req);
			
		}
		return false;
	
	}

	@Override
	public AccountRequest getUserAccByTempPwd(String tempPwd) {
 
		AccountMasterEntity entity = accRepo.findByUserPwd(tempPwd);
			
		AccountRequest acc=null;
			
			if (entity != null) {
				acc = new AccountRequest();
				
				BeanUtils.copyProperties(entity, acc);
			
			
			return acc;
		}
		return null;
	}

	@Override
	public boolean updateAccount(AccountRequest acc) {
		AccountMasterEntity entity = new AccountMasterEntity();
		
		BeanUtils.copyProperties(acc,entity);
		AccountMasterEntity saveEntity = accRepo.save(entity);
	return saveEntity!=null;
		
	}
	@Override
	public AccountRequest getAccountByAcc_Id(Integer acc_id) {
		Optional<AccountMasterEntity> findByAcc_Id=accRepo.findById(acc_id);
		if(findByAcc_Id.isPresent()) {
			AccountMasterEntity entity = findByAcc_Id.get();
			AccountRequest c = new AccountRequest();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		
		return null;
	}

	@Override
	public List<AccountRequest> getAllAccountDetails() {
		List<AccountMasterEntity> entities =accRepo.findAll();
			
		return entities. stream().map(entity ->{
			AccountRequest c = new AccountRequest();
			BeanUtils.copyProperties(entity,c);
			return c;
		}).collect(Collectors.toList());
		
		
	}

	@Override
	public boolean deleteContactById(Integer acc_id) {
		accRepo.deleteById(acc_id);
		return true;
	}

	
}
