package org.leti.Repo;

import org.leti.Domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface EntryRepo extends JpaRepository<Entry, String> {

    @Modifying
    @Transactional
    @Query("update Entry e set e.comment = :comment where e.id = :entryId")
    int updateEntryComment(@Param("comment") String comment,
                                   @Param("entryId") String entryId);

}
