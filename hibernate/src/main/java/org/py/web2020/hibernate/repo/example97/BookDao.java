package org.py.web2020.hibernate.repo.example97;

import org.py.web2020.hibernate.entity.example97.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookDao extends PagingAndSortingRepository<Book, Long> {
    Book findByTitle(String title);
}
