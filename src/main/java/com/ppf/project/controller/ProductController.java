package com.ppf.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ppf.project.model.Device;
import com.ppf.project.model.HardwareIssue;
import com.ppf.project.model.Shop;
import com.ppf.project.model.SoftwareIssue;
import com.ppf.project.dao.DeviceDao;
import com.ppf.project.dao.HardwareIssueDao;
import com.ppf.project.dao.ShopDao;
import com.ppf.project.dao.SoftwareIssueDao;

import java.util.List;

@Controller
public class ProductController {

	@Autowired
	private DeviceDao deviceDao;

	@Autowired
	private HardwareIssueDao hardwareIssueDao;

	@Autowired
	private SoftwareIssueDao softwareIssueDao;

	@Autowired
	private ShopDao shopDao;

	@GetMapping("/finalproducts")
	public String listHardwareIssue(Model model) {
		List<Device> device = deviceDao.findAll();
		model.addAttribute("devices", device);

		List<HardwareIssue> hardwareIssue = hardwareIssueDao.findAll();
		model.addAttribute("hardwareIssues", hardwareIssue);

		List<SoftwareIssue> softwareIssue = softwareIssueDao.findAll();
		model.addAttribute("softwareIssues", softwareIssue);

		return "finalproducts";
	}

	@GetMapping("/searchShop")
	public String searchShops(@RequestParam("city") String city, @RequestParam("device") String deviceName,
			@RequestParam(value = "hardware", required = false) String hardwareIssueName,
			@RequestParam(value = "software", required = false) String softwareIssueName, Model model) {

		if (hardwareIssueName == "" && softwareIssueName == "") {
			List<Shop> shopInfoList = shopDao.findByCityAndDevice(city, deviceName);
			model.addAttribute("shopInfoList", shopInfoList);
		} else if (hardwareIssueName == "") {
			List<Shop> shopInfoList = shopDao.findByCityAndDeviceAndSoftwareIssue(city, deviceName, softwareIssueName);
			model.addAttribute("shopInfoList", shopInfoList);
		} else if (softwareIssueName == "") {
			List<Shop> shopInfoList = shopDao.findByCityAndDeviceAndHardwareIssue(city, deviceName, hardwareIssueName);
			model.addAttribute("shopInfoList", shopInfoList);
		} else {
			List<Shop> shopInfoList = shopDao.findByCityAndDeviceAndHardwareAndSoftwareIssues(city, deviceName,
					hardwareIssueName, softwareIssueName);
			model.addAttribute("shopInfoList", shopInfoList);
		}

		return "searchShop";
	}

	@GetMapping("/shopDetails")
	public String getShopDetails(@RequestParam("shopId") Long shopId, Model model) {
		Shop shop = shopDao.findByShopId(shopId);
		model.addAttribute("shop", shop);
		return "shopDetails";
	}

}
