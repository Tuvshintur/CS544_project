package edu.miu.cs.cs544.tmservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Error DTO @author Turuu
 */

public class ErrorDTO implements IGeneralDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorDesc;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorType;

    /**
     * Constructor
     **/

    public ErrorDTO() {
        super();
    }

    public ErrorDTO(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorDTO(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public ErrorDTO(String errorCode, String errorDesc, String errorType) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.errorType = errorType;
    }

    /**
     * Getter.Setter
     **/

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}
