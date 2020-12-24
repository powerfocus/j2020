package org.py.web2020.web.repo;

import org.py.web2020.web.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}
