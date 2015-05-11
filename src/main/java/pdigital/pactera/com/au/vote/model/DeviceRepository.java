package pdigital.pactera.com.au.vote.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The repository for mobile devices
 */

@Repository
@Transactional
public class DeviceRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Device save(Device device) {
		return entityManager.merge(device);
	}

	public Device findDeviceById(String deviceId) {
		return entityManager.find(Device.class, deviceId);
	}
}
