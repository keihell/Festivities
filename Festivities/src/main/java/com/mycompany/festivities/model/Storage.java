/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.festivities.model;

import java.util.ArrayList;

/**
 *
 * @author Camilo Macias
 */
public final class Storage {
    private static ArrayList<Festivity> festivities = new ArrayList<>();
    
    //Avoid creating instances
    private Storage(){}
    
    public static void addFestivity(Festivity f){
        festivities.add(f);
    }
    
    public static Festivity getFestivityAt(int index){
        if(index < 0 || index > festivities.size()){
            return null;
        }
        return festivities.get(index);
    }
    
    public static int getNumberOfFestivities(){
        return festivities.size();
    }
}
