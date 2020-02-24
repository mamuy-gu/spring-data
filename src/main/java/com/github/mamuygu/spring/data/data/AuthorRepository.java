package com.github.mamuygu.spring.data.data;

import com.github.mamuygu.spring.data.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
