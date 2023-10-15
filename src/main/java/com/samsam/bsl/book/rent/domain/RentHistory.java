package com.samsam.bsl.book.rent.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.samsam.bsl.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="rent_history")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RentHistory {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int pk;

  @JsonIgnore
  private String userId;

  @JsonIgnore
  private int bookNo;

  private LocalDateTime rentedDate;

  private LocalDateTime returnedDate;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false, nullable = false)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinColumn(name = "bookNo", referencedColumnName = "bookNo", insertable = false, updatable = false, nullable = false)
  private Book book;

  public RentHistory(String userId, int bookNo, LocalDateTime rentedDate, LocalDateTime returnedDate) {
    this.userId = userId;
    this.bookNo = bookNo;
    this.rentedDate = rentedDate;
    this.returnedDate = returnedDate;
  }
}
