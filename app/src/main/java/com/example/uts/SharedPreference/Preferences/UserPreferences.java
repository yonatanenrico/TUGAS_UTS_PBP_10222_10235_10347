package com.example.uts.SharedPreference.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.uts.SharedPreference.Model.User;

public class UserPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_NAMA_AKUN = "nama_akun";

    public UserPreferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userPreferences",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setUser(int id, String password, String username, String nama_akun){
        editor.putBoolean(IS_LOGIN, true);
        editor.putInt(KEY_ID,id);
        editor.putString(KEY_PASSWORD,password);
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_NAMA_AKUN,nama_akun);
        editor.commit();
    }

    public User getUserLogin(){
        String password,username,nama_akun;
        int id;

        id = sharedPreferences.getInt(KEY_ID,0);
        password = sharedPreferences.getString(KEY_PASSWORD,null);
        username = sharedPreferences.getString(KEY_USERNAME,null);
        nama_akun = sharedPreferences.getString(KEY_NAMA_AKUN,null);
        return new User(id,password,username,nama_akun);
    }

    public boolean checkLogin(){
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }

    public void logout(){
        editor.clear();
        editor.commit();
    }
}
