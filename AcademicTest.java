import src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcademicTest {
    private static final Course CMPE = new Course();

    @Test
    public void testPassFail() {
        Grade g = new Grade();
        assertEquals("Pass", g.convertGradeIDToPassFail(85));
        assertEquals("Fail", g.convertGradeIDToPassFail(43));
    }

    @Test
    public void testConvertLettertoPoints() {
        Professor p = new Professor(1, "John Doe", "john.doe@example.com", 101, 102, 103);
        assertEquals(false, p.checkIfCourseIsTaughtByProfessor(CMPE));
    }

    @Test 
    public void testExtraCredit() {
        Grade g = new Grade();
        int originalGrade = 70;
        int extraPoints = 15;
        int newGrade = g.extraCredit(originalGrade, extraPoints);
        assertEquals(newGrade, 85);
    }

    @Test
    public void testConvertGradeIDToPassFail() {
        Grade g = new Grade();
        g.setGradeID(50);
        assertEquals(g.convertGradeIDToPassFail(50), "Fail");
    }

    @Test
    public void testCurveGrade() {
        Grade g = new Grade();
        g.setGradeID(50);
        assertEquals(g.curveGrade(50, 0.10), 55.0);
    }

    @Test
    public void testConvertGradeID() {
        Grade g = new Grade();
        g.setGradeID(85);
        assertEquals(g.convertGradeID(g.getGradeID(), Person.c1), "B");
    }
}
