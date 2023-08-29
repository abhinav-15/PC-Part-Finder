package com.ppf.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class HardwareIssue {

	@Id
	private int hwIssueId;
	private String hwIssueName;

	public int getHwIssueId() {
		return hwIssueId;
	}

	public void setHwIssueId(int hwIssueId) {
		this.hwIssueId = hwIssueId;
	}

	public String getHwIssueName() {
		return hwIssueName;
	}

	public void setHwIssueName(String hwIssueName) {
		this.hwIssueName = hwIssueName;
	}

	public HardwareIssue() {

	}

	public HardwareIssue(int hwIssueId, String hwIssueName) {
		super();
		this.hwIssueId = hwIssueId;
		this.hwIssueName = hwIssueName;
	}

	@Override
	public String toString() {
		return "Hardware Issue [hwIssueId=" + hwIssueId + ", hwIssueName=" + hwIssueName + "]";
	}
}
