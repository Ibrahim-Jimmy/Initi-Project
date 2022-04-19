package com.example.login.conroleur;


import com.example.login.modele.Profil;



public final class Controle {

    private static Controle instance=null;
    private Profil profil;


    /**
     * constructeur private
     */
    private Controle(){
        super();

    }

    /**
     * creation de l'instance
     * @return l'instance
     */
    public static final Controle getInstance(){
        if(Controle.instance==null){
            Controle.instance= new Controle();
        }
        return Controle.instance;
    }

    /**
     * Creation Profile
     * @param poids
     * @param taille en cm
     * @param age
     * @param sex 1 pour garçon et 0 por femme
     */
    public void creerProfil(Integer poids , Integer taille , Integer age , Integer sex){
        profil = new Profil(poids, taille, age, sex);
    }

    /**
     *  recuperation img de profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * recuperation de message de profile
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }
}
