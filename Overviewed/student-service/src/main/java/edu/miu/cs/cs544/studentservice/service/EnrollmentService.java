package edu.miu.cs.cs544.studentservice.service;

import edu.miu.cs.cs544.studentservice.domain.Enrollment;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EnrollmentService {

    public List<Enrollment> getAllEnrollments();

    public void createEnrollment(Enrollment enrollment);

    public void deleteEnrollment(Long id);

    public void updateById(@PathVariable Long id, Enrollment enrollment);
}
