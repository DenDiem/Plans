package com.mathpar.plans.services;

import com.mathpar.plans.entities.HeadPlan;
import com.mathpar.plans.repositories.HeadPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Сервіс для здійснення операцій над учбовими планами, використовуючи доступ до БД через JPA Repository
 * @author Василенко Олександр
 */
@Service
public class HeadPlanService {

    @Autowired
    private HeadPlanRepository headPlanRepository;

    /**
     * Метод пошуку учбового палану за унікальним ідентифікатором
     * @param headPlanId id шуканого учбового плану
     * @return об'єкт HeadPlan, якщо учбовий план знайдено у БД, інакше - null
     */
    public HeadPlan findHeadPlanById(long headPlanId) {
        Optional<HeadPlan> optional = headPlanRepository.findById(headPlanId);
        return optional.orElse(null);
    }

    /**
     * Метод додавання нового учбового плану до БД
     * @param name назва плану
     * @param startDate дата і час початку курсу
     * @param endDate дата і час закінчення курсу
     * @return об'єкт HeadPlan, що відповідає новому запису у БД
     */
    public HeadPlan createHeadPlan(String name, Date startDate, Date endDate){
        return headPlanRepository.save(new HeadPlan(name, startDate, endDate));
    }

    /**
     * Метод оновлення учбового плану в БД. Якщо плану з вказаним id не існує, створюється новий запис у БД
     * @param headPlan об'єкт HeadPlan що відповідає запису у БД, який треба оновити
     * @return об'єкт HeadPlan, що відповідає оновленому/новому запису у БД
     */
    public HeadPlan updateHeadPlan(HeadPlan headPlan){
        return headPlanRepository.save(headPlan);
    }

    /**
     * Метод видалення учбового плану в БД. Якщо не існує запису в БД з вказаним id, нічого не видаляється
     * @param headPlanId id шуканого учбового плану
     */
    @Transactional
    public void purgeHeadPlanById(long headPlanId){
        HeadPlan headPlan = findHeadPlanById(headPlanId);
        if (headPlan != null) {
            headPlanRepository.deleteById(headPlanId);
        }
    }

    /**
     * Метод для знаходження всіх учбових планів у БД
     * @return список усіх учбових планів
     */
    public List<HeadPlan> findAll() {
       return headPlanRepository.findAll();
    }
}
