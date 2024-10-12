package dev.sebastian.housinginsecurityapp.controller;

import dev.sebastian.housinginsecurityapp.exception.OrganizationNotFoundException;
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

	/*
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
	public Organization getOrganizationById(@PathVariable String id) throws OrganizationNotFoundException
	{
		return organizationService.getOrganizationById(id);
	}

	// ----------------------------------------------------------------------------

	/** Adds organization to the database
	 *
	 * @param newOrganization	the organization to add
	 */
	@PostMapping("/add")
	public Organization addNewOrganization(@RequestBody Organization newOrganization)
	{
		return organizationService.addNewOrganization(newOrganization);
	}
}
