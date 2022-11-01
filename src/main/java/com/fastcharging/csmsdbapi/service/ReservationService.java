package com.fastcharging.csmsdbapi.service;

import java.util.List;
import java.util.Map;

public interface ReservationService {
	List<Map<String,Object>> getReservationByIdTag(String idTag);
}
