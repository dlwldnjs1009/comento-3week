package com.demo.comentostatistic2.service;

import com.demo.comentostatistic2.dao.StatisticMapper;
import com.demo.comentostatistic2.dto.DepartmentLoginCountDto;
import com.demo.comentostatistic2.dto.HolidayInfoDto;
import com.demo.comentostatistic2.dto.LoginCountDto;
import com.demo.comentostatistic2.dto.YearCountDto;
import com.demo.comentostatistic2.dto.YearMonthCountDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }

    public List<LoginCountDto> getMonthlyLogins() {
        return statisticMapper.selectMonthlyLogins();
    }

    public List<LoginCountDto> getDailyLogins() {
        return statisticMapper.selectDailyLogins();
    }

    public int getAverageDailyLogins() {
        return statisticMapper.selectAverageDailyLogins();
    }

    public int getLoginsExcludingHolidays(int year, int month) {
        String yearMonth = String.format("%04d%02d", year, month);
        Map<String, Object> params = new HashMap<>();
        params.put("yearMonth", yearMonth);

        // 공휴일 정보 조회
        List<HolidayInfoDto> holidays = statisticMapper.selectHolidaysByYearMonth(params);
        Set<String> holidayDates = holidays.stream()
                .map(h -> String.valueOf(h.getLocdate()))
                .collect(Collectors.toSet());

        // 해당 년월의 모든 로그인 날짜 조회
        List<String> logins = statisticMapper.getLoginsByYearMonth(params);
        int loginCount = 0;

        for (String loginDate : logins) {
            if (!holidayDates.contains(loginDate)) {
                loginCount++;
            }
        }
        return loginCount;
    }

    public List<DepartmentLoginCountDto> getMonthlyLoginsByDepartment(String department) {
        return statisticMapper.selectMonthlyLoginsByDepartment(department);
    }
}
