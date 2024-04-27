package main.controllers;

import main.dtos.IssueTokenRequestDTO;
import main.dtos.IssueTokenResponseDTO;
import main.models.RequestStatus;
import main.models.Token;
import main.services.TokenService;

public class TokenController {
    // DTO : Data Transfer Object
    private TokenService tokenService;
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    public IssueTokenResponseDTO issueToken(IssueTokenRequestDTO issueTokenRequestDTO){
        // call the service
        IssueTokenResponseDTO issueTokenResponseDTO = new IssueTokenResponseDTO();
        try{
            Token token = tokenService.issueToken(issueTokenRequestDTO.getGetId(),
                    issueTokenRequestDTO.getVecihleNumber(),
                    issueTokenRequestDTO.getOwnerName(),
                    issueTokenRequestDTO.getVehicleType()
            );
            issueTokenResponseDTO.setToken(token);
            issueTokenResponseDTO.setRequestStatus(RequestStatus.SUCCESS);

        }catch(Exception e){
            issueTokenResponseDTO.setRequestStatus(RequestStatus.FAILURE);
            issueTokenResponseDTO.setFailureMessage(e.getMessage());
        }
        return issueTokenResponseDTO;
    }
}
