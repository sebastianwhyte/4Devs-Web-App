/** Service class responsible for handling business logic behind the organization api requests
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Oct 02 2024
 */

package dev.sebastian.housinginsecurityapp.service;

import dev.sebastian.housinginsecurityapp.dao.OrganizationRepository;
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

	/** Retrieves organization with the specified id
	 *
	 * @param id	id of organization to search for
	 * @return	organization with the given id
	 */
	public Organization getOrganizationById(@PathVariable String id)
	{
		Optional<Organization> chosenOrganization = organizationRepository.findById(parseInt(id));

		try
		{
			if (chosenOrganization.isPresent())
			{
				logger.info("Organization successfully retrieved.");
				return chosenOrganization.get();
			}
			else
			{
				logger.warn("Chosen Organization is empty");
			}
		}
		catch (NoSuchElementException exception)
		{
			logger.fatal(" " + exception.getClass() + ": Organization does not exist in database... " + exception.getMessage());
		}

		return null;
	}

	// ----------------------------------------------------------------------------
	/**
	 * @param newOrganization	the organization to add
	 */
	public Organization addNewOrganization(Organization newOrganization)
	{
		return organizationRepository.save(newOrganization);
	}

	// ----------------------------------------------------------------------------
	/**
	 *
	 * @param id	id of organization to delete
	 * @return deleted organization
	 */
	public Organization deleteOrganizationByid(String id)
	{
		Optional<Organization> organizationToBeDeleted = organizationRepository.findById(parseInt(id));

		try
		{
			if (organizationToBeDeleted.isPresent())
			{
				organizationRepository.delete(organizationToBeDeleted.get());
				logger.info("Organization successfully deleted.");
			}
			else
			{
				logger.warn("Deletion Failed -- Chosen Organization does not exist in database.");
			}
		}
		catch (NoSuchElementException exception)
		{
			logger.fatal(" " + exception.getClass() + ": " + exception.getMessage());
		}

		return null;
	}
}
