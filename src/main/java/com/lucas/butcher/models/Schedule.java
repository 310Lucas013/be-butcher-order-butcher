package com.lucas.butcher.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "week_number")
    private int weekNumber;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @OneToMany(mappedBy = "schedule", targetEntity = OpenTime.class)
    private List<OpenTime> openTimes;
    @ManyToOne
    @JoinColumn(name = "butcher_id")
    @JsonIgnore
    private Butcher butcher;

    public Schedule() {

    }
}
