package com.practical.project1.dao;

import com.practical.project1.models.ProjectInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 古丰杰
 * @date 2020/3/12
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectInformation, Integer> {

  /**
   * find project by project name
   *
   * @param projectName name of the project
   * @return the targeted project searched by project name
   */
  ProjectInformation findByProjectName(String projectName);

  /**
   * delete project by project name
   *
   * @param projectName name of the project
   */
  void deleteByProjectName(String projectName);
}
