package org.py.web2020.hibernate.repo.example97;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.hibernate.entity.example97.BookJoinLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookJoinLibraryDaoTest {
    @Autowired
    private BookJoinLibraryDao bookJoinLibraryDao;

    @Test
    public void testFind() {
        List<BookJoinLibrary> list = bookJoinLibraryDao.find();
        list.forEach(System.out::println);
    }
}