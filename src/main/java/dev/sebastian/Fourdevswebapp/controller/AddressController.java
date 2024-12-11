package dev.sebastian.Fourdevswebapp.controller;

import dev.sebastian.Fourdevswebapp.model.Address;
import dev.sebastian.Fourdevswebapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController
{
	@Autowired
	private final AddressService addressService;

	// ---------------------------------------------------------------------------
	public AddressController(AddressService addressService)
	{
		this.addressService = addressService;
	}


	// ---------------------------------------------------------------------------
	/** Retrieves the address belonging to the organization with the specified org id
	 *
	 * @param orgId		id of organization whose address we want to find
	 * @return			address of organization with specified org id
	 */

	@GetMapping("/find/{orgId}")
	public Address getAddressByOrganizationId(@PathVariable("orgId") String orgId)
	{
		return addressService.getAddressByOrganizationId(orgId);
	}

	// ---------------------------------------------------------------------------
	@PostMapping("/add")
	public Address addNewAddress(@RequestBody Address newAddress)
	{
		return addressService.addNewAddress(newAddress);
	}

	// ---------------------------------------------------------------------------
	@GetMapping("/all")
	public List<Address> getAllAddresses()
	{
		return addressService.getAllAddresses();
	}

	// ---------------------------------------------------------------------------
	/**
	 * Updates the address of the organization with the specified org id
	 * @param orgId		id of organization address to update
	 * @param newAddress	new address to be assigned to organization with specified id
	 * @return				true if organization with specified id exists, false otherwise
	 */
	@PutMapping("/update/{orgId}")
	public boolean updateAddressByOrganizationId(@PathVariable("orgId") String orgId, @RequestBody Address newAddress)
	{
		return addressService.updateAddressByOrganizationId(orgId, newAddress);
	}

	// ---------------------------------------------------------------------------
	/**
	 * @return address to be deleted
	 */
	@DeleteMapping("/delete/{addressId}")
	public boolean deleteAddressById(@PathVariable("addressId") String addressId)
	{
		return addressService.deleteAddressById(addressId);
	}

}
