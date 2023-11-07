package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.model.Report;

import java.util.List;

public interface IReportService {

    Report addReport(Report report);

    List<Report> getReports();

    Report getReportById(Long id);

    Report updateReport(Report report);

    void deleteReport(Long id);
}
