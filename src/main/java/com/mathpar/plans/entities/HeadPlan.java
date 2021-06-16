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

/**
 * Клас сутності учбового плану
 * @author Василенко Олександр
 */
@Data
@NoArgsConstructor
@Entity(name = "head_plans_table")
public class HeadPlan implements Serializable {
    /**
     * Унікальний ідентифікатор
     */
    @Id
    @Column(name = "head_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long head_id;

    /**
     * Назва учбового плану
     */
    @Column(name = "name")
    private String name;

    /**
     * Дата і час початку
     */
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    /**
     * Дата і час завершення
     */
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    /**
     * Дата і час створення плану
     */
    @CreationTimestamp
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    /**
     * Дата і час останнього оновлення плану
     */
    @UpdateTimestamp
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    /**
     * Зв'язок один до багатьох з пунктами плану
     */
    @OneToMany(mappedBy = "head_plan_var", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubPlan> subPlans_vars;

    /**
     * Конструктор для створення учбового плану
     * @param name Назва учбового плану
     * @param startDate Дата і час початку
     * @param endDate Дата і час завершення
     */
    public HeadPlan(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subPlans_vars = new ArrayList<>();
    }

    /**
     * Конструктор для створення учбового плану з списком пунктів
     * @param name Назва учбового плану
     * @param startDate Дата і час початку
     * @param endDate Дата і час завершення
     * @param subPlans список пунктів плану
     */
    public HeadPlan(String name, Date startDate, Date endDate, List<SubPlan> subPlans){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subPlans_vars = subPlans;
    }
}
