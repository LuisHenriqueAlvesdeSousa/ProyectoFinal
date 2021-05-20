create or replace procedure cerrar_torneo (v_idTorneo torneos.idtorneo%type)
as
    cursor equipos is select *
                        from (select idequipo
                                from equipos
                                where idequipos in (select idequipos
                                                    from partidos_jugados
                                                    where puntacion is not null)
                        where rownum <= 8;
                                            
    type a_equipos is varray(7) of equipos.idequipo%type;
    
    numEquipos number;
    x number := 1;
    y number := numEquipos -1;
    contador_dias number := 7;
    hora_inicial time := to_date('12:00:00', 'mi:ss:mm');
    horaPlus number := 0;
    
    idequipo_fijo equipo.idequipo%type;
    v_idjornada jornadas.idjornada%type;
    v_idpartido partidos.idpartido%type;
    
    error_equipos exception;
    equipos_vacio exception;
    v_error varchar2(500);
    
begin
    /*Obtenemos los equipos y separamos un equipo sobre el que rotar�
    todos los dem�s equipos.*/
    begin
        select count(*) into numEquipos
        from (select idequipo
                from equipos
                where idequipos in (select idequipos
                                    from partidos_jugados
                                    where puntacion is not null)
        where rownum <= 8;

        if numEquipos = 8 then
            a_equipos := a_equipos();
            open equipos;
            fetch equipos into idequipo_fijo;
            
                for i in 1..a_equipo.count loop
                    fetch equipos into a_equipo(i);
                end loop;
        else
            raise error_equipos;
        end if;

    exception
        when error_equipos then
            raise equipos_insuficientes;
    end;
    
        for jornada in 1..7 loop
            insert into jornadas (fecha, idtorneo) values (sysdate + contador_dias);
            
            contador_dias := contador_dias + 7;
            
            select max(idjornada) into v_idjornada
            from jornadas;

            for partido in 1..4 loop
                insert into partidos (hora, idjornada) values (hora_inicial + horaPlus, v_idjornada);
                
                horaPlus := horaPlus + 1/24;
                
                select max(idpartido) into v_idpartido
                from partidos;
                
                if partido = 4 * jornada + 1 or partido = 1 then
                    insert into partidos_jugados(idequipo, idpartido) values (a_equipo(x), v_idpartido);
                    insert into partidos_jugados(idequipo, idpartido) values (idequipo_fijo, v_idpartido);
                else
                    insert into partidos_jugados(idequipo, idpartido) values (a_equipo(x), v_idpartido);
                    insert into partidos_jugados(idequipo, idpartido) values (a_equipo(y), v_idpartido);
                end if;
                    
                x := x + 1;
                if x > 7 then
                    x := 1;
                end if;
                    
                y := y - 1;
                if y < 1 then
                    y := numEquipos - 1;
                end if;
                
            end loop;
            
        end loop;
        
        update torneos set estado = 'CERRADO' where idtorneo = v_idtorneo;
        
exception
    when equipos_insuficientes then
        v_error := 'Equipos insuficientes para cerrar el torneo, se necesita 8 equipos sin partidos por jugar.';
        raise_application_error(-20009, v_error);
end;