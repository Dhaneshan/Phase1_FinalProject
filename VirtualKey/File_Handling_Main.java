package VirtualKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class File_Handling_Main 
{
	private static void Fileadd(String file_path)
	{
		// TODO Auto-generated method stub
		System.out.println("Enter File Name:");
		Scanner a1=new Scanner(System.in);
		String Name=a1.next();
		String Final=file_path+Name;
		File B1=new File(Final);
		 try
		 {
			if (B1 .createNewFile()) 
			        System.out.println("File " + B1 .getName()+" Created Successfully");
		}
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void Retrive(String file_path) 
	{
		// TODO Auto-generated method stub
		File B=new File(file_path);
		File filename[]=B.listFiles();
		for(File C:filename)
		{
			System.out.println(C.getName());
		}
	}
  private static void Search(String file_path) throws IOException
  {
	// TODO Auto-generated method stub
	Scanner a3 = new Scanner(System.in);
	System.out.println("Enter File Name to Search");
	String file_name= a3.next();
	int flag=0;
	File files = new File(file_path);
	File filenames[] =files.listFiles();
	for(File ff:filenames)
	{
		if(ff.getName().equals(file_name))
		{
			flag=1;
			break;
		}
		else
		{
			flag=0;
		}
	}
	if(flag==1) 
	{
		System.out.println("\nFile Found in Location:--------- "+file_path);
		System.out.println("\nWant To See "+file_name+" File Content? (Y/N)");
		String y=a3.next();
		String yes="y";
		String no="n";
		if(y.equalsIgnoreCase(yes))
		{
			String finalpath=file_path+file_name;
			FileInputStream fi=new FileInputStream(finalpath);
			System.out.println("--------------Displaying "+file_name+" File Content---------------------");
			int i=0;
			//-1 is EOF
			while((i=fi.read())!=-1){
				System.out.print((char)i);
			}
			System.out.println();
			fi.close();
			

		}
		else if(y.equalsIgnoreCase(no))
		{
			System.out.println("Cancelled");
		}
		else
		{
			System.out.println("Invalid Input ");
		}
		
	}
	else
	{
		System.out.println("Sorry! File Does Not Exist");
	}
}
   private static void FileDelete(String file_path) 
   {
	// TODO Auto-generated method stub
	Scanner a4 = new Scanner(System.in);
	System.out.println("Enter File name to be deleted: ");
	String fname=a4.next();
	String finalpath=file_path+fname;
	File f1 = new File(finalpath);
	File f = new File(file_path);
	File filenames[] =f.listFiles();
	int flag=0;
	for(File ff:filenames)
	{
		
		if(ff.getName().equals(fname))
		{
			flag=1;
			break;	
		}
		else
		{
			flag=0;
		}
	}
	if(flag==1)
	{
		f1.delete();
		System.out.println("File "+fname +" deleted successfully");
	}
	else 
	{
		System.out.println("Sorry File Not Found");
	}
}
private static void FileAddwithContent(String file_path) throws IOException {
	// TODO Auto-generated method stub
	System.out.println("Enter File Name:");
	Scanner a2=new Scanner(System.in);
	String Name=a2.next();
	String FinalContent=file_path+Name;
	File B2=new File(FinalContent);
	 try
	 {
		if (B2 .createNewFile()) 
		        System.out.println("File " + B2 .getName()+" Created Successfully");
	}
	 catch (IOException e) 
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	 FileWriter FW =new FileWriter(FinalContent);
	 String Content=a2.next();
	 FW.write(Content);
	 System.out.println("Content in "+Name+" is written Successfully");
	 FW.close();
}
   public static void main(String [] args)throws IOException
   {
	   int Choice;
	   String File_path="F:\\Files\\";
	   System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	   System.out.println("--------------------------------- Locked Me.Com ------------------------------------");
	   System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	   System.out.println("\n Enter Your Choice\n 1.Retrive the files from Specified Folder\n 2.Perform the Business level Operation.\n 3.Close the Application\n");
	   Scanner a=new Scanner(System.in);
	   Choice=a.nextInt();
	   try
	   {
		   switch(Choice)
		   {
		   case 1:
			   System.out.println("Display The Files");
			   Retrive(File_path);
			   break;
		   case 2:
			   System.out.println("Business Level Operation \n 1.Add A File in the Specified Folder\n 2.Delete the File in the Folder\n 3.Search File \n 4.Close the all Function Return to the Main Application ");
			   int Choice1=a.nextInt();
			   try
			   {
				   switch(Choice1)
				   {
				   case 1:
					   System.out.println("\n 1.Adding a new file \n 2.Adding a file With Content");
					   int File_choice=a.nextInt();
					   switch(File_choice)
					   {
					   case 1:
						   Fileadd(File_path);
						   break;
					   case 2:
						   FileAddwithContent(File_path);
						   break;
						default:
							System.out.println("Enter the Wrong Choice please Enter the Correct Choice");
							break;
					   }
					break;
				   case 2:
					   System.out.println("Delete the File in the Folder");
					   FileDelete(File_path);
					   break;
				   case 3:
					   System.out.println("Search A File");
					   Search(File_path);
					   break;
				   case 4:
					     break;
				   default:
					   System.out.println("Enter the Wrong Choice please Enter the Correct Choice");
					   break;
				   }
			   }
			   catch(Exception e)
			   {
				   System.out.println("Program Terminated Due to "+e);  
			   }
			   break;
		   case 3:
			   System.out.println("Application Closed");
			   break;
		   default:
			   System.out.println("Enter the Wrong Choice please Enter the Correct Choice");
			   break;
		   }
	   }
	   catch(Exception e)
	   {
		   System.out.println("Program Terminated Due to "+e); 
	   }   
   }
}
