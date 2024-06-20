package com.demo.comentostatistic2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentLoginCountDto {
    private String period;
    private int count;
    private String departmentName;

}
