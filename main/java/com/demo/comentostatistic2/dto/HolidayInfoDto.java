package com.demo.comentostatistic2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HolidayInfoDto {
    private int locdate;
    private String dateKind;
    private String dateName;
    private String isHoliday;
    private int seq;
}
