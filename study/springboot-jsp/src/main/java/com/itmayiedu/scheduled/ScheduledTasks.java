
package com.itmayiedu.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

//@Component
public class ScheduledTasks {

	@Scheduled(fixedRate = 2000)
	public void test() {
      // 执行任务调度方法
		System.out.println("我正在每隔2秒打印...");
	}

}
