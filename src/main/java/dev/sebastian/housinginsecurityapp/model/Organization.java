package dev.sebastian.housinginsecurityapp.model;

import jakarta.persistence.*;

import java.net.URL;

@Entity
@Table (name = "organization")
public class Organization
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int org_id;

	@Column
	private String name;

	@Column
	private String phoneNumber;

	@Column
	private URL website;

	//@Autowired
	//@Transient
	//private Address address;

	// ------------------------------------------------------------------------------
	public Organization()
	{
	}

	// ------------------------------------------------------------------------------
	public Organization(int org_id, String name, String phoneNumber, URL website)
	{
		this.org_id = org_id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.website = website;
	}

	// ------------------------------------------------------------------------------


	/*public Organization(int id, String name, String phoneNumber, URL website, Address address)
	{
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.website = website;
		this.address = address;
	}*/

	// ------------------------------------------------------------------------------


	public int getOrg_id()
	{
		return org_id;
	}

	public void setOrg_id(int id)
	{
		this.org_id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public URL getWebsite()
	{
		return website;
	}

	public void setWebsite(URL website)
	{
		this.website = website;
	}

	/*public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = this.address;
	}*/
}
