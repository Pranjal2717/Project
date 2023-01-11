package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SMS {
	@Id
	private int s_id;
	private String s_name;
	@Column(unique = true)
	private String s_contact;
	private String s_address;

}
