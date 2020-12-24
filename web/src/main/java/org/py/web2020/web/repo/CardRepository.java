package org.py.web2020.web.repo;

import org.py.web2020.web.entity.Card;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
}
