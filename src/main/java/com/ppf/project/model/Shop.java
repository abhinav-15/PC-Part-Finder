package com.ppf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Set;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long shopId;
    
    @Column(name = "shop_name")
    private String shopName;
    
    @Column(name = "shop_data")
    private String shopData;
    private Long phone;
    private String email;
    @Column(name = "city")
    private String city;
    private String image;
    

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @ManyToMany
    @JoinTable(name = "shop_device",
               joinColumns = @JoinColumn(name = "shop_id"),
               inverseJoinColumns = @JoinColumn(name = "device_id"))
    private Set<Device> devices;

    @ManyToMany
    @JoinTable(name = "shop_hardware_issue",
               joinColumns = @JoinColumn(name = "shop_id"),
               inverseJoinColumns = @JoinColumn(name = "hw_issue_id"))
    private Set<HardwareIssue> hardwareIssues;

    @ManyToMany
    @JoinTable(name = "shop_software_issue",
               joinColumns = @JoinColumn(name = "shop_id"),
               inverseJoinColumns = @JoinColumn(name = "sw_issue_id"))
    private Set<SoftwareIssue> softwareIssues;

    public Shop() {
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopData() {
        return shopData;
    }

    public void setShopData(String shopData) {
        this.shopData = shopData;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public Set<HardwareIssue> getHardwareIssues() {
        return hardwareIssues;
    }

    public void setHardwareIssues(Set<HardwareIssue> hardwareIssues) {
        this.hardwareIssues = hardwareIssues;
    }

    public Set<SoftwareIssue> getSoftwareIssues() {
        return softwareIssues;
    }

    public void setSoftwareIssues(Set<SoftwareIssue> softwareIssues) {
        this.softwareIssues = softwareIssues;
    }

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Shop(Long shopId, String shopName, String shopData, Long phone, String email, Set<Device> devices,
			Set<HardwareIssue> hardwareIssues, Set<SoftwareIssue> softwareIssues, String city, String image) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopData = shopData;
		this.phone = phone;
		this.email = email;
		this.devices = devices;
		this.hardwareIssues = hardwareIssues;
		this.softwareIssues = softwareIssues;
		this.city = city;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", shopData=" + shopData + ", phone=" + phone
				+ ", email=" + email + ", city=" + city + ", image=" + image + ", devices=" + devices
				+ ", hardwareIssues=" + hardwareIssues + ", softwareIssues=" + softwareIssues + "]";
	}

}
