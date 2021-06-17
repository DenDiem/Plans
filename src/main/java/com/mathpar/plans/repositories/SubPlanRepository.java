package com.mathpar.plans.repositories;

import com.mathpar.plans.entities.SubPlan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepostiry для роботи з таблицею пунктів учбових планів у БД
 * @author Максим Рєпкін
 */
public interface SubPlanRepository extends JpaRepository<SubPlan, Long> {
}
