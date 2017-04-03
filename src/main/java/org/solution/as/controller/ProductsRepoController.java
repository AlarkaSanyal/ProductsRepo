package org.solution.as.controller;

import java.math.BigInteger;

import javax.validation.Valid;

import org.solution.as.Repository.PriceRepository;
import org.solution.as.common.Constants;
import org.solution.as.model.Price;
import org.solution.as.model.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductsRepoController {

	@Autowired
	private PriceRepository priceRepository;
	
	@RequestMapping(value="/v1/repo/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getPrice(@Valid @PathVariable("id") BigInteger id) {
		Price price = priceRepository.getPriceById(id);
		if (price == null) {
			return new ResponseEntity<ResponseBody>(new ResponseBody(Constants.NOT_FOUND), HttpStatus.OK);
		}
		return new ResponseEntity<ResponseBody>(new ResponseBody(price), HttpStatus.OK);
	}
	
	@RequestMapping(value="/v1/repo",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> updatePrice(@Valid @RequestBody Price price) {
		boolean updated = priceRepository.updatePriceById(price.getId(), price.getValue());
		if (!updated) {
			return new ResponseEntity<ResponseBody>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<ResponseBody>(HttpStatus.OK);
	}
}

