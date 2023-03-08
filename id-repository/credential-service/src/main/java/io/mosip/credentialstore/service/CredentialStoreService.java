package io.mosip.credentialstore.service;

import io.mosip.credentialstore.dto.CredentialCustomResponse;
import org.springframework.stereotype.Service;

import io.mosip.credentialstore.dto.CredentialTypeResponse;
import io.mosip.idrepository.core.dto.CredentialServiceRequestDto;
import io.mosip.idrepository.core.dto.CredentialServiceResponseDto;

import java.util.List;


/**
 * The Interface CredentialStoreService.
 * 
 * @author Sowmya
 */
@Service
public interface CredentialStoreService {

	/**
	 * Creates the credential issuance.
	 *
	 * @param credentialServiceRequestDto the credential service request dto
	 * @return the string
	 */
	public CredentialCustomResponse createCredentialIssuance(
			CredentialServiceRequestDto credentialServiceRequestDto,String api);

	/**
	 * Gets the credential types.
	 *
	 * @return the credential types
	 */
	public CredentialTypeResponse getCredentialTypes();
}
