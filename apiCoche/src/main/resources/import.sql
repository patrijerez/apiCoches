INSERT INTO marcas(nombre) VALUES ('Renault');
INSERT INTO marcas(nombre) VALUES ('Honda');
INSERT INTO marcas(nombre) VALUES ('Ford');
INSERT INTO marcas(nombre) VALUES ('Fiat');

INSERT INTO modelos(nombre) VALUES ('Sedán');
INSERT INTO modelos(nombre) VALUES ('Cupé');
INSERT INTO modelos(nombre) VALUES ('Monovolumen');
INSERT INTO modelos(nombre) VALUES ('Modus');
INSERT INTO modelos(nombre) VALUES ('Fiesta');

INSERT INTO coches (idmarca,idmodelo,color,matricula,cilindrada,velocidad) VALUES (1,4,'Azul marino','1234GHJ',4,163);
INSERT INTO coches (idmarca,idmodelo,color,matricula,cilindrada,velocidad) VALUES (2,1,'Blanco','1234MNÑ',6 ,210);
INSERT INTO coches (idmarca,idmodelo,color,matricula,cilindrada,velocidad) VALUES (3,5,'Verde pistacho','1234ABC',8,180);


INSERT INTO usuarios (username,password,enabled) VALUES ('patri','$2a$10$6/0MPQM9MicQqpK9Zzzt0uYUBdp.nHL.JopdXdjfOl6yiCLXNgTmu',1);
INSERT INTO usuarios (username,password,enabled) VALUES ('rolando','$2a$10$6/0MPQM9MicQqpK9Zzzt0uYUBdp.nHL.JopdXdjfOl6yiCLXNgTmu',1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (2,1);