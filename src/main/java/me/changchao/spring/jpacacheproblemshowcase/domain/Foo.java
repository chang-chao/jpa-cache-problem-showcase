package me.changchao.spring.jpacacheproblemshowcase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Foo {
	@Id
	@SequenceGenerator(name = "foo_generator", sequenceName = "foo_generator", initialValue = 23)
	@GeneratedValue(generator = "foo_generator")
	private Long id;

	@Column(nullable = false)
	private int bar;
}
