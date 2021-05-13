CREATE OR REPLACE PACKAGE XML_PKG IS

--Clasificacion General

    create type jugador_tipo as object ("@idpersona" jugadores.idpersona%type,
                                        nickname jugadores.nickname%type,
                                        rol jugadores.rol%type);
    
    create type list_jugador_tipo as table of jugador_tipo;

    create type equipo_gen_tipo as object ("@idequipo" equipos.idequipo%type,
                                        "@puntuacion" partido_jugados.puntuacion%type,
                                        nombre equipos.nombre%type,
                                        pais equipos.pais%type,
                                        juglist list_jugador_tipo);
    
    create type list_equipo_gen_tipo as table of equipo_tipo;

    create type jornada_gen_tipo as object ("@idjornada" jornadas.idjornada%type,
                                            "@fecha" jornadas.fecha%type,
                                            equilist list_equipo_gen_tipo);

    --create type list_jornada_gen_tipo as table of jornada_gen_tipo;

    --create type clasificacion_tipo as object (jorlist list_jornada_gen_tipo);

--Todas Jornadas y ultima jornada

    create type equipo_tipo as object ("@idequipo" equipos.idequipo%type,
                                    "@puntuacion" partido_jugados.puntuacion%type,
                                    nombre equipos.nombre%type,
                                    pais equipos.pais%type);

    create type list_equipo_tipo as table of equipo_tipo;

    create type partido_tipo as object("@idpartido" partido.idpartido%type,
                                        "@hora" partido.hora%type,
                                        equilist list_equipo_tipo);

    create type list_partido_tipo as table of partido_tipo;
    
    create type jornada_tipo as object ("@idjornada" jornadas.idjornadas%type,
                                        "@fecha" jornada.fecha%type,
                                        partlist list_partido_tipo);

    create type list_jornada_tipo as table of jornada_tipo;

    create type torneo as object("@estado" torneo.estado%type,
                                jorlist list_jornada_tipo);


END;

CERATE OR REPLACE PACKAGE BODY XML_PKG IS

END;