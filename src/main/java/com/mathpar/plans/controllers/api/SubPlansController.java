package com.mathpar.plans.controllers.api;

import com.mathpar.plans.entities.HeadPlan;
import com.mathpar.plans.entities.SubPlan;
import com.mathpar.plans.services.HeadPlanService;
import com.mathpar.plans.services.SubPlanService;
import com.mathpar.plans.utils.PublicApi;
import com.mathpar.plans.utils.dto.SubPlanPayload;
import com.mathpar.plans.utils.dto.payloads.CreateHeadPlanPayload;
import com.mathpar.plans.utils.enums.SubPlanType;
import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The type Sub plans controller.
 */
@RestController
@PublicApi
@Api(tags = "SubPlan")
public class SubPlansController {
    private final SubPlanService subPlanService;
    private final HeadPlanService headPlanService;

    /**
     * Instantiates a new Sub plans controller.
     *
     * @param subPlanService the sub plan service
     * @param headPlanService
     */
    public SubPlansController(SubPlanService subPlanService, HeadPlanService headPlanService) {
        this.subPlanService = subPlanService;
        this.headPlanService = headPlanService;
    }

    /**
     * Create sub plan .
     *
     * @param payload   the payload
     * @param userAgent the user agent
     * @return the sub plan
     */
    @PostMapping("sub-plan")
    public SubPlan createSubPlan(@RequestBody SubPlanPayload payload, @RequestHeader("user-agent") String userAgent) throws Exception{

        HeadPlan sb = headPlanService.getHeadPlanById(payload.getHead_id());
        return subPlanService.createSubPlan(payload.getSubplanName(), SubPlanType.valueOf(payload.getSubPlanType()),1 ,payload.getHead_id(), java.util.Optional.of(1), payload.getBody());

    }

    /**
     * Update sub plan.
     *
     * @param subPlanId the sub plan id
     * @param payload   the payload
     * @return the sub plan
     */
    @PutMapping("/sub-plan/update/{sub_plan_id}")
    public SubPlan updateSubPlan(@PathVariable("sub_plan_id") long subPlanId, @RequestBody CreateHeadPlanPayload payload) {
        SubPlan newSubPlan = subPlanService.getSubPlanById(subPlanId);
        if(newSubPlan == null)
            throw new EntityNotFoundException("HeadPlan with id " + subPlanId + " not found");
        newSubPlan.setName(payload.getHeadPlanName());
        return subPlanService.updateSubPlan(newSubPlan);
    }

    /**
     * Delete sub plan.
     *
     * @param subPlanId the sub plan id
     */
    @DeleteMapping("delete-subplan")
    public void deleteSubPlan(@RequestParam("subPlanId") long subPlanId) throws Exception{
        subPlanService.purgeSubPlanById(subPlanId);
    }

    @GetMapping("/getSubPlans")
    @ResponseBody
    public List<SubPlan> getAllPlans(@RequestParam("head_id") String head_id) {

        List<SubPlan> sp =  subPlanService.getAllwithHeadId(Integer.parseInt(head_id));
        if (sp.isEmpty()) return new ArrayList<>();
        System.out.println(sp.toString());
        return sp;
    }

}
