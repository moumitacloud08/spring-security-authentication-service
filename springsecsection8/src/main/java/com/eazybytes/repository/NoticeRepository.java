package com.eazybytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eazybytes.model.Notice;

public interface NoticeRepository extends CrudRepository<Notice, Long>{
	
	@Query(value ="from Notice n where CURDATE() BETWEEN noticeBegDt and noticeEndDt")
	List<Notice> findAllActiveNotices();

}
