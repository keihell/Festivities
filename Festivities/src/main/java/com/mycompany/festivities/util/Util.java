/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.festivities.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author keihell
 */
public class Util {
    
    public static Date turnStringDateToDate(String strDate){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");			
        Date date = null;
	try {
            date = formatter.parse(strDate);
	} catch (ParseException e) {
            System.out.println("There was an error turning "+strDate+" to Date...");
	}
        return date;
    }
    
    public static String turnDateToStringDate(Date date){
        return date.toString();
    }
}
