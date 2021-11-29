import java.util.Vector;

public class Customer
{
	//Customer details
	private String sName, sAddress, sNricNo;
	private int iPhoneNo;
	
	//Vehicle details - Vector class since one Customer can have >= 0 vehicles.
	//Default size: 1,increment by 1 upon overflow - refer to API for details.
	private Vector vVehicles = new Vector(1,1);
	
	//Constructors
	public Customer(){}
	
	//Since a Customer can have  >= 0 vehicles, constructor accepts only
	//Customer details. Assigning vehicles have to be done with assignVehicle()
	public Customer(	String sParamName,
							String sParamAddress,
							int iParamPhoneNo,
							String sParamNricNo
					)
	{
		setName(sParamName);
		setAddress(sParamAddress);
		setPhoneNo(iParamPhoneNo);
		setNricNo(sParamNricNo);
	}
	
	//Set/Add Accessors
	public void addVehicle(Vehicle vParamVehicle)
	{
		vVehicles.add(vParamVehicle);
	}
	
	public void removeVehicle(Vehicle vParamVehicle)
	{
		vVehicles.remove(vParamVehicle);
	}
	
	public void setName(String sParamName)
	{
		sName = sParamName;
	}
	
	public void setAddress(String sParamAddress)
	{
		sAddress = sParamAddress;
	}
	
	public void setPhoneNo(int sParamPhoneNo)
	{
		iPhoneNo = sParamPhoneNo;
	}
	
	public void setNricNo(String sParamNricNo)
	{
		sNricNo = sParamNricNo;
	}
	
	//Get Accesors	
	public Vehicle[] getVehicleArray()
	{
		Object[] objTempObjectArray = vVehicles.toArray();
		Vehicle[] vehVehicles = new Vehicle[objTempObjectArray.length];
		for(int iCounter=0;iCounter<objTempObjectArray.length;iCounter++)
		{
			vehVehicles[iCounter] = (Vehicle) objTempObjectArray[iCounter];
		}
		return vehVehicles;
	}
	
	public Vector getVehicleVector()
	{
		return vVehicles;
	}
	
	public String getName()
	{
		return sName;
	}
	
	public String getAddress()
	{
		return sAddress;
	}
	
	public int getPhoneNo()
	{
		return iPhoneNo;
	}
	
	public String getNricNo()
	{
		return sNricNo;
	}
}