/*** Class that controls API calls for shelter instances
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Oct 12 2024
 */

package dev.sebastian.Fourdevswebapp.controller;

import dev.sebastian.Fourdevswebapp.model.Shelter;
import dev.sebastian.Fourdevswebapp.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController
{
	@Autowired
	private final ShelterService shelterService;

	// ----------------------------------------------------------------------------
	@Autowired
	public ShelterController(ShelterService shelterService)
	{
		this.shelterService = shelterService;
	}

	// ----------------------------------------------------------------------------

	@GetMapping("/all")
	public List<Shelter> getAllShelters()
	{
		return shelterService.getAllShelters();
	}

	// ----------------------------------------------------------------------------
	/**
	 * @param newShelter	the shelter to add
	 */
	@PostMapping("/add")
	public Shelter addNewShelter(@RequestBody Shelter newShelter)
	{
		return shelterService.addNewShelter(newShelter);
	}
}