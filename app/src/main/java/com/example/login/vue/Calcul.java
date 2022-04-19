package com.example.login.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.conroleur.Controle;

public class Calcul extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);

         initi();
         this.controle= Controle.getInstance();

    }

    private EditText txtpoids;
    private EditText txttaille;

    private EditText txtage;
    private RadioButton rHomme;

    private TextView imglbl;
    private ImageView imgSmile;
    private Controle controle;


    /**
     * Initialisation des liens avec les objets graphique
     */
        private void initi(){

            txtpoids=(EditText) findViewById(R.id.txtpoids);
            txttaille=(EditText) findViewById(R.id.txttaille);
            txtage=(EditText) findViewById(R.id.txtage);
            rHomme=(RadioButton) findViewById(R.id.rHomme);
            imglbl=(TextView) findViewById(R.id.imglbl);
            imgSmile=(ImageView) findViewById(R.id.imgSmile);
            ecouteCalcul();
        }

    /**
     * Ecoute evenement sur Button Calcul
     */

    private void ecouteCalcul(){

            ((Button) findViewById(R.id.btn)).setOnClickListener(new Button.OnClickListener(){

                public void onClick(View v){

                    Integer poids=0;
                    Integer taille=0;
                    Integer age=0;
                    Integer sexe=0;

                    // recuperation de données saisies

                    try{
                    poids= Integer.parseInt(txtpoids.getText().toString());
                    taille= Integer.parseInt(txttaille.getText().toString());
                    age= Integer.parseInt(txtage.getText().toString());
                    }catch (Exception e ){ };

                    if(rHomme.isChecked()){
                        sexe=1;
                    }
                    // contrôle de données saisie
                    if(poids==0 || taille==0 || age==0){
                        Toast.makeText(Calcul.this, "veillez remplir tous les champs ",Toast.LENGTH_LONG).show();
                    }else{
                        AfficheResult(poids,taille,age,sexe);
                    }
            }
        });
}

    /**
     *  Affichage de L'IMG, du message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */

        @SuppressLint("ResourceAsColor")
        private void AfficheResult(Integer poids, Integer taille , Integer age , Integer sexe){
            // creation du profil et recuperation des informations

            this.controle.creerProfil(poids, taille, age, sexe);
            float img= this.controle.getImg();
            String message= this.controle.getMessage();
            //Affichage

            if(message=="normal"){
                imgSmile.setImageResource(R.drawable.hom_normal);
                imglbl.setTextColor(R.color.colorAccente);


            }else{
                if(message=="Trop Maigre"){
                    imgSmile.setImageResource(R.drawable.hom_maigre);
                    imglbl.setTextColor(R.color.colorPrimaryDark);
                }else{
                    imgSmile.setImageResource(R.drawable.hom_obese);
                    imglbl.setTextColor(R.color.purple_200);
                }
            }
            imglbl.setText(String.format("%.01f",img)+" : IMG "+message);
        }
}