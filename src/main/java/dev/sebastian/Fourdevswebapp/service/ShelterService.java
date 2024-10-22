/** Service class responsible for handling business logic behind the shelter api requests
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Oct 12 2024
 */

package dev.sebastian.Fourdevswebapp.service;

import dev.sebastian.Fourdevswebapp.dao.ShelterRepository;
import dev.sebastian.Fourdevswebapp.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelterService
{
	private final ShelterRepository shelterRepository;

	// ----------------------------------------------------------------------------
	@Autowired
	public ShelterService(ShelterRepository shelterRepository)
	{
		this.shelterRepository = shelterRepository;
	}

	// ----------------------------------------------------------------------------
	public List<Shelter> getAllShelters()
	{
		List<Shelter> shelters = new ArrayList<>();

		shelterRepository.findAll().forEach(shelter -> shelters.add(shelter));

		return shelters;
	}

	// ----------------------------------------------------------------------------
	public Shelter addNewShelter(Shelter newShelter)
	{
		return shelterRepository.save(newShelter);
	}

	// ----------------------------------------------------------------------------

}
