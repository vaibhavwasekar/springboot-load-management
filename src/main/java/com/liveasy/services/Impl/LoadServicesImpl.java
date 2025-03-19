package com.liveasy.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveasy.entities.Load;
import com.liveasy.exception.ResourceNotFoundException;
import com.liveasy.respositories.LoadRepository;
import com.liveasy.services.LoadServices;

import jakarta.transaction.Transactional;


@Service
public class LoadServicesImpl implements LoadServices{

	@Autowired
	private LoadRepository loadRepository;


	@Override

	public Load saveLoad(Load load) {
		load.setLoadId(null);
		return loadRepository.save(load);
	}

	@Override
	public List<Load> getAllLoad() {
		return loadRepository.findAll();
	}

	@Override
	public Load getLoad(UUID loadId) {
		return loadRepository.findById(loadId)
				.orElseThrow(()->new ResourceNotFoundException("Load with id"
		             +loadId+ "not found"));
	}

	@Override
	@Transactional
	public Load updateLoad(UUID loadId, Load load) {
		Load existingLoad = getLoad(loadId);
	    existingLoad.setFacility(load.getFacility());
	    existingLoad.setProductType(load.getProductType());
	    existingLoad.setTruckType(load.getTruckType());
	    existingLoad.setNoofTrucks(load.getNoofTrucks());
	    existingLoad.setWeight(load.getWeight());
	    existingLoad.setComment(load.getComment());
	    existingLoad.setShipperId(load.getShipperId());
	    existingLoad.setDate(load.getDate());
	    return loadRepository.save(existingLoad);
	}

	@Override
	public void deleteLoad(UUID loadId) {
		Load load=getLoad(loadId);
		loadRepository.delete(load);
	}

	@Override
	public List<Load> getFilteredLoads(
			Optional<String> shipperId, Optional<String> truckType,
			Optional<String> productType, Optional<String> loadingPoint,
			Optional<String> unloadingPoint) {

		  return loadRepository.findByFilters(shipperId.orElse(null),
				  truckType.orElse(null),
                  productType.orElse(null), loadingPoint.orElse(null),
                  unloadingPoint.orElse(null));
	}

}
