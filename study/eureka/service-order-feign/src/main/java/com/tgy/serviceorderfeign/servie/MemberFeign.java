package com.tgy.serviceorderfeign.servie;

import java.util.List;

import com.tgy.serviceorderfeign.fallback.MemberFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//fallback = MemberFeignService.class
@FeignClient(value = "eureka-client",fallback=MemberFallBack.class)
public interface MemberFeign {
	@RequestMapping("/getAllInfo")
	public List<String> getOrderByUserList();
}
