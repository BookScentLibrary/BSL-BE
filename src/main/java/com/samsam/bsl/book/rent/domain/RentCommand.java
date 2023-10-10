package com.samsam.bsl.book.rent.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RentCommand {
    private String userId;
    private int bookNo;

    public  RentCommand toCommand() {
        return RentCommand.builder()
                .userId(userId)
                .bookNo(bookNo)
                .build();
    }

    public Rent toEntity() {
        return Rent.builder()
                .userId(userId)
                .bookNo(bookNo)
                .build();
    }
}
