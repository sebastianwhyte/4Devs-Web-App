package dev.sebastian.housinginsecurityapp.service;

import dev.sebastian.housinginsecurityapp.dao.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

	public List<Map<String, Object>> getAllOrganizations()
	{
		return organizationRepository.getAllOrganizations();
	}
}
