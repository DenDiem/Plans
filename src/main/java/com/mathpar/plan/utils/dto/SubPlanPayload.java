package com.mathpar.plan.utils.dto;

import com.mathpar.plan.utils.enums.SubPlanType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubPlanPayload {
    private String subplanName;
    private SubPlanType subplanType;
    private int order;
    Optional<Integer> timeToCompl;

}
