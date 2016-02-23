/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.festivities.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author keihell
 */
@XmlRootElement
public class Festivity {
    @XmlElement
    private String name;
    @XmlElement
    private String place;
    @XmlElement
    private Date start;
    @XmlElement
    private Date end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj instanceof Festivity){
            Festivity fest = (Festivity) obj;
            if((fest.getStart().equals(this.start)) 
                    && (fest.getEnd().equals(this.getEnd())) 
                    && (fest.getPlace().equals(this.getPlace()))){
                return true;
            }
            return false;
        }
        return false;
    }
    
}
