package com.mathpar.plans.services;

import com.mathpar.plans.entities.HeadPlan;
import com.mathpar.plans.repositories.HeadPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HeadPlanService {

    @Autowired
    private HeadPlanRepository headPlanRepository;

    public HeadPlan getHeadPlanById(long headPlanId){
        return headPlanRepository.getById(headPlanId);
    }

    public HeadPlan findHeadPlanById(long headPlanId) {
        Optional<HeadPlan> optional = headPlanRepository.findById(headPlanId);
        return optional.orElse(null);
    }

    public HeadPlan createHeadPlan(String name, Date startDate, Date endDate){
        return headPlanRepository.save(new HeadPlan(name, startDate, endDate));
    }

    public HeadPlan updateHeadPlan(HeadPlan headPlan){
        return headPlanRepository.save(headPlan);
    }

    @Transactional
    public void purgeHeadPlanById(long headPlanId){
        HeadPlan headPlan = findHeadPlanById(headPlanId);
        if (headPlan != null) {
            headPlanRepository.deleteById(headPlanId);
        }
    }

    public List<HeadPlan> findAll() {
       return headPlanRepository.findAll();
    }
}
