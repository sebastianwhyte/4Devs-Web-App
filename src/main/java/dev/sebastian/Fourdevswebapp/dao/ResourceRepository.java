/*** Class that implements crud operations for resources
 *
 * @author Sebastian Whyte
 * @version 1.0
 * @date Nov 07 2024
 */


package dev.sebastian.Fourdevswebapp.dao;

import dev.sebastian.Fourdevswebapp.model.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Integer>
{
}
