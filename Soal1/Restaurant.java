public class Restaurant {
    // semua attribute private supaya tidak bisa diakses langsung dari luar
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    // getter untuk nama makanan berdasarkan index
    public String getNamaMakanan(int index) {
        return nama_makanan[index];
    }

    // getter untuk harga makanan berdasarkan index
    public double getHargaMakanan(int index) {
        return harga_makanan[index];
    }

    // getter untuk stok berdasarkan index
    public int getStok(int index) {
        return stok[index];
    }

    // setter stok dengan validasi tidak boleh negatif
    public void setStok(int index, int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif! Stok di-set jadi 0.");
            this.stok[index] = 0;
        } else {
            this.stok[index] = stok;
        }
    }

    public static byte getId() {
        return id;
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        // pakai setter supaya ada validasi
        setStok(id, stok);
    }

    public void tampilMenuMakanan() {
        System.out.println("=== Daftar Menu ===");
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println((i + 1) + ". " + nama_makanan[i] + " [stok: " + stok[i] + "]\tRp. " + harga_makanan[i]);
            } else {
                System.out.println((i + 1) + ". " + nama_makanan[i] + " [HABIS]\t\tRp. " + harga_makanan[i]);
            }
        }
        System.out.println("===================");
    }

    public boolean isOutOfStock(int id) {
        if (stok[id] == 0) {
            return true;
        } else {
            return false;
        }
    }

    // method pemesanan menu
    public void pesanMenu(int index, int jumlah) {
        System.out.println("\nMemesan " + jumlah + "x " + nama_makanan[index] + "...");
        if (jumlah <= 0) {
            System.out.println("Jumlah pesanan tidak valid!");
            return;
        }
        if (stok[index] >= jumlah) {
            stok[index] -= jumlah;
            double total = harga_makanan[index] * jumlah;
            System.out.println("Pesanan berhasil! Total harga: Rp. " + total);
        } else {
            System.out.println("Pesanan ditolak! Stok " + nama_makanan[index] + " tidak mencukupi. Sisa stok: " + stok[index]);
        }
    }

    public static void nextId() {
        id++;
    }
}
