CREATE DATABASE worddb;

USE worddb;

DROP TABLE IF EXISTS `words`;
CREATE TABLE `words`  (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `word` VARCHAR(45) DEFAULT NULL,
  `mark` VARCHAR(45) DEFAULT NULL,
  `intro` VARCHAR(300) DEFAULT NULL,
  `derivative` VARCHAR(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;

INSERT INTO `words` VALUES (1, 'vocabulary', '/ vəˈkæbjələri /', 'n.（某人掌握或使用的）全部词汇；（某一语言的）词汇；（某个学科的）专业词汇，术语；（尤指外语教科书中的）词汇表；（美术、音乐等领域的）表现形式，表达手段', '复数 vocabularies');