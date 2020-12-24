package org.py.web2020.hibernate.repo.example97;

import org.py.web2020.hibernate.entity.example97.Library;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LibraryDao extends PagingAndSortingRepository<Library, Long> {
    Library findByName(String name);
}
