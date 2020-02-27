package com.github.mamuygu.spring.data.service;

import com.github.mamuygu.spring.data.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public void save(Book book) {
    }

    @Override
    public Optional<Book> findById(Long id) {
        return null;
    }

    @Override
    public List<Book> findByYear(Integer year) {
        return null;
    }

    @Override
    public Page<Book> findAtPage(int pageIndex, int pageNumber, Sort.Direction direction, String sortField) {
        return null;
    }

    @Override
    public List<Book> findSame(Book book) {
        return null;
    }
}
