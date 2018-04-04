import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class linkedList  {
	protected CouponDetails start;
	//linkedList l = new linkedList();
	double[] finalprice= new double[50];
	int k = 0, counnt =0;
	public int size;

	public linkedList() {
		start = null;
		size = 0;
	}

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to check size of list */
	public int getSize() {
		return size;
	}

	/* Function to insert an element */
	public void insert(String couponprovider, String name_of_product, String status_of_Coupon, double price,
			double discount_rate, double expiration_period, double Coupon_ID, double Discounted_price, String customer_Name) {
		CouponDetails nptr, ptr, tmp = null;
		nptr = new CouponDetails(couponprovider, name_of_product, status_of_Coupon, price, discount_rate, expiration_period, Coupon_ID, Discounted_price, customer_Name, null);
		boolean ins = false;
		if (start == null)
			start = nptr;
		else if (Coupon_ID <= start.getCoupon_ID()) {
			nptr.setLink(start);
			start = nptr;
		} else {
			tmp = start;
			ptr = start.getLink();
			while (ptr != null) {
				if (Coupon_ID >= tmp.getCoupon_ID() && Coupon_ID <= ptr.getCoupon_ID()) {
					tmp.setLink(nptr);
					nptr.setLink(ptr);
					ins = true;
					break;
				} else {
					tmp = ptr;
					ptr = ptr.getLink();
				}
			}
			if (ins == false) {
				tmp.setLink(nptr);
			}
		}
		size++;
	}

	/* Function to delete an element at position */
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			start = start.getLink();
			size--;
			return;
		}
		if (pos == size) {
			CouponDetails ptr = start;

			for (int i = 1; i < size - 1; i++)
				ptr = ptr.getLink();
			ptr.setLink(null);
			size--;
			return;
		}
		CouponDetails ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				CouponDetails tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}

	/* Function to display elements */
	public void display() {
		//System.out.println("Sorted Singly Linked List = ");
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getLink() == null) {
			System.out.println(start.getCoupon_ID());
			System.out.println(start.getCouponprovider());
			System.out.println(start.getName_of_product());
			System.out.println(start.getStatus_of_Coupon());
			System.out.println(start.getPrice());
			System.out.println(start.getDiscount_rate());
			System.out.println(start.getExpiration_period());
			System.out.println(start.getDiscounted_price());
			System.out.println(start.getCustomer_name());
			return;
		}
		CouponDetails ptr = start;
		System.out.print(start.getCoupon_ID() + "\t" + start.getCouponprovider() + "\t" + start.getName_of_product()
				+ "\t" + start.getStatus_of_Coupon() + "\t" + start.getPrice() + "\t" + start.getDiscount_rate() + "\t"
				+ start.getExpiration_period() + "\t" + start.getDiscount_rate() +"\t" + start.getDiscounted_price() + "\t" +  start.getCustomer_name() + "\n\n");

		ptr = start.getLink();

		while (ptr.getLink() != null) {
			System.out.print(ptr.getCoupon_ID() + "\t" + ptr.getCouponprovider() + "\t" + ptr.getName_of_product()
					+ "\t" + ptr.getStatus_of_Coupon() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate() + "\t"
					+ ptr.getExpiration_period() + "\t" + ptr.getDiscount_rate() +"\t" + ptr.getDiscounted_price() + "\t" +  ptr.getCustomer_name() +"\n\n");
			ptr = ptr.getLink();
		}

		System.out.print(ptr.getCoupon_ID() + "\t" + ptr.getCouponprovider() + "\t" + ptr.getName_of_product() + "\t"
				+ ptr.getStatus_of_Coupon() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate() + "\t"
				+ ptr.getExpiration_period() + "\t" + ptr.getDiscount_rate() +"\t" + ptr.getDiscounted_price() + "\t" +  ptr.getCustomer_name() +"\n\n");
	}

	public Boolean CouponSearch_Linear(double Coupon_ID) {
		int count = 0;
		if (size == 0) {
			System.out.print("empty\n");
			count++;
			System.out.print("Total count for the search in linear is :- " + count + "\n");
			return false;
		}
		CouponDetails ptr = start;
		if (ptr.Coupon_ID == Coupon_ID) {
			System.out.print(start.getCoupon_ID() + "\t" + start.getCouponprovider() + "\t" + start.getName_of_product()
					+ "\t" + start.getStatus_of_Coupon() + "\t" + start.getPrice() + "\t" + start.getDiscount_rate()
					+ "\t" + start.getExpiration_period() +  "\t" + start.getDiscount_rate() + "\t" +  start.getCustomer_name() +"\n\n");
			count++;
			System.out.print("Total count for the search in linear is :- " + count + "\n");
			return true;
		}
		ptr = start.getLink();

		while (ptr.getLink() != null) {

			if (ptr.Coupon_ID == Coupon_ID) {
				System.out.print(ptr.getCoupon_ID() + "\t" + ptr.getCouponprovider() + "\t" + ptr.getName_of_product()
						+ "\t" + ptr.getStatus_of_Coupon() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate()
						+ "\t" + ptr.getExpiration_period() + "\t" + ptr.getDiscount_rate() + "\t" +  ptr.getCustomer_name() + "\n\n");
				count++;
				System.out.print("Total count for the search in linear is :- " + count + "\n");
				return true;
			}
			ptr = ptr.getLink();
			count++;
		}
		if (ptr.Coupon_ID == Coupon_ID) {

			System.out.print(ptr.getCoupon_ID() + "\t" + ptr.getCouponprovider() + "\t" + ptr.getName_of_product()
					+ "\t" + ptr.getStatus_of_Coupon() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate() + "\t"
					+ ptr.getExpiration_period() + "\t" + ptr.getDiscount_rate() + "\t" +  ptr.getCustomer_name() +"\n\n");
			count++;
			System.out.print("Total count for the search in linear is :- " + count + "\n");
			return true;
		}
		System.out.print("Total count for the search in linear is :- " + count + "\n");
		return false;

	}
	
	public void lowtohigh() {
		String couponprovider = null;
		String name_of_product = null;
		String status_of_Coupon = null;
		double price = 0;
		double discount_rate = 0, temp;
		double expiration_period = 0;
		double Coupon_ID = 0; double Discounted_price = 0; String customer_Name = null;
		CouponDetails nptr, ptr,chet = null, tmp = null;
		
		int i;
		nptr = new CouponDetails(couponprovider, name_of_product, status_of_Coupon, price, discount_rate, expiration_period, Coupon_ID, Discounted_price, customer_Name, null);
		boolean ins = false;
		i=0;
		while (start.getLink()!= null)
			{
				finalprice[i]= start.getDiscounted_price();
				start= start.getLink();
				i++;
				k = i;
				
			}
			finalprice[k]=start.getDiscounted_price();
			//System.out.println(finalprice[k]);
			for (int m = 0; m<=k; m++) {
	            for (i = m+1; i <= k; i++) {
	            
	                if (finalprice[i] < finalprice[m]) {
	                	temp = finalprice[i];
	                	finalprice[i] = finalprice[m];
	                	finalprice[m] = temp;
	                	
	                }
	            }
	          }
			for (i= 0; i<size; i++)
			{
				System.out.println(finalprice[i]);
			}
	}
	
	
	public int BinarySear(double ID)
	{
		
		double finalID[]= new double[50];
		int i = 0;
		while (start.getLink()!= null)
		{
			finalID[i]= start.getCoupon_ID();
			start= start.getLink();
			i++;
			k = i;
			
		}
		finalID[k]=start.getCoupon_ID();
		//int n = finalID.length;
		int y =binarySearch(finalID,0,k+1, ID);
		System.out.println("Element found at index:- " + counnt);
		return y;
		
		
	}
	
	 int binarySearch(double arr[], int l, int r, double x)
	    {
	        if (r>=l)
	        {
	            int mid = l + (r - l)/2;
	 
	            // If the element is present at the middle itself
	            if (arr[mid] == x)
	            {
	            	counnt++;
	               return mid;}
	 
	            // If element is smaller than mid, then it can only
	            // be present in left subarray
	            if (arr[mid] > x)
	            {counnt++;
	               return binarySearch(arr, l, mid-1, x);
	            }
	            // Else the element can only be present in right
	            // subarray
	            counnt++;
	            return binarySearch(arr, mid+1, r, x);
	        }
	 
	        // We reach here when element is not present in array
	        return -1;
	    }

}



