package dev.sebastian.housinginsecurityapp.api;

import dev.sebastian.housinginsecurityapp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

	@GetMapping("/all")
	public List<Map<String, Object>> getAllOrganizations()
	{
		return organizationService.getAllOrganizations();
	}
}
