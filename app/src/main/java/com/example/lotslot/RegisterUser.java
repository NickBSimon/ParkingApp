package com.example.lotslot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private EditText _registerUsername, _registerPassword, _registerEmail;
    private Button _registerButton;
    private FirebaseAuth mAuth;
    private ProgressBar _progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        _registerUsername = (EditText) findViewById(R.id.registerUsername);
        _registerEmail = (EditText) findViewById(R.id.registerEmail);
        _registerPassword = (EditText) findViewById(R.id.registerPassword);
        _progressBar = (ProgressBar) findViewById(R.id.progressBar);

        _registerButton = (Button) findViewById(R.id.registerButton);
        _registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerButton:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String email = _registerEmail.getText().toString().trim();
        String username = _registerUsername.getText().toString().trim();
        String password = _registerPassword.getText().toString().trim();
        if (email.isEmpty()) {
            _registerEmail.setError("Please enter an email");
            _registerEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _registerEmail.setError("Please enter a valid email");
            _registerEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            _registerPassword.setError("Please create a password");
            _registerPassword.requestFocus();
            return;
        }

        if (username.isEmpty()) {
            _registerUsername.setError("Please create a username");
            _registerUsername.requestFocus();
            return;
        }
        if (password.length() < 6) {
            _registerPassword.setError("Please enter a longer password (6 characters)");
            _registerPassword.requestFocus();
            return;
        }

        _progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(email, username, password);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterUser.this, "User has been registered successfully", Toast.LENGTH_LONG).show();
                                        _progressBar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(RegisterUser.this, "Failed to register", Toast.LENGTH_LONG).show();
                                        _progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }
                        else{
                            Toast.makeText(RegisterUser.this, "Failed to register", Toast.LENGTH_LONG).show();
                            _progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}