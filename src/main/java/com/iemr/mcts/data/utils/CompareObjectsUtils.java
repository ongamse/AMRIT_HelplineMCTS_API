package com.iemr.mcts.data.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;


public class CompareObjectsUtils {

	public static String compareObjects(Object oldObject, Object newObject, Map<String, String> fields)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		BeanMap map = new BeanMap(oldObject);
		StringBuilder stringBuilder = new StringBuilder("");

		PropertyUtilsBean propUtils = new PropertyUtilsBean();

		for (Object propNameObject : map.keySet()) {
			String propertyName = (String) propNameObject;
			String oldValue = null;
			String newValue = null;
			Object property1 = propUtils.getProperty(oldObject, propertyName);
			Object property2 = propUtils.getProperty(newObject, propertyName);
			
			if(property1 != null){
				
				oldValue = String.valueOf(property1);
			}
			
			if(property2 != null){
				
				newValue = String.valueOf(property2);
			}
			
			propertyName = propertyName.substring(0,1).toUpperCase()+propertyName.substring(1, propertyName.length());
			String column = fields.get(propertyName)!=null?fields.get(propertyName):propertyName;
			
			if (oldValue != null && newValue != null && ! propertyName.equalsIgnoreCase("LastModDate")) {
				if (!newValue.equalsIgnoreCase(oldValue)) {

					stringBuilder.append(column + " is changed from " + oldValue + " to " + newValue +"| ");
				}
			}else{
				
				if(newValue != null && ! propertyName.equalsIgnoreCase("beneficiaryID") && 
						! propertyName.equalsIgnoreCase("FileID") && ! propertyName.equalsIgnoreCase("LastModDate")){
					
					stringBuilder.append(column+ " is added " + newValue +"| ");
				}
			}
		}

		return stringBuilder.toString();
	}

}
