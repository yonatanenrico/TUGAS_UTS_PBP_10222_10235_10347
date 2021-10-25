package com.example.uts.entity;

public class Menu {
    private String nama_menu;
    private int harga;

    public Menu(String nama_menu, int harga)
    {
        this.nama_menu = nama_menu;
        this.harga = harga;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
