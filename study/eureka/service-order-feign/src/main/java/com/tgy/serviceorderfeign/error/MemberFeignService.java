package com.tgy.serviceorderfeign.error;

import com.tgy.serviceorderfeign.servie.MemberFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MemberFeignService implements MemberFeign {

	public List<String> getOrderByUserList() {
		List<String> listUser = new ArrayList<String>();
		listUser.add("not orderUser list");
		return listUser;
	}

}
