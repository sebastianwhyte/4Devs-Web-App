package dev.sebastian.Fourdevswebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "resource")
public class Resource
{
	@TableGenerator(
			name = "yourTableGenerator",
			allocationSize = 1,
			initialValue = 1
	)

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yourTableGenerator")
	@Column (name = "resource_id")
	private int resourceId;

	@Column(name = "resource_name")
	@JsonProperty("resource_name")
	private String resourceName;


	// ---------------------------------------------------------------
	public Resource() {}

	// ---------------------------------------------------------------

	public Resource(int resourceId, String resourceName)
	{
		this.resourceId = resourceId;
		this.resourceName = resourceName;
	}

	// ---------------------------------------------------------------------------

	public int getResourceId()
	{
		return resourceId;
	}


	public void setResourceId(int resourceId)
	{
		this.resourceId = resourceId;
	}

	public String getResourceName()
	{
		return resourceName;
	}

	public void setResourceName(String resourceName)
	{
		this.resourceName = resourceName;
	}
}
