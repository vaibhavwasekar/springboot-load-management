package com.liveasy.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liveasy.entities.Load;
import com.liveasy.exception.ResourceNotFoundException;
import com.liveasy.services.LoadServices;

@RestController
@RequestMapping("/load")
public class LoadController {

	@Autowired
	private LoadServices loadServices;

	//create
	@PostMapping
	public ResponseEntity<Load> createLoad(@RequestBody Load load)
	{
		Load load1=loadServices.saveLoad(load);

		return ResponseEntity.status(HttpStatus.CREATED).body(load1);
	}

	//getsingle
	@GetMapping("/{loadId}")
	public ResponseEntity<Load> getsingleLoad(@PathVariable UUID loadId)
	{
		Load load=loadServices.getLoad(loadId);
		return ResponseEntity.ok(load);
	}

	//all load
	@GetMapping
	public ResponseEntity<List<Load>> getfilterLoad(
			@RequestParam Optional<String> shipperId,
			@RequestParam Optional<String> truckType,
            @RequestParam Optional<String> productType,
            @RequestParam Optional<String> loadingPoint,
            @RequestParam Optional<String> unloadingPoint
			)
	{

		return ResponseEntity.ok(
				loadServices.getFilteredLoads(shipperId, truckType, productType, loadingPoint, unloadingPoint)
                                 );
	}


	//update
	@PutMapping("/{loadId}")
	public ResponseEntity<Load> updateLoad(@PathVariable UUID loadId,@RequestBody Load load)
	{
		 try {
	            Load updatedLoad = loadServices.updateLoad(loadId, load);
	            return ResponseEntity.ok(updatedLoad);
	        } catch (ResourceNotFoundException ex) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	}

	//delete
	@DeleteMapping("/{loadId}")
	public ResponseEntity<String> deleteLoad(@PathVariable UUID loadId)
	{
		try {
			loadServices.deleteLoad(loadId);
			return ResponseEntity.ok("load delted");
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("load not found");
		}

	}
}
