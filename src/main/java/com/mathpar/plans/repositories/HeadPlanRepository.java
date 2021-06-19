package com.mathpar.plans.repositories;

import com.mathpar.plans.entities.HeadPlan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepostiry для роботи з таблицею учбових планів у БД
 * @author Василенко Олександр
 */
public interface HeadPlanRepository extends JpaRepository<HeadPlan, Long> {
}
