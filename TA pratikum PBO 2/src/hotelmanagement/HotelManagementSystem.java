// Paket utama sebagai entry point program
package hotelmanagement;

import admin.AdminMenu;

import java.util.Scanner;

// Kelas utama sebagai entry point program
public class HotelManagementSystem {
    public static void main(String[] args) {
        // Objek Hotel untuk mengelola data kamar dan reservasi
        Hotel hotel = new Hotel();

        // Menu utama
        while (true) {
            System.out.println("\n===== Hotel Management System =====");
            System.out.println("1. Login Admin");
            System.out.println("2. Exit");
            System.out.print("Pilih menu: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Login Admin
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    if (hotel.adminLogin(username, password)) {
                        AdminMenu.adminMenu(hotel); // Jika login berhasil, tampilkan menu admin
                    } else {
                        System.out.println("Login failed. Invalid credentials.");
                    }
                    break;

                case 2:
                    System.out.println("Terima kasih!");
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
