package com.practical.project1.api;

import com.practical.project1.dao.ProjectRepository;
import com.practical.project1.models.ProjectInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 古丰杰
 * @date 2020/3/12
 */
@RestController
@RequestMapping("/")
@Transactional
public class RestFulController {

  /** project repository */
  @Autowired private ProjectRepository projectRepository;

  /**
   * get all projects data
   *
   * @return a list of data contains all project information
   */
  @GetMapping(path = "/projects")
  public List<ProjectInformation> findAllProjects() {
    return projectRepository.findAll();
  }

  /**
   * post and create new project
   *
   * @param postedProject posted project
   * @return created project information
   */
  @PostMapping(path = "/projects")
  public ProjectInformation createNewProject(@RequestBody ProjectInformation postedProject) {
    projectRepository.save(postedProject);
    return postedProject;
  }

  /**
   * update project information
   *
   * @param targetedProject name of the project meant to be updated
   * @return updated project information
   */
  @PutMapping(path = "/projects/{projectName}")
  public String updateProjectInformation(
      @RequestBody ProjectInformation targetedProject, @PathVariable String projectName) {
    ProjectInformation existedProject = projectRepository.findByProjectName(projectName);
    if (null != existedProject) {
      existedProject.setManager(targetedProject.getManager());
      existedProject.setProjectName(targetedProject.getProjectName());
      existedProject.setProjectDescription(targetedProject.getProjectDescription());
      projectRepository.save(existedProject);

      return targetedProject.getProjectName() + " added";
    }

    return "no such project";
  }

  /**
   * delete project by project name
   *
   * @param projectName name of project meant to be deleted
   * @return deleted project
   */
  @DeleteMapping(path = "projects/{project_name}")
  public String deleteProjectByProjectName(@PathVariable("project_name") String projectName) {
    projectRepository.deleteByProjectName(projectName);
    return "deleted";
  }

  /**
   * get project by project name
   *
   * @param projectName name of the project
   * @return target project information
   */
  @GetMapping(path = "/projects/{project_name}")
  public ProjectInformation getProjectByName(@PathVariable("project_name") String projectName) {

    return projectRepository.findByProjectName(projectName);
  }

  /** delete all data from database (only for testing) */
  @PostMapping(path = "/projects/delete_all")
  public void deleteAll() {
    projectRepository.deleteAll();
  }
}
