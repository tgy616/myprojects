package com.tgy.serviceorderfeign.error;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.tgy.serviceorderfeign.servie.MemberFeign;
import org.springframework.stereotype.Component;


@Component
public class MemberFeignService implements MemberFeign {

	public List<String> getOrderByUserList() {
		List<String> listUser = new ArrayList<String>();
		listUser.add("not orderUser list");
		return listUser;
	}

}
