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

public class RegistreClient extends AppCompatActivity {

    EditText username, password, repassword;
    TextView texte;
    Button registre;
    BaseDone data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_client);

        username= findViewById(R.id.inputEmail2);

        password= findViewById(R.id.inputpasse);
        repassword= findViewById(R.id.inputPasswor);
        registre =findViewById(R.id.btnLogine);
        texte= findViewById(R.id.gotoSign);


        texte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(RegistreClient.this,MainActivity.class);
                RegistreClient.this.startActivity(intent);
            }
        });

        data = new BaseDone(this);

        registre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String users= username.getText().toString();

                String pass =password.getText().toString();
                String repass= repassword.getText().toString();

                if(TextUtils.isEmpty(users) ||  TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(RegistreClient.this,"All fileds required ", Toast.LENGTH_LONG).show();

                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = data.checkusername(users);

                        if(checkuser==false){
                            Boolean insert = data.insertData(users,pass);
                            if(insert==true){
                                Toast.makeText(RegistreClient.this,"Enregistrement reussit", Toast.LENGTH_LONG).show();

                            }else{
                                Toast.makeText(RegistreClient.this,"Enregistrement non reussit", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(RegistreClient.this,"User already Exists ", Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(RegistreClient.this,"Password and confirme password Ne pas Identique ", Toast.LENGTH_LONG).show();
                    }
                }



            }
        });
    }
}