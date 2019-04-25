package com.tgy.clouddisk.service;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public interface AttendanceService {
    void activeUser(long userId, String dateKey);

    boolean isActiveUser(long userId, String dateKey);

    long totalCountUsers(String dateKey);

    List<Long> activeUserIds(String dateKey);

    List<Long> continueActiveUserCount(String... dateKeys);
}
