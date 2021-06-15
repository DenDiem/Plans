package com.mathpar.plans.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "head_plans_table")
public class HeadPlan implements Serializable {
    @Id
    @Column(name = "head_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long head_id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @CreationTimestamp
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @OneToMany(mappedBy = "head_plan_var", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubPlan> subPlans_vars;

    public HeadPlan(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subPlans_vars = new ArrayList<>();
    }

    public HeadPlan(String name, Date startDate, Date endDate, List<SubPlan> subPlans){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subPlans_vars = subPlans;
    }
}
