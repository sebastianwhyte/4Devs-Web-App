package dev.sebastian.housinginsecurityapp.builders;

public interface Builder
{
	public void setName(String name);

	public void setStreet(String street);

	public void setBorough(String borough);

	public void setState(String state);

	public void setZipCode(int zipCode);

	public void setPhoneNumber(String phoneNumber);

	public void setDescription(String description);
}
