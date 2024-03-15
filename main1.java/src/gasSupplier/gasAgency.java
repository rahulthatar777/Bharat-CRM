package gasSupplier;


public interface gasAgency {

    public String agencyName = "Bharat gas";

    public  int agencyCode = 1234;

    public int phNumber = 937040528;


        //no usages
        public int pincode = 201310;

        //no usages
        default void show(){
            System.out.println("The agency name is:" + agencyName);
            System.out.println("The agency Code is:" + agencyCode);
            System.out.println("The agency phone Numberis:" + phNumber);


        }

}
