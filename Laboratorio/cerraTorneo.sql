create or replace procedure cerrar_torneo (v_idTorneo torneos.idtorneo%type)
as
    cursor equipos is select idequipo
                        from equipos
                        where idequipos in (select idequipos
                                            from partidos_jugados
                                            where puntacion is not null);
                                            
    numEquipos number;
    numJornadas number := numEquipos - 1;
    numPartidos number := (numEquipos - 1) * (numEquipos / 2);
    numPartidosJornada number := numEquipos / 2;
    
    type a_jornadas is varray(numJornadas) of jornadas.idjornada%type;
    type a_partidos is varray(numPartidos) of partidos.idpartido%type;
    type a_equipos is varray(numEquipos - 1) of equipos.idequipo%type;
    
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
    
    begin
        select count(idEquipos) into numEquipos
        from equipos
        where idequipos in (select idequipos
                                            from partidos_jugados
                                            where puntacion is not null);
        if numEquipos is null then
            raise error_equipos;
        else
            numJornadas := numEquipos - 1;
            numPartidos := (numEquipos - 1) * (numEquipos / 2);
            a_equipos := a_equipos();
        end if;
    exception
        when error_equipos then
            raise equipos_vacio;
    end;

    /*Obtenemos los equipos y separamos un equipo sobre el que rotará
    todos los demás equipos.*/
    begin
       open equipos;
       fetch equipos into idequipo_fijo;
       
        for i in 1..a_equipo.count loop
            fetch equipos into a_equipo(i);
        end loop;
    end;
    
        for jornada in 1..a_jornadas.count loop
            insert into jornadas (fecha, idtorneo) values (sysdate + contador_dias);
            
            contador_dias := contador_dias + 7;
            
            select max(idjornada) into v_idjornada
            from jornadas;

            for partido in 1..numPartidosJornada loop
                insert into partidos (hora, idjornada) values (hora_inicial + horaPlus, v_idjornada);
                
                horaPlus := horaPlus + 1/24;
                
                select max(idpartido) into v_idpartido
                from partidos;
                
                if partido = numpartidosjornada * jornada + 1 or partido = 1 then
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
    when equipos_vacio then
        v_error := 'Tabla equipos vacia.';
        raise_application_error(-20009, v_error);
end;