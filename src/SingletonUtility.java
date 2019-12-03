import java.util.Scanner;
import java.util.Arrays;

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
		Arrays.sort(possibleAnswers);
		
		
		while(true){
			System.out.print(promptMessage);
			
			String entered_text = in.nextLine();
			
			try{
				ret_Value = Integer.parseInt(entered_text);
			}catch(Exception e){
				printInvalidMess(entered_text,possibleAnswers);
				continue;
			}
			//TODO implement array passing in to check
			
			//if entered value in array of possibleAnswers, we found a good input

			if(Arrays.binarySearch(possibleAnswers, ret_Value) >= 0){
				break;
				
			}else{
				printInvalidMess(entered_text,possibleAnswers);
				continue;
			}
		}
		
		in.close();
		
		return ret_Value;
	}
	
	public int validate_input(int[] possibleAnswers){
		return validate_input(possibleAnswers,"");
	}
		
	private void printInvalidMess(String entered_text, int[] possibleAnswers){
		
		System.out.println("Your selection: " + entered_text + " is not an accepted value.");
		System.out.println("Accepted values are: ");
		for (int num : possibleAnswers){
			System.out.print(Integer.toString(num) + ", ");
		}
		System.out.print("\n");
	}

}
