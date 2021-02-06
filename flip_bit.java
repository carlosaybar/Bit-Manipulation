import java.util.Scanner;

public class flip_bit {
	static int value = 0;
	static String binary;

	public static void main(String[] args) {
		getInput();
		getBinary();
		flipBit();
	}
	
	/**
	 * this method gets an integer from the user
	 * to be represented as a binary
	 */
	public static void getInput()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter an integer: ");
		value = input.nextInt();
	}
	
	/**
	 * this method gets the integer and corts it to a binary sequence
	 * the binary is store in the string binary variable and then printed
	 * so that we can see if its converting it correctly.
	 */
	public static void getBinary()
	{
		binary = Integer.toBinaryString(value);
		System.out.println("The binary representation is: " + binary);
	}
	
	
	public static void flipBit()
	{
		int currentMax = 0; //store each sequence of one
		int sequenceOfOnes = 0; //find new sequence
		int max = 0;
		int positionOfZeros = 0; //keep track of every index where there zero sepparating two sequences of 1
		int flipIndex = 0; //this will store the index to be flipped in order to get the best sequence posible
		
		for(int i = 0; i < binary.length(); i++)
		{
			if(binary.charAt(i) == '1')
			{
				sequenceOfOnes++;
			}
			else
			{
				currentMax = sequenceOfOnes; //setting the current max to the previous sequence of ones
				sequenceOfOnes = 0; //setting the sequence to 0 to start counting the length of the new sequence
				positionOfZeros = i; //storing the index of each zero in our binary string
				
			}
			if(max < currentMax + sequenceOfOnes)
			{
				max = currentMax + sequenceOfOnes; //setting the longest sequence possible to the length of a sequence before zero
													//plus the lenght of a sequence after zero
				flipIndex = positionOfZeros; //set the index to be flipped
			}

		}
		
		System.out.println("The index that should be flipped to get the longes sequence is: " + flipIndex);
		
		char [] newBinary = new char[binary.length()];
		for(int i = 0; i < binary.length(); i++)
		{
			newBinary[i] = binary.charAt(i); //storing every value from the binary string into the newBinary Array.
		}
		
		for(int j = 0; j < newBinary.length; j++)
		{
			newBinary[flipIndex] = '1';
		}
		

		

		int longestSequence = 1;
		int count = 0;
		
		for(int i = 0; i < newBinary.length; i++)
		{
			if(newBinary[i] == '1')
			{
				count++;
			}
			if(count > longestSequence)
			{
				longestSequence = count;
			}
			else if(newBinary[i] == '0')
			{
				count = 0; //to keep track of the actual length after finishing with a previous sequence
			}
		}
		
		System.out.println("the longest sequence posible is: " + longestSequence);
		
		System.out.print("The sequence after flipping is: ");
		for(int j = 0; j < newBinary.length; j++)
		{
			System.out.print(newBinary[j]);
		}

	}
	
}
