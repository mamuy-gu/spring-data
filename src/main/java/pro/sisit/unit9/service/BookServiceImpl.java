package pro.sisit.unit9.service;

import pro.sisit.unit9.data.BookRepository;
import pro.sisit.unit9.entity.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findByYear(Integer year) {
        return bookRepository.findByYear(year);
    }

    @Override
    public Page<Book> findAtPage(int pageIndex, int pageNumber, Sort.Direction direction, String sortField) {
        PageRequest pageRequest = PageRequest.of(pageIndex, pageNumber, direction, sortField);

        return bookRepository.findAll(pageRequest);
    }

    @Override
    public List<Book> findSame(Book book) {
        return bookRepository.findAll(Example.of(book));
    }
}
