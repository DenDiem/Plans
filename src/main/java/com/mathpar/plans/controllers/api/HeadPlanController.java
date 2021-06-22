package com.mathpar.plans.controllers.api;

import com.mathpar.plans.entities.HeadPlan;
import com.mathpar.plans.services.HeadPlanService;
import com.mathpar.plans.utils.PublicApi;
import com.mathpar.plans.utils.dto.payloads.CreateHeadPlanPayload;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * The
 * Контролер для обробки запитів стосовно навчальних планів, що використовує сервіс HeadPlanService
 * @author Семенюк Христина
 */
@PublicApi
@RestController
@Api(tags = "HeadPlan")
@AllArgsConstructor
public class HeadPlanController {
    /**
     * Об'єкт сервіса HeadPlanService
     */
    private final HeadPlanService headPlanService;

    /**
     * Метод додавання нового навчального плану до БД
     * @param payload DTO плану
     * @return об'єкт HeadPlan, що відповідає новому запису у БД
     */
    @PostMapping("/head-plans/create")
    public HeadPlan createHeadPlan(@RequestBody CreateHeadPlanPayload payload,@RequestParam (value = "23", required = false) CreateHeadPlanPayload a ) {
        return headPlanService.createHeadPlan(payload.getHeadPlanName(), null, null);
    }

    /**
     * Метод оновлення навчального плану у БД. Якщо плану з вказаним id не існує, повертається EntityNotFoundException
     * @param headPlanId отримується з URL, id об'єкта HeadPlan, який треба оновити
     * @param payload DTO плану, що містить нові дані для об'єкта HeadPlan, який треба оновити
     * @return об'єкт HeadPlan, що відповідає оновленому запису у БД
     */
    @PutMapping("/head-plans/update/{head_plan_id}")
    public HeadPlan updateHeadPlan(@PathVariable("head_plan_id") long headPlanId, @RequestBody CreateHeadPlanPayload payload) {
        HeadPlan newHeadPlan = headPlanService.findHeadPlanById(headPlanId);
        if(newHeadPlan == null)
            throw new EntityNotFoundException("HeadPlan with id " + headPlanId + " not found");
        newHeadPlan.setName(payload.getHeadPlanName());
        return headPlanService.updateHeadPlan(newHeadPlan);
    }

    /**
     * Метод видалення навчального плану з БД. Якщо не існує запису в БД з вказаним id, нічого не видаляється
     * @param headPlanId отримується з URL, id об'єкта HeadPlan, який треба видалити
     */
    @DeleteMapping("/head-plans/delete/{head_plan_id}")
    public void deleteHeadPlan(@PathVariable(name = "head_plan_id") long headPlanId){
        headPlanService.purgeHeadPlanById(headPlanId);
    }

    /**
     * Метод для виведення всіх навчальних планів у БД
     * @return список усіх навчальних планів
     */
    @GetMapping("/getAllPlans")
    public List<HeadPlan> getAllPlans() {

        List<HeadPlan> hp =  headPlanService.findAll();
        System.out.println(hp.toString());
        return hp;
    }
}
