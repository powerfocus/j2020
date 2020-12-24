package org.py.web2020.web.repo;

import org.py.web2020.web.entity.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {
}
