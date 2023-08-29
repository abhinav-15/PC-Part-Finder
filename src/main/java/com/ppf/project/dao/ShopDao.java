package com.ppf.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ppf.project.model.Shop;

import java.util.List;

public interface ShopDao extends JpaRepository<Shop, Long> {

	@Query("SELECT s FROM Shop s " + "JOIN s.devices d " + "WHERE d.deviceName = :deviceName " + "AND s.city = :city")
	List<Shop> findByCityAndDevice(@Param("city") String city, @Param("deviceName") String deviceName);

	@Query("SELECT s FROM Shop s " + "JOIN s.devices d " + "JOIN s.hardwareIssues hi "
			+ "WHERE d.deviceName = :deviceName " + "AND s.city = :city " + "AND hi.hwIssueName = :hardwareIssueName")
	List<Shop> findByCityAndDeviceAndHardwareIssue(@Param("city") String city, @Param("deviceName") String deviceName,
			@Param("hardwareIssueName") String hardwareIssueName);

	@Query("SELECT s FROM Shop s " + "JOIN s.devices d " + "JOIN s.softwareIssues si "
			+ "WHERE d.deviceName = :deviceName " + "AND s.city = :city " + "AND si.swIssueName = :softwareIssueName")
	List<Shop> findByCityAndDeviceAndSoftwareIssue(@Param("city") String city, @Param("deviceName") String deviceName,
			@Param("softwareIssueName") String softwareIssueName);

	@Query("SELECT s FROM Shop s " + "JOIN s.devices d " + "JOIN s.hardwareIssues hi " + "JOIN s.softwareIssues si "
			+ "WHERE d.deviceName = :deviceName " + "AND s.city = :city " + "AND hi.hwIssueName = :hardwareIssueName "
			+ "AND si.swIssueName = :softwareIssueName")
	List<Shop> findByCityAndDeviceAndHardwareAndSoftwareIssues(@Param("city") String city,
			@Param("deviceName") String deviceName, @Param("hardwareIssueName") String hardwareIssueName,
			@Param("softwareIssueName") String softwareIssueName);

	Shop findByShopId(Long shopId);

}
