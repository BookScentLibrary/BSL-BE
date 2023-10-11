package com.samsam.bsl.book.rent.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


@Getter
@Entity
@Builder
@Table(name = "ratingData")
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

    @Id
    @Column(name = "bookNo")
    private int bookNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookNo", referencedColumnName = "bookNo")
    private Book book;

    @ColumnDefault("0")
    @Column(name = "point_1", nullable = false)
    private int point_1;

    @ColumnDefault("0")
    @Column(name = "point_2", nullable = false)
    private int point_2;

    @ColumnDefault("0")
    @Column(name = "point_3", nullable = false)
    private int point_3;

    @ColumnDefault("0")
    @Column(name = "point_4", nullable = false)
    private int point_4;

    @ColumnDefault("0")
    @Column(name = "point_5", nullable = false)
    private int point_5;
}
