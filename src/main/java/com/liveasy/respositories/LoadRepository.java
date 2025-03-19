package com.liveasy.respositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.liveasy.entities.Load;

public interface LoadRepository extends JpaRepository<Load, UUID>{

	 @Query("SELECT l FROM Load l WHERE "
		        + "(:shipperId IS NULL OR l.shipperId = :shipperId) "
		        + "AND (:truckType IS NULL OR l.truckType = :truckType) "
		        + "AND (:productType IS NULL OR l.productType = :productType) "
		        + "AND (:loadingPoint IS NULL OR l.facility.loadingPoint = :loadingPoint) "
		        + "AND (:unloadingPoint IS NULL OR l.facility.unloadingPoint = :unloadingPoint)")
		    List<Load> findByFilters(
		        @Param("shipperId") String shipperId,
		        @Param("truckType") String truckType,
		        @Param("productType") String productType,
		        @Param("loadingPoint") String loadingPoint,
		        @Param("unloadingPoint") String unloadingPoint
		    );

}
