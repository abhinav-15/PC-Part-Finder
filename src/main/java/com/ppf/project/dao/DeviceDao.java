package com.ppf.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppf.project.model.Device;

public interface DeviceDao extends JpaRepository<Device, Long> {

}
