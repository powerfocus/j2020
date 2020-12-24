package org.py.web2020.hibernate.repo.example97;

import org.py.web2020.hibernate.entity.example97.BookJoinLibrary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookJoinLibraryDao extends PagingAndSortingRepository<BookJoinLibrary, Long> {
    @Query(value = "select b.id, b.title, b.author, l.name from book b inner join library l on b.lib_id=l.id",
            nativeQuery = true)
    List<BookJoinLibrary> find();
}
