/*** Class that controls API calls for the various types of organizations
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Oct 02 2024
 */

package dev.sebastian.housinginsecurityapp.controller;

import dev.sebastian.housinginsecurityapp.model.Organization;
import dev.sebastian.housinginsecurityapp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/organizations")
public class OrganizationController
{
	@Autowired
	private final OrganizationService organizationService;

	// ----------------------------------------------------------------------------
	@Autowired
	public OrganizationController(OrganizationService organizationService)
	{
		this.organizationService = organizationService;
	}

	// ----------------------------------------------------------------------------

	/**
	 *  Retrieves all organizations
	 * @return list consisting of all organizations
	 */
	@GetMapping("/all")
	public List<Organization> getAllOrganizations()
	{
		return organizationService.getAllOrganizations();
	}

	// ----------------------------------------------------------------------------

	/** Retrieves organization with the specified id
	 *
	 * @param id	id of the organization
	 * @return organization
	 */
	@GetMapping("/{id}")
	public Organization getOrganizationById(@PathVariable String id)
	{
		return organizationService.getOrganizationById(id);
	}

	// ----------------------------------------------------------------------------

	/**
	 * @param newOrganization	the organization to add
	 */
	@PostMapping("/add")
	public Organization addNewOrganization(@RequestBody Organization newOrganization)
	{
		return organizationService.addNewOrganization(newOrganization);
	}

	// ----------------------------------------------------------------------------
	/**
	 * @return organization to be deleted
	 */
	@DeleteMapping("/delete/{id}")
	public Organization deleteOrganizationById(@PathVariable("id") String id)
	{
		return organizationService.deleteOrganizationByid(id);
	}
}
