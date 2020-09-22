package miu.edu.cs.cs544.coachMS.service.utilities;

import miu.edu.cs.cs544.coachMS.DTO.IGeneralDTO;
import miu.edu.cs.cs544.coachMS.DTO.ResponseDTO;
import miu.edu.cs.cs544.coachMS.constants.Constants;

import java.util.List;

/**
 * Response Service @author Turuu
 */

public class ResponseService implements Constants {

    /**
     * DTO
     **/

    private IGeneralDTO dto;

    private List<IGeneralDTO> dtos;

    private ResponseDTO responseDTO;

    /**
     * Constructor
     **/

    public ResponseService(int code, String message, IGeneralDTO contentDTO) {
        this.getResponseDTO().getHeader().setCode(code);
        this.getResponseDTO().getHeader().setStatus(code == 200 ? Status.SUCCESS : Status.FAILED);
        this.getResponseDTO().getHeader().setMessage(message);
        dto = contentDTO;
    }

    /**
     * Getter.Setter
     **/

    public ResponseDTO getResponse() {
        this.getResponseDTO().getBody().setResponse(dto);
        return this.getResponseDTO();
    }

    public ResponseDTO getError() {
        this.getResponseDTO().getBody().setError(dto);
        return this.getResponseDTO();
    }

    public ResponseDTO getSuccess() {
        this.getResponseDTO().getBody().setSuccess(dto);
        return this.getResponseDTO();
    }

    private ResponseDTO getResponseDTO() {
        return responseDTO != null ? this.responseDTO : (this.responseDTO = new ResponseDTO());
    }

    private void setResponseDTO(ResponseDTO responseDTO) {
        this.responseDTO = responseDTO;
    }
}
