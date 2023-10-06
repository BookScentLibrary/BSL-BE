package com.samsam.bsl.book.rent.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Entity
@Builder
@Table(name = "readerData")
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    @Id
    @Column(name = "bookNo")
    private int bookNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookNo", referencedColumnName = "bookNo")
    private Book book;

    @ColumnDefault("0")
    @Column(name = "m_10", nullable = false)
    private int m_10;

    @ColumnDefault("0")
    @Column(name = "f_10", nullable = false)
    private int f_10;

    @ColumnDefault("0")
    @Column(name = "m_20", nullable = false)
    private int m_20;

    @ColumnDefault("0")
    @Column(name = "f_20", nullable = false)
    private int f_20;

    @ColumnDefault("0")
    @Column(name = "m_30", nullable = false)
    private int m_30;

    @ColumnDefault("0")
    @Column(name = "f_30", nullable = false)
    private int f_30;

    @ColumnDefault("0")
    @Column(name = "m_40", nullable = false)
    private int m_40;

    @ColumnDefault("0")
    @Column(name = "f_40", nullable = false)
    private int f_40;

    @ColumnDefault("0")
    @Column(name = "m_50", nullable = false)
    private int m_50;

    @ColumnDefault("0")
    @Column(name = "f_50", nullable = false)
    private int f_50;

    @ColumnDefault("0")
    @Column(name = "m_senior", nullable = false)
    private int m_senior;

    @ColumnDefault("0")
    @Column(name = "f_senior", nullable = false)
    private int f_senior;
}