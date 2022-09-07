package org.magm.backend.integration.cli1.controllers;

import org.magm.backend.controllers.BaseRestController;
import org.magm.backend.controllers.Constants;
import org.magm.backend.integration.cli1.model.ProductCli1;
import org.magm.backend.integration.cli1.model.business.IProductCli1Business;
import org.magm.backend.model.business.BusinessException;
import org.magm.backend.model.business.FoundException;
import org.magm.backend.model.business.NotFoundException;
import org.magm.backend.util.IStandartResponseBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile({"cli1","mysqldev"})
@RestController
@RequestMapping(Constants.URL_INTEGRATION_CLI1 + "/products")
public class ProductCli1RestController extends BaseRestController {

	@Autowired
	private IProductCli1Business productBusiness;

	@Autowired
	private IStandartResponseBusiness response;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list() {
		try {
			return new ResponseEntity<>(productBusiness.list(), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(response.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{codCli1}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loadByCode(@PathVariable("codCli1") String codCli1) {
		try {
			return new ResponseEntity<>(productBusiness.load(codCli1), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(response.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(response.build(HttpStatus.NOT_FOUND, e, e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "")
	public ResponseEntity<?> add(@RequestBody ProductCli1 product) {
		try {
			ProductCli1 response = productBusiness.add(product);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constants.URL_INTEGRATION_CLI1 + "/products/" + response.getCodCli1());
			return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity<>(response.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (FoundException e) {
			return new ResponseEntity<>(response.build(HttpStatus.FOUND, e, e.getMessage()), HttpStatus.FOUND);
		}
	}
	
	@PostMapping(value = "/b2b")
	public ResponseEntity<?> addExternal(HttpEntity<String> httpEntity) {
		try {
			ProductCli1 response = productBusiness.addExternal(httpEntity.getBody());
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constants.URL_INTEGRATION_CLI1 + "/products/" + response.getCodCli1());
			return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity<>(response.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (FoundException e) {
			return new ResponseEntity<>(response.build(HttpStatus.FOUND, e, e.getMessage()), HttpStatus.FOUND);
		}
	}


}
