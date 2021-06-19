package com.mathpar.plans.entities;

import com.mathpar.plans.utils.enums.SubPlanType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name = "sub_plans_table")
public class SubPlan implements Serializable {
    @Id
    @Column(name = "sub_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "types")
    private SubPlanType types;

    // for exam only (in seconds)
    @Column(name = "time_to_complete")
    private int timeToComplete;

    // to understand ordering of things in head plan
    @Column(name = "orders")
    private int orders;

    @ManyToOne
    @JoinColumn(name = "head_id")
    private HeadPlan head_plan_var;

    public SubPlan(String name, SubPlanType type, int order, HeadPlan headPlan) {
        this.name = name;
        this.types = type;
        this.orders = order;
        this.head_plan_var = headPlan;
    }

    public SubPlan(String name, SubPlanType type, int order, HeadPlan headPlan, int timeToComplete) {
        this.name = name;
        this.types = type;
        this.orders = order;
        this.head_plan_var = headPlan;
        if (this.types == SubPlanType.Exam) {
            this.timeToComplete = timeToComplete;
        }
    }
}
