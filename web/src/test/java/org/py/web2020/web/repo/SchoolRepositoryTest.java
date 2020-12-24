package org.py.web2020.web.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.web.entity.School;
import org.py.web2020.web.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SchoolRepositoryTest {
    @Autowired
    private SchoolRepository schoolDao;
    @Autowired
    private TeacherRepository teacherDao;

    @Test
    public void test() {
        School qh = School.builder()
                .name("清华大学")
                .build();
        schoolDao.save(qh);

        teacherDao.save(Teacher.builder()
                .name("张三")
                .school(qh)
                .build());
    }
}