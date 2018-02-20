package me.changchao.spring.jpacacheproblemshowcase.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import me.changchao.spring.jpacacheproblemshowcase.domain.Foo;

public interface FooRepository extends CrudRepository<Foo, Long> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select f from Foo f where f.id = ?1")
	Foo findOneForUpdate(Long id);
}
