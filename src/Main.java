//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

class Library {
    private final String adminUsername = "admin";
    private final String adminPassword = "admin123";
    private final String[] mahasiswaUsernames = {"mahasiswa1", "mahasiswa2", "mahasiswa3"};
    private final String[] mahasiswaNIMs = {"202210370311203", "20022222", "20233333"};

    public String loginAsStudent(String nim) {
        for (int i = 0; i < mahasiswaNIMs.length; i++) {
            if (nim.equals(mahasiswaNIMs[i])) {
                return "Student";
            }
        }
        return null;
    }

    public boolean loginAsAdmin(String username, String password) {
        return adminUsername.equals(username) && adminPassword.equals(password);
    }

    public void uploadToGitHub() {
        System.out.println("Proses upload tugas ke GitHub live...");
        // Implementasi upload tugas ke GitHub menggunakan Git
        // Pastikan untuk menggunakan pustaka Git untuk mengelola proses upload tugas secara otomatis
        System.out.println("Tugas berhasil diupload ke GitHub.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Enter your NIM: ");
                String nim = scanner.next();
                String loginStatus = library.loginAsStudent(nim);
                if (loginStatus != null) {
                    System.out.println("Successful Login as " + loginStatus);
                } else {
                    System.out.println("Student User Not Found!!");
                }
            } else if (option == 2) {
                System.out.print("Enter your username (admin): ");
                String username = scanner.next();
                System.out.print("Enter your password (admin): ");
                String password = scanner.next();
                if (library.loginAsAdmin(username, password)) {
                    System.out.println("Successful Login as Admin");
                    library.uploadToGitHub();
                } else {
                    System.out.println("Admin User Not Found!!");
                }
            } else if (option == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please choose between 1-3.");
            }
        }
        scanner.close();
    }
}