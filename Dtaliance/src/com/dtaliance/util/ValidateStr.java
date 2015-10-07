package com.dtaliance.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateStr {
	public static  boolean ValidateEmail(String email){
	      if (null==email || "".equals(email)) {
	    	  return false;
	      }     
	      Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//∏¥‘”∆•≈‰  
	      Matcher m = p.matcher(email);  
	      return m.matches();  
	}
}
