package edu.miu.cs.cs544.studentservice.controller;

import edu.miu.cs.cs544.studentservice.domain.CoursesRegistered;
import edu.miu.cs.cs544.studentservice.service.CourseRegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registered")
public class CourseRegistered {

    @Autowired
    CourseRegisteredService courseRegisteredService;

    @GetMapping("/all")
    public List<CoursesRegistered> getAllCourseRegistered(){
      return courseRegisteredService.getAllCourseRegistered();
    }

    @PostMapping("/create")
    public void createCoursesRegistered(CoursesRegistered coursesRegistered){
        courseRegisteredService.createCoursesRegistered(coursesRegistered);

    }

    @DeleteMapping("/delete/{id}")
   public void deleteCoursesRegistered(@PathVariable Long id){
        courseRegisteredService.deleteCoursesRegistered(id);

   }

   @PutMapping("/Update")
   public void updateById(@PathVariable Long id, @RequestBody CoursesRegistered coursesRegistered){
       courseRegisteredService.updateById(id, coursesRegistered);

   }
}
