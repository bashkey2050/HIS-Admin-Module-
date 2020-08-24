package com.nit.service;

import java.util.List;

import com.nit.model.AccountRequest;

public interface AccountService {
	
public boolean saveUserAcc(AccountRequest req);

public AccountRequest getAccountByAcc_Id(Integer Acc_id);
public List<AccountRequest> getAllAccountDetails();
public boolean deleteContactById(Integer acc_id);

	public AccountRequest getUserAccByTempPwd(String tempPwd);
	public boolean updateAccount(AccountRequest acc);

}
