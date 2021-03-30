package com.lucas.butcher.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Open_time")
public class OpenTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @ManyToOne
    @JoinColumn(name = "Schedule_id")
    @JsonIgnore
    private Schedule schedule;

    public OpenTime() {

    }

}
