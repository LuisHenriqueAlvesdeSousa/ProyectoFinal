--PAQUETE CREACIÓN XML
CREATE OR REPLACE PACKAGE XML_PKG IS

    PROCEDURE CLASI_GENERAL(PIDTORNEO TORNEOS.IDTORNEO%TYPE);

    PROCEDURE ULTI_JORNADA(PIDTORNEO TORNEOS.IDTORNEO%TYPE);
    
    PROCEDURE TODAS_JORNADA (PIDTORNEO TORNEOS.IDTORNEO%TYPE);
END;
/
CREATE OR REPLACE PACKAGE BODY XML_PKG IS

PROCEDURE CLASI_GENERAL (PIDTORNEO TORNEOS.IDTORNEO%TYPE)
IS
    QRYCTX DBMS_XMLGEN.CTXHANDLE;
    RESULT CLOB;
    V_MENSAJE VARCHAR(250);
BEGIN
    QRYCTX := DBMS_XMLGEN.NEWCONTEXT(
        'SELECT JORNADA_GEN_TIPO(IDJORNADA, FECHA,
                                CAST(MULTISET
                                (SELECT IDEQUIPO,
                                        (SELECT SUM(NVL(PUNTUACION, 0))
                                        FROM PARTIDOS_JUGADOS PJ
                                        WHERE PJ.IDEQUIPO = EQUI.IDEQUIPO
                                        AND IDPARTIDO IN (SELECT IDPARTIDO
                                                        FROM PARTIDOS
                                                        WHERE IDJORNADA IN (SELECT IDJORNADA
                                                                            FROM JORNADAS JOR
                                                                            WHERE JOR.IDTORNEO = J.IDTORNEO)))
                                        AS PUNTUACION,
                                        NOMBRE,
                                        PAIS,
                                        CAST(MULTISET(SELECT IDPERSONA,
                                                            NICKNAME,
                                                            ROL
                                                    FROM JUGADORES JUG
                                                    WHERE JUG.IDEQUIPO = EQUI.IDEQUIPO)
                                                    AS LIST_JUGADOR_TIPO)
                                FROM EQUIPOS EQUI)
                                AS LIST_EQUIPO_GEN_TIPO))
               AS JORNADA
              FROM JORNADAS J
              WHERE IDJORNADA = (SELECT MAX(IDJORNADA)
                                 FROM JORNADAS)
');

    DBMS_XMLGEN.SETROWSETTAG(QRYCTX, 'CLASIFICACION');
    DBMS_XMLGEN.SETROWTAG(QRYCTX, 'INFO');

    RESULT := DBMS_XMLGEN.GETXML(QRYCTX);
    INSERT INTO CLAGENRESULTS (RESULTSET, FECHA) VALUES (RESULT, SYSDATE);

    DBMS_XMLGEN.CLOSECONTEXT(QRYCTX);
EXCEPTION
WHEN OTHERS THEN
V_MENSAJE:= 'SE HA DETECTADO EL ERROR ' || SQLCODE || ': ' ||
            SQLERRM;
            RAISE_APPLICATION_ERROR(-20002, V_MENSAJE);
END CLASI_GENERAL;

PROCEDURE ULTI_JORNADA (PIDTORNEO TORNEOS.IDTORNEO%TYPE)
IS
QRYCTX DBMS_XMLGEN.CTXHANDLE;
    RESULT CLOB;
    V_MENSAJE VARCHAR(250);
BEGIN
    QRYCTX := DBMS_XMLGEN.NEWCONTEXT(
        'SELECT JORNADA_TIPO(IDJORNADA, FECHA,
                        CAST(MULTISET(SELECT IDPARTIDO, TO_CHAR(HORA, CHR(39)||HH24:MI:SS||CHR(39)),
                                            CAST(MULTISET
                                                (SELECT IDEQUIPO,
                                                (SELECT SUM(NVL(PUNTUACION, 0))
                                                    FROM PARTIDOS_JUGADOS PJ
                                                    WHERE PJ.IDEQUIPO = EQUI.IDEQUIPO
                                                    AND IDPARTIDO IN (SELECT IDPARTIDO
                                                                    FROM PARTIDOS
                                                                    WHERE IDJORNADA IN (SELECT IDJORNADA
                                                                                        FROM JORNADAS JOR
                                                                                        WHERE JOR.IDTORNEO = J.IDTORNEO)))
                                                    AS PUNTUACION,
                                                    NOMBRE,
                                                    PAIS
                                                    FROM EQUIPOS EQUI
                                                    WHERE EQUI.IDEQUIPO IN (SELECT PARJ.IDEQUIPO 
                                                                        FROM PARTIDOS_JUGADOS PARJ
                                                                        WHERE PARJ.IDPARTIDO = PAR.IDPARTIDO))
                                                    AS LIST_EQUIPO_TIPO)
                                        FROM PARTIDOS PAR
                                        WHERE J.IDJORNADA=PAR.IDJORNADA)
                                        AS LIST_PARTIDO_TIPO))
                AS LIST_JORNADA_TIPO
                FROM JORNADAS J
                WHERE IDJORNADA = (SELECT MAX(IDJORNADA)
                                    FROM JORNADAS)
                AND IDJORNADA = (SELECT IDJORNADA
                                    FROM PARTIDOS
                                    WHERE IDPARTIDO= (SELECT MAX(IDPARTIDO)
                                                        FROM PARTIDOS_JUGADOS
                                                        WHERE PUNTUACION IS NOT NULL))
');

    DBMS_XMLGEN.SETROWSETTAG(QRYCTX, 'ULTIMAJORNADA');
    DBMS_XMLGEN.SETROWTAG(QRYCTX, 'INFO');

    RESULT := DBMS_XMLGEN.GETXML(QRYCTX);
    INSERT INTO ULTJORRESULTS (RESULTSET, FECHA) VALUES (RESULT, SYSDATE);

    DBMS_XMLGEN.CLOSECONTEXT(QRYCTX);
EXCEPTION
WHEN OTHERS THEN
V_MENSAJE:= 'SE HA DETECTADO EL ERROR ' || SQLCODE || ': ' ||
            SQLERRM;
            RAISE_APPLICATION_ERROR(-20002, V_MENSAJE);
END ULTI_JORNADA;

PROCEDURE TODAS_JORNADA (PIDTORNEO TORNEOS.IDTORNEO%TYPE)
IS
QRYCTX DBMS_XMLGEN.CTXHANDLE;
    RESULT CLOB;
    V_MENSAJE VARCHAR(250);
BEGIN
    QRYCTX := DBMS_XMLGEN.NEWCONTEXT(
        'SELECT JORNADA_TIPO(IDJORNADA, FECHA,
                        CAST(MULTISET(SELECT IDPARTIDO, TO_CHAR(HORA, CHR(39)||HH24:MI:SS||CHR(39)),
                                            CAST(MULTISET
                                                (SELECT IDEQUIPO,
                                                (SELECT SUM(NVL(PUNTUACION, 0))
                                                    FROM PARTIDOS_JUGADOS PJ
                                                    WHERE PJ.IDEQUIPO = EQUI.IDEQUIPO
                                                    AND IDPARTIDO IN (SELECT IDPARTIDO
                                                                    FROM PARTIDOS
                                                                    WHERE IDJORNADA IN (SELECT IDJORNADA
                                                                                        FROM JORNADAS JOR
                                                                                        WHERE JOR.IDTORNEO = J.IDTORNEO)))
                                                    AS PUNTUACION,
                                                    NOMBRE,
                                                    PAIS
                                                    FROM EQUIPOS EQUI
                                                    WHERE EQUI.IDEQUIPO IN (SELECT PARJ.IDEQUIPO 
                                                                        FROM PARTIDOS_JUGADOS PARJ
                                                                        WHERE PARJ.IDPARTIDO = PAR.IDPARTIDO))
                                                    AS LIST_EQUIPO_TIPO)
                                        FROM PARTIDOS PAR
                                        WHERE J.IDJORNADA=PAR.IDJORNADA)
                                        AS LIST_PARTIDO_TIPO))
                AS LIST_JORNADA_TIPO
                FROM JORNADAS J
                WHERE IDJORNADA IN (SELECT IDJORNADA
                                    FROM PARTIDOS
                                    WHERE IDPARTIDO IN (SELECT IDPARTIDO
                                                        FROM PARTIDOS_JUGADOS
                                                        WHERE PUNTUACION IS NOT NULL))
');

    DBMS_XMLGEN.SETROWSETTAG(QRYCTX, 'TORNEO');
    DBMS_XMLGEN.SETROWTAG(QRYCTX, 'INFO');

    RESULT := DBMS_XMLGEN.GETXML(QRYCTX);
    INSERT INTO TODJORRESULTS (RESULTSET, FECHA) VALUES (RESULT, SYSDATE);

    DBMS_XMLGEN.CLOSECONTEXT(QRYCTX);
EXCEPTION
WHEN OTHERS THEN
V_MENSAJE:= 'SE HA DETECTADO EL ERROR ' || SQLCODE || ': ' ||
            SQLERRM;
            RAISE_APPLICATION_ERROR(-20002, V_MENSAJE);
END TODAS_JORNADA;
END;