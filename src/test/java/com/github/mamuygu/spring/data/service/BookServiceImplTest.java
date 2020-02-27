package com.github.mamuygu.spring.data.service;

import com.github.mamuygu.spring.data.SpringDataApplication;
import com.github.mamuygu.spring.data.data.AuthorOfBookRepository;
import com.github.mamuygu.spring.data.data.AuthorRepository;
import com.github.mamuygu.spring.data.entity.Author;
import com.github.mamuygu.spring.data.entity.AuthorOfBook;
import com.github.mamuygu.spring.data.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BookServiceImplTest {

    @Autowired
    //private BookRepository bookRepository;

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
    }

    @Test
    public void testFindByYear() {
    }

    @Test
    public void testFindAtPage() {
    }

    @Test
    public void testFindSame() {
    }

    @Test
    public void testFindInRange() {
    }

    @Test
    public void testFindByAuthorLastname() {
    }

    @Test
    public void testComplexQueryMethod() {
    }
}
