package com.example.UMC_WORKBOOK.repository;

import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Object> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);

}
