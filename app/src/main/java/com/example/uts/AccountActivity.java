package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uts.SharedPreference.Model.User;
import com.example.uts.SharedPreference.Preferences.UserPreferences;
import com.example.uts.databinding.ActivityAccountBinding;
import com.google.android.gms.common.internal.AccountType;

public class AccountActivity extends AppCompatActivity {

    private ActivityAccountBinding binding;
    private User user;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle(R.string.akun);

        userPreferences = new UserPreferences(this);
        user = userPreferences.getUserLogin();

        binding.tvNamaAkun.setText(user.getNama_akun());
        binding.tvUsername.setText("Username : " + user.getUsername());
        binding.tvPassword.setText("Password : " + user.getPassword());

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AccountActivity.this, "User " + user.getNama_akun() + " Telah Logout",
                        Toast.LENGTH_SHORT).show();
                userPreferences.logout();
                checkLogin();
            }
        });
    }

    private void checkLogin(){
        if(!userPreferences.checkLogin()) {
            startActivity(new Intent(AccountActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(AccountActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}