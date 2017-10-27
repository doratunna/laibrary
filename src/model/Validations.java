/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sith7
 */
public class Validations {
     private Pattern pattern;
	private Matcher matcher;
        private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
   

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	

	/**
	 * Validate hex with regular expression
	 *
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean emailValidate(final String hex) {
                pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
        
        public boolean ContactValidate(String sPhoneNumber){
        pattern = Pattern.compile("\\d{2}-\\d{10}");
      
       matcher = pattern.matcher(sPhoneNumber);
       return matcher.matches();
        }
        
        
         public boolean UserNameValidate(final String username){
                  pattern = Pattern.compile(USERNAME_PATTERN);
		  matcher = pattern.matcher(username);
		  return matcher.matches();

	  }
    
         
         public boolean FirstNamevalidate( String firstName )
   {
      return firstName.matches( "[a-zA-Z]*" );
   } // end method validateFirstName

   // validate last name
   public boolean LastNamevalidate (String lastName )
   {
      return lastName.matches( "[a-zA-Z]*" );
   }
   
    

     public boolean idValidate(final String id){
      String regex = "\\d+";
      System.out.println(id.matches(regex));
      return id.matches(id);
     
     }
     
     public static void main(String[] args)
     {
         
         Validations v=new Validations();
     System.out.println(v.idValidate("77"));
     }
    
}
