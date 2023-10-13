package com.samsam.bsl.newbook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newbook")
public class NewBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booknum;
}