package com.samsam.bsl.book.review.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.notice.domain.Notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ratingData")
public class RatingData {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookNo;
	
	@Column(nullable = false)
	private int point_1;
	
	@Column(nullable = false)
	private int point_2;
	
	@Column(nullable = false)
	private int point_3;
	
	@Column(nullable = false)
	private int point_4;
	
	@Column(nullable = false)
	private int point_5;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "bookNo", referencedColumnName = "bookNo", insertable = false, updatable = false, nullable = false)
	private Book book;
	
	@Builder
	public RatingData(int bookNo, int point_1, int point_2, int point_3, int point_4, int point_5) {
		this.bookNo = bookNo;
		this.point_1 = point_1;
		this.point_2 = point_2;
		this.point_3 = point_3;
		this.point_4 = point_4;
		this.point_5 = point_5;
	}
}
