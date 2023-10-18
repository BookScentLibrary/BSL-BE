package com.samsam.bsl.book.rent.repository;

import com.samsam.bsl.book.rent.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long>{
    Cart findByUserIdAndBookNo(String userId, int bookNo);
    List<Cart> findAllByUserIdOrderByIdDesc(String userId);
    @Transactional
    List<Cart> deleteByUserId(String userId);
    int countByUserId(String userId);
    void deleteByUserIdAndBookNo(String userId, int bookNo);
}
