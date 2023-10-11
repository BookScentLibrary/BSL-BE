package com.samsam.bsl.newbooks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="newbook")
public class NewBooksDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookNo;
}