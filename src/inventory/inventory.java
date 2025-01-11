package src.inventory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import src.automobile.automobile;

public class inventory {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

            automobile car = new automobile("honda", "Accord", "black", 2025);

            String carinfo = car.listing();
            String[] splitInfo = carinfo.split(",");
            for(String info : splitInfo){
                System.out.println(info);
            }

            boolean removed = car.removeCar();
            if(!removed){
                System.out.println("Car was not removed");
            }
            System.out.println("Car removed");

            String addedCar = car.addCar("infiniti", "G37", "white", 2013);
            System.out.println(addedCar);

            String addedCarInfo = car.listing();
            String[] addedCarSplit = carinfo.split(",");
            for(String info : addedCarSplit){
                System.out.println(info);
            }

            String updateCar = car.updateVehicle("Infiniti", "Q50", "White", 2016);
            String updateCarInfo = car.listing();
            String[] updateCarSplit = carinfo.split(",");
            for(String info : addedCarSplit){
                System.out.println(info);
            }

            boolean isRunning = true;

            while(isRunning){
                System.out.println("Would you like to save information to a file? (Y/N)");
                String userInput = scanner.nextLine().trim().toLowerCase();
                if(userInput.equalsIgnoreCase("y")){
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
                        break;
                    } catch (IOException e) {
                        System.out.println("Failed to print information to file: " + e.getMessage()); 
                    }
                   
                    
                }else if(userInput.equalsIgnoreCase("n")){
                    System.out.println("Not saving info, exiting program now");
                    break;
                }else if(userInput.equalsIgnoreCase("q") | userInput.equalsIgnoreCase("quit")){
                    System.out.println("Exiting program now");
                    break;
                } else{
                    System.out.println("invalid entry");
                }
            }
            

        }catch(Exception e){
            System.err.println(e);
        }
    }
}
