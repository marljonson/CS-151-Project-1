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
    public void extraCredit() {
        Grade extra = new Grade();
        assertEquals(extra, extra.extraCredit(13));
    }
}
