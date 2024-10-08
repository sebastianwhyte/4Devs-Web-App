package dev.sebastian.housinginsecurityapp.service;

import dev.sebastian.housinginsecurityapp.dao.OrganizationRepository;
import dev.sebastian.housinginsecurityapp.exception.OrganizationNotFoundException;
import dev.sebastian.housinginsecurityapp.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrganizationService
{
	private final OrganizationRepository organizationRepository;

	// ----------------------------------------------------------------------------

	@Autowired
	public OrganizationService(OrganizationRepository organizationRepository)
	{
		this.organizationRepository = organizationRepository;
	}

	// ----------------------------------------------------------------------------

	public List<Organization> getAllOrganizations()
	{
		List<Organization> orgs = new ArrayList<>();

		organizationRepository.findAll().forEach(organization -> orgs.add(organization));

		return orgs;
	}

	// ----------------------------------------------------------------------------

	public Organization getOrganizationById(int id) throws OrganizationNotFoundException
	{
		Optional<Organization> chosenOrganization = organizationRepository.findById(id);

		try
		{
			if (chosenOrganization.isPresent())
			{
				return chosenOrganization.get();
			}
		}
		catch (NoSuchElementException exception)
		{
			// Add logger here
			System.out.println(" " + exception.getClass() + ": " + exception.getMessage());
			throw new OrganizationNotFoundException("Organization with ID: + " + id + " not found!");
		}

		return null;
	}
}
