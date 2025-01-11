package src.inventory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import src.automobile.automobile;

public class inventory {
    public static void main(String[] args) {
        try{
            // init scanner to get user inoput
            Scanner scanner = new Scanner(System.in);

            // initialize an instance of the car class
            automobile car = new automobile("honda", "Accord", "black", 2025);

            // get car info in string, split string, loop through string array and print info to terminal
            String carinfo = car.listing();
            String[] splitInfo = carinfo.split(",");
            for(String info : splitInfo){
                System.out.println(info);
            }

            // remove the car
            boolean removed = car.removeCar();
            // check that the remove car method returned true, if returned false, error occured
            if(!removed){
                System.out.println("Car was not removed");
            }
            System.out.println("Car removed");

            // add new ar
            String addedCar = car.addCar("infiniti", "G37", "white", 2013);
            System.out.println(addedCar);

            
            String addedCarInfo = car.listing();
            String[] addedCarSplit = addedCarInfo.split(",");
            for(String info : addedCarSplit){
                System.out.println(info);
            }

            // update car info
            car.updateVehicle("Infiniti", "Q50", "White", 2016);
            String updateCarInfo = car.listing();
            String[] updateCarSplit = updateCarInfo.split(",");
            for(String info : updateCarSplit){
                System.out.println(info);
            }

            // drive car 1k miles to increase milage
            car.driveCar(1000);

            boolean isRunning = true;
            // create a while loop to capture user input until valid response or quit command
            while(isRunning){
                System.out.println("Would you like to save information to a file? (Y/N)");
                String userInput = scanner.nextLine().trim().toLowerCase();
                if(userInput.equalsIgnoreCase("y")){
                    // prints data to text file
                    try {
                        String filePath = "./carInfo.txt";
                        File file = new File(filePath);
            
                        // Make sure directories exist
                        file.getParentFile().mkdirs();
            
                        FileWriter writer = new FileWriter(file, false);
                        for (String info : addedCarSplit) {
                            writer.write(info + System.lineSeparator());
                        }
                        writer.close();
            
                        System.out.println("Vehicle information printed to: " + filePath);
                        isRunning = false;
                        
                    } catch (IOException e) {
                        System.out.println("Failed to print information to file: " + e.getMessage()); 
                    }
                   
                    
                }else if(userInput.equalsIgnoreCase("n")){
                    System.out.println("Not saving info, exiting program now");
                    isRunning = false;
                    
                }else if(userInput.equalsIgnoreCase("q") | userInput.equalsIgnoreCase("quit")){
                    System.out.println("Exiting program now");
                    isRunning = false;
                    
                } else{
                    System.out.println("invalid entry");
                }
            }
            

        }catch(Exception e){
            System.err.println(e);
        }

        System.out.println("Thanks for using, program exiting");
    }
}
