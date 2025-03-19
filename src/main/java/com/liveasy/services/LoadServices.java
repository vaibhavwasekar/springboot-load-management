package com.liveasy.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.liveasy.entities.Load;

public interface LoadServices {

	Load  saveLoad(Load load);

	List<Load> getAllLoad();

	Load getLoad(UUID loadId);

	 Load updateLoad(UUID loadId, Load load);

	 void deleteLoad(UUID loadId);

	 List<Load> getFilteredLoads(Optional<String> shipperId,
             Optional<String> truckType,
             Optional<String> productType,
             Optional<String> loadingPoint,
             Optional<String> unloadingPoint);
}
