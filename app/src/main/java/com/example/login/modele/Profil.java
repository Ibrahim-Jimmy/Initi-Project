package com.example.login.modele;

import java.util.Date;

public class Profil {

    //constantes

    public static final Integer minfemme = 15;  // maigre si en dessus
    public static final Integer maxfemme = 30;  // gros si au dessus
    public static final Integer minhomme = 10;  // maigre si en dessus
    public static final Integer maxhomme = 25;  // maigre si au dessus
    //Propriete


    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sex;
    private float img;
    private String  message;


    public Profil(Integer poids, Integer taille, Integer age, Integer sex) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sex = sex;
        this.calculImg();
        this.resultIMG();

    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSex() {
        return sex;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    private void calculImg(){

        float tailleM = ((float)taille)/100;
        this.img=(float)((1.2*poids / (tailleM*tailleM)) + (0.23*age) - (10.83 * sex) - 5.4);

    }
    private void resultIMG(){

        Integer min;
        Integer max;

        if(sex==0){ //femme
            min=minfemme;
            max=maxfemme;

        }else{ //homme
            min=minhomme;
            max=maxhomme;
        }
        //message Correspondant

        message="normal";

        if(img<min){
            message="Trop Maigre";
        }else{
            if(img>max){
                message="Trop graisse";
            }


        }


    }


}
