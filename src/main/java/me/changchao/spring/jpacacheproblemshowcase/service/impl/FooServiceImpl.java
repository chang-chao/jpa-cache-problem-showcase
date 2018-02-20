package me.changchao.spring.jpacacheproblemshowcase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.changchao.spring.jpacacheproblemshowcase.domain.Foo;
import me.changchao.spring.jpacacheproblemshowcase.repository.FooRepository;
import me.changchao.spring.jpacacheproblemshowcase.service.FooService;

@Service
public class FooServiceImpl implements FooService {

	@Autowired
	private FooRepository fooRepository;

	@Override
	@Transactional
	public void incFoo(Long id) {
		Foo foo = fooRepository.findOneForUpdate(id);
		foo.setBar(foo.getBar() + 1);
		fooRepository.save(foo);
	}

}
