public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        // tambah menu makanan
        menu.tambahMenuMakanan("Pizza", 250000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        // tampilkan menu awal
        System.out.println("--- Menu Sebelum Pemesanan ---");
        menu.tampilMenuMakanan();

        // demo pemesanan
        menu.pesanMenu(0, 5);   // pesan 5 Pizza -> berhasil
        menu.pesanMenu(1, 3);   // pesan 3 Spaghetti -> berhasil
        menu.pesanMenu(2, 30);  // pesan 30 Tenderloin Steak -> habiskan stok
        menu.pesanMenu(2, 1);   // pesan lagi Tenderloin Steak -> ditolak, stok habis

        // tampilkan menu setelah pemesanan
        System.out.println("\n--- Menu Setelah Pemesanan ---");
        menu.tampilMenuMakanan();
    }
}
