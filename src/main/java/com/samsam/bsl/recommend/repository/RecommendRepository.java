package com.samsam.bsl.recommend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samsam.bsl.recommend.model.Recommend;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Integer>, RecommendRepositoryQueryDsl {

}
