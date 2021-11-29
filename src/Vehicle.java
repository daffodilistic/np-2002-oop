public abstract class Vehicle
{
	private int iYear,iMaximumSpeed,iRentalDuration;
	//Since amount can be derived from rental type, duration and parking lot
	//size, there is no need to use a variable for the amount.
	private String 	sStateRegistrationNo,
					sManufacturer,
					sRentalType,
					sSizeOfParkingLot;
	
	//Constructors
	public Vehicle(){}
	
	public Vehicle(	String sParamStateRegistrationNo,
					String sParamManufacturer,
					int iParamYear,
					String sParamRentalType,
					int iParamRentalDuration,
					int iParamMaximumSpeed,
					String sParamSizeOfParkingLot
					)
	{
		setStateRegistrationNo(sParamStateRegistrationNo);
		setManufacturer(sParamManufacturer);
		setYear(iParamYear);
		setRentalType(sParamRentalType);
		setRentalDuration(iParamRentalDuration);
		setSizeOfParkingLot(sParamSizeOfParkingLot);
		setMaximumSpeed(iParamMaximumSpeed);
	}
	
	//Set accessors
	public void setStateRegistrationNo(String sParamStateRegistrationNo)
	{
		sStateRegistrationNo = sParamStateRegistrationNo;
	}
	
	public void setRentalType(String sParamRentalType)
	{
		sRentalType = sParamRentalType;
	}
	
	public void setRentalDuration(int iParamRentalDuration)
	{
		iRentalDuration = iParamRentalDuration;
	}
	
	public void setSizeOfParkingLot(String sParamSizeOfParkingLot)
	{
			sSizeOfParkingLot = sParamSizeOfParkingLot;
	}
	
	public void setMaximumSpeed(int iParamMaximumSpeed)
	{
		iMaximumSpeed = iParamMaximumSpeed;
	}
	
	public void setManufacturer(String sParamManufacturer)
	{
		sManufacturer = sParamManufacturer;
	}
	
	public void setYear(int iParamYear)
	{
		iYear = iParamYear;
	}
	
	//Get accssors
	public String getStateRegistrationNo()
	{
		return sStateRegistrationNo;
	}
	
	public String getRentalType()
	{
		return sRentalType;
	}
	
	public int getRentalDuration()
	{
		return iRentalDuration;
	}
	
	public String getSizeOfParkingLot()
	{
		return sSizeOfParkingLot;
	}
	
	public int getMaximumSpeed()
	{
		return iMaximumSpeed;
	}
	
	public String getManufacturer()
	{
		return sManufacturer;
	}
	
	public int getYear()
	{
		return iYear;
	}
	
	//Special/Misc. accessors
	public abstract float calculateFee();
	{
		
	}
}