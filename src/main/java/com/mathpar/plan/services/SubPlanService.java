package com.mathpar.plan.services;

import com.mathpar.plan.entities.SubPlan;
import com.mathpar.plan.repositories.SubPlanRepository;
import com.mathpar.plan.utils.enums.SubPlanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SubPlanService {

    @Autowired
    private SubPlanRepository subPlanRepository;

    public SubPlan getSubPlanById(long subPlanId){
        return subPlanRepository.getById(subPlanId);
    }

    public SubPlan createSubPlan(String name, SubPlanType type, int order, Optional<Integer> timeToComplete){
        SubPlan newSubPlan = new SubPlan(name, type, order);
        timeToComplete.ifPresent(newSubPlan::setTimeToComplete);
        return subPlanRepository.save(newSubPlan);
    }

    public SubPlan updateSubPlan(SubPlan subPlan){
        return subPlanRepository.save(subPlan);
    }

    @Transactional
    public void purgeSubPlanById(long headPlanId){
        subPlanRepository.deleteById(headPlanId);
    }


}
