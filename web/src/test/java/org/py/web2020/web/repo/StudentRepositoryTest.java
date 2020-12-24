package org.py.web2020.web.repo;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.web.entity.Book;
import org.py.web2020.web.entity.Card;
import org.py.web2020.web.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentDao;

    @Test
    public void testOneToOne() {
        Student s1 = new Student();
        s1.setName("赵大伟");
        s1.setSex("male");

        Card c1 = new Card();
        c1.setNum(422802);
        s1.setCard(c1);

        studentDao.save(s1);
    }

    @Test
    public void findAllTest() {
        studentDao.findAll()
                .forEach(System.out::println);
    }

    @Test
    public void del() {
        Optional<Student> opt = studentDao.findById(1L);
        Student student = opt.orElseThrow();
        TestCase.assertEquals(1, student.getId());

        studentDao.delete(student);
    }
}