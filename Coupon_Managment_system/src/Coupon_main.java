import java.io.FileInputStream;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ListView;


import java.io.IOException;

public class Coupon_main {
	protected static CouponDetails strt;
	static double[] p_price= new double[50];
	private static HSSFWorkbook xlWBook;
    private static HSSFSheet xlSheet;
    private static HSSFRow xlRow;
    private static HSSFCell xlCell;
    private static String filePath = "D:\\Eclipse\\Java\\Coupon_Managment_system\\src\\";
    private static String fileName = "1.xls";
    

    
    
    
    

	public static void main(String[] args) throws IOException {
		String Couponprovider = null, Name_of_product = null, Status_of_Coupon = null, Customer_Name = null;
		double price = 0, discount_rate = 0, expiration_period = 0, Coupon_ID = 0, Discounted_price = 0 ;
		
		
		//launch(args);
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Scanner can = new Scanner(System.in);
		/* Creating object of linkedList */
		linkedList list = new linkedList();
//		LinkedList<String> singlyLinkedList = new LinkedList<>();
		System.out.println("Sorted Singly Linked List Test\n");
		char ch;
		

		try {

            FileInputStream xlFile = new FileInputStream(filePath + fileName);

            // Access the required test data sheet

            xlWBook = new HSSFWorkbook(xlFile);

            // Assuming your data is in Sheet1- if not use your own sheet name
            xlSheet = xlWBook.getSheet("Data");

            // gives row count in sheet
            int noOfRows = xlSheet.getPhysicalNumberOfRows();

            // gives column count in sheet
            xlRow = xlSheet.getRow(0);
            int noOfColumns = xlRow.getLastCellNum();

            // r - row c- column
            for (int r = 0; r < noOfRows; r++) {
                for (int c = 0; c < noOfColumns; c++) {
                    xlRow = xlSheet.getRow(r);
                    xlCell = xlRow.getCell(c);

                    // Here we have complete excel data in an array -excelData-

//                    excelData[r][c] = xlCell.getStringCellValue();
                    switch (c) {
    	            case 0:
                        //aBook.setCouponprovider(nextCell.getStringCellValue());
                        Couponprovider = xlCell.getStringCellValue();
                        //System.out.print(Couponprovider);
                        break;
                    case 1:
                        //aBook.setName_of_product(nextCell.getStringCellValue());
                        Name_of_product = xlCell.getStringCellValue();
                        //System.out.print(Name_of_product);
                        break;
                    case 2:
                        //aBook.setPrice((float) nextCell.getNumericCellValue());
                        price = xlCell.getNumericCellValue();
                        //System.out.print(price);
                        break;
                    case 5:
                        //aBook.setStatus_of_Coupon(nextCell.getStringCellValue());
                        Status_of_Coupon = xlCell.getStringCellValue(); 
                        //System.out.print(Status_of_Coupon);                
                        break;
                    case 4:
                        //aBook.setDiscount_rate((float) nextCell.getNumericCellValue());
                        discount_rate = xlCell.getNumericCellValue();
                        //System.out.print(discount_rate);
                        break;
                    case 3:
                        //aBook.setExpiration_period((float) nextCell.getNumericCellValue());
                        expiration_period = xlCell.getNumericCellValue();
                        //System.out.print(expiration_period);
                        break;
                    case 6:
                        //aBook.setCoupon_ID((float) nextCell.getNumericCellValue());
                        Coupon_ID = xlCell.getNumericCellValue();
                        //System.out.print(Coupon_ID);
                        break;
                    case 7:
                        //aBook.setCoupon_ID((float) nextCell.getNumericCellValue());
                    	Discounted_price = xlCell.getNumericCellValue();
                        //System.out.print(Discounted_price);
                        break;
                    case 8:
                        //aBook.setCoupon_ID((float) nextCell.getNumericCellValue());
                    	Customer_Name = xlCell.getStringCellValue();
                        //System.out.print(Customer_Name);
                        break;
    	            }
                    System.out.print("\n");
                    
                   // excelData[r][c] = xlCell.getStringCellValue();

//                     System.out.println("row: " + r + " column: " + c);
//                     System.out.println(excelData[r][c]);	
                }
                list.insert(Couponprovider, Name_of_product, Status_of_Coupon, price, discount_rate, expiration_period,
						Coupon_ID, Discounted_price, Customer_Name);
            }

          
        } catch (IOException e) {
            e.printStackTrace();
        }
		

		do {
			System.out.println("\nCoupon Inventory System Operations\n");
			System.out.println("1. Purchase of Coupon");
			System.out.println("2. Delete Coupon");
			System.out.println("3. Check empty");
			System.out.println("4. Get number of coupons");
			System.out.println("5. Search for coupon");
			System.out.println("6. Sort by Discounted price");
			System.out.println("7. Display full list \n");
			System.out.print(" Enter your Choice:- ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Coupon ID of the product to insert");
				Coupon_ID = scan.nextInt();
				System.out.println("Enter name of the Coupon Provider to insert" + scan.nextLine());
				Couponprovider = scan.nextLine();
				System.out.println("Enter the name of the product to insert");
				Name_of_product = scan.nextLine();
				System.out.println("Enter the product price to insert");
				price = scan.nextInt();
				System.out.println("Enter the dicounted percentage product to insert");
				discount_rate = scan.nextInt();
				System.out.println("Enter the Expiration period to insert");
				expiration_period = scan.nextInt();
				System.out.println("Enter the status of the coupon");
				Status_of_Coupon = can.nextLine();
                //C.setStatus_of_Coupon(Status_of_Coupon); 

				System.out.println("Enter the Customer name to insert");
				Customer_Name = can.nextLine();
				Discounted_price = price*(1-(discount_rate/100));
                //C.setCustomer_name(Customer_Name);
				list.insert(Couponprovider, Name_of_product, Status_of_Coupon, price, discount_rate, expiration_period,
						Coupon_ID, Discounted_price, Customer_Name);
				break;
			case 2:
				System.out.println("Enter position");
				int p = scan.nextInt();
				if (p < 1 || p > list.getSize())
					System.out.println("Invalid position\n");
				else
					list.deleteAtPos(p);
				break;
			case 3:
				System.out.println("Empty status = " + list.isEmpty() + "\n");
				System.out.println("Listed items are as follows:-");
				list.display();
				break;
			case 4:
				System.out.println("Number of Coupons are = " + list.getSize() + " \n");
				break;
			case 5:
				System.out.println("1. Linear Seach");
				System.out.println("2. Binary Search");
				int Search = scan.nextInt();
				if(Search == 1) {
					System.out.println("Enter the Coupon ID of the product for search");
					Coupon_ID = scan.nextDouble();
					if(list.CouponSearch_Linear(Coupon_ID) == true)
						System.out.println("Searched coupon is found "  + Coupon_ID );
					else 
						System.out.println("Searched coupon is not found "  + Coupon_ID );	
					
					break;
				}
				else if	(Search == 2) {
					
					
					System.out.println("Enter the Coupon ID of the product for search");
					Discounted_price = scan.nextDouble();
					int y;
					y = list.BinarySear(Discounted_price);
					//System.out.println(y);
					if (y == -1)
			            System.out.println("Element not present");
			        else
			            System.out.println("Element found  " + Discounted_price);
				break;
				}
			case 6:
				System.out.println("sort by discount =  \n");
				list.lowtohigh();
				
				break;
			case 7:
				System.out.println("Display all products");
				list.display();
				break;
				default:
				System.out.println("Wrong Entry \n ");
				
			}
			// Display List
			//list.display();
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

		System.out.println("final list of products is as follows" );
		list.display();
	}

	
    
	
}
