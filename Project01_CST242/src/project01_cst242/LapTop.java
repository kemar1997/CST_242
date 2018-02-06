package project01_cst242;

/**
 *
 * @author kemar
 */
public final class LapTop extends Computer implements BasePrices {
    
    private int displaySize;
    
    public LapTop() {
        this(0.0, 0, 0, "", 0);
    }
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getDisplayPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
