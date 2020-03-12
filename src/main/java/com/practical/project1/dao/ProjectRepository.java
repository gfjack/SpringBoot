package com.practical.project1.dao;

import com.practical.project1.models.ProjectInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 古丰杰
 * @date 2020/3/12
 */

@Repository
public interface ProjectRepository extends JpaRepository<ProjectInformation, Integer> {
	/**
	 * get all projects data from database
	 * @return list of projects information
	 */
	List<ProjectInformation> findAllProjects();

	/**
	 * find project by project name
	 * @param projectName name of the project
	 * @return the targeted project searched by project name
	 */
	ProjectInformation findByProjectName(String projectName);

	/**
	 * update existed project information
	 * @param projectName name of the project
	 * @return the lasted information of the targeted project
	 */
	ProjectInformation updateProjectInformation(ProjectInformation projectName);

	/**
	 * delete project by project name
	 * @param projectName name of the project
	 * @return deleted project information
	 */
	ProjectInformation deleteByProjectName(String projectName);

}
