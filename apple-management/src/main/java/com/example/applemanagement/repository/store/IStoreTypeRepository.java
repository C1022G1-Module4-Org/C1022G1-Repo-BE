package com.example.applemanagement.repository.store;

import com.example.applemanagement.model.store.StoreType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStoreTypeRepository extends JpaRepository<StoreType, Integer> {
    StoreType findById(int id);
}
