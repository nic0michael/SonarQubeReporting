package za.co.nico.poc.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import za.co.nico.poc.dtos.model.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
	ProjectEntity findById(String dtoId);

}
