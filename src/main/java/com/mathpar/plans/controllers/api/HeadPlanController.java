package com.mathpar.plans.controllers.api;

import com.mathpar.plans.entities.HeadPlan;
import com.mathpar.plans.services.HeadPlanService;
import com.mathpar.plans.utils.PublicApi;
import com.mathpar.plans.utils.dto.payloads.CreateHeadPlanPayload;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@PublicApi
@RestController
@Api(tags = "HeadPlan")
@AllArgsConstructor
public class HeadPlanController {
    private final HeadPlanService headPlanService;

    @PostMapping("/head-plans/create")
    public HeadPlan createHeadPlan(@RequestBody CreateHeadPlanPayload payload) {
        return headPlanService.createHeadPlan(payload.getHeadPlanName(), null, null);
    }

    @PutMapping("/head-plans/update/{head_plan_id}")
    public HeadPlan updateHeadPlan(@PathVariable("head_plan_id") long headPlanId, @RequestBody CreateHeadPlanPayload payload) {
        HeadPlan newHeadPlan = headPlanService.findHeadPlanById(headPlanId);
        if(newHeadPlan == null)
            throw new EntityNotFoundException("HeadPlan with id " + headPlanId + " not found");
        newHeadPlan.setName(payload.getHeadPlanName());
        return headPlanService.updateHeadPlan(newHeadPlan);
    }

    @DeleteMapping("/head-plans/delete/{head_plan_id}")
    public void deleteHeadPlan(@PathVariable(name = "head_plan_id") long headPlanId){
        headPlanService.purgeHeadPlanById(headPlanId);
    }
}
