package sample.project.studentservice.project.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Integer id){
        super("Resource id not found : " + id);
    }
}
