package io.munkush.com.repository;

import java.util.List;

import io.munkush.com.entity.Notice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
	
	List<Notice> findAll();

}
