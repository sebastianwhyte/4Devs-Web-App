/** Model class that represents an organization
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Oct 02 2024
 */

package dev.sebastian.Fourdevswebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.net.URL;

@Entity
@Table (name = "organization")
public class Organization
{
	// TODO - Fix auto increment id
	@TableGenerator(
			name = "yourTableGenerator",
			allocationSize = 1,
			initialValue = 1
	)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yourTableGenerator")
	@Column
	@JsonProperty("org_id")
	int orgId;

	@Column (name = "name")
	@JsonProperty("name")
	String name;

	@Column (name = "phone_number")
	@JsonProperty("phone_number")
	String phoneNumber;

	@Column (name = "website")
	@JsonProperty("website")
	URL website;

	//@Autowired
	//@Transient
	//private Address address;

	// ------------------------------------------------------------------------------
	public Organization()
	{
	}

	// ------------------------------------------------------------------------------
	public Organization(String name, String phoneNumber, URL website)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.website = website;

		// DEBUG
		System.out.println(getName());
	}

	// ------------------------------------------------------------------------------
	public Organization(int orgId, String name, String phoneNumber, URL website)
	{
		this.orgId = orgId;
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


	public int getOrgId()
	{
		return orgId;
	}

	public void setOrgId(int id)
	{
		this.orgId = id;
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
