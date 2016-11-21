/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.service;

import ch.hearc.ig.odi.epicearc.business.PickupDate;
import ch.hearc.ig.odi.epicearc.presentation.beans.ProductBean;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author dimitri.mella
 */
@Named(value="pickupDateLOVConverter")
@Dependent
public class PickupDateLOVConverter implements Converter {
    
    /**
     * Injections.
     */
    @Inject Services services;
    @Inject ProductBean productBean;

    /**
     * Converts String to PickupDate.
     * 
     * @param context
     * @param component
     * @param value
     * @return PickupDate
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null) {
            return null;
        } else {
            return (PickupDate) services.getAbstractDateWithId(new Long(value));
        }
    }

    /**
     * Converts PickupDate to String.
     * 
     * @param context
     * @param component
     * @param value
     * @return String
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        } else {
            PickupDate pickupDate = (PickupDate) value;
            return pickupDate.getId().toString();
        }
    }
}
