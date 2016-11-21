/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.service;

import ch.hearc.ig.odi.epicearc.business.DeliveryDate;
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
@Named(value="deliveryDateLOVConverter")
@Dependent
public class DeliveryDateLOVConverter implements Converter {
    
    /**
     * Injections.
     */
    @Inject Services services;
    @Inject ProductBean productBean;

    /**
     * Converts String to DeliveryDate.
     * 
     * @param context
     * @param component
     * @param value
     * @return Object instance of DeliveryDate
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null) {
            return null;
        } else {
            return (DeliveryDate) services.getAbstractDateWithId(new Long(value));
        }
    }

    /**
     * Converts DeliveryDate to String.
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
            DeliveryDate deliveryDate = (DeliveryDate) value;
            return deliveryDate.getId().toString();
        }
    }
    
}
