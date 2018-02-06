package project01_cst242;

/**
 *
 * @author kemar
 */
public final class Desktop extends Computer implements BasePrices {
    
    private int displaySize;
    
    public Desktop() {
        this(0.0, 0, 0, "", 0);
    }
    
    public Desktop(double processorSpeed, int memorySize, int hardDriveSize,
                    String opticalDriveType, int displaySize) {
        super(processorSpeed, memorySize, hardDriveSize, opticalDriveType);
        setDisplaySize(displaySize);
    }
    
    
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
