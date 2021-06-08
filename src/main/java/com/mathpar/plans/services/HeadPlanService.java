package com.mathpar.plans.services;

import com.mathpar.plans.entities.HeadPlan;
import com.mathpar.plans.repositories.HeadPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Date;

public class HeadPlanService {

    @Autowired
    private HeadPlanRepository headPlanRepository;

    public HeadPlan getHeadPlanById(long headPlanId){
        return headPlanRepository.getById(headPlanId);
    }

    public HeadPlan createHeadPlan(String name, Date startDate, Date endDate){
        return headPlanRepository.save(new HeadPlan(name, startDate, endDate));
    }

    public HeadPlan updateHeadPlan(HeadPlan headPlan){
        return headPlanRepository.save(headPlan);
    }

    @Transactional
    public void purgeHeadPlanById(long headPlanId){
        headPlanRepository.deleteById(headPlanId);
    }
}
