   create database tituloProfesional;
   use tituloProfesional

   
   create table TituloElectronico(
   version varchar(10), /*dato que parece ser se extrae de la tabla de "autenticacion"*/
   folioControl varchar(100)/*pendiente corroborar tamaño de caracteres*/
   )
   
   create table CargoFirmantesAutorizados(
   id_cargo int primary key not null,
   cargo_firmante varchar(50)
   )
   
   create table FirmaResponsable(
   nombre varchar(50), 
   primerApellido varchar(50), 
   segundoApellido varchar(50), 
   curp varchar(18),
   abrTitulo varchar(50),
   sello varchar(50),/*pendiente corroborar tamaño de caracteres*/
   certificadoResponsable varchar(50),/*pendiente corroborar tamaño de caracter*/
   noCertificadoResponsable varchar(50), /*pendiente corroborar tamaño de caracter*/
   
   /*datos de la tabla externa*/
   id_cargo int,
   cargo_firmante varchar(50),
   /*construimos llave foranea de la tabla que contiene el atributo deseado*/
   constraint fk_cargo 
   foreign key (id_cargo)
   references CargoFirmantesAutorizados (id_cargo)
   on delete cascade
   )
   
   create table Institucion(
   cveInstitucion int primary key not null, 
   nombreInstitucion varchar(50),
   unique (cveInstitucion)
   ) 
   
   create table AutorizacionReconocimiento(
   id_autorizacion_reconocimiento int primary key not null,
   autorizacion_reconocimiento varchar(50),
   unique(id_autorizacion_reconocimiento)
   )
   
   create table Carrera(
   cveCarrera int primary key not null,
   nombreCarrera varchar(50), 
   fechaInicio datetime, 
   fechaTerminacion datetime, 
   numeroRvoe varchar(50), /*verificar el uso que se le da a los RVOES"*/
   unique(cveCarrera),
   
   id_autorizacion_reconocimiento int,
   autorizacionReconocimiento varchar(50),	
   constraint  fk_aut_rec
   foreign key (id_autorizacion_reconocimiento)
   references AutorizacionReconocimiento( id_autorizacion_reconocimiento )
   on delete cascade
   )   

   create table Profesionista(
   id_profesionista int primary key not null auto_increment,
   matricula varchar(15),
   curp varchar(18),
   nombre varchar(50),
   primerApellido varchar(50),
   segundoApellido varchar(50),
   correoElectronico varchar(50)
   )
   select * from Profesionista
   create table ModalidadTitulacion(
   id_modalidad_titulacion int primary key not null,
   modalidad_titulacion varchar(50),
   tipo_de_modalidad varchar(50),
   unique (id_modalidad_titulacion)
   )

   create table FundamentoLegalServicioSocial(
   id_fundamento_legal_servicio_social int primary key not null,
   fundamento_legal_servicio_social varchar(100),
   unique (id_fundamento_legal_servicio_social)
   )
   
   create table EntidadFederativa(
   id_entidad_federativa int primary key not null,
   c_nom_ent varchar(50),
   c_entidad_abr varchar(10),
   unique (id_entidad_federativa)
   )

   create table Expedicion(
   fechaExpedicion datetime,
   fechaExamenProfesional datetime,
   fechaExencionExamenProefsional datetime,
   cumplioServicioSocial varchar(1),
   
   id_modalidad_titulacion int,
   modalidad_titulacion varchar(50),
   constraint fk_mod_titul
   foreign key (id_modalidad_titulacion)
   references ModalidadTitulacion(id_modalidad_titulacion)
   on delete cascade,
   
   id_fundamento_legal_servicio_social int,
   fundamento_legal_servicio_social varchar(50),
   constraint fk_fun_leg_ser_soc
   foreign key (id_fundamento_legal_servicio_social)
   references FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social)
   on delete cascade,

   id_entidad_federativa int,
   entidad_federativa varchar(50),
   constraint  fk_ent_fed 
   foreign key (id_entidad_federativa)
   references EntidadFederativa(id_entidad_federativa)
   on delete cascade
   )
   
   create table EstudioAntecedente(
   id_tipo_antecedente int primary key not null,
   tipo_estudio_antecedente varchar(50),
   tipo_educativo_del_antecedente varchar(50),
   unique (id_tipo_antecedente)
   )
   
   create table Antecedente(
   institucionProcedencia varchar(100),
   fechaInicio datetime,
   fechaTerminacion datetime,
   noCedula varchar(100),
   
   /*ANTES
   id_tipo_estudio_antecedente int,
   tipo_estudio_antecedente varchar(50),
   constraint   fk_tip_est_ant
   foreign key (id_tipo_estudio_antecedente)
   references TipoEstudioAntecedente(id_tipo_estudio_antecedente)
   on delete cascade,
   NO CREASTE NINGUNA TABLA CON NOMBRE TipoEstudioAntecedente
   ***********AHORA***********
   */
   
   id_tipo_antecedente int,
   tipo_estudio_antecedente varchar(50),
   constraint   fk_tip_est_ant
   foreign key (id_tipo_antecedente)
   references EstudioAntecedente(id_tipo_antecedente)
   on delete cascade,
   
   id_entidad_federativa int,
   entidad_federativa varchar(50),
   constraint  fk_enti_feder 
   foreign key (id_entidad_federativa)
   references EntidadFederativa(id_entidad_federativa)
   on delete cascade
   )
   
   create table Autenticacion(  /*_______________________verificar el tamaño de caracteres*/
   version varchar(10),
   folioDigital varchar(100),
   fechaAutenticacion varchar(100),
   selloTitulo varchar(100),
   noCertificadoAutoridad varchar(100),
   selloAutenticacion varchar(100)
   )
   
   create table MotivosCancelacion(
   id_motivo_cancelacion int primary key not null,
   descripcion_cancelacion varchar(50),
   unique (id_motivo_cancelacion)
   )
   
   
   
   -- Posibles errores
-- *Cannot delete or update a parent row: a foreign key constraint fails (1)*
-- (1) desactivar llaves foraneas SET FOREIGN_KEY_CHECKS=0; 
-- (2) activar llaves foraneas SET FOREIGN_KEY_CHECKS=1; 
-- **Access denied for user 'root'@'localhost' (using password: YES)**
-- drop user genaro@localhost;
-- flush privileges;
-- create user genaro@localhost identified by'Pa$$word1'
-- GRANT ALL PRIVILEGES ON tituloProfesional.* TO 'genaro'@'localhost';
   