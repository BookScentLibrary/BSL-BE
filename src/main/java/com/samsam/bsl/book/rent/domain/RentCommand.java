package com.samsam.bsl.book.rent.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RentCommand {
    private String username;
    private int bookNo;

    public  RentCommand toCommand() {
        return RentCommand.builder()
                .username(username)
                .bookNo(bookNo)
                .build();
    }

    public Rent toEntity() {
        return Rent.builder()
                .username(username)
                .bookNo(bookNo)
                .build();
    }
}
