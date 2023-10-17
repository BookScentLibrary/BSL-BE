package com.samsam.bsl.newbook;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name="newBook")
@Getter
@ToString
public class NewBook {
	@Id
	private int bookNo;
}