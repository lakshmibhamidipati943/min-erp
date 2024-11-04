package com.minerp.Admin.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.minerp.Admin.entity.Area;
import com.minerp.Admin.entity.City;
import com.minerp.Admin.entity.Country;
import com.minerp.Admin.entity.PaymentMode;
import com.minerp.Admin.entity.State;
import com.minerp.Admin.entity.Store;
import com.minerp.Admin.response.ServiceResponse;

public interface AdminService {

	ServiceResponse<Country> saveCountry(Country country);

	ServiceResponse<Country> getCountryById(Long id);

	ServiceResponse<State> saveState(State state);

	ServiceResponse<List<State>> getAllStates(Pageable pageable);

	ServiceResponse<List<State>> getStatesByCountryId(Long id, Pageable pageable);

	ServiceResponse<State> getStatesByStateId(Long id);

	ServiceResponse<City> saveCity(City city);

	ServiceResponse<City> getCityById(Long id);

	ServiceResponse<List<City>> getAllCities(Pageable pageable);

	ServiceResponse<List<City>> getCityByStateId(Long id, Pageable pageable);

	ServiceResponse<Area> saveArea(Area area);

	ServiceResponse<Area> getAreaById(Long id);

	ServiceResponse<List<Area>> getAllAreas(Pageable pageable);

	ServiceResponse<List<Area>> getAreasByCityId(Long id, Pageable pageable);

	ServiceResponse<Store> saveStore(Store store);

	ServiceResponse<Store> getStoreById(Long id);

	ServiceResponse<List<Store>> getAllStores(Pageable pageable);

	ServiceResponse<List<Store>> getStoresByPincode(String pincode, Pageable pageable);

	ServiceResponse<List<Store>> getStoresByAreaId(Long id, Pageable pageable);

	ServiceResponse<List<PaymentMode>> getAllPaymentModes(Pageable pageable);

}
