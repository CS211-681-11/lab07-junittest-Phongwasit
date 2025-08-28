package ku.cs.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียน เเบบไม่ได้ใส่คะเเนน")
    void testAddNewStudent1() {
        StudentList list = new StudentList();
        list.addNewStudent("6xxxxxxxx", "StudentTest");
        assertEquals(1, list.getStudents().size());
        assertEquals("StudentTest", list.getStudents().get(0).getName());
        assertEquals("6xxxxxxxx", list.getStudents().get(0).getId());
        assertEquals(0, list.getStudents().get(0).getScore());
        assertEquals("F", list.getStudents().get(0).getGrade());
        list.addNewStudent("6xxxxxxxxx", "StudentTest2");
        assertEquals(2, list.getStudents().size());
        assertEquals("StudentTest2", list.getStudents().get(1).getName());
        assertEquals("6xxxxxxxxx", list.getStudents().get(1).getId());
        assertEquals(0, list.getStudents().get(1).getScore());
        assertEquals("F", list.getStudents().get(1).getGrade());
        list.addNewStudent("6xxxxxxxxxx", "StudentTest3");
        assertEquals(3, list.getStudents().size());
        assertEquals("StudentTest3", list.getStudents().get(2).getName());
        assertEquals("6xxxxxxxxxx", list.getStudents().get(2).getId());
        assertEquals(0, list.getStudents().get(2).getScore());
        assertEquals("F", list.getStudents().get(2).getGrade());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียน เเบบใส่คะเเนน")
    void testAddNewStudent() {
        StudentList list = new StudentList();
        list.addNewStudent("6xxxxxxxx", "StudentTest", 90.5);
        assertEquals(1, list.getStudents().size());
        assertEquals("StudentTest", list.getStudents().get(0).getName());
        assertEquals("6xxxxxxxx", list.getStudents().get(0).getId());
        assertEquals(90.5, list.getStudents().get(0).getScore());
        assertEquals("A", list.getStudents().get(0).getGrade());
        list.addNewStudent("6xxxxxxxxx", "StudentTest2", 85);
        assertEquals(2, list.getStudents().size());
        assertEquals("StudentTest2", list.getStudents().get(1).getName());
        assertEquals("6xxxxxxxxx", list.getStudents().get(1).getId());
        assertEquals(85, list.getStudents().get(1).getScore());
        assertEquals("A", list.getStudents().get(1).getGrade());
        list.addNewStudent("6xxxxxxxxxx", "StudentTest3", 75);
        assertEquals(3, list.getStudents().size());
        assertEquals("StudentTest3", list.getStudents().get(2).getName());
        assertEquals("6xxxxxxxxxx", list.getStudents().get(2).getId());
        assertEquals(75, list.getStudents().get(2).getScore());
        assertEquals("B", list.getStudents().get(2).getGrade());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วยไอดี")
    void testFindStudentById() {
        StudentList list = new StudentList();
        list.addNewStudent("6xxxxxxxx", "StudentTest");
        list.addNewStudent("6xxxxxxxxx", "StudentTest2");
        list.addNewStudent("6xxxxxxxxxx", "StudentTest3");
        Student student = list.findStudentById("6xxxxxxxxx");
        assertEquals("StudentTest2", student.getName());
        assertEquals("6xxxxxxxxx", student.getId());
        assertEquals(0, student.getScore());
        assertEquals("F", student.getGrade());
    }

    @Test
    @DisplayName("ทดสอบการฟิลเตอร์โดยใช้ชื่อ")
    void testFilterByName() {
        StudentList list = new StudentList();
        list.addNewStudent("6xxxxxxxx", "StudentTest");
        list.addNewStudent("6xxxxxxxxx", "StudentTest2");
        list.addNewStudent("6xxxxxxxxxx", "StudentTest3");
        list.addNewStudent("6xxxxxxxxxxx", "StudentTT");
        StudentList filteredList = list.filterByName("Test");
        assertEquals(3, filteredList.getStudents().size());
        assertEquals("StudentTest", filteredList.getStudents().get(0).getName());
    }

    @Test
    @DisplayName("ทดสอบการให้คะเเนนผ่านไอดีนักเรียน")
    void testGiveScoreToId() {
        StudentList list = new StudentList();
        list.addNewStudent("6xxxxxxxx", "StudentTest");
        list.addNewStudent("6xxxxxxxxx", "StudentTest2");
        list.addNewStudent("6xxxxxxxxxx", "StudentTest3");
        list.giveScoreToId("6xxxxxxxx", 90.5);
        list.giveScoreToId("6xxxxxxxxx", 85);
        list.giveScoreToId("6xxxxxxxxxx", 75);
        assertEquals(90.5, list.findStudentById("6xxxxxxxx").getScore());
        assertEquals(85, list.findStudentById("6xxxxxxxxx").getScore());
        assertEquals(75, list.findStudentById("6xxxxxxxxxx").getScore());
    }

    @Test
    @DisplayName("ทดสอบการเเสดงผลเกรด จากการป้อนไอดีนักเรียน")
    void testViewGradeOfId() {
        StudentList list = new StudentList();
        list.addNewStudent("6xxxxxxxx", "StudentTest");
        list.addNewStudent("6xxxxxxxxx", "StudentTest2");
        list.addNewStudent("6xxxxxxxxxx", "StudentTest3");
        list.giveScoreToId("6xxxxxxxx", 90.5);
        list.giveScoreToId("6xxxxxxxxx", 85);
        list.giveScoreToId("6xxxxxxxxxx", 75);
        assertEquals("A", list.viewGradeOfId("6xxxxxxxx"));
        assertEquals("A", list.viewGradeOfId("6xxxxxxxxx"));
        assertEquals("B", list.viewGradeOfId("6xxxxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบการคืนค่านักเรียน")
    void testGetStudents() {
        StudentList list = new StudentList();
        list.addNewStudent("6xxxxxxxx", "StudentTest");
        list.addNewStudent("6xxxxxxxxx", "StudentTest2");
        list.addNewStudent("6xxxxxxxxxx", "StudentTest3");
        assertEquals(3, list.getStudents().size());
        assertEquals("StudentTest", list.getStudents().get(0).getName());
        assertEquals("6xxxxxxxx", list.getStudents().get(0).getId());
        assertEquals(0, list.getStudents().get(0).getScore());
        assertEquals("F", list.getStudents().get(0).getGrade());
    }
}