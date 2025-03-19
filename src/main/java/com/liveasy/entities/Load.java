package com.liveasy.entities;


import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "load")
public class Load {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID loadId;

    @Version  // Ensures optimistic locking is enabled
    private int version;

	@Embedded
	private Facility facility;

	private String productType;
	private String truckType;
	private int noofTrucks;
	private double weight;
	private String comment;
	private String shipperId;
	@CreationTimestamp
	private Timestamp date;
}
