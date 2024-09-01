CREATE TABLE `espaco_agenda` (
  `id_agenda` bigint DEFAULT NULL,
  `id_projeto` bigint NOT NULL,
  PRIMARY KEY (`id_projeto`),
  KEY `FKoh3ob5c0heg092or8dwq1xwq9` (`id_agenda`),
  CONSTRAINT `FKoh3ob5c0heg092or8dwq1xwq9` FOREIGN KEY (`id_agenda`) REFERENCES `projeto` (`id`)
);
