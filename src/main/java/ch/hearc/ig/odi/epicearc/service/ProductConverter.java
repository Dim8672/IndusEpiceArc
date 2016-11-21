/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.service;

import ch.hearc.ig.odi.epicearc.business.Product;
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
@Named(value="productLOVConverter")
@Dependent
public class ProductConverter implements Converter {
    
    /**
     * Injections.
     */
    @Inject Services service;
    @Inject ProductBean productBean;

    /**
     * Converts String to Product.
     * 
     * @param context
     * @param component
     * @param value
     * @return Product
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Product product = null;
        if(value == null){
            return null;
        } else{            
            for(Product currentProduct : service.getProductsForConiferType(productBean.getConiferType())){
                if(currentProduct.getId().toString().equals(value)){
                    product = currentProduct;
                }
            }
        }
        return product;
    }

    /**
     * Converts Product to String.
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
            return ((Product)value).getId().toString();
        }
    }
    
}