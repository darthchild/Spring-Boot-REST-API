package com.darthchild.linear.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long id;
    private String name;
    private String email;
    private Boolean isActive;
}
