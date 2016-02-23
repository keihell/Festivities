/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.festivities.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author keihell
 */
@XmlRootElement
public class ModifiedFestivity {
    @XmlElement
    private String festivityName;
    @XmlElement
    private String fieldToChange;
    @XmlElement
    private String newValue;

    public String getFestivityName() {
        return festivityName;
    }

    public void setFestivityName(String festivityName) {
        this.festivityName = festivityName;
    }

    public String getFieldToChange() {
        return fieldToChange;
    }

    public void setFieldToChange(String fieldToChange) {
        this.fieldToChange = fieldToChange;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
    
    
}
