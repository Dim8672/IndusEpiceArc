/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.service;

import ch.hearc.ig.odi.epicearc.business.ConiferType;
import ch.hearc.ig.odi.epicearc.presentation.beans.ProductBean;
import java.util.List;
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
@Named(value="coniferTypeLOVConverter")
@Dependent
public class ConiferTypesConverter implements Converter {
    
    /**
     * Injections.
     */
    @Inject Services services;
    @Inject ProductBean productBean;
    
    /**
     * Converts String to ConiferType.
     * 
     * @param context
     * @param component
     * @param value
     * @return Object instance of ConiferType
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null){
            return null;
        } else {
            List<ConiferType> listConiferType = services.getConiferTypes();
            for(ConiferType coniferType: listConiferType){
                if(coniferType.getCode().equals(value)){
                    return coniferType;
                }
            }
            return null;
        }
    }

    /**
     * Converts ConiferType to String.
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
            ConiferType coniferType = (ConiferType) value;
            return coniferType.getCode();
        }
    }
    
}