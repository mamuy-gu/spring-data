package com.github.mamuygu.spring.data.service;

import com.github.mamuygu.spring.data.SpringDataApplication;
import com.github.mamuygu.spring.data.data.AuthorOfBookRepository;
import com.github.mamuygu.spring.data.data.AuthorRepository;
import com.github.mamuygu.spring.data.data.BookRepository;
import com.github.mamuygu.spring.data.data.BookSpecifications;
import com.github.mamuygu.spring.data.entity.Author;
import com.github.mamuygu.spring.data.entity.AuthorOfBook;
import com.github.mamuygu.spring.data.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BookServiceImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorOfBookRepository authorOfBookRepository;

    @Autowired
    private BookService bookService;

    @Before
    public void init() {
        Book book = new Book();
        book.setDescription("Увлекательные приключения Тома Сойера");
        book.setTitle("Приключения Тома Сойера");
        book.setYear(1876);
        bookRepository.save(book);

        Book book2 = new Book();
        book2.setTitle("Михаил Строгов");
        book2.setYear(1876);
        bookRepository.save(book2);

        Author author = new Author();
        author.setFirstname("Марк");
        author.setLastname("Твен");
        authorRepository.save(author);

        AuthorOfBook authorOfBook = new AuthorOfBook();
        authorOfBook.setAuthor(author);
        authorOfBook.setBook(book);
        authorOfBookRepository.save(authorOfBook);

        Author author2 = new Author();
        author2.setFirstname("Жюль");
        author2.setLastname("Верн");
        authorRepository.save(author2);
    }

    @Test
    public void testSave() {
        boolean founded = false;
        for (Book book : bookRepository.findAll()) {
            if (book.getTitle().equals("Приключения Тома Сойера")) {
                founded = true;
                break;
            }
        }

        assertTrue(founded);
    }

    @Test
    public void testFindByYear() {
        assertTrue(bookService.findByYear(1876)
                .stream()
                .anyMatch(book -> book.getYear() == 1876));

        assertEquals(0, bookService.findByYear(1986).size());
        assertEquals(2, bookService.findByYear(1876).size());
    }

    @Test
    public void testFindAtPage() {
        assertTrue(bookService.findAtPage(1, 1, Sort.Direction.ASC, "title")
                .get().anyMatch(book -> book.getTitle().equals("Приключения Тома Сойера")));
    }

    @Test
    public void testFindSame() {
        Book book = new Book();
        book.setTitle("Приключения Тома Сойера");

        assertEquals(1, bookService.findSame(book).size());
    }

    @Test
    public void testFindInRange() {
        assertEquals(2, bookRepository.findAll(BookSpecifications.rangeBetween(1800, 1900)).size());
        assertEquals(0, bookRepository.findAll(BookSpecifications.rangeBetween(1900, 2000)).size());
    }

    @Test
    public void testFindByAuthorLastname() {
        assertEquals(1, bookRepository.findByAuthorLastname("Твен").size());
    }

    @Test
    public void testComplexQueryMethod() {
        assertEquals(2, bookRepository.complexQueryMethod().size());
    }
}
