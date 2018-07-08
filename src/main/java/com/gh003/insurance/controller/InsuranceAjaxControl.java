package com.gh003.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gh003.insurance.dao.InsuranceMapper;
import com.gh003.insurance.entity.Insurance;

@Controller
@CrossOrigin
public class InsuranceAjaxControl {

	@Autowired
	InsuranceMapper insuranceMapper;
	
	@RequestMapping("/saler/policy")
	@ResponseBody
	public Object getSalerPolicy(Integer salerid) {
		List<Insurance> listOfIns;
		System.out.println("/saler/policy接口被调用");
		listOfIns = insuranceMapper.selectBySalerId(salerid);
		
		return listOfIns;
		
	}
	@RequestMapping("/root/policy")
	@ResponseBody
	public Object getRootPolicy() {
		List<Insurance> listOfIns;
		
		listOfIns = insuranceMapper.selectAllInsurance();
		System.out.println("/root/policy接口被调用");
		return listOfIns;
		
	}
	
}
