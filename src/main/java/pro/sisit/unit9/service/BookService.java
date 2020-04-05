package pro.sisit.unit9.service;

import pro.sisit.unit9.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(Book book);

    Optional<Book> findById(Long id);

    List<Book> findByYear(Integer year);

    Page<Book> findAtPage(int pageIndex, int pageNumber, Sort.Direction direction, String sortField);

    List<Book> findSame(Book book);


}