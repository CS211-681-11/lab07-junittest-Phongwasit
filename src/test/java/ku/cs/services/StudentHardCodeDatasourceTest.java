package ku.cs.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    @DisplayName("ทดสอบการอ่านข้อมูลจากลิสต์")
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        ku.cs.models.StudentList list = datasource.readData();
        assertEquals(4, list.getStudents().size());
        assertEquals("6710400001", list.getStudents().get(0).getId());
        assertEquals("First", list.getStudents().get(0).getName());
        assertEquals(0, list.getStudents().get(0).getScore());
        assertEquals("F", list.getStudents().get(0).getGrade());
        assertEquals("6710400002", list.getStudents().get(1).getId());
        assertEquals("Second", list.getStudents().get(1).getName());
        assertEquals(0, list.getStudents().get(1).getScore());
        assertEquals("F", list.getStudents().get(1).getGrade());
        assertEquals("6710400003", list.getStudents().get(2).getId());
        assertEquals("Third", list.getStudents().get(2).getName());
        assertEquals(0, list.getStudents().get(2).getScore());
        assertEquals("F", list.getStudents().get(2).getGrade());
        assertEquals("6710400004", list.getStudents().get(3).getId());
        assertEquals("Fourth", list.getStudents().get(3).getName());
        assertEquals(0, list.getStudents().get(3).getScore());
        assertEquals("F", list.getStudents().get(3).getGrade());
    }
}