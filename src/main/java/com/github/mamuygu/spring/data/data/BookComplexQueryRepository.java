package com.github.mamuygu.spring.data.data;

import com.github.mamuygu.spring.data.entity.Book;

import java.util.List;

public interface BookComplexQueryRepository {
    List<Book> complexQueryMethod();
}
