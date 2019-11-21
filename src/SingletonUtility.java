import java.util.Scanner;

public class SingletonUtility {
	
	private static SingletonUtility single_instance = null;
	
	private SingletonUtility(){
		
	}
	
	public static SingletonUtility getInstance(){
		if(single_instance == null)
			single_instance = new SingletonUtility();
		
		return single_instance;
	}
	
	public int validate_input(int[] possibleAnswers, String promptMessage){
		
		Scanner in = new Scanner(System.in);
		
		if (promptMessage.isEmpty())
			promptMessage = "Your Selection: ";
		
		int ret_Value = -1;
		
		while(true){
			System.out.print(promptMessage);
			
			String entered_text = in.nextLine();
			
			try{
				ret_Value = Integer.parseInt(entered_text);
			}catch(Exception e){
				printInvalidMess(entered_text);
				continue;
			}
			//TODO implement array passing in to check
			if(ret_Value == 1 || ret_Value == 2){
				break;
				
			}else{
				printInvalidMess(entered_text);
				continue;
			}
		}
		
		in.close();
		
		return ret_Value;
	}
	
	@SuppressWarnings("unused")
	public int validate_input(int[] possibleAnswers){
		return validate_input(input,possibleAnswers,"");
	}
		
	private void printInvalidMess(String entered_text){
		
		System.out.println("Your selection " + entered_text + " is not 1 or 2.");
		System.out.println("Please try again. \n");
		
	}

}
