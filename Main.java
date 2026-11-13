public class Main {
    public static void main(String[] args) {
        mahasiswadataview mahasiswaView = new mahasiswadataview();
        boolean running = true;

        while (running) {
            System.out.println("\nPilih menu");
            System.out.println("1. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            String menu = dataview.scanner.nextLine();

            switch (menu) {
                case "1":
                    aksiMenu(mahasiswaView);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        System.out.println("Selesai");
    }

    private static void aksiMenu(dataview view) {
        boolean back = false;
        while (!back) {
            System.out.println("\nPilih Aksi");
            System.out.println("1. Tampilkan semua data");
            System.out.println("2. Cari satu data");
            System.out.println("3. Tambah data");
            System.out.println("4. Ubah data");
            System.out.println("5. Delete data");
            System.out.println("0. Kembali");
            System.out.print("Pilihan: ");
            String aksi = dataview.scanner.nextLine();

            switch (aksi) {
                case "1":
                    view.printAll();
                    break;
                case "2":
                    view.printByPk(dataview.scanner.nextLine());
                    break;
                case "3":
                    view.showInsertForm();
                    break;
                case "4":
                    view.showUpdateForm();
                    break;
                case "5":
                    view.promptDelete();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}