package com.practical.project1.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 古丰杰
 * @data 2020/3/12
 */
@Data
@Component
@Entity
public class ProjectInformation {

  @Id @GeneratedValue private int id;
  private String projectName;
  private String projectDescription;
  private String manager;
}
