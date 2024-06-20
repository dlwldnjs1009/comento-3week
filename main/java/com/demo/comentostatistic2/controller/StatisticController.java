package com.demo.comentostatistic2.controller;

import com.demo.comentostatistic2.dto.DepartmentLoginCountDto;
import com.demo.comentostatistic2.dto.LoginCountDto;
import com.demo.comentostatistic2.dto.YearCountDto;
import com.demo.comentostatistic2.service.StatisticService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){

        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    @GetMapping("api/v1/monthly-logins")
    public ResponseEntity<List<LoginCountDto>> getMonthlyLogins() {
        return ResponseEntity.ok(statisticService.getMonthlyLogins());
    }

    @GetMapping("api/v1/daily-logins")
    public ResponseEntity<List<LoginCountDto>> getDailyLogins() {
        return ResponseEntity.ok(statisticService.getDailyLogins());
    }

    @GetMapping("api/v1/average-daily-logins")
    public ResponseEntity<Integer> getAverageDailyLogins() {
        return ResponseEntity.ok(statisticService.getAverageDailyLogins());
    }

    @GetMapping("api/v1/logins-excluding-holidays/{year}/{month}")
    public ResponseEntity<Integer> getLoginsExcludingHolidays(@PathVariable int year, @PathVariable int month) {
        int loginCount = statisticService.getLoginsExcludingHolidays(year, month);
        return ResponseEntity.ok(loginCount);
    }

    @GetMapping("api/v1/monthly-logins-by-department/{department}")
    public ResponseEntity<List<DepartmentLoginCountDto>> getMonthlyLoginsByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(statisticService.getMonthlyLoginsByDepartment(department));
    }
}
