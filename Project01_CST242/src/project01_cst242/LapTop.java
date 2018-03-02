package project01_cst242;

/**
 * The LapTop class which differentiates the type of computer that is chosen 
 * from the computer's display size.
 *
 * @author kemar
 */
public final class LapTop extends Computer implements BasePrices {
    
    private int displaySize;    // the computer's display size
    
    /**
     * This constructor gives default values to the instance variables.
     */
    public LapTop() {
        this(0.0, 0, 0, "", 0);
    }
    
    /**
     * Constructor that sets initial values of the instance variables to the 
     * appropriate data fields.
     * 
     * @param processorSpeed computer's processor speed
     * @param memorySize computer's memory size
     * @param hardDriveSize computer's hard drive size
     * @param opticalDriveType computer's optical drive type
     * @param displaySize the computer's display size
     */
    public LapTop(double processorSpeed, int memorySize, int hardDriveSize,
                   String opticalDriveType, int displaySize) {
        super(processorSpeed, memorySize, hardDriveSize, opticalDriveType);
        setDisplaySize(displaySize);
    }
    
    /**
     * Returns the price of a LapTop with all of it components for it.
     * 
     * @return The price of a LapTop with its components.
     */
    @Override
    public double getComputerPrice() {
        return LAPTOP_PRICE + getDisplaySize() + super.getMemoryPrice() +
                super.getOpticalDrivePrice() + super.getProcessorPrice() +
                super.getHardDrivePrice();
    }
    
    /**
     * Sets the display size of a LapTop using if processing.
     * 
     * @param displaySize display size of the laptop
     */
    @Override
    public void setDisplaySize(int displaySize) {
        if (displaySize == 14 || displaySize == 15 || displaySize == 17) {
            this.displaySize = displaySize;
        } else {
            this.displaySize = 0;
        }
    }
    
    /**
     * Returns the display size to determine if its a desktop or laptop.
     * 
     * @return The display size of a desktop or laptop
     */
    @Override
    public int getDisplaySize() {
        return displaySize;
    }
    
    /**
     * Returns the price of the display using switch/case.
     * 
     * @return The price of the display.
     */
    @Override
    public double getDisplayPrice() {
        switch (displaySize) {
            case 14:
                return 80;
            case 15:
                return 90;
            case 17:
                return 100;
        }
        
        return 0;
    }
}
