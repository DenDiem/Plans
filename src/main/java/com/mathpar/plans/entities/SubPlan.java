package com.mathpar.plans.entities;

import com.mathpar.plans.utils.enums.SubPlanType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity(name = "sub_plans_table")
public class SubPlan implements Serializable {
    @Id
    @Column(name = "sub_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sub_id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "types")
    private SubPlanType types;

    // for exam only (in seconds)
    @Column(name = "time_to_complete")
    private int timeToComplete;

    @Column(name = "plan_content")
    private String content;

    // to understand ordering of things in head plan
    @Column(name = "orders")
    private int orders;


    @Column(name = "head_id")
    private int head_plan_var;

    public SubPlan(String name, SubPlanType type, int order, int headPlan,String content) {
        this.name = name;
        this.types = type;
        this.orders = order;
        this.head_plan_var = headPlan;
        this.content = content;
    }


    public SubPlan(String name, SubPlanType type, int order, int headPlan, int timeToComplete,String content) {
        this.name = name;
        this.types = type;
        this.orders = order;
        this.content = content;
        this.head_plan_var = headPlan;
        if (this.types == SubPlanType.Exam) {
            this.timeToComplete = timeToComplete;
        }
    }


}
