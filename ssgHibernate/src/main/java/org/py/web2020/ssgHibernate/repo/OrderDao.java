package org.py.web2020.ssgHibernate.repo;

import org.py.web2020.ssgHibernate.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderDao extends PagingAndSortingRepository<Order, Long> {
}
