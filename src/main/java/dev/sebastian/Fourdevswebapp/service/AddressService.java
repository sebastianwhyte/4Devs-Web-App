package dev.sebastian.Fourdevswebapp.service;

import dev.sebastian.Fourdevswebapp.dao.AddressRepository;
import dev.sebastian.Fourdevswebapp.model.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddressService
{
	@Autowired
	private AddressRepository addressRepository;
	private final JdbcTemplate jdbcTemplate;

	private static final Logger logger = LogManager.getLogger();

	// ---------------------------------------------------------------------------
	public AddressService(AddressRepository addressRepository, JdbcTemplate jdbcTemplate)
	{
		this.addressRepository = addressRepository;
		this.jdbcTemplate = jdbcTemplate;
	}

	// ---------------------------------------------------------------------------
	/** Retrieves the address belonging to the organization with the specified org id
	 *
	 * @param orgId		id of organization whose address we want to find
	 * @return			address of organization with specified org id
	 */

	public Address getAddressByOrganizationId(String orgId)
	{
		Optional<Address> addressToFind = addressRepository.findById(Integer.parseInt(orgId));

		// If address exists, retrieve it
		try
		{
			if (addressToFind.isPresent())
			{
				logger.info("Address with ID: " + addressToFind.get() + " successfully retrieved.");
				return addressToFind.get();
			}
			else
			{
				logger.warn("Chosen Address with ID: " + orgId + " is empty");
			}
		}
		catch (NoSuchElementException exception)
		{
			logger.fatal(" " + exception.getClass() + ": Address does not exist in database... " + exception.getMessage());
		}

		// No address found
		return null;
	}

	// ---------------------------------------------------------------------------
	public Address addNewAddress(Address newAddress)
	{
		return addressRepository.save(newAddress);
	}

	// ---------------------------------------------------------------------------
	/**
	 * Updates the address of the organization with the specified org id
	 * @param orgId		id of organization address to update
	 * @param newAddress	new address to be assigned to organization with specified id
	 * @return				true if organization with specified id exists, false otherwise
	 */
	public boolean updateAddressByOrganizationId(String orgId, Address newAddress)
	{
		// Update address in database by finding org id assigned to it (from organizationaddress junction table)
		final String SQL_UPDATE_ADDRESS_BY_ORG_ID = """
				UPDATE address AS T1
				SET street = ?, borough = ?, state = ?, zip_code = ?
				FROM address AS T2
				INNER JOIN organizationaddress AS T3
				ON T2.address_id = T3.address_id
				WHERE T1.address_id = T2.address_id
				AND T3.org_id = ?""";

		// If any rows are updated then we have successfully updated an address
		return jdbcTemplate.update(SQL_UPDATE_ADDRESS_BY_ORG_ID,
				newAddress.getStreet(),
				newAddress.getBorough(),
				newAddress.getState(),
				newAddress.getZipCode(),
				Integer.parseInt(orgId)) > 0;
	
}

	// ---------------------------------------------------------------------------
	public List<Address> getAllAddresses()
	{

		List<Address> addresses = new ArrayList<>();

		addressRepository.findAll().forEach(address -> addresses.add(address));

		return addresses;
	}

	// ---------------------------------------------------------------------------
	/**
	 * @return address to be deleted
	 */
	public boolean deleteAddressById(String addressId)
	{
		Optional<Address> addressToBeDeleted = addressRepository.findById(Integer.parseInt(addressId));

		if (addressToBeDeleted.isEmpty())
		{
			logger.warn("Address with ID: " + addressId + " does not exist in database.");

			// TODO - display message informing user that address doesnt exist? - SW 12/10/2024
			return false;
		}

		// Delete address if found
		addressRepository.delete(addressToBeDeleted.get());

		return true;
	}
}
