
USE sonarqube_report;

-- show create table projects;

CREATE TABLE `projects` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `dto_id` varchar(255) DEFAULT NULL,
  `is_favorite` bit(1) DEFAULT NULL,
  `project_key` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `visibility` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8mb4;

-- show create table project_issue;

CREATE TABLE `project_issue` (
  `project_issue_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `debt` varchar(255) DEFAULT NULL,
  `effort` varchar(255) DEFAULT NULL,
  `end_line` int(11) DEFAULT NULL,
  `end_offset` int(11) DEFAULT NULL,
  `hash` varchar(255) DEFAULT NULL,
  `issue_key` varchar(255) DEFAULT NULL,
  `line_nr` int(11) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `rule` varchar(255) DEFAULT NULL,
  `severity` varchar(255) DEFAULT NULL,
  `start_line` int(11) DEFAULT NULL,
  `start_offset` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`project_issue_id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8mb4;
