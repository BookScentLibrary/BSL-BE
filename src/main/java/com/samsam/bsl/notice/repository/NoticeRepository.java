package com.samsam.bsl.notice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.samsam.bsl.notice.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
	@Query("SELECT n FROM Notice n LEFT JOIN FETCH n.user u WHERE u.userId = n.userId")
	List<Notice> getAllNotices();

	List<Notice> findByPostTitleContainingOrContentContaining(String postTitle, String content);

	List<Notice> findByPostTitleContaining(String postTitle);

	List<Notice> findByContentContaining(String content);
}
