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

/**
 * Сервіс для здійснення операцій над підпунктами учбових планів, використовуючи доступ до БД через JPA Repository
 * @author Максим Рєпкін
 */
@Service
public class SubPlanService {

    @Autowired
    private SubPlanRepository subPlanRepository;

    /**
     * Метод пошуку пункту учбового палану за унікальним ідентифікатором
     * @param subPlanId id шуканого пункту учбового плану
     * @return об'єкт SubPlan, якщо пункт знайдено у БД, інакше - null
     */
    public SubPlan getSubPlanById(long subPlanId){
        return subPlanRepository.getById(subPlanId);
    }

<<<<<<< HEAD
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
=======
    /**
     * Метод створення нового пункту учбового плану в БД
     * @param name назва пункту
     * @param type тип пункту (SubPlanType: Lecture, Practice, Exam)
     * @param order порядковий номер в межах плану
     * @param headPlan учбовий план, якому належить
     * @param timeToComplete час, відведений на виконання
     * @return об'єкт SubPlan, що відповідає новому запису у БД
     */
    public SubPlan createSubPlan(String name, SubPlanType type, int order, HeadPlan headPlan, Optional<Integer> timeToComplete){
        SubPlan newSubPlan = new SubPlan(name, type, order, headPlan);
        timeToComplete.ifPresent(newSubPlan::setTimeToComplete);
        return subPlanRepository.saveAndFlush(newSubPlan);
    }

    /**
     * Метод оновлення пункту учбового плану в БД. Якщо пункту з вказаним id не існує, створюється новий запис у БД
     * @param subPlan об'єкт SubPlan що відповідає запису у БД, який треба оновити
     * @return об'єкт SubPlan, що відповідає оновленому/новому запису у БД
     */
>>>>>>> d42c9afd913080156fd913351f98a095bd8527bd
    public SubPlan updateSubPlan(SubPlan subPlan){
        return subPlanRepository.save(subPlan);
    }

    /**
     * Метод видалення пункту учбового плану в БД
     * @param headPlanId id шуканого пункту
     */
    @Transactional
    public void purgeSubPlanById(long headPlanId){
        subPlanRepository.deleteById(headPlanId);
    }


}
