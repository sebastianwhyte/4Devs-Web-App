package dev.sebastian.housinginsecurityapp.model;

import dev.sebastian.housinginsecurityapp.constants.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Component
public class Organization
{
	private int id;
	private String name;
	private String street;
	private String borough;
	private String state;
	private int zipCode;
	private String phoneNumber;
	private URL website;

	@Autowired
	private Description description;


	// ----------------------------------------------------
	public Organization() {}


	// ---- Getters and setters ----------------------------------------

	public String getName()
	{
		return name;
	}

	// -----------------------------------------------------------------
	public void setName(String name)
	{
		this.name = name;
	}

	// -----------------------------------------------------------------
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	// -----------------------------------------------------------------
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	// -----------------------------------------------------------------
	public URL getWebsite()
	{
		return website;
	}

	// -----------------------------------------------------------------
	public void setWebsite(String website)
	{
		this.website = validateURL(website);
	}

	// -----------------------------------------------------------------

	private URL validateURL(String url)
	{
		URI uri;

		try
		{
			uri = new URI(url);
		}
		catch (URISyntaxException e)
		{
			throw new RuntimeException(e);
		}

		try
		{
			return uri.toURL();
		} catch (MalformedURLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// -----------------------------------------------------------------
	public int getId()
	{
		return id;
	}

	// -----------------------------------------------------------------
	public void setId(int id)
	{
		this.id = id;
	}

	// -----------------------------------------------------------------
	public String getStreet()
	{
		return street;
	}

	// -----------------------------------------------------------------
	public void setStreet(String street)
	{
		this.street = street;
	}

	// -----------------------------------------------------------------
	public String getBorough()
	{
		return borough;
	}

	// -----------------------------------------------------------------
	public void setBorough(String borough)
	{
		this.borough = borough;
	}

	// -----------------------------------------------------------------
	public String getState()
	{
		return state;
	}

	// -----------------------------------------------------------------
	public void setState(String state)
	{
		this.state = state;
	}

	// -----------------------------------------------------------------
	public int getZipCode()
	{
		return zipCode;
	}

	// -----------------------------------------------------------------
	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}

	// -----------------------------------------------------------------
	public Description getDescription()
	{
		return description;
	}

	// -----------------------------------------------------------------
	public void setDescription(String description)
	{
		if (description.equals("Drop-In Center"))
		{
			this.description = Description.DROP_IN_CENTER;
		}
		else
		{
			this.description = Description.SERVICE_AND_SUPPORT_BUSES;
		}
	}

	// -----------------------------------------------------------------
	@Override
	public String toString()
	{
		return "Organization Name: " + name + '\n' +
				"Address{" +
				"street='" + street + '\'' +
				", borough='" + borough + '\'' +
				", state='" + state + '\'' +
				", zipCode=" + zipCode +
				'}';
	}
}
