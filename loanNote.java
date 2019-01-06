package Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
public class LoanNote  
{
	ArrayList<MoneyLentPeople>loanNote; //Initialising Array list containing MoneyLent objects.
	ArrayList<String>key1;				//Initialising  Array List for String data type on 
	ArrayList<String>key2;				//Initialising Array List for String data type on 
	
	// constructor
	public LoanNote()
	{
		loanNote = new ArrayList<MoneyLentPeople>();
		key1 = new ArrayList<String>(); //creating string array list for first name 
		key2 = new ArrayList<String>();//creating string array list for last name
		
	}
	
	
	// get size of array list
	public int getSize() 
	{
		return loanNote.size();	//retrieving the size of the main Array List
	}

	
	//add items to loan Note Array list
	public void add(MoneyLentPeople moneyLentPeople)
	{
			loanNote.add(moneyLentPeople);			// Adding moneyLent class objects to the Array List
			key1.add(moneyLentPeople.getFname());	// Adding first name to key 1 Array List
			key2.add(moneyLentPeople.getLname());
		
	}
	
	
	public void print(String heading)
	{
		System.out.println(heading); //Printing out the heading text to user
		System.out.println(String.format("%s%18s%18s%18s%10s", "Id","First Name", "Last Name", "Phone Number", "Amount\n"));//formatting toString method with the maximum sizes.
		for(int i=0; i<loanNote.size(); i++) //looping from 1st element of ArrayList to its end
		{
			System.out.println(loanNote.get(i)); 
			// Printing out all the elements in the Array list
		}
	}
	
	
	//delete method to remove instances from Array list
	public void delete1(MoneyLentPeople moneyLentPeople)
	{
		loanNote.remove(moneyLentPeople);
		key1.remove(moneyLentPeople.getFname());
		key2.remove(moneyLentPeople.getLname());
		
	}
	
	
	// search method by first name
	public MoneyLentPeople search(String fName, String lName)
	{
		int index1 = key1.indexOf(fName);
		int index2 = key2.indexOf(lName);
		if(index1 == -1 && index2 == -1)
		{
			return null;
		}
		else
			return loanNote.get(index1);
	}
	
	
	//finding index of the array list objects
	public int findIndex(String fname, String lname)
	{
		for(int i=0; i<loanNote.size(); i++)
		{
			if((loanNote.get(i).getFname()).equals(fname) &&
					(loanNote.get(i).getLname()).equals(lname))
					return i;
		}
		return -1;
		
	}
	
	
	//delete by 
	public void delete(String fname, String lname)
	{
		loanNote.remove(findIndex(fname, lname));
	}
	
	
	
	// sortAmount method to sort by amount of money people have lent from you
	public void sortAmount()
	{
		Collections.sort(loanNote);
		System.out.println("List has been sorted succeffully by Amount!!");
		System.out.println(String.format("%s%18s%18s%18s%10s", "Id", "First Name", "Last Name", "Phone Number", "Amount\n"));
		
		//printing out the sorted Array List
		for(MoneyLentPeople moneyLentPeople: loanNote)
		{
			System.out.println(String.format("%s%18s%18s%18s%10s",moneyLentPeople.getID(),moneyLentPeople.getFname(),moneyLentPeople.getLname(),moneyLentPeople.getPno(),moneyLentPeople.getAmount()));
		}
	}


	// save method to save the file to file system in binary.
	@SuppressWarnings("resource")
	public void save(String fileName) throws Exception
	{
		FileOutputStream outFile;
		try // to open file
		{
			outFile = new FileOutputStream(fileName);
		}
		catch (IOException io)
		{
			throw new Exception("Cannot create " + fileName);
		}
		ObjectOutputStream dataFile;
		try  // to write file
		{
			dataFile = new ObjectOutputStream(outFile);
			dataFile.writeObject(loanNote);
			dataFile.writeObject(key1);
		}
		catch (IOException io)
		{
			throw new Exception("Cannot write to " + fileName);
		}
		try // to close file
		{
			dataFile.close();
		}
		catch (IOException io)
		{
			throw new Exception("Cannot close " + fileName);
		}
	}

	// open method to open data from file system.
	@SuppressWarnings({ "resource", "unchecked" })
	public void open(String fileName) throws Exception
	{
		FileInputStream inFile;
		try // to open file
		{
			inFile = new FileInputStream(fileName);
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("File " + fileName + " not found.");
		}

		ObjectInputStream dataFile;
		try // to read file
		{
			dataFile = new ObjectInputStream(inFile);
			key1 = (ArrayList<String>)dataFile.readObject();
			loanNote = (ArrayList<MoneyLentPeople>)dataFile.readObject();
		}
		catch (IOException e)
		{
			throw new Exception("Error reading from " + fileName);
		}
		catch (ClassNotFoundException e)
		{
			throw new Exception("Error reading from " + fileName);
		}
		try
		{
			// to close file
			dataFile.close();
		}
		catch (IOException e)
		{
			throw new Exception("Cannot close " + fileName);
		}
	} // end open

}

