/*
 What it does
 It prompts the user to select a YES/NO option to proceed. 
	If user clicks no, the program ends
	If user clicks yes, a countdown timer begins with 5 seconds
		Once timer ends, the program prints out a picture onto the console
 

 
 How it works
 - Reads a text file (called block.x2g) [Or reports an error message]
 - Sets background color to black
 - Opens file and reads line by line
		- Temporarily stores each line as a String
		- Converts the String to a character array (to check each character in each line individually)
		- Use a SWITCH statement to check for certain characters
			- set bold and color-coding flags (based on ANSI encoding)
		- Clear all bold flags after printing each character 
			/ Clear color flag upon encountering unimportant characters
		- After each line, break a new line and add a 500ms delay to print next line
		- Once finished, closes file, resets background color schemes, and exits program
  

 NOTE: Input file may be hidden. To edit the input file, run the following command
	(after cd'ing into the Christmas folder)
	open -a TextEdit block.x2g
 
 */


import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;


public class Christmas{
	
	//ANSI color code constants 
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK_BG = "\u001B[40m";
	public static final String ANSI_DEFAULT_BG = "\u001B[40m";
	public static final String ANSI_BOLD_ON = "\u001B[1m";
	public static final String ANSI_BOLD_OFF = "\u001B[22m";

	
	public static void main(String[] args){
	
		promptUser();
		
		addDelay();
	
	}


	//timer for printing interval
	private static void addDelay(){
	
		try {
			Thread.sleep(500);                 //500 milliseconds
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
	}

	//timer for 1 second (in countdown)
	private static void secondDelay(){
		
		try {
			Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
	}
	
	//countdown prompt
	private static void showCountdown(){
	
		System.out.print(" Surprise in: 5 \r");
		secondDelay();
		System.out.print(" Surprise in: 4 \r");
		secondDelay();
		System.out.print(" Surprise in: 3 \r");		
		secondDelay();
		System.out.print(" Surprise in: 2 \r");		
		secondDelay();
		System.out.print(" Surprise in: 1 \r");
		secondDelay();
		System.out.print(" Surprise in: 0 \r");

		System.out.println(" ");
		
		
	}
	

	//open the file, read the contents, and print them  
	private static void readFile(){
	
		try {
			//File fileManager = new File("christmas-tree.txt");
			File fileManager = new File("block.x2g");

			Scanner inputFile = new Scanner(fileManager);
		
			
			//set background color to black
			System.out.println(ANSI_BLACK_BG);
			
			
			
			//parse file
			while (inputFile.hasNext()) {
				
				
			String str = inputFile.nextLine();
				char[] arr = str.toCharArray();
				
				
				for (int i = 0; i < arr.length; i++) {
					
					switch (arr[i]) {
						case '*':
							System.out.print(ANSI_BLUE);
							
							break;
							
						case '-':
							System.out.print(ANSI_GREEN);
							System.out.print(ANSI_BOLD_ON);
							
							break;
							
						case '_':
							System.out.print(ANSI_GREEN);
							System.out.print(ANSI_BOLD_ON);
							
							break;
							
						case '@':
							System.out.print(ANSI_RED);
							System.out.print(ANSI_BOLD_ON);
							
							break;
							
						case '/':
							System.out.print(ANSI_GREEN);
							System.out.print(ANSI_BOLD_ON);

							break;
							
						case '\\':
							System.out.print(ANSI_GREEN);
							System.out.print(ANSI_BOLD_ON);

							break;
							
						case '|':
							System.out.print(ANSI_GREEN);
							System.out.print(ANSI_BOLD_ON);

							break;
						
						case '~':
							System.out.print(ANSI_PURPLE);
							System.out.print(ANSI_BOLD_ON);

							break;		
							
						case 'o':
							System.out.print(ANSI_CYAN);
							System.out.print(ANSI_BOLD_ON);
							
							break;	
					
						case 'O':
							//for the Star on top
							System.out.print(ANSI_YELLOW);
							System.out.print(ANSI_BOLD_ON);
							
							break;
						
						case 'V':
							//for the Star on top
							System.out.print(ANSI_PURPLE);
							System.out.print(ANSI_BOLD_ON);
							
							break;
							
						case 'U':
							//for the Star on top
							System.out.print(ANSI_YELLOW);
							System.out.print(ANSI_BOLD_ON);
							
							break;
						
						case 'X':
							//for the Star on top
							System.out.print(ANSI_WHITE);
							System.out.print(ANSI_BOLD_ON);
							
							break;
							
						default:
							System.out.print(ANSI_RESET);
							//set bg back to black
							System.out.print(ANSI_BLACK_BG);

							break;
					}
					

					System.out.print(arr[i]);

					//turn off bold after printing each letter
					System.out.print(ANSI_BOLD_OFF);
					
					
					
				}
				//break a new line after each line is read from file
				System.out.println();
				addDelay();

							
			}
			
			
			
			//reset everything back to normal after everything finishes
			System.out.print(ANSI_DEFAULT_BG);
			System.out.print(ANSI_RESET);

			inputFile.close();
		
			//in case can't find file and throws exception
		} catch(IOException ex) {
			System.out.println("Whoops. Something went wrong");
			
		}
		
	
	}

	//prompt user to start process
	private static void promptUser(){
	
		//save JOptionPane user feedback (returned as int)
	int response = JOptionPane.showConfirmDialog(null,
					"Want to see something awesome?", "Greetings!", JOptionPane.YES_NO_OPTION);
		
		
		//check which option the user chose
		
		if(response == JOptionPane.NO_OPTION){
			System.exit(0);

		}
		else if(response == JOptionPane.YES_OPTION) {
			showCountdown();
			readFile();
			//quit the program after finished successfully
			System.exit(0);

		}

			
	}
	
	
	
}


/*
 resources
 
 http://www.tutorialspoint.com/java/java_string_tochararray.htm
 http://stackoverflow.com/questions/19720458/any-other-way-to-find-char-array-length
 http://stackoverflow.com/questions/13151714/reading-text-file-into-a-char-array-in-java
 http://stackoverflow.com/questions/3413586/string-to-string-array-conversion-in-java

 
 http://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 
 http://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 http://stackoverflow.com/questions/8396870/joptionpane-yes-or-no-window
 
 http://pueblo.sourceforge.net/doc/manual/ansi_color_codes.html
 
 http://stackoverflow.com/questions/852665/command-line-progress-bar-in-java
 

 */

