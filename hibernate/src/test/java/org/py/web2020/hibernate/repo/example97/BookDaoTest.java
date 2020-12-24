package org.py.web2020.hibernate.repo.example97;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.hibernate.entity.example97.Book;
import org.py.web2020.hibernate.entity.example97.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private LibraryDao libraryDao;

    @Test
    public void testSave() {
        Book book1 = Book.builder()
                .title("疯狂java讲义第4版")
                .author("admin")
                .build();
        bookDao.save(book1);

        /*Library library = libraryDao.findById(2L).orElseThrow();
        library.getBooks().add(book1);
        libraryDao.save(library);*/
    }

    @Test
    public void testChange2Lib() {
        Book book = bookDao.findById(8L).orElseThrow();
        Library library = libraryDao.findById(2L).orElseThrow();
        library.getBooks().add(book);
        libraryDao.save(library);
    }

    @Test
    public void testFindById() {
        Book book = bookDao.findById(12L).orElseThrow();
        System.out.println(book);
    }
}