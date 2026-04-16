package Kue;

public class MainKue {
    public static void main(String[] args) {

        Kue[] kue = new Kue[20];

        for (int i = 0; i < kue.length; i++) {
            if (i % 2 == 0) {
                kue[i] = new KuePesanan("KuePesanan" + i, 10000, i + 1);
            } else {
                kue[i] = new KueJadi("KueJadi" + i, 8000, i + 2);
            }
        }

        double totalSemua = 0;
        double totalPesanan = 0;
        double totalBerat = 0;
        double totalJadi = 0;
        double totalJumlah = 0;

        Kue kueTermahal = kue[0];

        for (Kue k : kue) {
            System.out.println("----------------------------");
            System.out.println(k);
            System.out.println("Harga akhir: " + k.hitungHarga());

            totalSemua += k.hitungHarga();

            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalPesanan += kp.hitungHarga();
                totalBerat += kp.getBerat();
            }

            if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalJadi += kj.hitungHarga();
                totalJumlah += kj.getJumlah();
            }

            if (k.hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }

        System.out.println("----------------------------");

        System.out.println("\n============================");
        System.out.println("Total semua harga: " + totalSemua);
        System.out.println("Total harga KuePesanan: " + totalPesanan);
        System.out.println("Total berat KuePesanan: " + totalBerat);
        System.out.println("Total harga KueJadi: " + totalJadi);
        System.out.println("Total jumlah KueJadi: " + totalJumlah);

        System.out.println("\n============================");
        System.out.println("Kue termahal:");
        System.out.println(kueTermahal);
        System.out.println("Harga akhir: " + kueTermahal.hitungHarga());
        System.out.println("============================");
    }
}