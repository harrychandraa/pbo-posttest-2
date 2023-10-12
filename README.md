Nama : Harry Chandra
Nim  : 2209116014
kelas: SI A1 22

package models;

public final class Book {
    private final int id;
    private String title;
    private String author;
    private int year;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

penjelasan:
1. `public final class Book`: Ini adalah deklarasi kelas `Book`. Kode ini mendefinisikan sebuah kelas bernama `Book` yang dideklarasikan sebagai `final`, yang berarti kelas ini tidak dapat diwariskan oleh kelas lain. Ini adalah praktik yang baik untuk mencegah perubahan pada kelas ini setelah diimplementasikan.
2. `private final int id`: Ini adalah deklarasi properti `id` yang merupakan unik untuk setiap buku. Properti ini dideklarasikan sebagai `final`, yang berarti setelah nilainya diinisialisasi dalam konstruktor, nilainya tidak dapat diubah. Properti ini adalah identifikasi unik untuk setiap buku.
3. `private String title`: Ini adalah properti `title` yang menyimpan judul buku. Properti ini tidak dideklarasikan sebagai `final`, sehingga nilainya dapat diubah dengan menggunakan metode setter.
4. `private String author`: Ini adalah properti `author` yang menyimpan nama penulis buku. Seperti `title`, properti ini juga tidak dideklarasikan sebagai `final`.
5. `private int year`: Ini adalah properti `year` yang menyimpan tahun terbit buku. Properti ini, seperti `title` dan `author`, tidak dideklarasikan sebagai `final`.
6. `public Book(int id, String title, String author, int year)`: Ini adalah konstruktor kelas `Book`. Konstruktor ini menerima empat parameter: `id`, `title`, `author`, dan `year`. Ketika objek `Book` dibuat, konstruktor ini akan dijalankan untuk menginisialisasi properti-properti kelas dengan nilai yang sesuai.
7. `public int getId()`: Ini adalah metode `getter` yang digunakan untuk mengambil nilai properti `id`. Ini memungkinkan akses ke properti `id` dari luar kelas.
8. `public String getTitle()`: Ini adalah metode `getter` yang digunakan untuk mengambil nilai properti `title`. Ini memungkinkan akses ke properti `title` dari luar kelas.
9. `public void setTitle(String title)`: Ini adalah metode `setter` yang digunakan untuk mengatur nilai properti `title`. Dengan metode ini, Anda dapat mengubah atau memperbarui nilai properti `title` dari luar kelas.
10. `public String getAuthor()`: Ini adalah metode `getter` yang digunakan untuk mengambil nilai properti `author`. Ini memungkinkan akses ke properti `author` dari luar kelas.
11. `public void setAuthor(String author)`: Ini adalah metode `setter` yang digunakan untuk mengatur nilai properti `author`. Dengan metode ini, Anda dapat mengubah atau memperbarui nilai properti `author` dari luar kelas.
12. `public int getYear()`: Ini adalah metode `getter` yang digunakan untuk mengambil nilai properti `year`. Ini memungkinkan akses ke properti `year` dari luar kelas.
13. `public void setYear(int year)`: Ini adalah metode `setter` yang digunakan untuk mengatur nilai properti `year`. Dengan metode ini, dapat mengubah atau memperbarui nilai properti `year` dari luar kelas.
Kelas `Book` digunakan untuk merepresentasikan buku dengan properti unik (ID), judul, penulis, dan tahun terbit, serta metode untuk mengakses dan memperbarui properti-properti ini.

package com.mycompany.perpustakaan;

import models.Book;

import java.util.ArrayList;
import java.util.Scanner;

public final class Perpustakaan {
    private static final ArrayList<Book> library = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Perpustakaan - Pilih operasi:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Update Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Keluar");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 5);
    }

    private static void addBook() {
        System.out.println("Tambah Buku");
        System.out.print("Judul: ");
        String title = scanner.next();

        System.out.print("Penulis: ");
        String author = scanner.next();

        System.out.print("Tahun Terbit: ");
        int year = scanner.nextInt();

        Book newBook = new Book(library.size() + 1, title, author, year);
        library.add(newBook);

        System.out.println("Buku berhasil ditambahkan!");
    }

    private static void viewBooks() {
        System.out.println("Daftar Buku:");
        for (Book book : library) {
            System.out.println("ID: " + book.getId());
            System.out.println("Judul: " + book.getTitle());
            System.out.println("Penulis: " + book.getAuthor());
            System.out.println("Tahun Terbit: " + book.getYear());
            System.out.println();
        }
    }

    private static void updateBook() {
        System.out.print("Masukkan ID buku yang ingin diupdate: ");
        int idToUpdate = scanner.nextInt();
        Book bookToUpdate = findBookById(idToUpdate);

        if (bookToUpdate != null) {
            System.out.print("Judul Baru: ");
            String newTitle = scanner.next();

            System.out.print("Penulis Baru: ");
            String newAuthor = scanner.next();

            System.out.print("Tahun Terbit Baru: ");
            int newYear = scanner.nextInt();

            bookToUpdate.setTitle(newTitle);
            bookToUpdate.setAuthor(newAuthor);
            bookToUpdate.setYear(newYear);

            System.out.println("Buku berhasil diupdate!");
        } else {
            System.out.println("Buku dengan ID " + idToUpdate + " tidak ditemukan.");
        }
    }

    private static void deleteBook() {
        System.out.print("Masukkan ID buku yang ingin dihapus: ");
        int idToDelete = scanner.nextInt();
        Book bookToDelete = findBookById(idToDelete);

        if (bookToDelete != null) {
            library.remove(bookToDelete);
            System.out.println("Buku berhasil dihapus!");
        } else {
            System.out.println("Buku dengan ID " + idToDelete + " tidak ditemukan.");
        }
    }

    private static Book findBookById(int id) {
        for (Book book : library) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}

penjelasan :
1. `import models.Book;`: Ini adalah pernyataan `import` yang mengimpor kelas `Book` dari package `models`. Ini memungkinkan kelas `Perpustakaan` untuk menggunakan kelas `Book` yang telah didefinisikan sebelumnya.
2. `import java.util.ArrayList;`: Ini adalah pernyataan `import` yang mengimpor kelas `ArrayList` dari package `java.util`. `ArrayList` digunakan untuk menyimpan daftar buku dalam perpustakaan.
3. `import java.util.Scanner;`: Ini adalah pernyataan `import` yang mengimpor kelas `Scanner` dari package `java.util`. `Scanner` digunakan untuk menerima input dari pengguna melalui konsol.
4. `public final class Perpustakaan {`: Ini adalah deklarasi kelas `Perpustakaan`. Kode ini mendefinisikan kelas bernama `Perpustakaan` yang dideklarasikan sebagai `final`, sehingga kelas ini tidak dapat diwariskan oleh kelas lain. Ini adalah titik awal dari program perpustakaan.
5. `private static final ArrayList<Book> library = new ArrayList<>();`: Ini adalah deklarasi variabel `library`, yang merupakan objek `ArrayList` yang akan digunakan untuk menyimpan daftar buku. Ini adalah koleksi buku dalam perpustakaan.
6. `private static final Scanner scanner = new Scanner(System.in);`: Ini adalah deklarasi variabel `scanner`, yang digunakan untuk menerima input dari pengguna melalui konsol.
7. `public static void main(String[] args) {`: Ini adalah metode `main`, yang merupakan titik masuk utama program. Semua kode dalam metode `main` akan dijalankan saat program dimulai.
8. `int choice;`: Ini adalah deklarasi variabel `choice` yang digunakan untuk menyimpan pilihan pengguna saat menjalankan program.
9. `do { ... } while (choice != 5);`: Ini adalah loop `do-while` yang akan menjalankan operasi dalam program hingga pengguna memilih untuk keluar (pilihan 5).
10. Di dalam loop, program menampilkan menu operasi dan menggunakan `switch` untuk mengeksekusi operasi yang sesuai sesuai dengan pilihan pengguna.
11. `private static void addBook() { ... }`: Ini adalah metode `addBook` yang digunakan untuk menambahkan buku baru ke dalam perpustakaan. Metode ini meminta pengguna untuk memasukkan judul, penulis, dan tahun terbit buku.
12. `private static void viewBooks() { ... }`: Ini adalah metode `viewBooks` yang digunakan untuk menampilkan daftar buku dalam perpustakaan.
13. `private static void updateBook() { ... }`: Ini adalah metode `updateBook` yang digunakan untuk mengupdate informasi buku dalam perpustakaan. Pengguna diminta untuk memasukkan ID buku yang ingin diupdate, kemudian mereka dapat memasukkan informasi baru.
14. `private static void deleteBook() { ... }`: Ini adalah metode `deleteBook` yang digunakan untuk menghapus buku dari perpustakaan. Pengguna diminta untuk memasukkan ID buku yang ingin dihapus.
15. `private static Book findBookById(int id) { ... }`: Ini adalah metode `findBookById` yang digunakan untuk mencari buku berdasarkan ID-nya dalam daftar buku. Metode ini mengembalikan buku jika ditemukan, atau `null` jika tidak ditemukan.
Seluruh program berfokus pada manajemen perpustakaan, termasuk menambahkan, melihat, mengupdate, dan menghapus buku. Dengan menggunakan `ArrayList` dan objek `Book`, program ini menyediakan antarmuka sederhana untuk interaksi pengguna dengan perpustakaan.
