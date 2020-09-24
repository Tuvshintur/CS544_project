package com.edu.miu.cs544.tminstructor;

import com.edu.miu.cs544.tminstructor.model.TmAttendance;
import com.edu.miu.cs544.tminstructor.model.TmRecord;
import com.edu.miu.cs544.tminstructor.repository.TmAttendanceRepository;
import com.edu.miu.cs544.tminstructor.repository.TmRecordRepository;
import com.edu.miu.cs544.tminstructor.service.TmRecordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class TMinstructorMsApplicationTests {
	@Autowired
	private ApplicationContext context;

	@Autowired
	private TmRecordService tmRecordService;

	@Autowired
	private TmRecordRepository tmRecordRepository;

	@Autowired
	private TmAttendanceRepository tmAttendanceRepository;

	@Test
	public void testTmRecord() {
		Assertions.assertTrue(context.getBean(TmRecord.class) == null);
	}

	@Test
	public void testTmAttendance() {
		Assertions.assertTrue(context.getBean(TmAttendance.class) == null);
	}

	@Test
	public void testRecordService(){
		Assertions.assertEquals(0,tmRecordRepository.findAll().size());
	}

	@Test
	public void testAttendanceService(){
		Assertions.assertEquals(0,tmAttendanceRepository.findAll().size());
	}
}
