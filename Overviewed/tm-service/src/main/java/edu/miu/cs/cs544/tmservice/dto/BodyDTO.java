package edu.miu.cs.cs544.tmservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


public class BodyDTO implements IGeneralDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object response;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object success;

    /**
     * Constructor
     **/

    public BodyDTO() {
        super();
    }

    public BodyDTO(Object response) {
        this.response = response;
    }

    public BodyDTO(Object response, Object error) {
        this.response = response;
        this.error = error;
    }

    /**
     * Getter.Setter
     **/

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Object getSuccess() {
        return success;
    }

    public void setSuccess(Object success) {
        this.success = success;
    }
}