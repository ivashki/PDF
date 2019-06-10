package com.frantishex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frantishex.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}