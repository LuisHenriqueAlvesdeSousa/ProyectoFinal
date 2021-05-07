DROP TABLE PARTIDOS_JUGADOS;
DROP TABLE JEFES;
DROP TABLE ENTRENADORES;
DROP TABLE PREPARADORES;
DROP TABLE TORNEOS;
DROP TABLE PARTIDOS;
DROP TABLE JUGADORES;
DROP TABLE TRABAJADORES;
DROP TABLE PERSONAS;
DROP TABLE EQUIPOS;
DROP TABLE JORNADAS;
DROP TABLE TODJORRESULTS;
DROP TABLE ULTJORRESULTS;
DROP TABLE CLAGENRESULTS;


Create Table Torneos (
Idtorneo Number(4) Generated  Always As Identity(Start With 1 Increment By 1 Maxvalue 9999	),
Estado Varchar2(15),
Constraint Tor_Estado_Ck Check (Estado In ('ABIERTO', 'CERRADO')),
Constraint Tor_Idtorneo_Pk Primary Key(Idtorneo)
);

Create Table Jornadas(
Idjornada Number(4) Generated  Always As Identity(Start With 1 Increment By 1 Maxvalue 9999),
Fecha Date,
Idtorneo Number(4),
Constraint Jor_Idjornada_Pk Primary Key(Idjornada),
Constraint Jor_Idtorneo_Fk Foreign Key(Idtorneo) References Torneos
);

Create Table Partidos(
Idpartido Number(4) Generated  Always As Identity(Start With 1 Increment By 1 Maxvalue 9999),
Hora Date,
Idjornada Number(4),
Constraint Par_Idpartido_Pk Primary Key(Idpartido),
Constraint Par_Idjornada_Fk Foreign Key(Idjornada) References Jornadas
);

Create Table Personas(
Idpersona Number(4) Generated  Always As Identity(Start With 1 Increment By 1 Maxvalue 9999),
Dni Varchar2(9) Unique Not Null,
Nombre Varchar2(20),
Apellido Varchar2(20),
Fecha_Nacimiento Date,
Sueldo Number,
Telefono Varchar2(9),
Fecha_Contrato Date,
Fecha_Fin_Contrato Date,
Nacionalidad Varchar2(30),
Constraint Per_Idpersona_Pk Primary Key(Idpersona)
);


Create Table Jefes (
Idpersona Number(4),
Constraint Jef_Idpersona_Pk Primary Key(Idpersona),
Constraint Jef_Idpersona_Fk Foreign Key (Idpersona) References Personas
);

Create Table Entrenadores (
Idpersona Number(4),
Constraint Ent_Idpersona_Pk Primary Key(Idpersona),
Constraint Ent_Idpersona_Fk Foreign Key (Idpersona) References Personas
);

Create Table Preparadores (
Idpersona Number(4),
Constraint Prep_Idpersona_Pk Primary Key(Idpersona),
Constraint Prep_Idpersona_Fk Foreign Key (Idpersona) References Personas
);

Create Table Equipos(
Idequipo Number(4) Generated  Always As Identity(Start With 1 Increment By 1 Maxvalue 9999),
Nombre Varchar2(20),
Pais Varchar2(20),
Idjefe Number(4),
Idpreparador Number(4),
Identrenador Number(4),
Constraint Equi_Idequipo_Pk Primary Key (Idequipo),
Constraint Equi_Idjefe_Fk Foreign Key (Idjefe) References Jefes,
Constraint Equi_Idpreparador_Fk Foreign Key (Idpreparador) References Preparadores,
Constraint Equi_Identrenador_Fk Foreign Key (Identrenador) References Entrenadores
);

Create Table Partidos_Jugados(
Idequipo Number(4),
Idpartido Number(4),
Puntuacion Number(6),
Constraint Parjug_Idequipo_Idpartido_Pk Primary Key(Idpartido, Idequipo),
Constraint Parjug_Idequipo_Fk Foreign Key (Idequipo) References Equipos,
Constraint Parjug_Idpartido_Fk Foreign Key (Idpartido) References Partidos
);


Create Table Jugadores (
Idpersona Number(4),
Nickname Varchar2(20),
Rol Varchar2(30),
Idequipo Number(4),
Constraint Jug_Idpersona_Pk Primary Key(Idpersona),
Constraint Jug_Idpersona_Fk Foreign Key (Idpersona) References Personas,
Constraint Jug_Idequipo_Fk Foreign Key (Idequipo) References Equipos
);


Create Table Trabajadores (
Idpersona Number(4),
Oficio Varchar2(20),
Idequipo Number(4),
Constraint Trab_Idpersona_Pk Primary Key(Idpersona),
Constraint Trab_Idpersona_Fk Foreign Key (Idpersona) References Personas,
Constraint Trab_Idequipo_Fk Foreign Key (Idequipo) References Equipos
);


Create Table Todjorresults (
Idresult Number(4) Generated  Always As Identity(Start With 1 Increment By 1 Maxvalue 9999),
Resultset Blob,
Constraint Tod_Idresult_Pk Primary Key (Idresult)
);



Create Table Ultjorresults (
Idresult Number(4) Generated  Always As Identity(Start With 1 Increment By 1 Maxvalue 9999),
Resultset Blob,
Constraint Ult_Idresult_Pk Primary Key (Idresult)
);

Create Table Clagenresults (
Idresult Number(4) Generated  Always As Identity(Start With 1 Increment By 1 Maxvalue 9999),
Resultset Blob,
Constraint Cla_Idresult_Pk Primary Key (Idresult)
);




