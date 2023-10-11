package com.samsam.bsl.newbooks;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NewBooksRepository extends JpaRepository<NewBooksDTO, Long> {
    List<NewBooksDTO> newBooksRanking();
}