package Game;

import java.util.Scanner;

public class NumberGuessingGame {
	static int upperlimit;
	static int lowerlimit;
	static String type;
	static int NUMBER;
	public static void main(String[] args)
	{
		System.out.println("Can You Guess My Number :) ?");
		System.out.println("__________________________________________"+"\n");
		System.out.println("Do you want it to be with limited Attempts or unlimited Attempts ?");
		Scanner sc=new Scanner(System.in);
		type=sc.next();
		type= type.toLowerCase();
		while (!(type.equals("unlimited") || type.equals("limited")))
		{
			System.out.println("Do you want it to be with limited Attempts or unlimited Attempts ?");
			type=sc.next();
			type =type.toLowerCase();
		}
		System.out.println("Now , Choose the Range : ");
		System.out.print ("Lower Limit : "); lowerlimit=sc.nextInt();
		System.out.print ("Upper Limit : "); upperlimit=sc.nextInt();
		
		while( upperlimit <= lowerlimit)
		{
			System.out.println("The Upper Limit must be Greater Than Lower Limit !");
			System.out.print ("Upper Limit :"); 
			upperlimit=sc.nextInt();
		}
		String answer;
		if (type.equals("limited"))
		{
			Limited();
			System.out.println("Do You Want Extra Rounds ?");
			answer=sc.next();
			answer= answer.toLowerCase();
			while (answer.equals("yes"))
			{
				Limited();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Do You Want Extra Rounds ?");
				answer=sc.next();
				answer= answer.toLowerCase();
			}
		}
		else 
		{
			Unlimited();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Do You Want Extra Rounds ?");
			answer=sc.next();
			answer= answer.toLowerCase();
			while (answer.equals("yes"))
			{
				Unlimited();
				System.out.println("Do You Want Extra Rounds ?");
				answer=sc.next();
				answer= answer.toLowerCase();
			}
		}
		
			System.out.println("Thank You ! Bye Bye ");
	}
	static void Limited()
	{
		Scanner sc=new Scanner(System.in);
		int guess;
		int numattempts;
		NUMBER = (int)( Math.random() *( upperlimit - lowerlimit + 1 )) + lowerlimit;
		if (upperlimit-lowerlimit <=5)
			numattempts=3;
		else if (upperlimit-lowerlimit<=20)
			numattempts=5;
		else if (upperlimit-lowerlimit<=50)
			numattempts=10;
		else if (upperlimit-lowerlimit<=100)
			numattempts=15;
		else 
			numattempts=30;
		
		int val=1000/numattempts;
		int score=1000;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Guess The Number from "+lowerlimit+" to "+upperlimit+"\nSCORE = "+score+"\nATTEMPTS = "+numattempts);
		guess=sc.nextInt();
		while ((--numattempts)>0)
		{
			score -= val ;

			if (guess==NUMBER)
			{
				System.out.println ("It is Correct ! \nAnd Your Score = " + (score+val));
				return;
			}
			else if (guess<NUMBER)
			{
				System.out.println("It is Less than My NUMBER ! Try Again .\n"
						+ "Your Attempts now = " + numattempts+"\nYour Score now = "+score);
			}
			else 
			{
				System.out.println("It is Greater Than My Number ! Try Again .\n"
						+ "Yor Attempts now = " + numattempts+"\nYour Score now = "+score);
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			guess=sc.nextInt();
		}
		if (guess==NUMBER)
		{
			System.out.println ("It is Correct !");
			return;
		}
		
		System.out.println("Your Attempts finished :( And You couldn't Guess my NUMBER ! "
				+ "Your Score = 0 ");
		
	}
	static void Unlimited()
	{
		Scanner sc=new Scanner(System.in);
		int guess;
		int numattempts;
		NUMBER = (int)( Math.random() *( upperlimit - lowerlimit + 1 )) + lowerlimit;
		
		System.out.println("Guess The Number from "+lowerlimit+" to "+upperlimit);
		guess=sc.nextInt();
		while (true)
		{
			if (guess==NUMBER)
			{
				System.out.println ("It is Correct !");
				return;
			}
			else if (guess<NUMBER)
			{
				System.out.println("It is Less than My NUMBER ! Try Again .");
			}
			else 
			{
				System.out.println("It is Greater Than My Number ! Try Again .");
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			guess=sc.nextInt();
		}
	}
}
