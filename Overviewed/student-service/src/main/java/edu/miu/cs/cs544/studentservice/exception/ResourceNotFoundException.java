package edu.miu.cs.cs544.studentservice.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Integer id){
        super("Resource id not found : " + id);
    }
}
