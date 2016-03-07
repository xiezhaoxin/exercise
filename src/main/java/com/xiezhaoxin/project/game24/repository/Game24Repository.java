package com.xiezhaoxin.project.game24.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.xiezhaoxin.project.game24.entity.Game24;

public interface Game24Repository extends CrudRepository<Game24, String> {

	@Query(value = "select * from (select t.* from GAME_TWENTYFOUR t where t.GAME_LEVEL = '0' order by dbms_random.random) where rownum < 2", nativeQuery = true)
	public Game24 findRandomOne();
	
	@Query("from Game24 t where t.level = '0'")
	public Page<Game24> findOne0Leve(Pageable page);
	
	@Query(value = "select * from (select t.pid from GAME_TWENTYFOUR t where t.GAME_LEVEL = '0' order by dbms_random.random) m where rownum < 2", nativeQuery = true)
	public String findRandomOneId();
	
	@Query("from Game24")
	public List<Game24> findAll();
	
	@Query(value = "select count(0) from (select t.* from GAME_TWENTYFOUR t where t.GAME_LEVEL = '0')", nativeQuery = true)
	public Integer countLevelIsNull();

}
