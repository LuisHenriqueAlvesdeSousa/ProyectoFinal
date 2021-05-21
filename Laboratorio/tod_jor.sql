select jornada_tipo(idjornada, fecha,
                        cast(multiset(select idpartido, to_char(hora, 'hh24:mi:ss'),
                                            cast(multiset
                                                (select idequipo,
                                                (select sum(nvl(puntuacion, 0))
                                                    from partidos_jugados pj
                                                    where pj.idequipo = equi.idequipo
                                                    and idpartido IN (select idpartido
                                                                    from partidos
                                                                    where idjornada IN (select idjornada
                                                                                        from jornadas jor
                                                                                        where jor.idtorneo = j.idtorneo)))
                                                    as puntuacion,
                                                    nombre,
                                                    pais
                                                    from equipos equi
                                                    where equi.idequipo in (select parj.idequipo 
                                                                        from partidos_jugados parj
                                                                        where parj.idpartido = par.idpartido))
                                                    as list_equipo_tipo)
                                        from partidos par
                                        where j.idjornada=par.idjornada)
                                        as list_partido_tipo))
                as list_jornada_tipo
                from jornadas j
                where idjornada in (select idjornada
                                    from partidos
                                    where idpartido in (select idpartido
                                                        from partidos_jugados
                                                        where puntuacion is not null))
                and idtorneo = 2;