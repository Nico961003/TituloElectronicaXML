   create database tituloProfesional;
   use tituloProfesional
   
   create table AutorizacionReconocimiento(
   id_autorizacion 						int primary key not null auto_increment,
   clave_autorizacion				 	int,
   autorizacion_reconocimiento 		 	varchar(50),
   unique								(id_autorizacion)
   )
   
    /*ConsultasAUTORIZACION RECONOCIMIENTO*/
	insert into AutorizacionReconocimiento values(id_autorizacion,1,'Federal');
	insert into AutorizacionReconocimiento values(id_autorizacion,2,'Estatal');
	insert into AutorizacionReconocimiento values(id_autorizacion,3,'SEP');
    
    select *from AutorizacionReconocimiento;
    drop table AutorizacionReconocimiento;
   

   
   create table Carrera(
   idCarrera 						int primary key not null auto_increment,
   cveCarrera 						int not null,
   nombreCarrera 					varchar(50), 
   numeroRvoe 						varchar(50), /*verificar el uso que se le da a los RVOES"*/
   unique(cveCarrera),

   clave_autorizacion int,
   autorizacion_reconocimiento 		varchar(50)
   )  
   
   
   CREATE TABLE antecedentesEstudiante(
   id_antecedenteE     int primary key not null auto_increment,
   instProcedencia     varchar(50),
   tipoEstAntecedente  varchar(50),
   entidadFederativa   varchar(100),
   fechaInicio         date,
   fechaTermino        date
   )
   
   create table Profesionista(
   idProfesionista 				int primary key not null auto_increment, 
   Matricula 					varchar(15),
   curp 						varchar(18),
   nombre 						varchar(50),
   primerApellido 				varchar(50),
   segundoApellido 				varchar(50),
   correoElectronico 			varchar(50)
   )

select * from antecedentesEstudiante
select * from Profesionista
select * from entidadFederativa   
select * from estudioAntecedente

   