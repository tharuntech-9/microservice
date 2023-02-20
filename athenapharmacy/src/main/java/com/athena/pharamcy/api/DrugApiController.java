package com.athena.pharamcy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athena.pharamcy.dto.DrugDetailsDto;
import com.athena.pharamcy.service.DrugService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/drug")
@AllArgsConstructor
public class DrugApiController {
	@Autowired
	private final DrugService drugService;

	@GetMapping(value = "/{drugName}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DrugDetailsDto> findDrugs(@PathVariable("drugName") String drugName) {
		return drugService.findDrugs(drugName);
	}
}
