/**
 * Class for student.
 */
class Student {
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private String rollno;
    /**
     * { var_description }.
     */
    private float sub1;
    /**
     * { var_description }.
     */
    private float sub2;
    /**
     * { var_description }.
     */
    private float sub3;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      rollno  The rollno
     * @param      sub1    The sub 1
     * @param      sub2    The sub 2
     * @param      sub3    The sub 3
     */
    Student(final String name, final String rollno,
                   final float sub1, final float sub2, final float sub3) {
        this.name = name;
        this.rollno = rollno;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }
    /**
     * { Calculates Average }.
     *
     * @return     { Floating value }.
     */
    public float gPA() {
        final int three = 3;
        return (float) ((sub1 + sub2 + sub3) / three);
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public void main(final String[] args) {

    }
}
/**
 * Class for student details.
 */
public class StudentDetails {
    /**
     * { var_description }.
     */
    private final float s11 = 7.5f;
    /**
     * { var_description }.
     */
    private final float s12 = 7.0f;
    /**
     * { var_description }.
     */
    private final float s13 = 8.0f;
    /**
     * { var_description }.
     */
    private final float s21 = 8.5f;
    /**
     * { var_description }.
     */
    private final float s22 = 6.0f;
    /**
     * { var_description }.
     */
    private final float s23 = 7.5f;
    /**
     * { var_description }.
     */
    private final float s31 = 7.5f;
    /**
     * { var_description }.
     */
    private final float s32 = 8.0f;
    /**
     * { var_description }.
     */
    private final float s33 = 9.0f;
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Student s1 = new Student("Sangay", "IT201985001",
                                 s11, s12, s13);
        Student s2 = new Student("Bidhya", "IT201985003",
                                 s21, s22, s23);
        Student s3 = new Student("Kelzang", "IT201985065",
                                 s31, s32, s33);
        System.out.printf("%.1f\n", s1.gPA());
        System.out.printf("%.1f\n", s2.gPA());
        System.out.printf("%.1f", s3.gPA());
    }
}