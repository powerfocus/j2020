package org.py.web2020.hibernate.repo;

import org.py.web2020.hibernate.entity.SubSelectEnt;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountTransactionDao extends PagingAndSortingRepository<SubSelectEnt.AccountTransaction, Long> {
}
