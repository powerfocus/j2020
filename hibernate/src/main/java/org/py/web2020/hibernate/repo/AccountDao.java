package org.py.web2020.hibernate.repo;

import org.py.web2020.hibernate.entity.SubSelectEnt;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountDao extends PagingAndSortingRepository<SubSelectEnt.Account, Long> {
}
