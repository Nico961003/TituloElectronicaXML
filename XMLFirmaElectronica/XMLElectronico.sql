create database tituloProfesional
use tituloProfesional


create table autorizacionRec(
ID_AUTORIZACION_RECONOCIMIENTO	int(11) primary key not null ,
AUTORIZACIÓN_RECONOCIMIENTO	text
)IdCarreraIdCarreraentidadfederativamodalidadtitulacionmodalidadtitulacionIdCarrera
insert into autorizacionRec values('1', 'RVOE FEDERAL');
insert into autorizacionRec values('2', 'RVOE ESTATAL');
insert into autorizacionRec values('3', 'AUTORIZACIÓN FEDERAL');
insert into autorizacionRec values('4', 'AUTORIZACIÓN ESTATAL');
insert into autorizacionRec values('5', 'ACTA DE SESIÓN');
insert into autorizacionRec values('6', 'ACUERDO DE INCORPORACIÓN');
insert into autorizacionRec values('7', 'ACUERDO SECRETARIAL SEP');
insert into autorizacionRec values('8', 'DECRETO DE CREACIÓN');
insert into autorizacionRec values('9', 'OTRO');





create table modalidadTitulacion(
ID_MODALIDAD_TITULACIÓN	int(11) primary key not null,
CLAVE	int(11),
MODALIDAD_TITULACIÓN	text,
TIPO_DE_MODALIDAD	text
)
insert into modalidadTitulacion values('1', '1', 'POR TESIS', 'ACTA DE EXAMEN');
insert into modalidadTitulacion values('2', '2', 'POR PROMEDIO', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('3', '3', 'POR ESTUDIOS DE POSGRADOS', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('4', '4', 'POR EXPERIENCIA LABORAL', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('5', '5', 'POR CENEVAL', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('6', '6', 'OTRO', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('7', '6', 'SEMINARIO DE TITULACIÓN', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('8', '6', 'EXAMEN DE CONOCIMIENTOS GENERALES DE LA LICENCIATURA', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('9', '6', 'REPORTE GLOBAL DE SERVICIO SOCIAL', 'CONSTANCIA DE EXENCIÓN');

select * from Carreras