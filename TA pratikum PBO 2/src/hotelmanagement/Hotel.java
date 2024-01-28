// Paket hotel untuk kelas Hotel, Room, dan Reservation
package hotelmanagement;

import admin.Admin;

import java.util.ArrayList;
import java.util.Scanner;

// Kelas Hotel sebagai representasi keseluruhan hotel
public class Hotel {
    public ArrayList<Room> rooms;
    public ArrayList<Reservation> reservations;
    public Admin admin;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        admin = new Admin("alif", "1234");
    }

    // Metode untuk login admin
    public boolean adminLogin(String username, String password) {
        return admin.login(username, password);
    }

    public boolean isRoomNumberExists(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return true;
            }
        }
        return false;
    }

    // Metode untuk menambah kamar baru
    public void addRoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Tambah Kamar =====");
        System.out.print("Nomor Kamar: ");
        int roomNumber = scanner.nextInt();

        // Memeriksa apakah nomor kamar sudah ada
        if (isRoomNumberExists(roomNumber)) {
            System.out.println("Nomor Kamar sudah ada. Gagal menambahkan kamar.");
            return;
        }

        System.out.print("Jenis Bed: ");
        String bedType = scanner.next();

        double pricePerNight = 0.0;
        boolean validInput = false;

        // Validasi input harga per malam
        while (!validInput) {
            try {
                System.out.print("Harga per Malam: ");
                pricePerNight = scanner.nextDouble();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Mohon masukkan angka.");
                scanner.next(); // Membersihkan buffer input
            }
        }

        Room newRoom = new Room(roomNumber, bedType, pricePerNight);
        rooms.add(newRoom);

        System.out.println("Kamar berhasil ditambahkan!");
    }


    // Metode untuk menampilkan informasi kamar
    public void displayRooms() {
        System.out.println("\n===== Informasi Kamar =====");
        if (rooms.isEmpty()) {
            System.out.println("Belum ada kamar yang ditambahkan.");
        } else {
            for (Room room : rooms) {
                System.out.println(room.toString());
            }
        }
    }


    // Metode untuk mengedit data kamar
    public void editRoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Edit Data Kamar =====");
        System.out.print("Masukkan Nomor Kamar yang akan diubah: ");
        int roomNumber = scanner.nextInt();

        // Mencari kamar berdasarkan nomor kamar
        Room roomToEdit = findRoomByNumber(roomNumber);

        if (roomToEdit != null) {
            System.out.print("Jenis Bed (baru): ");
            String newBedType = scanner.next();
            roomToEdit.setBedType(newBedType);

            System.out.print("Harga per Malam (baru): ");
            double newPricePerNight = scanner.nextDouble();
            roomToEdit.setPricePerNight(newPricePerNight);

            System.out.println("Data Kamar berhasil diubah!");
        } else {
            System.out.println("Kamar tidak ditemukan. Gagal mengubah data kamar.");
        }
    }

    // Mencari kamar berdasarkan nomor kamar
    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }


    // Metode untuk check-in (reservasi kamar)
    public void checkIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Reservasi Kamar (Check-in) =====");
        System.out.print("Nomor Kamar yang akan di-Check-in: ");
        int roomNumber = scanner.nextInt();

        // Mencari kamar berdasarkan nomor kamar
        Room roomToCheckIn = findRoomByNumber(roomNumber);

        if (roomToCheckIn != null) {
            if (!roomToCheckIn.isOccupied()) {
                System.out.print("Nama Tamu: ");
                String guestName = scanner.next();

                System.out.print("Durasi Menginap (malam): ");
                int duration = scanner.nextInt();

                double totalPrice = duration * roomToCheckIn.getPricePerNight();

                Reservation newReservation = new Reservation(roomNumber, guestName, totalPrice);
                reservations.add(newReservation);

                roomToCheckIn.occupyRoom();
                System.out.println("Check-in berhasil!");
            } else {
                System.out.println("Kamar sudah terisi. Gagal melakukan check-in.");
            }
        } else {
            System.out.println("Kamar tidak ditemukan. Gagal melakukan check-in.");
        }
    }

    // Metode untuk menampilkan detail reservasi
    // Metode untuk menampilkan detail reservasi
    public void displayReservationDetails() {
        System.out.println("\n===== Detail Reservasi =====");

        if (reservations.isEmpty()) {
            System.out.println("Belum ada reservasi yang dilakukan.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println("Nomor Kamar: " + reservation.getRoomNumber());
                System.out.println("Nama Tamu: " + reservation.getGuestName());
                System.out.println("Total Harga: $" + reservation.getTotalPrice());
                System.out.println();
            }
        }
    }


    // Metode untuk check-out (mengakhiri reservasi)
    public void checkOut() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Reservasi Kamar (Check-out) =====");
        System.out.print("Nomor Kamar atau Nama Tamu: ");
        String searchInput = scanner.next();

        boolean found = false;

        for (Reservation reservation : reservations) {
            if (String.valueOf(reservation.getRoomNumber()).equals(searchInput) ||
                    reservation.getGuestName().equalsIgnoreCase(searchInput)) {
                Room roomToCheckOut = findRoomByNumber(reservation.getRoomNumber());

                if (roomToCheckOut != null) {
                    roomToCheckOut.vacateRoom();
                    reservations.remove(reservation);
                    System.out.println("Check-out berhasil!");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Data tidak ditemukan.");
        }
    }


    // Metode untuk menampilkan jumlah kamar yang tersedia
    public void displayAvailableRooms() {
        System.out.println("\n===== Kamar Tersedia =====");

        if (rooms.isEmpty()) {
            System.out.println("Belum ada kamar yang ditambahkan.");
        } else {
            for (Room room : rooms) {
                if (!room.isOccupied()) {
                    System.out.println(room.toString());
                }
            }
        }
    }

    // Metode untuk menampilkan data tamu
    public void displayGuestData() {
        System.out.println("\n===== Data Tamu =====");

        if (reservations.isEmpty()) {
            System.out.println("Belum ada tamu yang melakukan check-in.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println("Nomor Kamar: " + reservation.getRoomNumber());
                System.out.println("Nama Tamu: " + reservation.getGuestName());
                System.out.println("Total Harga: $" + reservation.getTotalPrice());
                System.out.println();
            }
        }
    }
}
