package com.mathpar.plans.controllers.api;

import com.mathpar.plans.entities.HeadPlan;
import com.mathpar.plans.services.SubPlanService;
import com.mathpar.plans.utils.PublicApi;
import com.mathpar.plans.utils.dto.SubPlanPayload;
import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.*;


@RestController
@PublicApi
@Api(tags = "SubPlan")
public class SubPlansController {
    private final SubPlanService subPlanService;

    public SubPlansController(SubPlanService subPlanService) {
        this.subPlanService = subPlanService;
    }

    @PostMapping("create-subplan")
    public String createSubPlan(@RequestBody SubPlanPayload payload, @RequestHeader("user-agent") String userAgent){
        HeadPlan headPlan = new HeadPlan();
        var account = subPlanService.createSubPlan(payload.getSubplanName(), payload.getSubplanType(),1 ,headPlan, java.util.Optional.of(1));
        return "OK";
    }

    @DeleteMapping("delete-subplan")
    public void deleteAccount(@RequestParam("subPlanId") long subPlanId){
        subPlanService.purgeSubPlanById(subPlanId);
    }
}
