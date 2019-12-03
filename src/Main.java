import java.security.GeneralSecurityException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws GeneralSecurityException {
		
		//connect to database
		SingletonUtility utility = SingletonUtility.getInstance();
		Scanner in = new Scanner(System.in);
		int[] possibleAnswers = new int[]{1,2};
		greetingMessage();
		int response = utility.validate_input(possibleAnswers);
		
		
		
		if(response == 1){
			//TODO handle return 
			ReturnUser.promptCredentials(in);
			
		}else{
			//TODO handle new user
		}
		
		in.close();
	}
	
	public static void greetingMessage(){
		
		System.out.println("Welcome to the best password manager ever!");
		System.out.println("You'll never get hacked using this! \n");
		
		System.out.println("Are you a new or returning user?");
		System.out.println("1. Returning User");
		System.out.println("2. New User");
		
	}
	
	public static int get_response(Scanner in){
		
		int ret_Value = -1;
		
		while(true){
			System.out.print("Your selection: ");
			
			String entered_text = in.nextLine();
			
			try{
				ret_Value = Integer.parseInt(entered_text);
			}catch(Exception e){
				printInvalidMess(entered_text);
				continue;
			}
			
			if(ret_Value == 1 || ret_Value == 2){
				break;
				
			}else{
				printInvalidMess(entered_text);
				continue;
			}
			
		}
		
		
		return ret_Value;
	}
	
	public static void printInvalidMess(String entered_text){
		
		System.out.println("Your selection " + entered_text + " is not 1 or 2.");
		System.out.println("Please try again. \n");
		
	}

}
