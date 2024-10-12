package dev.sebastian.housinginsecurityapp.service;

import dev.sebastian.housinginsecurityapp.dao.OrganizationRepository;
import dev.sebastian.housinginsecurityapp.exception.OrganizationNotFoundException;
import dev.sebastian.housinginsecurityapp.model.Organization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class OrganizationService
{
	private final OrganizationRepository organizationRepository;
	private static final Logger logger = LogManager.getLogger();

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
	public Organization getOrganizationById(@PathVariable String id) throws OrganizationNotFoundException
	{
		Optional<Organization> chosenOrganization = organizationRepository.findById(parseInt(id));

		try
		{
			if (chosenOrganization.isPresent())
			{
				return chosenOrganization.get();
			}
			else
			{
				logger.warn("Chosen Organization is empty");
			}
		}
		catch (NoSuchElementException exception)
		{
			logger.fatal(" " + exception.getClass() + ": " + exception.getMessage());

			//throw new OrganizationNotFoundException("Organization with ID: + " + id + " not found!");
		}

		return null;
	}

	// ----------------------------------------------------------------------------
	public Organization addNewOrganization(Organization newOrganization)
	{
		return organizationRepository.save(newOrganization);
	}
}
