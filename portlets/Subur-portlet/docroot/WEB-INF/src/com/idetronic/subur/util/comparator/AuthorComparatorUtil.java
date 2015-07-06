package com.idetronic.subur.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AuthorComparatorUtil {
	public static OrderByComparator getUserOrderByComparator(
	
	String orderByCol, String orderByType) {
	  
	  
		boolean orderByAsc = false;
	 
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
	 
		OrderByComparator orderByComparator = null;
	   
	   
		if (orderByCol.equalsIgnoreCase("firstName")) {
	    
			orderByComparator = new AuthorFirstNameComparator(orderByAsc);
		} 
		
	   else if (orderByCol.equalsIgnoreCase("lastName")) {
	    
	    orderByComparator = new AuthorLastNameComparator(orderByAsc);
	   }
	   else if (orderByCol.equalsIgnoreCase("itemCount")) {
	    
	    orderByComparator = new AuthorItemCountComparator(orderByAsc);
	   }/*
	   else if (orderByCol.equalsIgnoreCase("Job Title")) {
	    
	    orderByComparator = new JobTitleComparator(orderByAsc);
	   }*/
	   
	   return orderByComparator;
	}

}
