package com.tgy.demo.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * Timestamp to java.util.Date类型转换器
 * ClassName: TimestampConverter
 * Description:SpringData默认的时间类型是java.util.Date，而实体类中的时间类型是Timestamp，所以需要转换一下
 * @date 2017年4月12日
 */
public class TimestampConverter implements Converter<Date, Timestamp> {

	public Timestamp convert(Date date) {
		if (date != null) {
			return new Timestamp(date.getTime());
		}
		return null;
	}

}