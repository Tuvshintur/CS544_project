package edu.miu.cs.cs544.MicroserviceProject.constants;

public interface Constants {

    interface Status {

        String SUCCESS = "success";

        String FAILED = "failed";

    }

    interface ErrorType {

        String RMI = "rmi";

        String RESTRICTION = "restriction";

        String NOT_FOUND = "not found";

        String VALIDATION = "validation";

        String UNKNOWN = "unknown";

    }

}
