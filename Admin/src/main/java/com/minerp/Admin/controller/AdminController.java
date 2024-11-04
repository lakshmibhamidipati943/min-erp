package com.minerp.Admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minerp.Admin.entity.Area;
import com.minerp.Admin.entity.City;
import com.minerp.Admin.entity.Country;
import com.minerp.Admin.entity.PaymentMode;
import com.minerp.Admin.entity.State;
import com.minerp.Admin.entity.Store;
import com.minerp.Admin.response.ServiceResponse;
import com.minerp.Admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	Pageable pageable= PageRequest.of(0, 10);
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/savecountry")
	public ResponseEntity<ServiceResponse<Country>> saveCountry(@RequestBody Country country, @RequestHeader("Authorization") String token){
        ServiceResponse<Country> response=adminService.saveCountry(country);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcountry/{id}")
	public ResponseEntity<ServiceResponse<Country>> getCountryById(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) {
		ServiceResponse<Country> response=adminService.getCountryById(id);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savestate")
	public ResponseEntity<ServiceResponse<State>> saveState(@RequestBody State state, @RequestHeader("Authorization") String token){
		ServiceResponse<State> response=adminService.saveState(state);
		return new ResponseEntity<>(response, response.getStatusCode());

	} 
	
	@GetMapping("/getstates")
	public ResponseEntity<ServiceResponse<List<State>>> getAllStates( @RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<State>> response=adminService.getAllStates(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstatesbycountryid/{id}")
	public ResponseEntity<ServiceResponse<List<State>>> getStatesByCountryId(@PathVariable("id") Long id, @RequestHeader("Authorization")String token, Pageable pageable){
		ServiceResponse<List<State>> response=adminService.getStatesByCountryId(id, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstates/{id}")
	public ResponseEntity<ServiceResponse<State>> getStateById(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) {
		ServiceResponse<State> response=adminService.getStatesByStateId(id);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savecity")
	public ResponseEntity<ServiceResponse<City>> saveCity(@RequestBody City city, @RequestHeader("Authorization") String token ){
		ServiceResponse<City> response=adminService.saveCity(city);
		return new ResponseEntity<>(response, response.getStatusCode());

	}
	
	@GetMapping("/getcities/{id}")
	public ResponseEntity<ServiceResponse<City>> getCityById(@PathVariable("id")Long id, @RequestHeader("Authorization") String token ){
		ServiceResponse<City> response=adminService.getCityById(id);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcities")
	public ResponseEntity<ServiceResponse<List<City>>> getAllCities(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<City>> response=adminService.getAllCities(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getcitiesbystateid/{id}")
	public ResponseEntity<ServiceResponse<List<City>>> getCitiesByStateId(@PathVariable("id") Long id,@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<City>> response=adminService.getCityByStateId(id, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savearea")
	public ResponseEntity<ServiceResponse<Area>> saveArea(@RequestBody Area area, @RequestHeader("Authorization") String token ){
		ServiceResponse<Area> response=adminService.saveArea(area);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getareas/{id}")
	public ResponseEntity<ServiceResponse<Area>> getAreaById(@PathVariable("id")Long id, @RequestHeader("Authorization") String token ){
		ServiceResponse<Area> response=adminService.getAreaById(id);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getareas")
	public ResponseEntity<ServiceResponse<List<Area>>> getAllAreas(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Area>> response=adminService.getAllAreas(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getareasbycityid/{id}")
	public ResponseEntity<ServiceResponse<List<Area>>> getAreasByCityId(@PathVariable("id") Long id,@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Area>> response=adminService.getAreasByCityId(id, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@PostMapping("/savestore")
	public ResponseEntity<ServiceResponse<Store>> saveStore(@RequestBody Store store, @RequestHeader("Authorization") String token ){
		ServiceResponse<Store> response=adminService.saveStore(store);
		return new ResponseEntity<>(response, response.getStatusCode());

	}
	
	@GetMapping("/getstores/{id}")
	public ResponseEntity<ServiceResponse<Store>> getStoreById(@PathVariable("id")Long id, @RequestHeader("Authorization") String token ){
		ServiceResponse<Store> response=adminService.getStoreById(id);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstores")
	public ResponseEntity<ServiceResponse<List<Store>>> getAllStores(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Store>> response=adminService.getAllStores(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstoresbyareaid/{id}")
	public ResponseEntity<ServiceResponse<List<Store>>> getStoresByAreaId(@PathVariable("id") Long id,@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<Store>> response=adminService.getStoresByAreaId(id, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/getstoresbypincode/{pincode}")
	public ResponseEntity<ServiceResponse<List<Store>>> getStoresByPincode(@PathVariable("pincode") String pincode, @RequestHeader("Authorization") String token, Pageable pageable ){
		ServiceResponse<List<Store>> response=adminService.getStoresByPincode(pincode, pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
	
	@GetMapping("/paymentmodes")
	public ResponseEntity<ServiceResponse<List<PaymentMode>>> getAllPaymentModes(@RequestHeader("Authorization") String token, Pageable pageable){
		ServiceResponse<List<PaymentMode>> response=adminService.getAllPaymentModes(pageable);
		return new ResponseEntity<>(response, response.getStatusCode());
	}
}
