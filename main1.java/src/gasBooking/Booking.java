package gasBooking;

import Customers.*;
import org.w3c.dom.ls.LSOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Booking extends GasConnection {
public double otp = 5678,amount = 825.0,refund =0;

public String dt,delDate,status,DelMobileNo = "7838048546";
public Date dt_1,dt_2;



    public Booking(String name, String street, String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile, numberOfCylinders);
    }

    public void getDates() {
        System.out.println("enter booking date");
        dt = new Scanner(System.in).next();
        dt_1 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt_1 = dateFormat.parse(dt);
        } catch (Exception e) {
            System.out.println("the error in getDates function:" + e);
        }

        System.out.println("Enter Delivery Date");

        delDate = new Scanner(System.in).nextLine(); //next is when
        try {
            dt_2 = dateFormat.parse(delDate);
        } catch (Exception exp) {
            System.out.println("Error parsing  date dt_2: "+ exp);
        }

        //find the difference between two dates

        try {
            long difference = dt_2.getTime() - dt_1.getTime();

            //difference in days
            long newDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);

            if (newDifference > 7) { //check difference
                status = "P"; // pending status
            }
        } catch (Exception e) {
            System.out.println("Error while finding difference:" + e);
        }

    }

    public void validate() {
        long elapsedms = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);

        System.out.println("difference between two dates id : " + diff);
        if (numberOfCylinders == 1) {
            //for single cylinder
            if (diff < 30) {
                System.out.println("booking cannot be done");
                //numberofcylinder = 0;
                status = "C";
            } else {
                status = "B";
                lastDate = dt_1;
            }
        } else if (numberOfCylinders == 2) {

            if (diff < 50) {
                System.out.println("booking cannot to done");
                status = "C";
            } else {
                status = "B";//booked
                lastDate = dt_1;
            }

        }
    }
}


