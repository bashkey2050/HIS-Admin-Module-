package com.nit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
	
	
	private Integer acc_Id;
	
	private String accStatus;
	
	private String firstName;
	
	private String lastName;
	private String userPwd;
	private String email;
	private String gender;
	
	private String userRole;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	

}
