package com.samsam.bsl.bestseller;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.samsam.bsl.book.rent.domain.Book;

import lombok.*;

@Entity
@Table(name = "bestseller")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Best {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="pk")
  private int rank;

  @JsonIgnore
  private int bookNo;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "bookNo", referencedColumnName = "bookNo", insertable = false, updatable = false, nullable = false)
  private Book book;
}
