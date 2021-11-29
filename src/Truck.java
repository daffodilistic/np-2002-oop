public final class Truck extends Vehicle
{
	//truck details
	private int iCarraigeLength;
	private int iWeight;
	
	private final float DAILY_RENTAL_COST = 50.00f,
						MONTHLY_RENTAL_COST = 1200.00f,
						ANNUAL_RENTAL_COST = 14000.00f;
	
	//Constructors
	public Truck(){}
	
	public Truck(	String sParamStateRegistrationNo,
						String sParamManufacturer,
						int iParamYear,
						String sParamRentalType,
						int iParamRentalDuration,
						int iParamMaximumSpeed,
						String sParamSizeOfParkingLot,
						int iParamCarraigeLength,
						int iParamWeight
						)
	{
		super(	sParamStateRegistrationNo,
				sParamManufacturer,
				iParamYear,
				sParamRentalType,
				iParamRentalDuration,
				iParamMaximumSpeed,
				sParamSizeOfParkingLot
				);
		setCarraigeLength(iParamCarraigeLength);
		setWeight(iParamWeight);
	}
	
	//Set accessors
	public final void setCarraigeLength(int iParamCarraigeLength)
	{
		iCarraigeLength = iParamCarraigeLength;
	}
	
	public final void setWeight(int iParamWeight)
	{
		iWeight = iParamWeight;
	}
	
	//Get accessors
	public final int getCarraigeLength()
	{
		return iCarraigeLength;
	}
	
	public final int getWeight()
	{
		return iWeight;
	}
	
	//Special/Misc accessors
	public final float calculateFee()
	{
		String sRentalType = super.getRentalType();
		
		//Set for debug
		float fReturnValue=-1.0f;
		
		if (sRentalType.equals("Daily"))
		{
			fReturnValue = 	super.getRentalDuration() * DAILY_RENTAL_COST;
		}
		else if(sRentalType.equals("Monthly"))
		{
			fReturnValue = super.getRentalDuration() * MONTHLY_RENTAL_COST;
		}
		else if(sRentalType.equals("Annually"))
		{
			fReturnValue = super.getRentalDuration() * ANNUAL_RENTAL_COST;
		}
		
		return fReturnValue;
	}
}