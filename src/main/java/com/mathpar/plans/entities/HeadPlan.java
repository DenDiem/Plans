package com.mathpar.plans.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "head_plans")
public class HeadPlan implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "head_plans_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubPlan> subPlans;

    public HeadPlan(String name) {
        this.name = name;
        this.subPlans = new ArrayList<>();
    }

    public HeadPlan(String name, List<SubPlan> subPlans){
        this.name = name;
        this.subPlans = subPlans;
    }
}
