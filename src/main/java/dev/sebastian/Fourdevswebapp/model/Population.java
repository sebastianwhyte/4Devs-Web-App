package dev.sebastian.Fourdevswebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.sebastian.Fourdevswebapp.constants.PopulationType;
import jakarta.persistence.*;

@Entity
@Table (name = "population")
public class Population
{
	@TableGenerator(
			name = "yourTableGenerator",
			allocationSize = 1,
			initialValue = 1
	)

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yourTableGenerator")
	private int populationId;

	@Column
	@Enumerated(EnumType.STRING)
	@JsonProperty("population_type")
	private PopulationType populationType;

	// -----------------------------------------------------------------
	public Population()
	{
	}

	// -----------------------------------------------------------------
	public Population(int populationId, PopulationType populationType)
	{
		this.populationId = populationId;
		this.populationType = populationType;
	}

	// -----------------------------------------------------------------

	public Population(PopulationType populationType)
	{
		this.populationType = populationType;
	}

	// -----------------------------------------------------------------

	public int getPopulationId()
	{
		return populationId;
	}

	// -----------------------------------------------------------------
	public void setPopulationId(int population_id)
	{
		this.populationId = population_id;
	}

	// -----------------------------------------------------------------
	public PopulationType getPopulationType()
	{
		return populationType;
	}

	// -----------------------------------------------------------------
	public void setPopulationType(String population_type)
	{
		if (population_type.equalsIgnoreCase("Single Adults") ||
				population_type.equalsIgnoreCase("SINGLE_ADULTS"))
		{
			this.populationType = PopulationType.SINGLE_ADULTS;
		}
		else if (population_type.equalsIgnoreCase("Adult Families") ||
				population_type.equalsIgnoreCase("ADULT_FAMILIES"))
		{
			this.populationType = PopulationType.ADULT_FAMILIES;
		}
		else if (population_type.equalsIgnoreCase("Families with Children / Single Pregnant Women") ||
				population_type.equalsIgnoreCase("Families with Children") ||
				population_type.equalsIgnoreCase("Single Pregnant Women") ||
				population_type.equalsIgnoreCase("Families with Children Single Pregnant Women") ||
				population_type.equalsIgnoreCase("Families with Children, Single Pregnant Women"))
		{
			this.populationType = PopulationType.FAMILIES_WITH_CHILDREN_AND_SINGLE_PREGNANT_WOMEN;
		}
	}
}
