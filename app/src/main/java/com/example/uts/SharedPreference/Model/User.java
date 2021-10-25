package com.example.uts.SharedPreference.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "nama_akun")
    private String nama_akun;

    public User(int id, String password, String username, String nama_akun) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.nama_akun = nama_akun;
    }

    public User(){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama_akun() {
        return nama_akun;
    }

    public void setNama_akun(String nama_akun) {
        this.nama_akun = nama_akun;
    }
}
