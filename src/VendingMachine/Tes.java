package VendingMachine;


import java.util.Scanner;

public class Tes {

    public Scanner sc = new Scanner(System.in);
    public int money = getMoney();
    public int totalBeli = getTotalBeli();
    public int pilihMenu;

    public int getMoney(){
        System.out.print("Masukkan Jumlah Uang = ");
        int jumlahUang = sc.nextInt();
        return jumlahUang;
    }

    public int getTotalBeli(){
        System.out.print("Masukkan Jumlah barang yang dibeli = ");
        int totalBeli = sc.nextInt();
        return totalBeli;
    }

    public void cekMoney(){
        if (money == 2000 || money == 5000 || money == 10000 || money == 20000 || money == 50000 ){
            System.out.println("Silahkan Pilih Menu :");
            System.out.println("1. Biskuit : Rp 6000");
            System.out.println("2. Chips : Rp 8000");
            System.out.println("3. Oreo : Rp 10000");
            System.out.println("4. Tango : Rp 12000");
            System.out.println("5. Cokelat : Rp 15000");
            System.out.println("6. Keluar");
            System.out.print("Masukkan nomor menu = ");
            this.pilihMenu = sc.nextInt();
            pilihMenu();
        }
        else {
            System.out.println("Uang nominal ini tidak dapat digunakan. Gunakan uang pecahan 2000, 5000, 10000, 20000, atau 50000!!");
        }
    }

    public void pilihMenu() {
        switch (this.pilihMenu) {
            case 1:
                pembelian("Biskuit" ,6000, 6);
                break;
            case 2:
                pembelian("Chips" ,8000, 7);
                break;
            case 3:
                pembelian("Oreo" ,10000, 3);
                break;
            case 4:
                pembelian("Tango" ,12000,0);
                break;
            case 5:
                pembelian("Cokelat" ,15000, 5);
                break;
            case 6:
                System.out.println("Keluar");
                break;
            default:
                System.out.println("Menu Tidak Tersedia");
                break;
        }
    }

    public void pembelian(String product, int price, int stok) {
        int hasil;
        int cekStok;
        int totalHarga;
//        Menghitung stok barang
        cekStok = stok - totalBeli;

//        Menghitung total harga
        totalHarga = totalBeli * price;

        hasil = money - totalHarga;

        if (cekStok <= 0){
            System.out.println("Maaf, Stok " + product +" tidak cukup");
            pilihMenuLagi();
        } else if (hasil<0) {
            System.out.println("Maaf, uang tidak cukup");
            pilihMenuLagi();
        } else {
            System.out.println("======================================================");
            System.out.println("Produk yang dipilih = " + product);
            System.out.println("Jumlah produk yang dipilih = " + totalBeli);
            System.out.println("Harga produk = " + totalHarga);
            System.out.println("Uang yang anda masukkan = " + money);
            System.out.println("Kembalian = " + hasil);
            System.out.println("======================================================");
        }
    }

    public void pilihMenuLagi () {
        getTotalBeli();
        System.out.println("Silahkan Pilih Menu Lagi :");
        System.out.println("1. Biskuit : Rp 6000");
        System.out.println("2. Chips : Rp 8000");
        System.out.println("3. Oreo : Rp 10000");
        System.out.println("4. Tango : Rp 12000");
        System.out.println("5. Cokelat : Rp 15000");
        System.out.println("6. Keluar");
                System.out.print("Masukkan nomor menu = ");
        this.pilihMenu = sc.nextInt();
        pilihMenu();

    }

    public static void main(String[] args) {
        Tes p = new Tes();
        p.cekMoney();
    }
}

