
import java.util.*;

public class EmployeeExpertSystem {
        static Scanner sc = new Scanner(System.in);

        static class Employee {
                String name;
                int quality;
                int attendance;
                int teamwork;
                int projects;
                boolean deadlineMet;

                Employee(String name,
                                int attendance,
                                int quality,
                                int teamwork,
                                int projects,
                                boolean deadlineMet) {
                        this.name = name;
                        this.attendance = attendance;
                        this.quality = quality;
                        this.teamwork = teamwork;
                        this.projects = projects;
                        this.deadlineMet = deadlineMet;
                }
        }

        public static void main(String[] args) {
                System.out.println("======================================");
                System.out.println(" EMPLOYEE PERFORMANCE EXPERT SYSTEM ");
                System.out.println("======================================");

                System.out.print("Enter Employee Name :");
                String name = sc.nextLine();

                System.out.print("Enter Attendance :(in %)");
                int attendance = sc.nextInt();

                System.out.println("Enter quality rating (1-10):");
                int quality = sc.nextInt();

                System.out.println("Enter teamwork rating (1-10):");
                int teamwork = sc.nextInt();

                System.out.println("Enter project completed (1-100):");
                int projects = sc.nextInt();

                System.out.print("Were deadlines met? (yes/no): ");
                boolean deadlineMet = sc.next().toLowerCase().equals("yes");

                Employee emp = new Employee(name, attendance, quality, teamwork, projects, deadlineMet);

                displayEmployee(emp);

                evaluateEmployee(emp);

                System.out.println("\n======================================");
                System.out.println("AI Technique Used:");
                System.out.println("Rule-Based Expert System");
                System.out.println("Inference Method: Forward Chaining");
                System.out.println("======================================");

                sc.close();
        }

        
        private static void displayEmployee(Employee emp) {
                System.out.println("\n======================================");
                System.out.println("         EMPLOYEE DETAILS");
                System.out.println("======================================");

                System.out.println("Employee Name       : " + emp.name);

                System.out.println("Attendance          : "+ emp.attendance + "%");

                System.out.println("Work Quality        : "+ emp.quality + "/10");

                System.out.println("Teamwork            : "+ emp.teamwork + "/10");

                System.out.println("Projects Completed  : "+ emp.projects);

                System.out.println("Deadlines Met       : "+ (emp.deadlineMet ? "Yes" : "No"));
       
        }

        private static void evaluateEmployee(Employee emp) {
                System.out.println("\n======================================");
                System.out.println("      PERFORMANCE EVALUATION");
                System.out.println("======================================");

                String rating;
                String reason;
                String suggestion;

                
        if (emp.attendance >= 90
                && emp.quality >= 9
                && emp.teamwork >= 9
                && emp.projects >= 5
                && emp.deadlineMet) {

            rating = "Outstanding Performer";

            reason =
                    "Excellent attendance, teamwork and high-quality work.";

            suggestion =
                    "Eligible for promotion and leadership role.";
        }

        // ---------------- RULE 2 ----------------

        else if (emp.attendance >= 80
                && emp.quality >= 8
                && emp.deadlineMet) {

            rating = "Very Good";

            reason =
                    "Consistent performance and timely project completion.";

            suggestion =
                    "Improve leadership and innovation skills.";
        }

        // ---------------- RULE 3 ----------------

        else if (emp.quality >= 9
                && emp.teamwork <= 5) {

            rating = "Technically Strong";

            reason =
                    "Excellent technical skills but weak collaboration.";

            suggestion =
                    "Improve communication and teamwork.";
        }

        // ---------------- RULE 4 ----------------

        else if (emp.projects >= 3
                && emp.quality >= 7) {

            rating = "Good Performer";

            reason =
                    "Completed projects with good quality work.";

            suggestion =
                    "Improve consistency and attendance.";
        }

        // ---------------- RULE 5 ----------------

        else if (emp.attendance >= 65
                && emp.quality >= 5) {

            rating = "Average Performer";

            reason =
                    "Moderate performance in evaluation areas.";

            suggestion =
                    "Increase productivity and work quality.";
        }

        // ---------------- RULE 6 ----------------

        else if (emp.attendance < 60
                && !emp.deadlineMet) {

            rating = "Poor Performer";

            reason =
                    "Low attendance and missed deadlines.";

            suggestion =
                    "Improve discipline and time management.";
        }

        // ---------------- DEFAULT RULE ----------------

        else {

            rating = "Needs Improvement";

            reason =
                    "Performance does not meet organizational expectations.";

            suggestion =
                    "Focus on punctuality, teamwork and quality improvement.";
        }

                double score =
                (emp.attendance * 0.4) +
                (emp.quality * 3) +
                (emp.teamwork * 2) +
                (Math.min(emp.projects,5) * 2);
         System.out.println("Performance Rating  : "
                + rating);

        System.out.println("Performance Score   : "
                + String.format("%.2f", score));

        System.out.println("Reason              : "
                + reason);

        System.out.println("Suggestion          : "
                + suggestion);

        if(score>=80){
                System.out.println("Bonus Eligibility: Elligible");
        }else{
                System.out.println("Bonus Elligiblity : Not Elligible");
        }        

        }

}