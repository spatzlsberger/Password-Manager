import java.security.GeneralSecurityException;
import java.util.Scanner;

public class ReturnUser {
	
	public static void promptCredentials(Scanner in) throws GeneralSecurityException{
		
		System.out.print("Username: ");
		String username = in.nextLine();
		
		System.out.print("Password: ");
		String password = in.nextLine();
		
		
		login(username,password);
	}

	private static void login(String username, String password) {
		// TODO Auto-generated method stub
		
		//check to see if username exists
		String hash = lookupUser(username);
		hash = "meow";
		//check against passwords
		SingletonEncryption encryptor = SingletonEncryption.getInstance();
		System.out.println("Hashed Password: " + encryptor.encryptString(password));
		
		if(hash.equals(encryptor.encryptString(password))){
			System.out.println("You are who you say you are!");
		}
	}

	private static String lookupUser(String username) {
		// TODO Auto-generated method stub
		
		return "meow";
	}

}
