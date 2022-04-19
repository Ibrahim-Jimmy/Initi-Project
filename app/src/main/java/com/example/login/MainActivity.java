package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.vue.Calcul;

public class MainActivity extends AppCompatActivity {


    EditText username, password;
    Button button;
    BaseDone database;

    TextView registre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        username= findViewById(R.id.inputEmail);
        password= findViewById(R.id.inputPassword);
        button= findViewById(R.id.btnLogin);
        database = new BaseDone(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String users= username.getText().toString();
                String pass= password.getText().toString();

                if(TextUtils.isEmpty(users) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivity.this,"All fileds required", Toast.LENGTH_LONG).show();
                else{
                    Boolean checkuserpass= database.checkusernamepassword(users,pass);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this,"Login reussit", Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(getApplicationContext(), Calcul.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"Login failed", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        registre= findViewById(R.id.gotoRegister);

        registre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this, RegistreClient.class);
                MainActivity.this.startActivity(intent);
            }
        });


    }
}