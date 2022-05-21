CREATE TABLE `tb_pessoas` (
  `id_pessoa` bigint NOT NULL AUTO_INCREMENT,
  `email_pessoa` varchar(255) COLLATE utf8_swedish_ci DEFAULT NULL,
  `nome_pessoa` varchar(255) COLLATE utf8_swedish_ci DEFAULT NULL,
  `nomesocial_pessoa` varchar(255) COLLATE utf8_swedish_ci DEFAULT NULL,
  `sobrenome_pessoa` varchar(255) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`)
)