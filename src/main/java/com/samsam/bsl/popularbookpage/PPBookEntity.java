package com.samsam.bsl.popularbookpage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Builder
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PPBookEntity {
	@Id
	@Column(name="bookNo")
	private int bookNo;

	@Column(name="pk")
	private int pk;
}