package dev.sebastian.Fourdevswebapp.service;


import dev.sebastian.Fourdevswebapp.dao.ResourceRepository;
import dev.sebastian.Fourdevswebapp.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService
{
	@Autowired
	private final ResourceRepository resourceRepository;

	// ------------------------------------------------------------------------------
	public ResourceService(ResourceRepository resourceRepository)
	{
		this.resourceRepository = resourceRepository;
	}

	// ------------------------------------------------------------------------------
	public List<Resource> getAllResources()
	{
		List<Resource> resources = new ArrayList<>();

		resourceRepository.findAll().forEach(resource -> resources.add(resource));

		return resources;
	}

	// ------------------------------------------------------------------------------
	public Resource addNewResource(Resource newResource)
	{
		return resourceRepository.save(newResource);
	}
}
