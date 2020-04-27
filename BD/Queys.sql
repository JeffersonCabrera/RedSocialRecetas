
CREATE DATABASE CASERITAPERU;
DROP TABLE TM_USUARIOSSC;
DROP TABLE TU_USER_ROLE;
SELECT * FROM TM_USUARIOSSC TU;
SELECT * FROM TU_USER_ROLE AS UR;

DESCRIBE TM_USUARIOSSC;

DESCRIBE TU_USER_ROLE;




  -- CONTRASEÑA 1234
SET NAMES 'utf8';
INSERT INTO caseritaperu.tm_usuariossc(nid, scontrasena, semail, nestado, dfecharegistro, nerror, susuario, susuariofull) VALUES
(1, '$2a$10$qqSgL.tHqMj5u8gTIMej/OfoZH0Hhc1hGLK657A.M.g4WZ1UVT5GO', 'root@gmail.com', True, '2020-04-27 02:35:20', NULL, 'root', 'root');

SET NAMES 'utf8';
INSERT INTO caseritaperu.tu_user_role(nusrolid, srol, nid) VALUES
(1, 'ROLE_USER', 1);
