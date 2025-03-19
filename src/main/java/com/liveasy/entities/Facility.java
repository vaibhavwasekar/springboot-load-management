package com.liveasy.entities;



import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Facility {


    private String loadingPoint;
    private String unloadingPoint;
    @Column(columnDefinition = "timestamp(6)")
    private Timestamp loadingDate;
    @Column(columnDefinition = "timestamp(6)")
    private Timestamp unloadingDate;

}
