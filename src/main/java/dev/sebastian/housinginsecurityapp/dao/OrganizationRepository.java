/*** Class that implements crud operations for organizations
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Oct 02 2024
 */

package dev.sebastian.housinginsecurityapp.dao;

import dev.sebastian.housinginsecurityapp.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer>
{

}
