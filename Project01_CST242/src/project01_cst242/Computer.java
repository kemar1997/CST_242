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
     * 
     * @param processorSpeed 
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
     * 
     * @param memorySize 
     */
    public void setMemorySize(int memorySize) {
        if (memorySize == 2 || memorySize == 3 || memorySize == 4 || memorySize
                == 0) {
            this.memorySize = memorySize;
        }
    }

    /**
     * 
     * @param hardDriveSize 
     */
    public void setHardDriveSize(int hardDriveSize) {
        if (hardDriveSize == 160 || hardDriveSize == 250 || hardDriveSize == 
                500 || hardDriveSize == 0) {
            this.hardDriveSize = hardDriveSize;
        }
    }

    /**
     * 
     * @param opticalDriveType 
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
        return 0;
    }
    
    /**
     * Calculates the memory price using if processing and returning it.
     * 
     * @return The price of computer memory
     */
    public double getMemoryPrice() {
        return 0;
    }
    
    /**
     * Calculates the price of an optical drive and returns it
     * 
     * @return The price of an optical drive
     */
    public double getOpticalDrivePrice() {
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
     * @return The computer's optical drive type
     */
    public String getOpticalDriveType() {
        return opticalDriveType;
    }
    
    /**
     * Abstract method definition to calculate the computer price depending on
     * the components prices.
     * 
     * @return Price of a computer
     */
    public abstract double getComputerPrice();
    
}
