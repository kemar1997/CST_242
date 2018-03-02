package project01_cst242;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Create a pricing system for a computer company that sells personal computers 
 * over the Internet.There are two kinds of computers, laptops and desktops.Each
 * computer has a processor (1.8. 2.0, 2.5, or 3.0 gigahertz), memory (2, 3
 * or 4 Gb), hard drive (160, 250, or 500 Gb), and optical drive ("CD-RW", "DVD"
 * or "Blu-ray Combo Drive"). Laptops have 14-, 15- or 17-inch screens. Desktops
 * have 17-, 19-, or 24-inch monitors.
 *
 * @author kemar
 */
public abstract class Computer {
    
    private double processorSpeed; // Computer's Processor Speed
    private int memorySize; // Computer's Memory Size
    private int hardDriveSize; // Computer's Hard Drive Size
    private String opticalDriveType; // Computer's Optical Drive Type
    
    /**
     * This constructor gives default values to the instance variables.
     */
    public Computer() {
        this(0.0, 0, 0, "");
    }
    
    /**
     * Constructor that sets initial values of the instance variables to the 
     * appropriate data fields.
     * 
     * @param processorSpeed computer's processor speed
     * @param memorySize computer's memory size
     * @param hardDriveSize computer's hard drive size
     * @param opticalDriveType computer's optical drive type
     */
    public Computer(double processorSpeed, int memorySize, int hardDriveSize,
            String opticalDriveType) {
        setProcessorSpeed(processorSpeed);
        setMemorySize(memorySize);
        setHardDriveSize(hardDriveSize);
        setOpticalDriveType(opticalDriveType);
    }

    /**
     * Sets the processor speed accordingly using if processing.
     * 
     * @param processorSpeed the computer's processor speed
     */
    public void setProcessorSpeed(double processorSpeed) {
        if (processorSpeed == 1.8 || processorSpeed == 2.0 || processorSpeed ==
                2.5 || processorSpeed == 3.0) {
            this.processorSpeed = processorSpeed;
        } else if (processorSpeed == 0.0) {
            this.processorSpeed = processorSpeed;
        }
    }

    /**
     * Sets the memory size accordingly using if processing.
     * 
     * @param memorySize the size of the computer's memory
     */
    public void setMemorySize(int memorySize) {
        if (memorySize == 2 || memorySize == 3 || memorySize == 4 || memorySize
                == 0) {
            this.memorySize = memorySize;
        }
    }

    /**
     * Sets the hard drive size accordingly using if processing.
     * 
     * @param hardDriveSize the computer's hard drive size
     */
    public void setHardDriveSize(int hardDriveSize) {
        if (hardDriveSize == 160 || hardDriveSize == 250 || hardDriveSize == 
                500 || hardDriveSize == 0) {
            this.hardDriveSize = hardDriveSize;
        }
    }

    /**
     * Sets the optical drive type, checking that appropriate names are
     * inputted using an array list. Then applying the result to its instance
     * variable using an if statement.
     * 
     * @param opticalDriveType the type of optical drive of a computer
     */
    public void setOpticalDriveType(String opticalDriveType) {
        // String constants for valid optical drive types
        String[] VALID_OPTICAL_DRIVE_TYPES = {
            "CD-RW", "DVD", "Blu-ray Combo Drive"
        };
        
        ArrayList<String> validOpticalDriveTypes = new ArrayList();
        Collections.addAll(validOpticalDriveTypes, VALID_OPTICAL_DRIVE_TYPES);
        
        if ( validOpticalDriveTypes.indexOf( opticalDriveType ) >= 0) {
            this.opticalDriveType = opticalDriveType;
        }
    }
    
    /**
     * Calculates the processor price using if processing and returning it.
     * 
     * @return The price of computer processor
     */
    public double getProcessorPrice() {
        if (processorSpeed == 1.8) {
            return 75.00;
        } else if (processorSpeed == 2.0) {
            return 82.00;
        } else if (processorSpeed == 2.5) {
            return 87.99;
        } else if (processorSpeed == 3.0) {
            return 95.99;
        }
        
        return 0;
    }
    
    /**
     * Calculates the memory price using if processing and returning it.
     * 
     * @return The price of computer memory
     */
    public double getMemoryPrice() {
        switch (memorySize) {
            case 2:
                return 40.00;
            case 3:
                return 60.00;
            case 4:
                return 80.00;
        }
        
        return 0;
    }
    
    /**
     * Calculates the price of an optical drive and returns it.
     * 
     * @return The price of an optical drive.
     */
    public double getOpticalDrivePrice() {
        switch (opticalDriveType) {
            case "CD-RW":
                return 20.00;
            case "DVD":
                return 30.00;
            case "Blu-ray Combo Drive":
                return 40.00;
            default:
                break;
        }
        
        return 0;
    }
    
    /**
     * Calculates the price of a hard drive and returns it.
     * 
     * @return The price of a hard drive.
     */
    public double getHardDrivePrice() {
        switch (hardDriveSize) {
            case 160:
                return 25.00;
            case 250:
                return 50.00;
            case 500:
                return 75.00;
            default:
                break;
        } 
        return 0;
    }
    
    /**
     * Returns the processor speed of the computer.
     * 
     * @return The computer's processor speed.
     */
    public double getProcessorSpeed() {
        return processorSpeed;
    }
    
    /**
     * Returns the memory size of the computer.
     * 
     * @return The computer's memory size.
     */
    public int getMemorySize() {
        return memorySize;
    }
    
    /**
     * Returns the optical drive type of the computer.
     * 
     * @return The computer's optical drive type.
     */
    public String getOpticalDriveType() {
        return opticalDriveType;
    }
    
    /**
     * Returns the size of the hard drive.
     * 
     * @return The size of the hard drive.
     */
    public int getHardDriveSize() {
        return hardDriveSize;
    }
    
    /**
     * Abstract method definition to calculate the computer price depending on
     * the components prices and the base price of each computer.
     * 
     * @return Base price of a computer and prices of the components into one.
     */
    public abstract double getComputerPrice();
    
    /**
     * Abstract method that sets a value for a computer's display whether it be
     * for a laptop or desktop.
     * 
     * @param displaySize the size of a computer's display (laptop or desktop)
     */
    public abstract void setDisplaySize(int displaySize);
    
    /**
     * Abstract method that returns the display size for either a laptop or a 
     * desktop.
     * 
     * @return The size of the computer's display.
     */
    public abstract int getDisplaySize();
    
    /**
     * Abstract method which displays the price of the computer's display. Also
     * allows the toString() method to call the subclass getDisplayPrice()
     * method.
     * 
     * @return Price of a computer display.
     */
    public abstract double getDisplayPrice();
    
    /**
     * Returns a string representation of all the components chosen by a user,
     * then takes all of the components based on their price values and sums it
     * all together and outputs the price of the entire system along with the 
     * components chosen.
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        
        output.append("Processor Speed: ");
        output.append(getProcessorSpeed());
        output.append(" gigahertz \n");
        output.append("Memory Size: ");
        output.append(getMemorySize());
        output.append(" Gb \n");
        output.append("Optical Drive Type: ");
        output.append(getOpticalDriveType());
        output.append("\n");
        output.append("Hard Drive Size: ");
        output.append(getHardDriveSize());
        output.append(" gb \n");
        output.append("Display Size: ");
        output.append(getDisplaySize());
        output.append(" inch \n");
        output.append("Price: $");
        output.append(getComputerPrice());
        output.append("\n");
        
        
        return output.toString();
    }
    
}
