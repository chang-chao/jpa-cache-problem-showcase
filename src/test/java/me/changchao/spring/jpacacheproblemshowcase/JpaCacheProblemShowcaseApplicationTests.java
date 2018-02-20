package me.changchao.spring.jpacacheproblemshowcase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.SneakyThrows;
import me.changchao.spring.jpacacheproblemshowcase.domain.Foo;
import me.changchao.spring.jpacacheproblemshowcase.repository.FooRepository;
import me.changchao.spring.jpacacheproblemshowcase.service.FooService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaCacheProblemShowcaseApplicationTests {

	@Autowired
	private FooRepository fooRepository;

	@Autowired
	private FooService fooService;

	@Test
	@SneakyThrows
	public void testCache() {
		long fooId = 1l;
		Foo foo1 = fooRepository.findOne(fooId);
		Thread thread2 = new Thread(() -> {
			fooService.incFoo(fooId);
		});
		thread2.start();
		thread2.join();

		fooService.incFoo(fooId);

		Foo foo2 = fooRepository.findOne(fooId);

		Assert.assertEquals(3, foo2.getBar());
	}

}
