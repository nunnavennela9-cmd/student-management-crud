import java.sql.*;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) throws SQLException {
        Connection con = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        boolean running = true; // controls the loop

        while (running) {
            // Show menu every time
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            sc.nextLine(); // clears leftover newline

            if (choice == 1) {
                // CREATE
                System.out.println("Enter name:");
                String name = sc.nextLine();
                System.out.println("Enter course:");
                String course = sc.nextLine();
                System.out.println("Enter marks:");
                int marks = sc.nextInt();

                String query = "INSERT INTO students (name, course, marks) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, course);
                ps.setInt(3, marks);

                int rows = ps.executeUpdate();
                System.out.println(rows + " row(s) inserted!");

            } else if (choice == 2) {
                // READ (all)
                String query = "SELECT * FROM students";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);

                System.out.println("ID\tName\tCourse\tMarks");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t"
                            + rs.getString("course") + "\t" + rs.getInt("marks"));
                }

            } else if (choice == 3) {
                // UPDATE
                System.out.println("Enter ID of student to update:");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter new marks:");
                int newMarks = sc.nextInt();

                String query = "UPDATE students SET marks = ? WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, newMarks);
                ps.setInt(2, id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " row(s) updated!");

            } else if (choice == 4) {
                // DELETE
                System.out.println("Enter ID of student to delete:");
                int id = sc.nextInt();

                String query = "DELETE FROM students WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);

                int rows = ps.executeUpdate();
                System.out.println(rows + " row(s) deleted!");

            } else if (choice == 5) {
                // READ (single, by ID)
                System.out.println("Enter ID to search:");
                int id = sc.nextInt();

                String query = "SELECT * FROM students WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Course: " + rs.getString("course"));
                    System.out.println("Marks: " + rs.getInt("marks"));
                } else {
                    System.out.println("No student found with that ID.");
                }

            } else if (choice == 6) {
                // EXIT
                running = false;
                System.out.println("Exiting... Goodbye!");
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        con.close(); // close database connection when done
    }
}