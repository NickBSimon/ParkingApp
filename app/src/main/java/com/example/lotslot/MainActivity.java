package com.example.lotslot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView register;
    private EditText _email, _password;
    private Button _signIn;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (TextView) findViewById(R.id.registerNewUser);
        register.setOnClickListener(this);

        _signIn = (Button) findViewById(R.id.signIn);
        _signIn.setOnClickListener(this);

        _email = (EditText) findViewById(R.id.loginEmail);
        _password = (EditText) findViewById(R.id.loginPassword);
        progressBar = (ProgressBar) findViewById(R.id.signInProgBar);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.registerNewUser:
                startActivity(new Intent(this, RegisterUser.class));
                break;
            case R.id.signIn:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String email = _email.getText().toString().trim();
        String password = _password.getText().toString().trim();

        if(email.isEmpty()){
            _email.setError("Email required to login");
            _email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _email.setError("Please enter a valid email");
            _email.requestFocus();
            return;
        }
        if (password.isEmpty()){
            _password.setError("Password required to login");
            _password.requestFocus();
            return;
        }
        if(password.length() < 6){
            _password.setError("Invalid password");
            _password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this, homeActivity.class));
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid login credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}