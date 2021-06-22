package com.mathpar.plans.utils.dto.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object для навчального плану
 * @author Семенюк Христина
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateHeadPlanPayload {
    /**
     * Назва навчального плану
     */
    private String headPlanName;
}
