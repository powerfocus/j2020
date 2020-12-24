package org.py.web2020.web.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.web.entity.School;
import org.py.web2020.web.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherDao;

    @Autowired
    private SchoolRepository schoolDao;

    @Test
    public void save() {
        School CQsc = School.builder()
                .name("重庆大学")
                .build();
        School sCQ = schoolDao.save(CQsc);

        Teacher zs = Teacher.builder()
                .name("张三")
                .school(CQsc)
                .build();
        Teacher szs = teacherDao.save(zs);
        System.out.println(szs);
    }
}