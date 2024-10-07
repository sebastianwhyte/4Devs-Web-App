package dev.sebastian.housinginsecurityapp.model;

import dev.sebastian.housinginsecurityapp.constants.ShelterType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Shelter extends Organization
{
	private List<String> servicesOffered;
	private ShelterType type;

	private List<String> populationServed;

	// ----------------------------------------------------------------------------
	public Shelter()
	{
	}

	public Shelter(List<String> servicesOffered, ShelterType type, List<String> populationServed)
	{
		this.servicesOffered = servicesOffered;
		this.type = type;
		this.populationServed = populationServed;
	}

	// ----------------------------------------------------------------------------

	public void addServices(String serviceOffered)
	{
		servicesOffered.add(serviceOffered);
	}

	// ----------------------------------------------------------------------------

	public void addPopulation(String population)
	{
		populationServed.add(population);
	}

	// ----------------------------------------------------------------------------


	public List<String> getServicesOffered()
	{
		return servicesOffered;
	}

	public void setServicesOffered(List<String> servicesOffered)
	{
		this.servicesOffered = servicesOffered;
	}

	public ShelterType getType()
	{
		return type;
	}

	public void setType(String type)
	{
		if (type.equals("DROP_IN_CENTER"))
		{
			this.type = ShelterType.DROP_IN_CENTER;
		}
		else
		{
			this.type = ShelterType.SERVICE_AND_SUPPORT_BUSES;
		}
	}

	public List<String> getPopulationServed()
	{
		return populationServed;
	}

	public void setPopulationServed(List<String> populationServed)
	{
		this.populationServed = populationServed;
	}
}
