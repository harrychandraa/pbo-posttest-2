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
