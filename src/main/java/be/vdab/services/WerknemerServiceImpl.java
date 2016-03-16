package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import be.vdab.dao.WerknemerDAO;
import be.vdab.entities.Werknemer;

@ReadOnlyTransactionalService
public class WerknemerServiceImpl implements WerknemerService {

	private final WerknemerDAO werknemerDAO;
	
	@Autowired
	WerknemerServiceImpl(WerknemerDAO werknemerDAO) {
		this.werknemerDAO = werknemerDAO;
	}
	
	@Override
	public List<Werknemer> findAll() {
		return werknemerDAO.findAll(new Sort("familienaam", "voornaam"));
	}

	@Override
	public Page<Werknemer> findAll(Pageable pageable) {
		return werknemerDAO.findAll(pageable);
	}
}
