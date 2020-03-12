package com.practical.project1.api;

import com.practical.project1.dao.ProjectRepository;
import com.practical.project1.models.ProjectInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 古丰杰
 * @date 2020/3/12
 *
 */

@RestController
@RequestMapping("/")
public class RestFulController {

	/**
	 * project repository
	 */
	private ProjectRepository projectRepository;

	/**
	 * constructor for rest controller
	 * @param projectRepository repository for project
	 */
	@Autowired
	public RestFulController(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	/**
	 * get all projects data
	 * @return a list of data contains all project information
	 */
	@GetMapping(path = "/projects")
	public List<ProjectInformation> findAllProjects() {
		return projectRepository.findAllProjects();
	}

	/**
	 * post and create new project
	 * @param postedProject posted project
	 * @return created project information
	 */
	@PostMapping(path = "/projects", consumes = "application/json")
	public ProjectInformation createNewProject(@RequestBody ProjectInformation postedProject) {
		projectRepository.save(postedProject);
		return postedProject;
	}

	/**
	 * update project information
	 * @param projectName name of the project meant to be updated
	 * @return updated project information
	 */
	@PutMapping(path = "/projects/{projectName}", consumes = "application/json")
	public ProjectInformation updateProjectInformation(@PathVariable ProjectInformation projectName) {
		projectRepository.save(projectName);
		return projectName;
	}

	/**
	 * delete project by project name
	 * @param projectName name of project meant to be deleted
	 * @return deleted project
	 */
	@DeleteMapping(path = "projects/{projectName}")
	public ProjectInformation deleteProjectByProjectName(@PathVariable String projectName) {

		return projectRepository.deleteByProjectName(projectName);
	}

	/**
	 * get project by project name
	 * @param projectName name of the project
	 * @return target project information
	 */
	@GetMapping(path = "/projects/{projectName}")
	public ProjectInformation getProjectByName(@PathVariable String projectName) {

		return projectRepository.findByProjectName(projectName);
	}
}
