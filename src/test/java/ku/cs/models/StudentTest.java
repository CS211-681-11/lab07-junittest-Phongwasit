package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
        s.addScore(15.5);
        assertEquals(60.65, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(60);
        assertEquals("C", s.getGrade());
        s.addScore(20);
        assertEquals("A", s.getGrade());
    }

    @Test
    @DisplayName("ทดสอบ constructor 1")
    void testConstructor1(){
        Student s1 = new Student("6xxxxxxxxx", "StudentTest1");
        assertEquals("6xxxxxxxxx", s1.getId());
        assertEquals("StudentTest1", s1.getName());
        assertEquals(0, s1.getScore());
        assertEquals("F", s1.getGrade());
        Student s2 = new Student("6xxxxxxxxz", "StudentTest2");
        assertEquals("6xxxxxxxxz", s2.getId());
        assertEquals("StudentTest2", s2.getName());
        assertEquals(0, s2.getScore());
        assertEquals("F", s2.getGrade());
    }

    @Test
    @DisplayName("ทดสอบ constructor 2")
    void testConstructor2(){
        Student s1 = new Student("6xxxxxxxxx", "StudentTest", 90.5);
        assertEquals("6xxxxxxxxx", s1.getId());
        assertEquals("StudentTest", s1.getName());
        assertEquals(90.5, s1.getScore());
        assertEquals("A", s1.getGrade());
        Student s2 = new Student("6xxxxxxxxz", "StudentTest2", 85);
        assertEquals("6xxxxxxxxz", s2.getId());
        assertEquals("StudentTest2", s2.getName());
        assertEquals(85, s2.getScore());
        assertEquals("A", s2.getGrade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.changeName("StudentTest2");
        assertEquals("StudentTest2", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหาโดยใช้ไอดี")
    void testIsId() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxxx"));
        assertFalse(s.isId("6xxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบการค้นหาโดยใช้ชื่อ")
    void testIsNameContains() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isNameContains("StudentTest"));
        assertFalse(s.isNameContains("Studentz"));
    }
}