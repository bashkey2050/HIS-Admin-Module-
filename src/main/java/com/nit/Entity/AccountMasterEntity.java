package com.nit.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name="Account")
public class AccountMasterEntity {
	
	    public AccountMasterEntity() {
		// TODO Auto-generated constructor stub
	}
		@Id
	    @GeneratedValue()  
		private Integer acc_Id;
		
		@Column(name = "ACCSTATUS")
		private String accStatus;
		@NonNull
		@Column(length = 50, name = "FIRSTNAME")
		private String firstName;
		@NonNull
		@Column(length = 50, name = "LASTNAME")
		private String lastName;
		
		@Column(name = "USERPWD")
		private String userPwd;
		@Column(length = 50, name = "EMAIL")
		private String email;
		@NonNull
		@Column(length = 50, name = "GENDER")
		private String gender;
		@NonNull
		@Column(length = 50, name = "USERROLE")
		private String userRole;
		@Column(name = "CREATED_DATE")
		@CreationTimestamp
		@Temporal(TemporalType.DATE)
		private Date createdDate;
		@Column(name = "UPDATED_DATE",insertable = false)
		@UpdateTimestamp
		private Date updatedDate;

}
