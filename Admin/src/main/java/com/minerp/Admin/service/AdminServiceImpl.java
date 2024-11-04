package com.minerp.Admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.minerp.Admin.entity.Area;
import com.minerp.Admin.entity.City;
import com.minerp.Admin.entity.Country;
import com.minerp.Admin.entity.PaymentMode;
import com.minerp.Admin.entity.State;
import com.minerp.Admin.entity.Store;
import com.minerp.Admin.exception.InternalServerErrorException;
import com.minerp.Admin.exception.UnauthorizedException;
import com.minerp.Admin.repository.AreaRepository;
import com.minerp.Admin.repository.CityRepository;
import com.minerp.Admin.repository.CountryRepository;
import com.minerp.Admin.repository.PaymentModeRepository;
import com.minerp.Admin.repository.StateRepository;
import com.minerp.Admin.repository.StoreRepository;
import com.minerp.Admin.response.ServiceResponse;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private PaymentModeRepository paymentModeRepository;

	@Override
	public ServiceResponse<Country> saveCountry(Country country) {
		// TODO Auto-generated method stub
		if(countryRepository.existsByCountryname(country.getCountryName())) {
			throw new IllegalArgumentException("Country already exists");
		}
		try {
			Country savedCountry=countryRepository.save(country);

			return new ServiceResponse<Country>(
				HttpStatus.CREATED, "Country saved successfully",
				List.of(savedCountry),
				1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save country.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the country.");
		}
	}

	@Override
	public ServiceResponse<Country> getCountryById(Long id) {
		// TODO Auto-generated method stub
		try {
			Country country1=countryRepository.getCountryById(id);
			return new ServiceResponse<Country>(
					HttpStatus.CREATED, "Country retrieved successfully",
					List.of(country1),
					1L);
		}
		catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve country.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the country.");
		}
	}

	@Override
	public ServiceResponse<State> saveState(State state) {
		// TODO Auto-generated method stub
		try {
			State savedState=stateRepository.save(state);
			return new ServiceResponse<State>(
					HttpStatus.CREATED, "State saved successfully",
					List.of(savedState),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save state.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the state.");
		}
	}
	
	@Override
	public ServiceResponse<List<State>> getAllStates(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<State> states=stateRepository.getAllStates(pageable);
			ServiceResponse<List<State>> response= new ServiceResponse(
					HttpStatus.CREATED, "State retrieved successfully",
					states,
					(long) states.size());
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve states.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the states.");
		}		
	}

	@Override
	public ServiceResponse<List<State>> getStatesByCountryId(Long id, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<State> states=stateRepository.getAllStates(pageable);
			ServiceResponse<List<State>> response= new ServiceResponse(
					HttpStatus.CREATED, "State retrieved successfully",
					states,
					(long) states.size());
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve states.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the states.");
		}
	}

	@Override
	public ServiceResponse<State> getStatesByStateId(Long id) {
		// TODO Auto-generated method stub
		try {
			State state1=stateRepository.getStatesByStateId(id);
			return new ServiceResponse<State>(
					HttpStatus.CREATED, "State information successfully retrieved",
					List.of(state1),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve state.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the state.");
		}
	}

	@Override
	public ServiceResponse<City> saveCity(City city) {
		// TODO Auto-generated method stub
		try {
			City savedCity=cityRepository.save(city);
			return new ServiceResponse<City>(
					HttpStatus.CREATED,"City saved successfully",
					List.of(savedCity),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save city.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the city.");
		}
	}

	@Override
	public ServiceResponse<City> getCityById(Long id) {
		// TODO Auto-generated method stub
		try {
			City city1=cityRepository.getCityById(id);
			return new ServiceResponse<City>(
					HttpStatus.CREATED,"City saved successfully",
					List.of(city1),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save city.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the city.");
		}
	}

	@Override
	public ServiceResponse<List<City>> getAllCities(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<City> cities=cityRepository.getAllCities(pageable);
			ServiceResponse<List<City>> response=new ServiceResponse(
					HttpStatus.OK,
					"Cities returned successfylly",
					cities,
					(long) cities.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve cities.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the cities.");
		}
	}

	@Override
	public ServiceResponse<List<City>> getCityByStateId(Long id, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<City> cities=cityRepository.getCityByStateId(id, pageable);
			ServiceResponse<List<City>> response=new ServiceResponse(
					HttpStatus.OK,
					"Cities returned successfylly",
					cities,
					(long) cities.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve cities.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while returning the city.");
		}
	}

	@Override
	public ServiceResponse<Area> saveArea(Area area) {
		// TODO Auto-generated method stub
		try {
			Area savedArea=areaRepository.save(area);
			return new ServiceResponse<Area>(
					HttpStatus.CREATED, "Area saved successfully",
					List.of(savedArea),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save area.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the area.");
		}
	}

	@Override
	public ServiceResponse<Area> getAreaById(Long id) {
		// TODO Auto-generated method stub
		try {
			Area area1=areaRepository.getAreaById(id);
			return new ServiceResponse<Area>(
					HttpStatus.CREATED, "Area retrieved successfully",
					List.of(area1),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve area.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieve the area.");
		}
	}

	@Override
	public ServiceResponse<List<Area>> getAllAreas(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Area> areas=areaRepository.getAllAreas(pageable);
			ServiceResponse<List<Area>> response=new ServiceResponse(
					HttpStatus.OK,
					"Areas returned successfully",
					areas,
					(long) areas.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve area.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieve the area.");
		}
	}

	@Override
	public ServiceResponse<List<Area>> getAreasByCityId(Long id, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Area> areas=areaRepository.getAllAreas(pageable);
			ServiceResponse<List<Area>> response=new ServiceResponse(
					HttpStatus.OK,
					"Areas returned successfully",
					areas,
					(long) areas.size()
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve area.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieve the area.");
		}
	}

	@Override
	public ServiceResponse<Store> saveStore(Store store) {
		// TODO Auto-generated method stub
		try {
			Store savedStore=storeRepository.save(store);
			return new ServiceResponse<Store>(
					HttpStatus.OK,
					"Store saved successfully",
					List.of(savedStore),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to save store.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while saving the store.");
		}
	}

	@Override
	public ServiceResponse<Store> getStoreById(Long id) {
		// TODO Auto-generated method stub
		try {
			Store store1=storeRepository.getStoreById(id);
			return new ServiceResponse<Store>(
					HttpStatus.OK,
					"Store returned successfully",
					List.of(store1),
					1L);
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve store.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieve the store.");
		}
		
	}

	@Override
	public ServiceResponse<List<Store>> getAllStores(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
		List<Store> stores=storeRepository.getAllStores(pageable);
		ServiceResponse<List<Store>> response= new ServiceResponse(
				HttpStatus.OK,
				"Stores returned successfully",
				stores,
				(long) stores.size()
		);
		return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve store.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the store.");
		}
	}

	@Override
	public ServiceResponse<List<Store>> getStoresByPincode(String pincode, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Store> stores=storeRepository.getStoresByPincode(pincode, pageable);
			ServiceResponse<List<Store>> response=new ServiceResponse(
					HttpStatus.OK,
					"Stores returned successfully",
					stores,
					(long) stores.size()	
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve store.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the store.");
		}
	}

	@Override
	public ServiceResponse<List<Store>> getStoresByAreaId(Long id, Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<Store> stores=storeRepository.getStoresByAreaId(id, pageable);
			ServiceResponse<List<Store>> response=new ServiceResponse(
					HttpStatus.OK,
					"Stores returned successfully",
					stores,
					(long) stores.size()	
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve store.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the store.");
		}
	}

	@Override
	public ServiceResponse<List<PaymentMode>> getAllPaymentModes(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			List<PaymentMode> paymentModes=paymentModeRepository.getAllPaymentModes(pageable);
			ServiceResponse<List<PaymentMode>> response=new ServiceResponse(
					HttpStatus.OK,
					"PaymentModes returned successfully",
					paymentModes,
					(long) paymentModes.size()	
			);
			return response;
		}catch(UnauthorizedException e) {
			throw new UnauthorizedException("Unauthorized to retrieve paymentmodes.");
		}catch(Exception e) {
			throw new InternalServerErrorException("An unexpected error occurred while retrieving the paymentmodes.");
		}	
	}
}
