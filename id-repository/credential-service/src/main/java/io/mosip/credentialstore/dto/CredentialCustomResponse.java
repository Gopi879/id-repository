package io.mosip.credentialstore.dto;

import io.mosip.idrepository.core.dto.CredentialServiceResponseDto;
import io.mosip.kernel.core.websub.model.EventModel;
import lombok.Data;

@Data
public class CredentialCustomResponse {

    public CredentialServiceResponseDto resDto;

    public EventModel event;
}
