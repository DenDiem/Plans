package com.mathpar.plans.utils.dto;

import com.mathpar.plans.utils.enums.SubPlanType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubPlanPayload {
    private String subplanName;
    private String subPlanType;
    private int order;
    Optional<Integer> timeToCompl;
    private int head_id;
    private String body;

}
