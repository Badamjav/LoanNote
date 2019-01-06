package Assignment;

public class Menu {
	static LoanNote loanNote = new LoanNote();
	static MoneyLentPeople moneyLentPeople; 
	static boolean isFinished = false;
	static char option;
	static Console console = new Console();
	
	public static void main(String[] args) throws Exception 
	{	
		//start();
		// main
		while(!isFinished) 
		{
			option = console.askChar("-------------------\nPress for: \n a)-> Add:\n c)-> Count:\n p)-> Print:\n w)-> Sort:\n "
					+ "s)-> Search By Full Name:\n f)-> Find and Delete: \n d)-> Delete Last Entry:\n q)-> Quit!!");
			System.out.println("---------------------------------------");
			switch(option)
			{
			case 'A': addHandler();  break;
			case 'C': countHandler(); break;
			case 'P': printHandler(); break;
			case 'W': sortHandler(); break;
			case 'S': searchByNameHandler(); break;
			case 'F': findNdelHandler(); break;
			case 'D': deleteHandler(); break;
			case 'Q': exitHandler(); break;
			default:
				System.out.println("Invalid Option");
			}
			// Add sort, search and remove, edit.
		}
	}
	
	// Switch Handlers
	
	// start method which initiates the file/
	public static void start()
	{
		try
		{
			loanNote.open("debtNote.dat");// pre-defined name
			System.out.println("File is opened");
		}
		catch (Exception e)
		{
			System.out.println("File not created yet!");
		}
	}
	
	
	
	//add Handler for the LoanNote
	public static void addHandler()
	{
		moneyLentPeople = new MoneyLentPeople(); //initiating new instance of this class to save the difference.
		moneyLentPeople.ask("Enter details for people!!! "); //Asking details for user to enter for info
		loanNote.add(moneyLentPeople);
		
		System.out.println("---------------------------------------");
	}
	
	
	
	// count Handler
	public static void countHandler()
	{
		System.out.println("The number of the people who owe you: " + loanNote.getSize());
	}
	
	
	
	// Print Handler for printing out list
	public static void printHandler()
	{
		loanNote.print("Those are the People who owe you money: ");
	}
	
	
	
	// Search by name handler
	public static void searchByNameHandler() 
	{
		String firstName = moneyLentPeople.ask1stName("Enter 1st name: ");
		String lastName = moneyLentPeople.ask2ndName("Enter 2nd name: ");
		if(loanNote.search(firstName, lastName) != null) 
		{
			System.out.println("The person found is: "+ loanNote.search(firstName, lastName));
		}
		else
			System.out.println("There is no such person!!!");
	}
	
	
	//find and delete objects by its index
	public static void findNdelHandler()
	{
		String fname = console.askString("Enter the 1st name: ");
		String lname = console.askString("Enter the 2nd name: ");
		if(loanNote.findIndex(fname, lname) != -1)
		{
			loanNote.delete(fname, lname);
			System.out.println("Entries deleted: " + fname + " ,"+ lname);
		}
		else
		{
			System.out.println("Can not find anything!");
		}
	}
	
	
	//	Deleting the last entry
	public static void deleteHandler()
	{
		loanNote.delete1(moneyLentPeople);
		System.out.println("Last entry has been deleted successfully!");
	}
	//	Quit Handler when exiting it will automatically save data to file named debtNote.
	public static void exitHandler() throws Exception
	{
		System.out.println("Application will automatically save data file");
		System.out.println("End of the Application!!!");
		isFinished = true;
		//loanNote.save("debtNote.dat");
	}
	
	public static void sortHandler()
	{
		loanNote.sortAmount();
		
		
	}
}






