package za.co.nico.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.nico.poc.dtos.model.ProjectIssueEntity;

@Repository
public interface ProjectIssueRepository extends JpaRepository<ProjectIssueEntity, Long> {
	ProjectIssueEntity findByKey(String key);

}
