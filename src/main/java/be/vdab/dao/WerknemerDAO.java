package be.vdab.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Werknemer;

public interface WerknemerDAO extends JpaRepository<Werknemer, Long> {
	@Override
	@EntityGraph("Werknemer.metFiliaal")
	List<Werknemer> findAll(Sort sort);
	
	@Override
	@EntityGraph("Werknemer.metFiliaal")
	Page<Werknemer> findAll(Pageable pageable);
}
