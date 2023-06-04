package com.boston.OutdoorsApi.dao;

import com.boston.OutdoorsApi.Models.FileData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileDataRepository extends PagingAndSortingRepository<FileData, Long> {

    Optional<FileData> findByName(String fileName);
}
