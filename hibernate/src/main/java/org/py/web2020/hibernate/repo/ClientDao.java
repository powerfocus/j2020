package org.py.web2020.hibernate.repo;

import org.py.web2020.hibernate.entity.SubSelectEnt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ClientDao extends PagingAndSortingRepository<SubSelectEnt.Client, Long> {
    @Query(
            "select s " +
                    "from AccountSummary s " +
                    "where s.id = :id"
    )
    SubSelectEnt.AccountSummary findSummary(@Param("id") long id);
}
