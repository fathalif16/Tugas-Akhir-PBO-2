// Paket admin untuk kelas Admin dan AdminMenu
package admin;

import hotelmanagement.Hotel;

import java.util.Scanner;

public class AdminMenu {
    // Menu admin setelah login
    public static void adminMenu(Hotel hotel) {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Lihat Informasi Kamar");
            System.out.println("3. Edit Data Kamar");
            System.out.println("4. Reservasi Kamar (Check-in)");
            System.out.println("5. Lihat Detail Reservasi");
            System.out.println("6. Reservasi Kamar (Check-out)");
            System.out.println("7. Lihat Jumlah Kamar Tersedia");
            System.out.println("8. Lihat Data Tamu");
            System.out.println("9. Logout");
            System.out.print("Pilih menu: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.addRoom();
                    break;

                case 2:
                    hotel.displayRooms();
                    break;

                case 3:
                    hotel.editRoom();
                    break;

                case 4:
                    hotel.checkIn();
                    break;

                case 5:
                    hotel.displayReservationDetails();
                    break;

                case 6:
                    hotel.checkOut();
                    break;

                case 7:
                    hotel.displayAvailableRooms();
                    break;

                case 8:
                    hotel.displayGuestData();
                    break;

                case 9:
                    return; // Logout dan kembali ke menu utama

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}