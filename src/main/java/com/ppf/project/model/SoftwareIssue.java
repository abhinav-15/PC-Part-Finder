package com.ppf.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SoftwareIssue {

	@Id
	private int swIssueId;
	private String swIssueName;

	public int getSwIssueId() {
		return swIssueId;
	}

	public void setSwIssueId(int swIssueId) {
		this.swIssueId = swIssueId;
	}

	public String getSwIssueName() {
		return swIssueName;
	}

	public void setSwIssueName(String swIssueName) {
		this.swIssueName = swIssueName;
	}

	public SoftwareIssue() {

	}

	public SoftwareIssue(int swIssueId, String swIssueName) {
		super();
		this.swIssueId = swIssueId;
		this.swIssueName = swIssueName;
	}

	@Override
	public String toString() {
		return "Product [swIssueId=" + swIssueId + ", swIssueName=" + swIssueName + "]";
	}
}
