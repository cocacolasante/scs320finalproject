package src.automobile;

public class automobile{
    // private variables to store cars information
    private String make;
    private String model;
    private String color;
    private int year;
    private boolean isOn;
    private int mileage;

    // constructor function to create a car object
    public automobile(String _make, String _model, String _color, int _year){
        try {
        // takes input parameters to construct an automobile object
        this.make = _make;
        this.model = _model;
        this.color = _color;
        this.year = _year;
        this.isOn = false;
        this.mileage = 0;

        }catch(Exception e){
            System.err.println(e);
        }
    }

    // used to set car information
    public String addCar(String _make, String _model, String _color, int _year){
        try {
            this.make = _make;
            this.model = _model;
            this.color = _color;
            this.year = _year;
    
            return "Car Added: " + _make + " " + " " + _model + " " + _color + " " + _year;

        }catch(Exception e){
            return "Error" + e;
        }
    }

    // removes a car by setting everything to null
    public boolean removeCar(){
        try{
           
            // sets the object to null
            this.make = null;
            this.model = null;
            this.color = null;
            this.year = 0;
            this.isOn = false;
            this.mileage = 0;
            
            return true;
           

        }catch(Exception e){
            return false;
        }
    }

    // get full description of the car
    public String listing() {
        try {
            // check if car exists first
            if(this.make == null){
                return "No Information";
            }
    
            return "Make: " + this.make + ", Model: " +this.model + ", Color" +this.color + ", Year: " + this.year + ", Engine On: " + this.isOn + ", Mileage: " + this.mileage;  
    

        }catch(Exception e){
            return "Error" +e;
        }
        
    }

    public String updateVehicle(String _make, String _model, String _color, int _year){
        try {

            this.make = null;
            this.model = null;
            this.color = null;
            this.year = _year;
            this.isOn = false;
            this.mileage = 0;
            return "Car Successfully Updated: " +"Make: " + this.make + ", Model: " +this.model + ", Color" +this.color + ", Year: " + this.year + ", Engine On: " + this.isOn + ", Mileage: " + this.mileage;  

        }catch(Exception e){
            return "Error" + e;
        }
    }

    // turn the car engine on
    public void startCar(){
        // checks if the engine is on or not
        if(!isOn){
            isOn = true;
            System.out.println("Engine was Started");
        }else {
            System.out.println("Car is already running");
        }
    }

    // drive the car
    // adds miles driven to total mileage
    public String driveCar(int miles){
        // checks if engine is on in order to drive
        if(!isOn){
            return "Please start the car first";
        }

        // adds miles to mileage
        mileage += miles;
        return "Drove " + miles + " miles. Total Mileage: " + mileage;
    } 

}