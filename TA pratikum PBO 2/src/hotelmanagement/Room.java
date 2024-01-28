package hotelmanagement;

public class Room {
    private int roomNumber;
    private String bedType;
    private double pricePerNight;
    private boolean isOccupied;

    public Room(int roomNumber, String bedType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.bedType = bedType;
        this.pricePerNight = pricePerNight;
        this.isOccupied = false;
    }

    // Getter dan setter untuk setiap atribut
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupyRoom() {
        isOccupied = true;
    }

    public void vacateRoom() {
        isOccupied = false;
    }

    @Override
    public String toString() {
        return "Nomor Kamar: " + roomNumber +
                "\nJenis Bed: " + bedType +
                "\nHarga per Malam: $" + pricePerNight +
                "\nStatus: " + (isOccupied ? "Terisi" : "Kosong") + "\n";
    }
}
