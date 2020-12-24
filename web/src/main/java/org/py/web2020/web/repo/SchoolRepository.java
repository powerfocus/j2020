package org.py.web2020.web.repo;

import org.py.web2020.web.entity.School;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {
}
