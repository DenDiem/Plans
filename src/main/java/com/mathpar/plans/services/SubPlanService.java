package com.mathpar.plans.services;


import com.mathpar.plans.entities.SubPlan;
import com.mathpar.plans.repositories.SubPlanRepository;
import com.mathpar.plans.utils.enums.SubPlanType;
import com.mathpar.plans.entities.HeadPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubPlanService {

    @Autowired
    private SubPlanRepository subPlanRepository;

    public SubPlan getSubPlanById(long subPlanId){
        return subPlanRepository.getById(subPlanId);
    }

    public SubPlan createSubPlan(String name, SubPlanType type, int order, int headPlan, Optional<Integer> timeToComplete, String content){
        SubPlan newSubPlan = new SubPlan(name, type, order, headPlan,content);
        timeToComplete.ifPresent(newSubPlan::setTimeToComplete);
        return subPlanRepository.saveAndFlush(newSubPlan);
    }
    public List<SubPlan> getAllwithHeadId (Integer head_id){
        List<SubPlan> all = subPlanRepository.findAll();
        List<SubPlan> result =new ArrayList<>();
        if (all.isEmpty()) return  result;

        for (SubPlan sp:  all
             ) {
            if(Integer.valueOf(sp.getHead_plan_var()).equals(head_id))
            result.add(sp);
        }
        return result;
    }
    public SubPlan updateSubPlan(SubPlan subPlan){
        return subPlanRepository.save(subPlan);
    }

    @Transactional
    public void purgeSubPlanById(long headPlanId){
        subPlanRepository.deleteById(headPlanId);
    }


}
