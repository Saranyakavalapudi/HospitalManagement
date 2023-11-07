package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IReportRepository extends JpaRepository<Report,Long> {
}
