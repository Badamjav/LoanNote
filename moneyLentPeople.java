package Assignment;
import java.io.*;

public class MoneyLentPeople  implements Comparable<MoneyLentPeople>
{	
	static int count;
	int id;
	String fName;
	String lName;
	String pNumber;
	int lAmount;
	Console console = new Console();
	
	
	
	// default constructor
	public MoneyLentPeople()
	{	
		count++;
		id = count;
		fName = "Unknown";
		lName = "Unknown";
		pNumber = "0000";
		lAmount = 0000;
		
	}
	// constructor with parameter 
	public MoneyLentPeople(String fName, String lName, String pNumber, int lAmount)
	{
		count++;
		id = count;
		this.fName = fName; //first name
		this.lName = lName; // last name
		this.pNumber = pNumber; // phone number
		this.lAmount = lAmount; //amount
	}
	
	// set methods
	public void setFname(String fName)
	{
		this.fName = fName;
	}
	public void setLname(String lName)
	{
		this.lName = lName;
	}
	public void setPno(String pNumber)
	{
		this.pNumber = pNumber;
	}
	
	public void setAmount(int lAmount)
	{
		this.lAmount = lAmount;
	}
	public void setAll(String fName, String lName, String pNumber, int lAmount)
	{
		setFname(fName);
		setLname(lName);
		setPno(pNumber);
		setAmount(lAmount);
	}
	// get methods for individuals
	public int getID()
	{
		return this.id;
	}
	public String getFname()
	{
		return this.fName;
	}
	public String getLname()
	{
		return this.lName;
	}
	public String getPno()
	{
		return this.pNumber;
	}
	public int getAmount()
	{
		return this.lAmount;
	}
	//compareTo method for sorting array list
	public int compareTo(MoneyLentPeople amount)
	{
		return amount.lAmount - this.lAmount;
	}
	// print methods
	public void print1()
	{
		System.out.println("--------------------------------------");
		System.out.println("Loan ID: " + id);
		System.out.println("Full Name: \t" + fName);
		System.out.println("Last Name: \t" + lName);
		System.out.println("Phone Number: " + pNumber);
		System.out.println("Amount of Money:" + lAmount);
		System.out.println("--------------------------------------");
		
	}
	
	// to string methods
	public String toString()
	{
		return String.format("%s%18s%18s%18s%10d", id,fName,lName,pNumber,lAmount); 
		//formatting toString method with the maximum sizes.
	}
	// ask from user
	public void ask(String heading)
	{
		
		System.out.println(heading);
		askFname();
		//setFname(console.askString("Enter 1st name: "));
		askLname();
		//setLname(console.askString("Enter 2nd name: "));
		askPno();
		//setPno(console.askInt("Enter phone number: "));
		askAmount();
		//setAmount(console.askInt("Enter the amount you lent: "));
		
	}
	public String askFname()
	{
		setFname(console.askString("Enter 1st name: "));
		return fName;
	}
	public String askLname()
	{
		setLname(console.askString("Enter 2nd name: "));
		return lName;
	}
	public String askPno()
	{
		setPno(console.askString("Enter Phone Number: "));
		return pNumber;
	}
	public int askAmount()
	{
		setAmount(console.askInt("Enter the amount: "));
		return lAmount;
	}
	//askID method for finding the corresponding ID number
	public int askID()
	{
		int idX = console.askInt("Enter ID; ");
		return idX;
	}
	//askName method for Search by name from the array list
	public String ask1stName(String prompt)
    {
    	setFname(console.askString("Enter the first name of person who owe you: "));
    	return fName;
    }
	//askName method for search by last name from the array list
	public String ask2ndName(String prompt)
	{
	setLname(console.askString("Enter the second name of person who owe you: "));
	return lName;
	}
}
