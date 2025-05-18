import java.util.*;

class Student {
    protected long studentId;
    protected String studentName;
    protected String courseName;
    protected int yearOfStudy;
    protected double baseFee;

    public Student() {
    };

    public Student(long studentId, String studentName, String courseName, int yearOfStudy, double baseFee) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.yearOfStudy = yearOfStudy;
        this.baseFee = baseFee;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public double getBaseFees() {
        return baseFee;
    }

    public void setBaseFees(double baseFee) {
        this.baseFee = baseFee;
    }

}

class RegularStudent extends Student {
    private double mentorshipFee;

    public RegularStudent() {
    };

    public RegularStudent(long studentId, String studentName, String courseName, int yearOfStudy, double baseFee,
            double mentorshipFree) {
        super(studentId, studentName, courseName, yearOfStudy, baseFee);
        this.mentorshipFee = mentorshipFree;
    }

    public double getMentorshipFee() {
        return mentorshipFee;
    }

    public void setMentorshipFee(double mentorshipFree) {
        this.mentorshipFee = mentorshipFree;
    }

    public double calculateRegularStudentFees() {
        if (yearOfStudy > 0 && yearOfStudy < 5) {
            return ((baseFee * yearOfStudy) + mentorshipFee);
        } else {
            return -1;
        }
    }
}

class DistanceStudent extends Student {
    private double materialFee;

    public DistanceStudent() {
    };

    public DistanceStudent(long studentId, String studentName, String courseName, int yearOfStudy, double baseFee,
            double materialFee) {
        super(studentId, studentName, courseName, yearOfStudy, baseFee);
        this.materialFee = materialFee;
    }

    public double getMaterialFee() {
        return materialFee;
    }

    public void setMaterialFee(double materialFee) {
        this.materialFee = materialFee;
    }

    public double calculateDistanceFee() {
        if (yearOfStudy > 0 && yearOfStudy < 7) {
            return ((baseFee * yearOfStudy) + materialFee);
        } else {
            return -1;
        }
    }
}

public class BeetaUniversity {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student details");

        String input = sc.nextLine();
        String parts[] = input.split(":");

        if (parts[0].equalsIgnoreCase("Regular")) {
            long studentId = Long.parseLong(parts[1]);
            String studentName = parts[2];
            String course = parts[3];
            int year = Integer.parseInt(parts[4]);
            double baseFee = Double.parseDouble(parts[5]);
            double mentorshipFree = Double.parseDouble(parts[6]);

            RegularStudent rs = new RegularStudent(studentId, studentName, course, year, baseFee, mentorshipFree);

            if (rs.calculateRegularStudentFees() != -1) {
                System.out.println("Calculated regular mode fees for student " + rs.getStudentName() + " is "
                        + rs.calculateRegularStudentFees());
            } else {
                System.out.println("You have provided invalid year of study as " + rs.getBaseFees()
                        + " for a regular student " + rs.getStudentName());
            }
        }

        if (parts[0].equalsIgnoreCase("Distance")) {
            long studentId = Long.parseLong(parts[1]);
            String studentName = parts[2];
            String course = parts[3];
            int year = Integer.parseInt(parts[4]);
            double baseFee = Double.parseDouble(parts[5]);
            double materialFee = Double.parseDouble(parts[6]);

            DistanceStudent ds = new DistanceStudent(studentId, studentName, course, year, baseFee, materialFee);

            if(ds.calculateDistanceFee() != -1){
                System.out.println("Calculated distance mode fees for student "+ ds.getStudentName()+" is "+ ds.calculateDistanceFee());
            }else{
                System.out.println("You have provided invalid year of study as "+ ds.getBaseFees()+" for distance student "+ ds.getStudentName());
            }
        }
    }
}
