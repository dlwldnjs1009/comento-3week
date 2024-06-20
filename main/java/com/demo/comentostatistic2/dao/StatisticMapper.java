package com.demo.comentostatistic2.dao;

import com.demo.comentostatistic2.dto.DepartmentLoginCountDto;
import com.demo.comentostatistic2.dto.HolidayInfoDto;
import com.demo.comentostatistic2.dto.LoginCountDto;
import com.demo.comentostatistic2.dto.YearCountDto;
import com.demo.comentostatistic2.dto.YearMonthCountDto;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);

    YearMonthCountDto selectYearMonthLogin(String yearMonth);

    List<LoginCountDto> selectMonthlyLogins();

    List<LoginCountDto> selectDailyLogins();

    int selectAverageDailyLogins();

    List<String> getLoginsByYearMonth(Map<String, Object> params);

    List<HolidayInfoDto> selectHolidaysByYearMonth(Map<String, Object> params);

    List<DepartmentLoginCountDto> selectMonthlyLoginsByDepartment(String department);
}
