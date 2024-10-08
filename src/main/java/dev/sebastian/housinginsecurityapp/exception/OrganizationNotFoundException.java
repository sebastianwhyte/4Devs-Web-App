package dev.sebastian.housinginsecurityapp.exception;

public class OrganizationNotFoundException extends Exception
{
	public OrganizationNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
}
