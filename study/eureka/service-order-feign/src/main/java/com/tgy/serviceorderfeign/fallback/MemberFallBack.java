package com.tgy.serviceorderfeign.fallback;

import java.util.ArrayList;
import java.util.List;

import com.tgy.serviceorderfeign.servie.MemberFeign;
import org.springframework.stereotype.Component;

@Component
public class MemberFallBack implements MemberFeign {

	public List<String> getOrderByUserList() {
	    //服务降级处理
		List<String> list = new ArrayList<String>();
		list.add("服务发生异常...");
		return list;
	}
}
