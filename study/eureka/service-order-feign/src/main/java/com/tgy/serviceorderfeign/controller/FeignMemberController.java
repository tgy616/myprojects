package com.tgy.serviceorderfeign.controller;

import java.util.List;

import com.tgy.serviceorderfeign.servie.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignMemberController {
	@Autowired
	private MemberFeign memberFeign;

	@RequestMapping("/getFeignOrderByUserList")
	public List<String> getFeignOrderByUserList() {
		System.out.println("order-feign工程调用eureka-client工程");
		return memberFeign.getOrderByUserList();
	}

	@RequestMapping("/getOrderFeign")
	public String getOrderFeign() {
		return "getOrderFeign";
	}

}
