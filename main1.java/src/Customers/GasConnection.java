package Customers;

import  java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;

public class GasConnection extends Customer {
    public int numberOfCylinders;
    // no usage

    String date;

    static  int connectionNumber = 100;
    {
        connectionNumber +=1;
    }

    // no usage
    public Date lastDate = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy");

    public GasConnection(String name, String street, String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile);
        this.numberOfCylinders = numberOfCylinders;
    }

    public void getLastDate(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the last Date");
        date = new Scanner(System.in).next();

        try{
            lastDate = dateFormat.parse(date);
        }catch (Exception e){
            System.out.println("error in getLAstDate:"+ e);
        }

    }

}

