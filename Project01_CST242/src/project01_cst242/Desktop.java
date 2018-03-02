package project01_cst242;

/**
 * The Desktop class which differentiates the type of computer that is chosen 
 * from the computer's display size.
 *
 * @author kemar
 */
public final class Desktop extends Computer implements BasePrices {
    
    private int displaySize;    // the computer's display size
    
    /**
     * This constructor gives default values to the instance variables.
     */
    public Desktop() {
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
    public Desktop(double processorSpeed, int memorySize, int hardDriveSize,
                    String opticalDriveType, int displaySize) {
        super(processorSpeed, memorySize, hardDriveSize, opticalDriveType);
        setDisplaySize(displaySize);
    }
    
    /**
     * Returns the price of a Desktop with all of it components for it.
     * 
     * @return The price of a Desktop with its components.
     */
    @Override
    public double getComputerPrice() {
        return DESKTOP_PRICE + getDisplayPrice() + super.getMemoryPrice() + 
                super.getOpticalDrivePrice() + super.getProcessorPrice() +
                super.getHardDrivePrice();
    }
    
    /**
     * Sets the display size of a Desktop using if processing.
     * 
     * @param displaySize display size of the desktop
     */
    @Override
    public void setDisplaySize(int displaySize) {
        if (displaySize == 17 || displaySize == 19 || displaySize == 24) {
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
            case 17:
                return 100.00;
            case 19:
                return 120.00;
            case 24:
                return 140.00;
            default:
                break;
        }
        
        return 0;
    }
    
}
