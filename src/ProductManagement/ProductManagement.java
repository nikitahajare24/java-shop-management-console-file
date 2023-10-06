package ProductManagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class ProductManagement {


	static ArrayList<Product> al = new ArrayList();
	static
	{
		try {
			loadDataFromFileToArrayList();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void productManagement() throws IOException {
	{
		Scanner scan = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		while(CanIKeepRunningTheProgram == true )
		{
			System.out.println(" ******WELCOME To Product MANAGMENT** ");
			System.out.println(" 1.Add Product ");
			System.out.println(" 2.Edit Product ");
			System.out.println(" 3.Delete Product ");
			System.out.println(" 4.Search Product ");
			System.out.println(" 5.Quit ");
			
			int optionselectedbyuser = scan.nextInt();
			if(optionselectedbyuser == ProductOptions.QUIT)
			{
				File file = new File("C:\\Users\\NIKITA HAJARE\\nikita-eclipse-workspace\\Shop Management\\src\\ProductManagement\\nikiii.txt");
				
				FileWriter fr = new FileWriter(file,false);
				
				BufferedWriter br = new BufferedWriter(fr);
				
				for(Product u1:al)
				{
					br.write(u1.name+","+u1.id+","+u1.quantity+","+u1.price+","+u1.category+"\n");
				}
				br.close();
				file = null;
				System.out.println(" !!!! PROGRAM CLOSED !!!! ");
				CanIKeepRunningTheProgram = false;
			}
			else if(optionselectedbyuser == ProductOptions.ADD_PRODUCT)
			{
				AddProduct();
			}
			else if(optionselectedbyuser == ProductOptions.SEARCH_PRODUCT)
			{
				System.out.println(" Enter the product number to search : ");
				scan.nextLine();
				String searchproduct = scan.nextLine();
				SearchProduct(searchproduct);
			}
			else if(optionselectedbyuser == ProductOptions.EDIT_PRODUCT)
			{
				System.out.println(" Enter the product number to edit : ");
				scan.nextLine();
				String editproduct = scan.nextLine();
				EditProduct(editproduct);
			}
			else if(optionselectedbyuser == ProductOptions.DELETE_PRODUCT)
			{
				System.out.println(" Enter the product number to delete : ");
				scan.nextLine();
				String deleteproduct = scan.nextLine();
				DeleteProduct(deleteproduct);
			}
		}
		System.out.println(" *After While Loop *");
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).id);
			System.out.println(al.get(i).name);
			System.out.println(al.get(i).quantity);
			System.out.println(al.get(i).price);
			System.out.println(al.get(i).category);

		}}
	}
	public static void AddProduct()
	{
		Scanner scan = new Scanner(System.in);
		Product u1 = new Product();
		
		System.out.println("New Product_Name is: ");
		u1.name = scan.nextLine();
		
		System.out.println("New Product_Id is: ");
		u1.id = scan.nextLine();
		
		System.out.println("New Product_Quantity is: ");
		u1.quantity = scan.nextLine();
		
		System.out.println("New Product_Price is: ");
		u1.price = scan.nextLine();
		
		System.out.println("New Product_Category is: ");
		u1.category = scan.nextLine();

		
		System.out.println("Task Number is :"+u1.id);
		System.out.println("Task Name is :"+u1.name);
		System.out.println("Task Mark is :"+u1.quantity);
		System.out.println("Task Number is :"+u1.price);
		System.out.println("Task Number is :"+u1.category);

		al.add(u1);
	}
	public static void SearchProduct(String Productid)
	{
		for(Product u1:al)
		{
			if(u1.id.equalsIgnoreCase(Productid))
			{
				System.out.println("Product Id is :"+u1.id);
				System.out.println("Product Name is :"+u1.name);
				System.out.println("Product Quantity is :"+u1.quantity);
				System.out.println("Product Price is :"+u1.price);
				System.out.println("Product Category is :"+u1.category);

				return;
				
			}
		}
		System.out.println(" PRODUCT NOT FOUND ");
	}
	
	//**** Edit Product Function ***

	public static void EditProduct(String Productid) {
		for(Product u1:al) {
			if(u1.id.equalsIgnoreCase(Productid)) {
				Scanner scan = new Scanner(System.in);
				
				System.out.println("Enter Product_id: "+u1.id);
				
				System.out.println("New Product_Name is: ");
				u1.name = scan.nextLine();
				
				System.out.println("New Product_Quantity is: ");
				u1.quantity = scan.nextLine();
				
				System.out.println("New Product_Price is: ");
				u1.price = scan.nextLine();
				
				System.out.println("New Product_Category is: ");
				u1.category = scan.nextLine();


				System.out.println("PRODUCT Information updated");
				return;
			}
		}
		System.out.println("!!! PRODUCT Not Found !!!");

	}
	
	//**** Delete Product Function ****

	
	public static void DeleteProduct(String Productid)
	{
		Iterator<Product>itr = al.iterator();
		while(itr.hasNext())
		{
			Product u1 = itr.next();
			if(u1.id.equalsIgnoreCase(Productid))
			{
				itr.remove();
				System.out.println(" Product "+u1.id+" has been deleted ");
				return;
			}
		}
		System.out.println(" PRODUCT NOT FOUND ");
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\NIKITA HAJARE\\nikita-eclipse-workspace\\Shop Management\\src\\ProductManagement\\nikiii.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		String line ="";
		
		while((line = br.readLine())!=null)
		{
			Product u1 = new Product ();
		   
		   String[] userDataArray = line.split(",");
		   
		   if(userDataArray.length>4)
		   {
			   u1.name = userDataArray[0];
			   u1.id = userDataArray[1];
			   u1.quantity = userDataArray[2];
			   u1.price = userDataArray[3];			   
			   u1.category = userDataArray[4];			   

			   al.add(u1);
		   }
		}
		br.close();
		fr.close();
		file = null;
	}
}