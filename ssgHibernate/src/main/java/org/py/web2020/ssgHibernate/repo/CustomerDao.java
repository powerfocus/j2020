package org.py.web2020.ssgHibernate.repo;

import org.py.web2020.ssgHibernate.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerDao extends PagingAndSortingRepository<Customer, Long> {
}
