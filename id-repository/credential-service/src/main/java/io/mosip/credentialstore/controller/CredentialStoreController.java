package io.mosip.credentialstore.controller;

import io.mosip.credentialstore.dto.CredentialCustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.mosip.credentialstore.dto.CredentialTypeResponse;
import io.mosip.credentialstore.service.CredentialStoreService;
import io.mosip.idrepository.core.dto.CredentialServiceRequestDto;
import io.mosip.idrepository.core.dto.CredentialServiceResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

/**
 * The Class CredentialStoreController.
 * 
 * @author Sowmya
 */
@RestController
@Api(tags = "Credential Store")
public class CredentialStoreController {

	/** The credential store service. */
	@Autowired
	private CredentialStoreService credentialStoreService;


	/**
	 * Credential issue.
	 *
	 * @param credentialServiceRequestDto the credential service request dto
	 * @return the response entity
	 */
	@PreAuthorize("hasAnyRole('CREDENTIAL_ISSUANCE')")
	@PostMapping(path = "/issue", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "create credential", response = CredentialServiceResponseDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "create credential successfully"),
			@ApiResponse(code = 400, message = "Unable to create credential ") })
	public ResponseEntity<Object> credentialIssue(
			@RequestBody(required = true) CredentialServiceRequestDto credentialServiceRequestDto, @RequestParam(required = false) String api) {

		CredentialCustomResponse response;

		if(api == null || api.isEmpty()) {
			response = credentialStoreService
					.createCredentialIssuance(credentialServiceRequestDto, api);
//			System.out.println("CredentialServiceResponseDto response : "+ response.getResDto());
			return ResponseEntity.status(HttpStatus.OK).body(response.getResDto());
		}else{
			response =  credentialStoreService
					.createCredentialIssuance(credentialServiceRequestDto, api);
//			System.out.println("CredentialServiceResponseDto response : "+ response.getResDto());
//			System.out.println("EventModel response : "+ response.getEvent());

			return ResponseEntity.status(HttpStatus.OK).body(response);
		}




	}


	@GetMapping(path = "/types", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get the credential types", response = CredentialTypeResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "get the credential types successfully"),
			@ApiResponse(code = 400, message = "Unable get the credential types"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ResponseBody
	public ResponseEntity<Object> getCredentialTypes() {

		CredentialTypeResponse credentialTypeResponse = null;

		credentialTypeResponse = credentialStoreService.getCredentialTypes();

		return ResponseEntity.status(HttpStatus.OK).body(credentialTypeResponse);
	}

}
