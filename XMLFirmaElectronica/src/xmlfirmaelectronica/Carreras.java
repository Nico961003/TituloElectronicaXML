package xmlfirmaelectronica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import CodeHelpers.ConexionesDB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

/*import java.sql.Date;*/
public class Carreras extends javax.swing.JFrame {

    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;
    DefaultTableModel modeloTabla;

    String curpResponsable = "";
    int idCargo = 0;
    String cargo = "";
    String abrTitulo = "";

    int clave = 0;
    String nombreCarrera = "";
    String numeroRvoe = "";
    int clave_autorizacion = 0;
    String autorizacion_reconocimiento = "";

    /**
     * *****************************************
     */
    String nombre = "", aPaterno = "", aMaterno = "";
    String matricula = "", correo = "", CURP = "";

    String fechaComoCadena = "", institucionProcedencia = "";
    String fechaComoCadena2 = "", tipodeEstudio = "", eFederativa = "";
    int idModalidadTitulacion = 0, idFundamentoLegalServicioSocial = 0;
    int idEntidadFederativa1 = 0, idEntidadFederativa2 = 0;

    /**
     * *****************************************
     */
    String fechaExpedicion = "", modalidadTitulacion = "", fundamentoSS = "";
    String fechaExamen = "", eFederativa2 = "", folioControl = "";
    int sSocial = 0;

    int idTipoEstudioAntecedente = 0;
    String fechaTerminoAntecedente = "", fechaInicioAntecedente = "";

    public Carreras() {
        initComponents();
        this.setLocationRelativeTo(null);

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM AutorizacionReconocimiento");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboReconocimiento.addItem(resultadoConsulta.getString("autorizacion_reconocimiento"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM entidadFederativa");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboEFederativa.addItem(resultadoConsulta.getString("nombreEntidad"));
                ComboEFederativa2.addItem(resultadoConsulta.getString("nombreEntidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM estudioAntecedente");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboTipoEstudio.addItem(resultadoConsulta.getString("tipoEstudioAntecedente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM modalidadTitulacion");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboModalidadT.addItem(resultadoConsulta.getString("MODALIDAD_TITULACIÓN"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM fundamentoSSocial");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboFLegal.addItem(resultadoConsulta.getString("FUNDAMENTO_LEGAL_SERVICIO_SOCIAL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        ComboSSocial = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        DateExpedicion = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ComboModalidadT = new javax.swing.JComboBox<>();
        DateExamenP = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        ComboFLegal = new javax.swing.JComboBox<>();
        ComboEFederativa2 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtaPaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtaMaterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCURP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ComboTipoEstudio = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        ComboEFederativa = new javax.swing.JComboBox<>();
        txtProcedencia = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        DateFechaInicioE = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        DateFechaTerminoE = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCarrera = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ComboReconocimiento = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        DateFechaInicio = new com.toedter.calendar.JDateChooser();
        DateFechaTermino = new com.toedter.calendar.JDateChooser();
        jButton41 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel20.setText("fechaExpedicion");

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel38.setText("Expedición");

        ComboSSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel21.setText("Fundamento Servicio Social");

        jLabel22.setText("modalidadTitulacion");

        jLabel23.setText("fecha examen profesional");

        jLabel24.setText("cumplioServicioSocial");

        jLabel25.setText("Entidad Federativa");

        jLabel26.setText("Folio de control");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel38))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboEFederativa2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboSSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboModalidadT, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateExamenP, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboFLegal, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel38)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(DateExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(ComboModalidadT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23))
                    .addComponent(DateExamenP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboSSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(ComboFLegal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboEFederativa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Expedición", jPanel2);

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel37.setText("Datos Estudiante");

        jLabel3.setText("Matricula");

        jLabel4.setText("Nombre(s)");

        jLabel6.setText("Apellido Paterno");

        jLabel7.setText("Apellido Materno");

        jLabel8.setText("DATOS PERSONALES DEL ALUMNO");

        jLabel9.setText("CURP");

        jLabel10.setText("Correo Electrónico");

        jLabel11.setText("DATOS DE ESTUDIO ANTECEDENTES DEL ALUMNO");

        jLabel12.setText("Institución de Procedencia");

        jLabel15.setText("Tipo de Estudio Antecedente");

        ComboTipoEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTipoEstudioActionPerformed(evt);
            }
        });

        jLabel16.setText("Entidad Federativa");

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Descartar");

        jLabel18.setText("Fecha de inicio");

        jLabel19.setText("Fecha termino");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(ComboTipoEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ComboEFederativa, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(150, 150, 150)
                                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(DateFechaInicioE, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(DateFechaTerminoE, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(52, 52, 52)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(17, 17, 17)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtaPaterno)
                                                    .addComponent(txtaMaterno))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(59, 59, 59)
                                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(110, 110, 110)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtaPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboTipoEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboEFederativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(DateFechaInicioE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)))
                    .addComponent(DateFechaTerminoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estudiante", jPanel5);

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel35.setText("Carrera ");

        jLabel1.setText("Clave de Carrera");

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre de Carrera");

        jLabel5.setText("Editar Datos de la Carrera");

        jLabel13.setText("Fecha termino");

        jLabel17.setText("Autorización reconocimiento");

        jLabel14.setText("Fecha de inicio");

        jButton41.setText("Generar");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(6, 6, 6)
                        .addComponent(ComboReconocimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombreCarrera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(txtClave, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateFechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateFechaTermino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(390, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(DateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13))
                    .addComponent(DateFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboReconocimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(jButton41)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Carrera", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void ComboTipoEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipoEstudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTipoEstudioActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        capturarDatos();
        regitroBaseDatos();
        dispose();
        new Carreras().setVisible(true);
    }//GEN-LAST:event_jButton41ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carreras().setVisible(true);
            }
        });
    }

    public void datosResponsables() {
        String variable = (String) txtClave.getText();
        clave = Integer.parseInt(variable);
        nombreCarrera = txtNombreCarrera.getText();
        autorizacion_reconocimiento = (String) ComboReconocimiento.getSelectedItem();
        Date fecha1 = DateFechaInicio.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fechaComoCadena = sdf.format(fecha1);
        Date fecha2 = DateFechaTermino.getDate();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        fechaComoCadena2 = sdf2.format(fecha2);
    }

    public void datosAlumno() {
        matricula = txtMatricula.getText();
        nombre = txtNombre.getText();
        aPaterno = txtaPaterno.getText();
        aMaterno = txtaMaterno.getText();
        CURP = txtCURP.getText();
        correo = txtCorreo.getText();
    }

    public void datosExpedicion() {
        folioControl = txtFolio.getText();
        modalidadTitulacion = (String) ComboModalidadT.getSelectedItem();
        Date fecha4 = DateExamenP.getDate();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
        fechaExamen = sdf4.format(fecha4);

        if ((String) ComboSSocial.getSelectedItem() == "No") {
            sSocial = 0;
        } else {
            sSocial = 1;
        }

        fundamentoSS = (String) ComboFLegal.getSelectedItem();
        eFederativa2 = (String) ComboEFederativa2.getSelectedItem();
        Date fecha3 = DateExpedicion.getDate();
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        fechaExpedicion = sdf3.format(fecha3);

    }

    public void datosAntecedentes() {
        institucionProcedencia = txtProcedencia.getText();
        tipodeEstudio = (String) ComboTipoEstudio.getSelectedItem();
        eFederativa = (String) ComboEFederativa.getSelectedItem();
        Date fecha5 = DateExpedicion.getDate();
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
        fechaInicioAntecedente = sdf5.format(fecha5);
        Date fecha6 = DateExpedicion.getDate();
        SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd");
        fechaTerminoAntecedente = sdf6.format(fecha6);
    }

    public void capturarDatos() {

        datosResponsables();
        datosAlumno();
        datosExpedicion();
        datosAntecedentes();

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT clave_autorizacion FROM AutorizacionReconocimiento where autorizacion_reconocimiento='" + autorizacion_reconocimiento + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                clave_autorizacion = resultadoConsulta.getInt("clave_autorizacion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT ID_MODALIDAD_TITULACIÓN FROM modalidadTitulacion where MODALIDAD_TITULACIÓN='" + modalidadTitulacion + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idModalidadTitulacion = resultadoConsulta.getInt("ID_MODALIDAD_TITULACIÓN");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT ID_FUNDAMENTO_LEGAL_SERVICIO_SOCIAL FROM fundamentoSSocial where FUNDAMENTO_LEGAL_SERVICIO_SOCIAL='" + fundamentoSS + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idFundamentoLegalServicioSocial = resultadoConsulta.getInt("ID_FUNDAMENTO_LEGAL_SERVICIO_SOCIAL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT id_EntidadF FROM entidadFederativa where nombreEntidad='" + eFederativa + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idEntidadFederativa1 = resultadoConsulta.getInt("id_EntidadF");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT idTipoAntecedente FROM estudioAntecedente where tipoEstudioAntecedente='" + tipodeEstudio + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idTipoEstudioAntecedente = resultadoConsulta.getInt("idTipoAntecedente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT id_EntidadF FROM entidadFederativa where nombreEntidad='" + eFederativa2 + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idEntidadFederativa2 = resultadoConsulta.getInt("id_EntidadF");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Titulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void regitroBaseDatos() {
        /*try {
            String salida = conector.registrar("INSERT INTO Carrera(cveCarrera, nombreCarrera, numeroRvoe, clave_autorizacion, autorizacion_reconocimiento) VALUES ('" + clave + "','" + nombreCarrera
                    + "','" + numeroRvoe + "','" + clave_autorizacion + "','" + autorizacion_reconocimiento + "')");
            System.out.println(salida);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Los datos se han registrado bien  ");*/

        try {
            String ruta = "/home/genaro/Documentos/TituloElectronico_" + matricula + ".txt";
            String contenido = "||1.0|" + folioControl + "|" + curpResponsable + "|1|Director|LIC.|" + curpResponsable + "|3|Rector|ING."
                    + "|090653|UNIVERSIDAD VICTORIA|" + clave + "|" + nombreCarrera + "|" + fechaComoCadena + "|"
                    + fechaComoCadena2 + "|" + clave_autorizacion + "|" + autorizacion_reconocimiento + "||" + CURP + "|"
                    + nombre + "|" + aPaterno + "|" + aMaterno + "|" + correo + "|" + fechaExpedicion + "|" + idModalidadTitulacion + "|"
                    + modalidadTitulacion + "|" + fechaExamen + "||" + sSocial + "|" + idFundamentoLegalServicioSocial + "|"
                    + fundamentoSS + "|" + idEntidadFederativa1 + "|" + eFederativa + "|"
                    + institucionProcedencia + "|" + idTipoEstudioAntecedente + "|" + tipodeEstudio + "|"
                    + idEntidadFederativa2 + "|" + eFederativa2 + "|" + fechaComoCadena + "|" + fechaComoCadena2 + "|||";
            System.out.println(contenido);
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            JOptionPane.showMessageDialog(null, "txt Generado en la ruta : " + ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEFederativa;
    private javax.swing.JComboBox<String> ComboEFederativa2;
    private javax.swing.JComboBox<String> ComboFLegal;
    private javax.swing.JComboBox<String> ComboModalidadT;
    private javax.swing.JComboBox<String> ComboReconocimiento;
    private javax.swing.JComboBox<String> ComboSSocial;
    private javax.swing.JComboBox<String> ComboTipoEstudio;
    private com.toedter.calendar.JDateChooser DateExamenP;
    private com.toedter.calendar.JDateChooser DateExpedicion;
    private com.toedter.calendar.JDateChooser DateFechaInicio;
    private com.toedter.calendar.JDateChooser DateFechaInicioE;
    private com.toedter.calendar.JDateChooser DateFechaTermino;
    private com.toedter.calendar.JDateChooser DateFechaTerminoE;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCarrera;
    private javax.swing.JTextField txtProcedencia;
    private javax.swing.JTextField txtaMaterno;
    private javax.swing.JTextField txtaPaterno;
    // End of variables declaration//GEN-END:variables
}
