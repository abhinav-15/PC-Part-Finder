package com.ppf.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppf.project.model.SoftwareIssue;

public interface SoftwareIssueDao extends JpaRepository<SoftwareIssue, Long> {
	SoftwareIssue findBySwIssueId(Integer swIssueId);
}
