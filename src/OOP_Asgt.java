/*	Done by:
 *	Soh Thiam Hing 
 *	2M01
 *	sXXXXXXXX
 *
 * No assumptions, no features.
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Vector;

public class OOP_Asgt extends JFrame implements ActionListener,
												ChangeListener,
												ListSelectionListener
{
//******************************************************************************
// TOP LEVEL CONTAINERS
//==============================================================================
	//For layout management using the GridBagLayout manager - "Main Menu"
	Container ctrPane = getContentPane();
	//DEBUG - Layout needed for toplevel pane?
	GridLayout glMainPane = new GridLayout(2,1);
	GridBagConstraints gbcMainPanelConstraint = new GridBagConstraints();
	GridBagLayout gblMainPanelLayout = new GridBagLayout();
	
	//Top-level Pane for holding JTabbedPane - REQUIRED
	//Assigns BoxLayout as Layout manager; Components added will be placed
	//vertically in the application
	JPanel pnlMainPanel = new JPanel(gblMainPanelLayout);
//******************************************************************************


//******************************************************************************
// SECOND-LEVEL CONTAINERS - APPLICATION NAME PANEL AND TABBED PANE PANEL
//==============================================================================
	//Application Label Panel
	JPanel pnlAppPanel = new JPanel();
	JLabel lblAppLabel = new JLabel("XYZ Parking");
	
	//Panel for the JTabbedPane
	JPanel pnlTabPanel = new JPanel(new BorderLayout());
//******************************************************************************


//******************************************************************************
// TABBED PANE PANEL - TOP-LEVEL CONTAINERS
//==============================================================================
	//TabbedPane for user interaction
	JTabbedPane tabAppTab = new JTabbedPane();
	
	//"Add" page "main" panel
	JPanel pnlTabAddPanel = new JPanel(new BorderLayout());

	//"Edit/View" page "main" panel
	JPanel pnlTabEditPanel = new JPanel(new BorderLayout());
//******************************************************************************


//******************************************************************************
//TABBED PANE PANEL - SECOND-LEVEL CONTAINER - ADD & EDIT/VIEW CHOICE SUB PANEL
//											   (SHARED)
//==============================================================================
	//AddChoiceSubPanel for the "Add" and "View" pages of tabAppTab
	JPanel pnlAddChoiceSubPanel = new JPanel();
	JRadioButton rdoCustomer = new JRadioButton("Customer",true);
	JRadioButton rdoVehicle = new JRadioButton("Vehicle");
	ButtonGroup bgpAddChoice = new ButtonGroup();
//******************************************************************************


//******************************************************************************
//TABBED PANE PANEL - SECOND-LEVEL CONTAINER - ADD CUSTOMER SUB PANEL
//==============================================================================
	//pnlAddCustomerSubPanel for adding Customers
	JPanel pnlAddCustomerSubPanel = new JPanel(new GridLayout(4,2));
	JLabel lblName = new JLabel("Name:",SwingConstants.RIGHT);
	JLabel lblAddress = new JLabel("Address:",SwingConstants.RIGHT);
	JLabel lblPhoneNo = new JLabel("Phone No.:",SwingConstants.RIGHT);
	JLabel lblNricNo = new JLabel("NRIC No.:",SwingConstants.RIGHT);
	JTextField txtName = new JTextField(24);
	JTextField txtAddress = new JTextField(24);
	JTextField txtPhoneNo = new JTextField(24);
	JTextField txtNricNo = new JTextField(24);
//******************************************************************************	


//******************************************************************************
//TABBED PANE PANEL - SECOND-LEVEL CONTAINER - ADD/CLEAR SUB PANEL (SHARED)
//==============================================================================
	//pnlAddClearSubPanel for adding customer/vehicle and clearing fields
	JPanel pnlAddClearSubPanel = new JPanel();
	JButton btnAdd = new JButton("Add");
	JButton btnClear = new JButton("Clear");
//******************************************************************************


//******************************************************************************
//TABBED PANE PANEL - SECOND-LEVEL CONTAINER - ADD VEHICLE SUB PANEL (SHARED)
//==============================================================================
	//pnlAddVehicleSubPanel for adding vehicles
	JPanel pnlAddVehicleSubPanel = new JPanel();
	
	JLabel lblCustomer = new JLabel("Customer:",SwingConstants.RIGHT);
	JLabel lblStateRegNo = new JLabel("State Reg. No.:",SwingConstants.RIGHT);
	JLabel lblManufacturer = new JLabel("Manufacturer:",SwingConstants.RIGHT);
	JLabel lblYear = new JLabel("Year:",SwingConstants.RIGHT);
	JLabel lblRentalType = new JLabel("Rental Type:",SwingConstants.RIGHT);
	JLabel lblRentalDuration = new JLabel
									("Rental Duration:",SwingConstants.RIGHT);
									
	//Used to indicate no. of months, days, years, etc.
	JLabel lblDurationLabel = new JLabel("Days");
	
	JLabel lblMaxSpeed = new JLabel("Maximum Speed:",SwingConstants.RIGHT);
	JLabel lblParkingLotSize = new JLabel(	"Parking Lot Size: Small",
											SwingConstants.RIGHT);
	JTextField txtStateRegNo = new JTextField(24);
	JTextField txtManufacturer = new JTextField(24);
	JTextField txtYear = new JTextField(24);
	JTextField txtRentalDuration = new JTextField(24);
	JTextField txtMaxSpeed = new JTextField(24);
	JComboBox cboCustomerList = new JComboBox();
	JComboBox cboRentalType = new JComboBox();

	//UniqueVehiclePanel for changing UI component when Car or Truck is selected
	JPanel pnlUniqueVehiclePanel = new JPanel();

//******************************************************************************


//******************************************************************************
//TABBED PANE PANEL - THIRD-LEVEL CONTAINER - CAR SUB PANEL (UNIQUE)
//==============================================================================
	JPanel pnlCarSubPanel = new JPanel();
	JLabel lblSeatCapacity = new JLabel("Seat Capacity:",SwingConstants.RIGHT);
	JTextField txtSeatCapacity = new JTextField(16);
//******************************************************************************


//******************************************************************************
//TABBED PANE PANEL - THIRD-LEVEL CONTAINER - TRUCK SUB PANEL (UNIQUE)
//==============================================================================
	JPanel pnlTruckSubPanel = new JPanel();
	JLabel lblCarraigeLength = new JLabel
									("Carraige Length:",SwingConstants.RIGHT);
	JLabel lblWeight = new JLabel("Weight:",SwingConstants.RIGHT);
	
	//To display "Kg" beside txtWeight
	JLabel lblKg = new JLabel("Kg",SwingConstants.LEFT);
	
	JTextField txtCarraigeLength = new JTextField(8);
	JTextField txtWeight = new JTextField(8);
//******************************************************************************


//******************************************************************************
//TABBED PANE PANEL - THIRD-LEVEL CONTAINER - VEHICLE CHOICE SUB PANEL (SHARED)
//==============================================================================
	JPanel pnlVehicleChoiceSubPanel = new JPanel();
	JRadioButton rdoCar = new JRadioButton("Car",true);
	JRadioButton rdoTruck = new JRadioButton("Truck");
	ButtonGroup bgpVehicleChoice = new ButtonGroup();
//******************************************************************************


//******************************************************************************
//TABBED PANE PANEL - THIRD-LEVEL CONTAINER - CUSTOMER/VEHICLE COMBINED
//											  LIST PANEL (SHARED)
//==============================================================================
	JPanel pnlCombinedPanel = new JPanel();
	JList lstCustomerList = new JList();
	JList lstVehicleList = new JList();
	JButton btnDeleteVehicle = new JButton("Delete Vehicle");
	JScrollPane scpVehiclePane = new JScrollPane(lstCustomerList);
	JScrollPane scpCustomerList = new JScrollPane(lstVehicleList);
//******************************************************************************


//******************************************************************************
//TABBED PANE PANEL - THIRD-LEVEL CONTAINER - UPDATE PANEL(SHARED)
//==============================================================================
	JPanel pnlUpdatePanel = new JPanel();
	JButton btnUpdate = new JButton("Update");
	JButton btnDelete = new JButton("Delete");
	JButton btnFind = new JButton("Find");
//******************************************************************************

//CustomerList
	Vector vctTotalCustomerList = new Vector(1,1);
//Parking Lots
	int iLargeLots = 10;
	int iSmallLots = 5;
	
	public static void main(String args[])
	{
		OOP_Asgt mainFrame = new OOP_Asgt();
		mainFrame.setSize(440, 580);
		mainFrame.setTitle("OOP_Asgt");
		mainFrame.setVisible(true);
	}
	
	public OOP_Asgt()
	{
		//Init AppLabel
		lblAppLabel.setFont( new Font("Arial",Font.PLAIN,48));
		//Init AppPanel
		pnlAppPanel.add(lblAppLabel);
		
		//Init ButtonGroup and JRadioButton
		bgpAddChoice.add(rdoCustomer);
		bgpAddChoice.add(rdoVehicle);
		
		//Init pnlAddChoiceSubPanel
		rdoCustomer.addActionListener(this);
		rdoVehicle.addActionListener(this);
		pnlAddChoiceSubPanel.add(rdoCustomer);
		pnlAddChoiceSubPanel.add(rdoVehicle);
		
		//Init AddCustomerSubPanel
		pnlAddCustomerSubPanel.add(lblName);
		pnlAddCustomerSubPanel.add(txtName);
		pnlAddCustomerSubPanel.add(lblAddress);
		pnlAddCustomerSubPanel.add(txtAddress);
		pnlAddCustomerSubPanel.add(lblPhoneNo);
		pnlAddCustomerSubPanel.add(txtPhoneNo);
		pnlAddCustomerSubPanel.add(lblNricNo);
		pnlAddCustomerSubPanel.add(txtNricNo);
		
		//Init AddClearSubPanel
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		pnlAddClearSubPanel.add(btnAdd);
		pnlAddClearSubPanel.add(btnClear);
		
		//Init pnlAddVehicleSubPanel
		rdoCar.addActionListener(this);
		rdoTruck.addActionListener(this);
		bgpVehicleChoice.add(rdoCar);
		bgpVehicleChoice.add(rdoTruck);
		pnlVehicleChoiceSubPanel.add(rdoCar);
		pnlVehicleChoiceSubPanel.add(rdoTruck);
		
		//Init pnlCarSubPanel
		pnlCarSubPanel.add(lblSeatCapacity);
		pnlCarSubPanel.add(txtSeatCapacity);
		
		//Init pnlTruckSubPanel
		pnlTruckSubPanel.add(lblCarraigeLength);
		pnlTruckSubPanel.add(txtCarraigeLength);
		pnlTruckSubPanel.add(lblWeight);
		pnlTruckSubPanel.add(txtWeight);
		pnlTruckSubPanel.add(lblKg);
		
		//Init pnlUniqueVehiclePanel
		pnlUniqueVehiclePanel.add(pnlCarSubPanel);
		
		//Init pnlAddVehicleSubPanel
		cboRentalType.addItem("Daily");
		cboRentalType.addItem("Monthly");
		cboRentalType.addItem("Yearly");
		cboRentalType.addActionListener(this);
		pnlAddVehicleSubPanel.setLayout(gblMainPanelLayout);
		gbcMainPanelConstraint.fill = GridBagConstraints.BOTH;
		gridBagConstraintInit
		(
			pnlVehicleChoiceSubPanel,1,1,0,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(pnlVehicleChoiceSubPanel);
		
		gbcMainPanelConstraint.weighty=1;
		gridBagConstraintInit
		(
			lblCustomer,1,0,1,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblCustomer);
		
		gridBagConstraintInit
		(
			cboCustomerList,1,1,1,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(cboCustomerList);
		
		gridBagConstraintInit
		(
			lblStateRegNo,1,0,2,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblStateRegNo);
		
		gridBagConstraintInit
		(
			txtStateRegNo,1,1,2,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(txtStateRegNo);
		
		gridBagConstraintInit
		(
			lblManufacturer,1,0,3,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblManufacturer);
		
		gridBagConstraintInit
		(
			txtManufacturer,1,1,3,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(txtManufacturer);
		
		gridBagConstraintInit
		(
			lblYear,1,0,4,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblYear);
		
		gridBagConstraintInit
		(
			txtYear,1,1,4,gblMainPanelLayout,gbcMainPanelConstraint
		);
		
		pnlAddVehicleSubPanel.add(txtYear);
		
		gridBagConstraintInit
		(
			lblRentalType,1,0,5,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblRentalType);
		
		gridBagConstraintInit
		(
			cboRentalType,1,1,5,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(cboRentalType);
		
		gridBagConstraintInit
		(
			lblRentalDuration,1,0,6,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblRentalDuration);
		
		gridBagConstraintInit
		(
			txtRentalDuration,1,1,6,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(txtRentalDuration);
		
		gridBagConstraintInit
		(
			lblDurationLabel,1,2,6,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblDurationLabel);
		
		gridBagConstraintInit
		(
			lblMaxSpeed,1,0,7,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblMaxSpeed);
		
		gridBagConstraintInit
		(
			txtMaxSpeed,1,1,7,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(txtMaxSpeed);
		
		gbcMainPanelConstraint.gridwidth=3;
		gridBagConstraintInit
		(
		   pnlUniqueVehiclePanel,1,0,8,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(pnlUniqueVehiclePanel);
		
		gbcMainPanelConstraint.gridwidth=1;
		gridBagConstraintInit
		(
			lblParkingLotSize,1,0,9,gblMainPanelLayout,gbcMainPanelConstraint
		);
		pnlAddVehicleSubPanel.add(lblParkingLotSize);
		gbcMainPanelConstraint.weighty=0;

		//Add panels to pnlTabAddPanel
		pnlTabAddPanel.add(pnlAddChoiceSubPanel,"North");
		pnlTabAddPanel.add(pnlAddCustomerSubPanel,"Center");
		pnlTabAddPanel.add(pnlAddClearSubPanel,"South");

		//Init tabAppTab
		tabAppTab.setFont( new Font("Courier",Font.PLAIN,16));
		//Add two page containing pnlTabAddPanel to tabAppTab
		tabAppTab.addTab("Add",pnlTabAddPanel);
		tabAppTab.add("Edit/View",pnlTabEditPanel);
		tabAppTab.addChangeListener(this);
		pnlTabPanel.add(tabAppTab,BorderLayout.CENTER);
		
		
		//Init pnlCombinedPanel
		lstCustomerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstCustomerList.addListSelectionListener(this);
		lstVehicleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstVehicleList.addListSelectionListener(this);
		btnDeleteVehicle.addActionListener(this);
		pnlCombinedPanel.setLayout(new GridLayout(2,2));
		pnlCombinedPanel.add(scpCustomerList);
		pnlCombinedPanel.add(scpVehiclePane);
		pnlCombinedPanel.add(btnDeleteVehicle);
		
		//Init pnlUpdatePanel
		btnFind.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		pnlUpdatePanel.setLayout(new GridLayout(1,3));
		pnlUpdatePanel.add(btnUpdate);
		pnlUpdatePanel.add(btnDelete);
		pnlUpdatePanel.add(btnFind);
		
		//Init pnlTabEditPanel
		pnlTabEditPanel.setLayout(new GridLayout(4,1));
		
		//Set GridBagConstraint for Component layout for AppPanel
		gbcMainPanelConstraint.fill = GridBagConstraints.BOTH;
		gbcMainPanelConstraint.weightx=0.5;
		gbcMainPanelConstraint.gridx=0;
		gbcMainPanelConstraint.gridy=0;
		gblMainPanelLayout.setConstraints(pnlAppPanel,gbcMainPanelConstraint);
		//Add to MainPanel's GridBagLayout
		pnlMainPanel.add(pnlAppPanel);
		
		//Set GridBagConstraint for Component layout for TabPanel
		gbcMainPanelConstraint.gridx=0;
		gbcMainPanelConstraint.gridy=1;
		gbcMainPanelConstraint.weighty=1;
		gblMainPanelLayout.setConstraints(pnlTabPanel,gbcMainPanelConstraint);
		//Add to MainPanel's GridBagLayout
		pnlMainPanel.add(pnlTabPanel);
		
		//Add Components to the Container LAST - adding a child Component
		//to a parent Component after adding to the Container will result 
		//in the Component not being shown (e.g. add button to a Pane before
		//adding to Container)
		ctrPane.add(pnlMainPanel);
		
		//Anonymous WindowListener for event handling
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
	}

	public void actionPerformed(ActionEvent event)
	{
//******************************************************************************
// ADD BUTTON
//==============================================================================
		if(event.getSource() == btnAdd)
		{	
			//Since Add button appears only in the Add tab pane, it is safe to
			//Check for the radio button status instead of the tab title
			if(rdoCustomer.isSelected())
			{
				checkCustomerFields();
			}
			else
			{
				checkVehicleFields();
				//Check which vehicle is selected - Car or Truck
				if(rdoCar.isSelected())
				{
					checkCarFields();
				}
				else
				{
					checkTruckFields();
				}
			}
		}
//******************************************************************************
//******************************************************************************
// CLEAR BUTTON
//==============================================================================
		else if(event.getSource() == btnClear)
		{	
			clearCustomerFields();
		}
//******************************************************************************
		
//******************************************************************************
// FIND BUTTON
//==============================================================================
		if(event.getSource() == btnFind)
		{	
			String UserResponse;
			UserResponse = JOptionPane.showInputDialog
			(
				this,
				"Please type in the Customer NRIC:",
				"Question",
				JOptionPane.QUESTION_MESSAGE
			);
			if(UserResponse != null)
			{
				Customer[] cstArrayCustomerNameList;
				cstArrayCustomerNameList = getCustomerPointer
											(
												vctTotalCustomerList
											);
				int iCounter=0;
				while(iCounter<cstArrayCustomerNameList.length)
				{
					if
					(
						cstArrayCustomerNameList[iCounter].getNricNo().equals
						(
							UserResponse
						)
					)
					{	
						lstCustomerList.setSelectedIndex(iCounter);
						iCounter = cstArrayCustomerNameList.length;
					}
					else if(iCounter == cstArrayCustomerNameList.length -1)
					{
						clearCustomerFields();
						lstCustomerList.clearSelection();
						JOptionPane.showMessageDialog(this,"No such Customer!");
					}
					iCounter++;
				}
			}
		}
//******************************************************************************
//******************************************************************************
// UPDATE BUTTON
//==============================================================================
		else if(event.getSource() == btnUpdate)
		{
			if(rdoCustomer.isSelected())
			{
				if(lstCustomerList.getSelectedIndex() != -1)
				{
					//Error-Check for null values and numbers in names
					if(	hasNoErrorInTextField(txtName,0) == false
						||
						hasNoErrorInTextField(txtName,2) == true
					  )
					{
						JOptionPane.showMessageDialog
						(	this,
							"Error: Invalid name",
							"Error",
							JOptionPane.ERROR_MESSAGE
						);
					}
					//Check for null values in address
					else if(hasNoErrorInTextField(txtAddress,0)==false)
					{
						JOptionPane.showMessageDialog
						(
							this,
							"Error: Invalid Address",
							"Error",
							JOptionPane.ERROR_MESSAGE
						);
					}
					//Check for null values and alphabets in phone no.
					else if( hasNoErrorInTextField(txtPhoneNo,0) == false
							 ||
							 hasNoErrorInTextField(txtPhoneNo,2) == false
						   )
					{
						JOptionPane.showMessageDialog
						(
							this,
							"Error: Invalid Phone No.",
							"Error",
							JOptionPane.ERROR_MESSAGE
						);
					} 
					//check for null value in NRIC
					else if(hasNoErrorInTextField(txtNricNo,0)==false)
					{
						JOptionPane.showMessageDialog
						(
							this,
							"Error: Invalid NRIC",
							"Error",
							JOptionPane.ERROR_MESSAGE
						);
					}
					else
					{
						Customer[] cstArrayCustomerNameList;
						cstArrayCustomerNameList = getCustomerPointer
													(
														vctTotalCustomerList
													);
						int iCounter=0;
						while(iCounter<cstArrayCustomerNameList.length)
						{
							if
							(
								cstArrayCustomerNameList[iCounter].getName()
								==
								lstCustomerList.getSelectedValue()
							)
							{	
								cstArrayCustomerNameList[iCounter].setName
								(
									txtName.getText()
								);
								cstArrayCustomerNameList[iCounter].setNricNo
								(
									txtNricNo.getText()
								);
								cstArrayCustomerNameList[iCounter].setAddress
								(
									txtAddress.getText()
								);
								cstArrayCustomerNameList[iCounter].setPhoneNo
								(
									Integer.parseInt(txtPhoneNo.getText())
								);
							}
							iCounter++;
						}	
						JOptionPane.showMessageDialog(this,"Customer updated");
						refreshCustomerList();
						clearCustomerFields();
					}
				}
				else
				{
					JOptionPane.showMessageDialog
					(
						this,
						"Error: No Customer/Vehicle selected!",
						"Error",
						JOptionPane.ERROR_MESSAGE
					);
				}
			}
		}
//******************************************************************************
//******************************************************************************
// DELETE CUSTOMER BUTTON
//==============================================================================
		else if(event.getSource() == btnDelete)
		{
			int UserResponse;
			UserResponse = JOptionPane.showConfirmDialog
			(
				this,
				"Are you sure you want to delete this customer?",
				"Confirm Delete?",
				JOptionPane.YES_NO_OPTION
			);
			if(UserResponse == 0)
			{
				Customer[] cstArrayCustomerNameList;
				cstArrayCustomerNameList = getCustomerPointer
											(
												vctTotalCustomerList
											);
				int iCounter=0;
				while(iCounter<cstArrayCustomerNameList.length)
				{
					if(cstArrayCustomerNameList[iCounter].getName().equals
					(
						lstCustomerList.getSelectedValue())
					)
					{	
						vctTotalCustomerList.remove
						(
							cstArrayCustomerNameList[iCounter]
						);
						refreshCustomerList();
					}
					iCounter++;
				}
				refreshVehicleList();
			}

		}
//******************************************************************************
//******************************************************************************
// DELETE VEHICLE BUTTON
//==============================================================================
		else if(event.getSource() == btnDeleteVehicle)
		{
			int UserResponse;
			UserResponse = JOptionPane.showConfirmDialog
			(
				this,
				"Are you sure you want to delete this vehicle?",
				"Confirm Delete?",
				JOptionPane.YES_NO_OPTION
			);
			if(UserResponse == 0)
			{
				Customer[] cstCustomerList = getCustomerPointer
				(
					vctTotalCustomerList
				);
				Vehicle[] tmpVehicleArray;
				for(int iCounter=0;iCounter < cstCustomerList.length;iCounter++)
				{
					//Ensure correct customer
					if
					(	
						cstCustomerList[iCounter].getName()
						==
						lstCustomerList.getSelectedValue()
					)
					{
						tmpVehicleArray = 
						cstCustomerList[iCounter].getVehicleArray();
						for(int i=0;i<tmpVehicleArray.length;i++)
						{
							if
							(
								tmpVehicleArray[i].
								getStateRegistrationNo().
								equals(lstVehicleList.getSelectedValue())
							)
							{
								cstCustomerList[iCounter].getVehicleVector().
								remove(tmpVehicleArray[i]);
							}
						}
					}
				}
				refreshVehicleList();
			}
		}
//******************************************************************************


//******************************************************************************
// ADD CUSTOMER RADIO BUTTON
//==============================================================================
		if(event.getSource() == rdoCustomer)
		{
			pnlTabAddPanel.remove(pnlAddVehicleSubPanel);
			pnlTabAddPanel.add(pnlAddCustomerSubPanel,"Center");
			//To "re-draw" the UI of the panel
			pnlTabAddPanel.updateUI();
		}
//******************************************************************************
//******************************************************************************
// ADD VEHICLE RADIO BUTTON
//==============================================================================
		else if(event.getSource() == rdoVehicle)
		{
			swapTabEditPanel(1);
			pnlTabAddPanel.remove(pnlAddCustomerSubPanel);
			pnlTabAddPanel.add(pnlAddVehicleSubPanel,"Center");
			Customer[] cstArrayCustomerNameList;
			cstArrayCustomerNameList = getCustomerPointer(vctTotalCustomerList);
			cboCustomerList.removeAllItems();
			for
			(
				int iCounter=0;
				iCounter<cstArrayCustomerNameList.length;
				iCounter++
			)
			{
				cboCustomerList.addItem
				(
					cstArrayCustomerNameList[iCounter].getName()
				);
			}
			//To "re-draw" the UI of the panel
			pnlTabAddPanel.updateUI();
		}
//******************************************************************************


//******************************************************************************
// CAR/TRUCK RADIO BUTTON
//==============================================================================
		if(event.getSource() == rdoCar)
		{
			lblParkingLotSize.setText("Parking Lot Size: Small");
			pnlUniqueVehiclePanel.remove(pnlTruckSubPanel);
			pnlUniqueVehiclePanel.add(pnlCarSubPanel);
			pnlUniqueVehiclePanel.updateUI();
		}
		else if(event.getSource() == rdoTruck)
		{
			lblParkingLotSize.setText("Parking Lot Size: Large");
			pnlUniqueVehiclePanel.remove(pnlCarSubPanel);
			pnlUniqueVehiclePanel.add(pnlTruckSubPanel);
			pnlUniqueVehiclePanel.updateUI();
		}
//******************************************************************************


//******************************************************************************
// RENTAL TYPE COMBOBOX
//==============================================================================
		if(event.getSource() == cboRentalType)
		{	
			if(cboRentalType.getSelectedItem().equals("Daily"))
			{
				lblDurationLabel.setText("Days");
			}
			else if(cboRentalType.getSelectedItem().equals("Monthly"))
			{
				lblDurationLabel.setText("Months");
			}
			else if(cboRentalType.getSelectedItem().equals("Yearly"))
			{
				lblDurationLabel.setText("Years");
			}
		}
	}
//******************************************************************************



//******************************************************************************
// ADD OR EDIT/VIEW TABBED PANE CHANGE
//==============================================================================
	public void stateChanged(ChangeEvent event)
	{
		if (event.getSource() == tabAppTab)
		{
			if(tabAppTab.getTitleAt(tabAppTab.getSelectedIndex()) == "Add")
			{
				//"Laziness" in adding/removing individual components
				changeTabAddPanel(0);
				changeTabAddPanel(1);
				clearCustomerFields();
			}
			else
			{ 
				//"Laziness" in adding/removing individual components
				changeTabAddPanel(0);
				swapTabEditPanel(0);
			}
		}
	}
//******************************************************************************

//******************************************************************************
// CUSTOMER LIST SELECTION EVENT
//==============================================================================
	public void valueChanged(ListSelectionEvent event)
	{	
		Customer[] cstCustomerList = getCustomerPointer(vctTotalCustomerList);
		Vehicle[] tmpVehicleArray;
		if(	event.getSource()
			==
			lstCustomerList	&& lstCustomerList.getSelectedValue()
			!= null
		  )
		{	
			//int iVehicleArraySize = 0;
			for(int iCounter = 0;iCounter < cstCustomerList.length;iCounter++)
			{
				if( cstCustomerList[iCounter].getName()
					== lstCustomerList.getSelectedValue()
				  )
				{
					//Show Customer information
					txtName.setText(cstCustomerList[iCounter].getName());
					txtAddress.setText(cstCustomerList[iCounter].getAddress());
					txtPhoneNo.setText(
									""
									+cstCustomerList[iCounter].getPhoneNo());
					txtNricNo.setText(cstCustomerList[iCounter].getNricNo());
					//Show Vehicle list
					tmpVehicleArray=cstCustomerList[iCounter].getVehicleArray();
					String[] strTempArray = new String[tmpVehicleArray.length];
					lstVehicleList.removeAll();
					for(int i=0;i<tmpVehicleArray.length;i++)
					{	
						strTempArray[i]=
						tmpVehicleArray[i].getStateRegistrationNo();
					}
					lstVehicleList.setListData(strTempArray);
				}
			}
		}
	}
//******************************************************************************
	
	
//******************************************************************************
// METHODS
//==============================================================================
	public void gridBagConstraintInit(
										Component cptComponent,
										float iWeightX,
										int iGridX,
										int iGridY,
										GridBagLayout gblLayout,
										GridBagConstraints gbcConstraint)
	{
		gbcConstraint.weightx=iWeightX;
		gbcConstraint.gridx=iGridX;
		gbcConstraint.gridy=iGridY;
		gblLayout.setConstraints(cptComponent,gbcConstraint);
	}
	
	public void changeTabAddPanel(int iParamPanelState)
	{
		//If iParamPanelState is 0, remove Components. If it is 1, add.
		switch(iParamPanelState)
		{
			case 0:	pnlTabAddPanel.removeAll();
					break;
			case 1: rdoCustomer.setSelected(true);
					pnlTabAddPanel.add(pnlAddChoiceSubPanel,"North");
					pnlTabAddPanel.add(pnlAddCustomerSubPanel,"Center");
					pnlTabAddPanel.add(pnlAddClearSubPanel,"South");
					break;
			default:System.out.println(
					"ERROR in initTabAddPanel: iParamPanelState is not valid");
		}
		
		pnlTabAddPanel.updateUI();
	}
	
	public void swapTabEditPanel(int iParamPanelState)
	{
		pnlTabEditPanel.removeAll();
//		pnlTabEditPanel.add(pnlAddChoiceSubPanel);
		pnlTabEditPanel.add(pnlCombinedPanel);
		refreshCustomerList();
		clearCustomerFields();
		clearVehicleFields();
	
		//If iParamPanelState is 0, use pnlAddCustomerSubPanel.
		//If it is 1, use pnlAddVehicleSubPanel and pnlUniqueVehiclePanel
		switch(iParamPanelState)
		{
			case 0:	rdoCustomer.setSelected(true);
					pnlTabEditPanel.add(pnlAddCustomerSubPanel);
					break;
			case 1: pnlTabEditPanel.add(new JScrollPane(pnlAddVehicleSubPanel));
					break;
			default:System.out.println(
					"ERROR in initTabEditPanel: iParamPanelState is not valid");
		}
		
		pnlTabEditPanel.add(pnlUpdatePanel);
		pnlTabEditPanel.updateUI();
	}
	
	public int[] getNoOfVehicles()
	{
		//Index 0 is Cars, 1 is Trucks
		int[] iReturnValue={0,0};
		Object[] objTempArray = vctTotalCustomerList.toArray();
		for(int iCounter=0;iCounter<objTempArray.length;iCounter++)
		{
			Customer cstTempCustomer = (Customer) objTempArray[iCounter];
			Vehicle[] vehTempVehicle = cstTempCustomer.getVehicleArray();
			for(int i=0;i<vehTempVehicle.length;i++)
			{
				if(vehTempVehicle[i].getSizeOfParkingLot().equals("Large"))
				{
					iReturnValue[1] += 1;
				}
				else
				{
					iReturnValue[0] += 1;
				}
			}
		}
		return iReturnValue;
	}	
	
	public void refreshCustomerList()
	{
		String[] sArrayCustomerNameList;
		sArrayCustomerNameList = getCustomerName(vctTotalCustomerList);
		lstCustomerList.removeAll();
		lstCustomerList.setListData(sArrayCustomerNameList);
	}

	public void refreshVehicleList()
	{
		Customer[] cstCustomerList = getCustomerPointer(vctTotalCustomerList);
		Vehicle[] tmpVehicleArray;
		for(int iCounter = 0;iCounter < cstCustomerList.length;iCounter++)
		{
			if(	cstCustomerList[iCounter].getName()
				== lstCustomerList.getSelectedValue()
			  )
			{
				tmpVehicleArray = cstCustomerList[iCounter].getVehicleArray();
				String[] strTempArray = new String[tmpVehicleArray.length];
				lstVehicleList.removeAll();
				for(int i=0;i<tmpVehicleArray.length;i++)
				{	
					strTempArray[i]=tmpVehicleArray[i].getStateRegistrationNo();
				}
				lstVehicleList.setListData(strTempArray);
			}
		}
	}
	
	public void checkTruckFields()
	{
		if( hasNoErrorInTextField(txtWeight,0) == false
			||
			hasNoErrorInTextField(txtWeight,2) == false
		  )
		{
			JOptionPane.showMessageDialog( 	this,
											"Error: Invalid Weight",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		else if( hasNoErrorInTextField(txtCarraigeLength,0) == false
				 ||
				 hasNoErrorInTextField(txtCarraigeLength,2) == false
			   )
		{
			JOptionPane.showMessageDialog( 	this,
											"Error: Invalid Carraige Length",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		else
		{
			//Check to see if there is a Customer selected in cboCustomerList
			if(cboCustomerList.getItemCount() == 0)
			{
				JOptionPane.showMessageDialog
				(
					this,
					"Error: No Customers in the database!",
					"Error",
					JOptionPane.ERROR_MESSAGE
				);
			}
			else
			{
				Customer[] cstTempCustomer = getCustomerPointer
											 (
												vctTotalCustomerList
											 );
				for(int iCounter=0;iCounter<cstTempCustomer.length;iCounter++)
				{
					if(	cstTempCustomer[iCounter].getName() 
						== cboCustomerList.getSelectedItem()
					  )
					{
						if(getNoOfVehicles()[1] <= iLargeLots)
						{
							Truck trkTempTruck = new Truck
							(
								txtStateRegNo.getText(),
								txtManufacturer.getText(),
								Integer.parseInt(txtYear.getText()),
								(String)cboRentalType.getSelectedItem(),
								Integer.parseInt(txtRentalDuration.getText()),
								Integer.parseInt(txtMaxSpeed.getText()),
								"Large",
								Integer.parseInt(txtCarraigeLength.getText()),
								Integer.parseInt(txtWeight.getText())
							);
							cstTempCustomer[iCounter].addVehicle(trkTempTruck);
							clearVehicleFields();
							JOptionPane.showMessageDialog
							(	
								this,
								"The rental amount will be: $"
								+trkTempTruck.calculateFee()
							);
							JOptionPane.showMessageDialog(this,"Vehicle added");
						}
						else
						{
							JOptionPane.showMessageDialog
							(
								this,"All large parking lots are full!"
							);
						}
					}
				}
			}
		}
	}
	
	public void checkCarFields()
	{
		if( hasNoErrorInTextField(txtSeatCapacity,0) == false
			||
			hasNoErrorInTextField(txtSeatCapacity,2) == false
		  )
		{
			JOptionPane.showMessageDialog( 	this,
											"Error: Invalid Seat",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		else
		{
			//Check to see if there is a Customer selected in cboCustomerList
			if(cboCustomerList.getItemCount() == 0)
			{
				JOptionPane.showMessageDialog
				(
					this,
					"Error: No Customers in the database!",
					"Error",
					JOptionPane.ERROR_MESSAGE
				);
			}
			else
			{
				Customer[] cstTempCustomer = getCustomerPointer
											(
												vctTotalCustomerList
											);
				for(int iCounter=0;iCounter<cstTempCustomer.length;iCounter++)
				{
					if(
						cstTempCustomer[iCounter].getName()
						== cboCustomerList.getSelectedItem()
					  )
					{
						if(getNoOfVehicles()[0] <= iSmallLots)
						{
							Car carTempCar = new Car
							(
								txtStateRegNo.getText(),
								txtManufacturer.getText(),
								Integer.parseInt(txtYear.getText()),
								(String)cboRentalType.getSelectedItem(),
								Integer.parseInt(txtRentalDuration.getText()),
								Integer.parseInt(txtMaxSpeed.getText()),
								"Small",
								Integer.parseInt(txtSeatCapacity.getText())
							);
							cstTempCustomer[iCounter].addVehicle(carTempCar);
							clearVehicleFields();
							JOptionPane.showMessageDialog
							(	
								this,
								"The rental amount will be: $"
								+carTempCar.calculateFee()
							);
							JOptionPane.showMessageDialog(this,"Vehicle added");
						}
						else
						{
							JOptionPane.showMessageDialog
							(
								this,"All small parking lots are full!"
							);
						}
					}
				}
			}
		}
	}
		
	public void checkVehicleFields()
	{	
		//Error-Check for null values and numbers in names
		if(hasNoErrorInTextField(txtStateRegNo,0) == false)
		{
			JOptionPane.showMessageDialog(	this,
											"Error: Invalid State Reg. No.",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		else if(hasNoErrorInTextField(txtManufacturer,0) == false)
		{
			JOptionPane.showMessageDialog(	this,
											"Error: Invalid Manufacturer",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		else if( hasNoErrorInTextField(txtYear,0) == false
				 ||
				 hasNoErrorInTextField(txtYear,2) == false
			   )
		{
			JOptionPane.showMessageDialog( 	this,
											"Error: Invalid Year",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		else if( hasNoErrorInTextField(txtRentalDuration,0) == false
				 ||
				 hasNoErrorInTextField(txtRentalDuration,2) == false
			   )
		{
			JOptionPane.showMessageDialog( 	this,
											"Error: Invalid Rental Duration",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		else if( hasNoErrorInTextField(txtMaxSpeed,0) == false
				 ||
				 hasNoErrorInTextField(txtMaxSpeed,2) == false
			   )
		{
			JOptionPane.showMessageDialog( 	this,
											"Error: Invalid Speed",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
	}
	
	
	public void checkCustomerFields()
	{
		//Error-Check for null values and numbers in names
		if(	hasNoErrorInTextField(txtName,0) == false
			||
			hasNoErrorInTextField(txtName,2) == true
		  )
		{
			JOptionPane.showMessageDialog(	this,
											"Error: Invalid name",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		//Check for null values in address
		else if(hasNoErrorInTextField(txtAddress,0)==false)
		{
			JOptionPane.showMessageDialog(	this,
											"Error: Invalid Address",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		//Check for null values and alphabets in phone no.
		else if( hasNoErrorInTextField(txtPhoneNo,0) == false
				 ||
				 hasNoErrorInTextField(txtPhoneNo,2) == false
			   )
		{
			JOptionPane.showMessageDialog(	this,
											"Error: Invalid Phone No.",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		} 
		//check for null value in NRIC
		else if(hasNoErrorInTextField(txtNricNo,0)==false)
		{
			JOptionPane.showMessageDialog(	this,
											"Error: Invalid NRIC",
											"Error",
											JOptionPane.ERROR_MESSAGE
										 );
		}
		else
		{
			//Add Customer to the vector list
			vctTotalCustomerList.add
			(
				new Customer
				(	
					txtName.getText(),
					txtAddress.getText(),
					Integer.parseInt(txtPhoneNo.getText()),
					txtNricNo.getText()
				)
			);
			JOptionPane.showMessageDialog(this,"Customer added");
		}
	}
	
	 // Vector
	public String[] getCustomerName(Vector vctParamCustomerVector)
	{
		Object[] objTempArray = vctParamCustomerVector.toArray();
		String[] sReturnValue = new String[objTempArray.length];
		Customer cstTempCustomer;
		for(int iCounter=0;iCounter < objTempArray.length;iCounter++)
		{
 			cstTempCustomer = (Customer) objTempArray[iCounter];
			sReturnValue[iCounter] = cstTempCustomer.getName();
		}
		return sReturnValue;
	}
	
	public Customer[] getCustomerPointer(Vector vctParamCustomerVector)
	{
		Object[] objTempArray = vctParamCustomerVector.toArray();
		Customer[] cstReturnValue = new Customer[objTempArray.length];
		for(int iCounter=0;iCounter < objTempArray.length;iCounter++)
		{

			cstReturnValue[iCounter] = (Customer) objTempArray[iCounter];
		}
		return cstReturnValue;
	}
	
	public void clearVehicleFields()
	{
		txtStateRegNo.setText("");
		txtManufacturer.setText("");
		txtYear.setText("");
		txtRentalDuration.setText("");
		txtMaxSpeed.setText("");
		txtCarraigeLength.setText("");
		txtWeight.setText("");
		txtSeatCapacity.setText("");
	}
	
	public void clearCustomerFields()
	{
			txtName.setText("");
			txtAddress.setText("");
			txtPhoneNo.setText("");
			txtNricNo.setText("");
	}
	
	public boolean hasNoErrorInTextField(JTextField txtParamTextField,
										int iParamType)
	{
		//Return true by default and when there is no error detected	
		boolean bReturnValue = true;
		//Check what type of error-check should this method do
		//0 - Null values
		//2 - Numeric
		String strTempString = txtParamTextField.getText();
		int iCounter;
		int iStringLength;
		switch(iParamType)
		{
			case 0:	if (strTempString.length() == 0)
					{
						bReturnValue = false;
					};
					break;
			case 2:	iCounter = 0;
					iStringLength = strTempString.length();
					while(bReturnValue == true && iCounter < iStringLength)
					{
						if(	strTempString.charAt(iCounter) < '0'
							||
							strTempString.charAt(iCounter) > '9'
						  )
						{
							//Break out of loop
							iCounter = iStringLength;
							bReturnValue = false;
						}
						iCounter++;
					};
					break;
		}
		return bReturnValue;
	}
}
//******************************************************************************
