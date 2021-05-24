create or replace procedure clasi_general (pIdTorneo torneos.idtorneo%type)
IS
    qryctx dbms_xmlgen.cxHandle;
    result clob;
begin
    qryctx := dbms_xmlgen.newContext(
        select jornada_gen_tipo(idjornada,
                                fecha,
                                cast(multiset
                                (select idequipo,
                                        (select sum(nvl(puntuacion, 0))
                                        from partidos_jugados pj
                                        where pj.idequipo = equi.idequipo
                                        and idpartido = (select idpartido
                                                        from partidos
                                                        where idjornada = (select idjornada
                                                                            from jornadas jor
                                                                            where jor.idtorneo = j.idtorneo)))
                                        as puntuacion,
                                        nombre,
                                        pais,
                                        cast(multiset(select idpersona,
                                                            nickname,
                                                            rol
                                                    from jugadores jug
                                                    where jug.idequipo = equi.idequipo)
                                                    as jugador)
                                from equipos equi)
                                as equipo))
        as jornada
        from jornadas j
        where idjornada = (select max(idjornada)
                            from jornadas)
    );

    DBMS_XMLGEN.setRowSetTag(qryCtx, 'clasificacion');
    DBMS_XMLGEN.setRowTag(qryCtx, 'info');

    result := dbms_xmlgen.getxml(qryctx);
    insert into clagenresult (resultset) values (result, sysdate);

    dbms_xmlgen.closecontext(qryctx);
exception

end;