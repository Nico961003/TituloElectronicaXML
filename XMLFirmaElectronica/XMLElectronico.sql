   create database tituloProfesional;
   use tituloProfesional
   
   
create table FirmaResponsable(
idFirma                    int primary key not null auto_increment,
nombre                     varchar(50),
primerApellido             varchar(50),
segundoApellido            varchar(50),
curp                       varchar(50),  
idCargo                    int,
cargo                      varchar(50),
abrTitulo                  varchar(50),
sello                      varchar(200),
certificadoResponsable     varchar(300),
noCertificadoResponsable   varchar(50)
)
 
 
 create table Institucion(
 cveInstitucion        varchar(50), 
 nombreInstitucion     varchar(50)
 )
 
 
   
   create table Carrera(
   cveCarrera 						int not null,
   nombreCarrera 					varchar(50), 
   fechaInicio                      date,
   fechaTerminacion     			date,
   idAutorizacionReconocimiento     int,
   autorizacion_reconocimiento 		varchar(50)
   )  
   
   
   create table Profesionista(
   curp					varchar(50),
   nombre				varchar(50),
   primerApellido 		varchar(50),
   segundoApellido		varchar(50),
   correoElectronico    varchar(50)
   )

   create table Expedicion(
   fechaExpedicion						date,
   idModalidadTitulacion				int, 
   modalidadTitulacion					varchar(50),
   fechaExamenProfesional 				varchar(50),
   cumplioServicioSocial				varchar(50),
   idFundamentoLegalServicioSocial		int,
   fundamentoLegalServicioSocial		varchar(50),
   idEntidadFederativa					int,
   entidadFederativa					varchar(50)
   )

   
   CREATE TABLE antecedentesEstudiante(
   id_antecedenteE     int primary key not null auto_increment,
   instProcedencia     varchar(50),
   tipoEstAntecedente  varchar(50),
   entidadFederativa   varchar(100),
   fechaInicio         date,
   fechaTermino        date
   )
   
 















   