package com.example.login.modele;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfilTest {

    //creation profil

    private Profil profil= new Profil(67,165 ,35 ,0);

    //result IMG

    private float img = (float)32.2;

    //message

    private String message ="Trop élevé";



    @Test
    public void getImg() {
        assertEquals(img,profil.getImg(),(float)0.1);
    }

    @Test
    public void getMessage() {
        assertEquals(message, profil.getMessage());
    }
}