package org.py.web2020.hibernate.repo.example97;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.hibernate.entity.example97.Book;
import org.py.web2020.hibernate.entity.example97.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryDaoTest {
    @Autowired
    private LibraryDao libraryDao;

    @Test
    public void testSave() {
        Library lib1 = Library.builder()
                .name("spring boot")
                .books(new HashSet<>() {{
                    add(Book.builder().title("java编程思想").author("admin").build());
                    add(Book.builder().title("c++编程思想").author("admin").build());
                    add(Book.builder().title("c++primer plus").author("admin").build());
                    add(Book.builder().title("c++primer").author("admin").build());
                    add(Book.builder().title("netty权威指南").author("admin").build());
                }})
                .build();
        libraryDao.save(lib1);

        Library lib2 = Library.builder()
                .name("c#")
                .books(new HashSet<>() {{
                    add(Book.builder().title("C#本质论").author("admin").build());
                    add(Book.builder().title("C#从入门到精通").author("admin").build());
                    add(Book.builder().title("C#高级编程").author("admin").build());
                }})
                .build();
        libraryDao.save(lib2);
    }

    @Test
    public void testFindById() {
        Library library = libraryDao.findById(10L).orElseThrow();
        System.out.println(library);
    }

    @Test
    public void testFindByName() {
        Library lib = libraryDao.findByName("spring boot");
        System.out.println(lib);
    }
}