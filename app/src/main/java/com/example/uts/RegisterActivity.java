package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uts.SharedPreference.Model.User;
import com.example.uts.SharedPreference.Preferences.UserPreferences;
import com.example.uts.SharedPreference.Room.DatabaseClient;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText etPassword, etUsername, etNamaAkun;
    private MaterialButton btnClear, btnRegister;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle(R.string.register);

        userPreferences = new UserPreferences(RegisterActivity.this);

        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
        etNamaAkun = findViewById(R.id.etNamaAkun);

        btnClear = findViewById(R.id.btnClear);
        btnRegister = findViewById(R.id.btnRegister);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearField();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateForm()){
                    register(etPassword.getText().toString().trim(), etUsername.getText().toString().trim(),
                            etNamaAkun.getText().toString().trim());
                }
            }
        });
    }

    private void register(String password, String username, String nama_akun){

        class RegisterUser extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User();
                user.setPassword(password);
                user.setUsername(username);
                user.setNama_akun(nama_akun);

                DatabaseClient.getInstance(RegisterActivity.this)
                        .getDatabase()
                        .userDao()
                        .registerUser(user);

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(RegisterActivity.this, "Selamat! Anda Berhasil Mendaftar", Toast.LENGTH_SHORT).show();
                clearField();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }

        }

        RegisterUser registerUser = new RegisterUser();
        registerUser.execute();
    }

    private void clearField(){
        etPassword.setText("");
        etUsername.setText("");
        etNamaAkun.setText("");
    }

    private boolean validateForm(){
        /* Check data is empty or not */
        if(etPassword.getText().toString().trim().isEmpty() || etUsername.getText().toString().trim().isEmpty()
                || etNamaAkun.getText().toString().trim().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Tolong isi field yang kosong",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}