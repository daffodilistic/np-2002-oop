public class Car extends Vehicle
{
	//car details
	private int iSeatCapacity;

	private final float DAILY_RENTAL_COST = 25.00f,
						MONTHLY_RENTAL_COST = 650.00f,
						ANNUAL_RENTAL_COST = 7200.00f;

	//Constructors
	public Car(){}
	
	public Car(	String sParamStateRegistrationNo,
						String sParamManufacturer,
						int iParamYear,
						String sParamRentalType,
						int iParamRentalDuration,
						int iParamMaximumSpeed,
						String sParamSizeOfParkingLot,
						int iParamSeatCapacity
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
		setSeatCapacity(iParamSeatCapacity);
	}
	
	//Set Accessors
	public void setSeatCapacity(int iParamSeatCapacity)
	{
		iSeatCapacity = iParamSeatCapacity;
	}
	
	//Get Accessors
	public int getSeatCapacity()
	{
		return iSeatCapacity;
	}
	
	//Special/Misc Accessors
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