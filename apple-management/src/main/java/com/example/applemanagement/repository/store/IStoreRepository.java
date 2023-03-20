package com.example.applemanagement.repository.store;

import com.example.applemanagement.model.store.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStoreRepository extends JpaRepository<Store,Integer> {
    @Query(value = "select * from store where name like %:name% and is_delete = false", nativeQuery = true)
    Page<Store> findByNameAndIsDelete(Pageable pageable, @Param("name") String name);
}
