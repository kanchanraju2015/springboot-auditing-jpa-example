package com.briz.myaudit;

import java.util.Date;

import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass  // note this is a super class object cannot be created read inheritance  
@EntityListeners(AuditingEntityListener.class)
public class Auditable
{
@CreatedBy
String Createdby;

@CreatedDate
@Temporal(TemporalType.TIMESTAMP)
Date createddt;

@LastModifiedBy
String modifiedby;

@LastModifiedDate
@Temporal(TemporalType.TIMESTAMP)
Date modifieddt;

public String getCreatedby() {
	return Createdby;
}

public void setCreatedby(String createdby) {
	Createdby = createdby;
}

public Date getCreateddt() {
	return createddt;
}

public void setCreateddt(Date createddt) {
	this.createddt = createddt;
}

public String getModifiedby() {
	return modifiedby;
}

public void setModifiedby(String modifiedby) {
	this.modifiedby = modifiedby;
}

public Date getModifieddt() {
	return modifieddt;
}

public void setModifieddt(Date modifieddt) {
	this.modifieddt = modifieddt;
}
}
