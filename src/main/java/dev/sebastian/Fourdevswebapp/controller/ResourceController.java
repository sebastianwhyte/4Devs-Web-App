package dev.sebastian.Fourdevswebapp.controller;

import dev.sebastian.Fourdevswebapp.model.Resource;
import dev.sebastian.Fourdevswebapp.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController
{
	@Autowired
	private final ResourceService resourceService;

	// ---------------------------------------------------------------------------
	@Autowired
	public ResourceController(ResourceService resourceService)
	{
		this.resourceService = resourceService;
	}

	// ---------------------------------------------------------------------------
	@GetMapping("/all")
	public List<Resource> getAllResources()
	{
		return resourceService.getAllResources();
	}

	// ---------------------------------------------------------------------------
	@PostMapping("/add")
	public Resource addNewResource(@RequestBody Resource newResource)
	{
		return resourceService.addNewResource(newResource);
	}
}
