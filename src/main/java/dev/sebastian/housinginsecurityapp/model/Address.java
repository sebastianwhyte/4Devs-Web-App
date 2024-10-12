package dev.sebastian.housinginsecurityapp.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

//@Component
@Entity
@Table(name = "Address")
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int id;
	@Column
	private String street;
	@Column
	private String borough;
	@Column
	private String state;
	@Column
	private int zipCode;

	// ----------------------------------------------------------------------------
	public Address()
	{
	}

	public Address(String street, String borough, String state, int zipCode)
	{
		this.street = street;
		this.borough = borough;
		this.state = state;
		this.zipCode = zipCode;
	}

	// ----------------------------------------------------------------------------

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getBorough()
	{
		return borough;
	}

	public void setBorough(String borough)
	{
		this.borough = borough;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public int getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}
}
