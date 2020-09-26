package sample.project.studentservice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.project.studentservice.project.domain.Attendance;
import sample.project.studentservice.project.repository.AttendanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements  AttendanceService{

    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public void createAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAddress(Long id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public Attendance updateAttendanceById(Long id, Attendance editedattendance) {

        Optional<Attendance> attendanceOld = attendanceRepository.findById(id);
        if(attendanceOld.isPresent()) {
         editedattendance.setId(attendanceOld.get().getId());
            return attendanceRepository.save(editedattendance);
        } else {
            //	Insert for new recored
            return attendanceRepository.save(editedattendance);


        }
    }

    @Override
    public Optional<Attendance> getAttendanceBayId(Long id) {
        return attendanceRepository.findById(id);
    }


}
