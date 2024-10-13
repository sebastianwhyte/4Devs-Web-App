/*** Class that implements crud operations for shelters
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Oct 12 2024
 */

package dev.sebastian.housinginsecurityapp.dao;

import dev.sebastian.housinginsecurityapp.model.Shelter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends CrudRepository<Shelter, Integer>
{
}
