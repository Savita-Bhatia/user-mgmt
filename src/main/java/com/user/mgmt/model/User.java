package com.user.mgmt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @NotBlank(message = "FIELD_REQUIRED")
    private String socialSecurityNumber;
    @NotBlank(message = "FIELD_REQUIRED")
    private String name;
    @NotBlank(message = "FIELD_REQUIRED")
    private String spouseName;

    private Map<String,Integer> children;

}
