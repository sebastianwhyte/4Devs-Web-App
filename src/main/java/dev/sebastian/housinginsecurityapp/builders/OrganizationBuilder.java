package dev.sebastian.housinginsecurityapp.builders;

import dev.sebastian.housinginsecurityapp.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationBuilder implements Builder
{
	private final Organization organization;

	// -----------------------------------------------------------------
	@Autowired
	public OrganizationBuilder(Organization organization)
	{
		this.organization = organization;
	}


	// -----------------------------------------------------------------
	@Override
	public void setName(String name)
	{
		this.organization.setName(name);
	}

	// -----------------------------------------------------------------
	@Override
	public void setStreet(String street)
	{
		this.organization.setStreet(street);
	}

	// -----------------------------------------------------------------
	@Override
	public void setBorough(String borough)
	{
		this.organization.setBorough(borough);
	}

	// -----------------------------------------------------------------
	@Override
	public void setState(String state)
	{
		this.organization.setState(state);
	}

	// -----------------------------------------------------------------
	@Override
	public void setZipCode(int zipCode)
	{
		this.organization.setZipCode(zipCode);
	}

	// -----------------------------------------------------------------
	@Override
	public void setPhoneNumber(String phoneNumber)
	{
		this.organization.setPhoneNumber(phoneNumber);
	}

	// -----------------------------------------------------------------
	@Override
	public void setDescription(String description)
	{
		this.organization.setDescription(description);
	}

	// -----------------------------------------------------------------
	public Organization getResult()
	{
		return this.organization;
	}

}
