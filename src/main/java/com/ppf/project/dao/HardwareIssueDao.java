package com.ppf.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppf.project.model.HardwareIssue;

public interface HardwareIssueDao extends JpaRepository<HardwareIssue, Long> {
}
