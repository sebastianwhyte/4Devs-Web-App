/*** Model class that represents a shelter
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Oct 06 2024
 */

package dev.sebastian.Fourdevswebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.sebastian.Fourdevswebapp.constants.ShelterType;
import dev.sebastian.Fourdevswebapp.model.Resource;
import jakarta.persistence.*;

import java.net.URL;
import java.util.List;

@Entity
public class Shelter extends Organization
{
	@ManyToMany
	@JoinTable(name = "organizationresources",
				joinColumns = @JoinColumn(name = "org_id"),
				inverseJoinColumns = @JoinColumn(name = "resource_id"))
	private List<Resource> resourcesOffered;

	//@Enumerated(EnumType.STRING)
	@JsonProperty("type")
	private ShelterType type;

	@OneToMany(mappedBy = "populationType")
	private List<Population> populationServed;

	// ----------------------------------------------------------------------------
	public Shelter()
	{

	}

	// ------------------------------------------------------------------------------
	public Shelter(String name, String phoneNumber, URL website)
	{
		super(name, phoneNumber, website);

		// DEBUG
		System.out.println("After calling super");
	}

	// ------------------------------------------------------------------------------
	public Shelter(List<Resource> resourcesOffered, ShelterType type, List<Population> populationServed)
	{
		this.resourcesOffered = resourcesOffered;
		this.type = type;
		this.populationServed = populationServed;
	}

	// ----------------------------------------------------------------------------

	public void addServices(Resource resourcesOffered)
	{
		this.resourcesOffered.add(resourcesOffered);
	}

	// ----------------------------------------------------------------------------

	public void addPopulation(Population population)
	{
		populationServed.add(population);
	}

	// ----------------------------------------------------------------------------


	public List<Resource> getResourcesOffered()
	{
		return resourcesOffered;
	}

	public void setResourcesOffered(List<Resource> resourcesOffered)
	{
		this.resourcesOffered = resourcesOffered;
	}

	public ShelterType getType()
	{
		return type;
	}

	public void setType(String type)
	{
		if (type.equalsIgnoreCase("DROP_IN_CENTER") || type.equalsIgnoreCase("Drop In Center"))
		{
			this.type = ShelterType.DROP_IN_CENTER;
		}
		else
		{
			this.type = ShelterType.SERVICE_AND_SUPPORT_BUSES;
		}
	}

	public List<Population> getPopulationServed()
	{
		return populationServed;
	}

	public void setPopulationServed(List<Population> populationServed)
	{
		this.populationServed = populationServed;
	}
}
