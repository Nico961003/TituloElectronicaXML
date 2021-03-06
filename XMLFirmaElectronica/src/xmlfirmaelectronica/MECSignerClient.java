package xmlfirmaelectronica;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.ssl.PKCS8Key;

import mx.com.mostrotouille.axolotl.CaptureException;
import mx.com.mostrotouille.axolotl.swing.AxolotlSwingToolkit;
import mx.com.mostrotouille.axolotl.swing.JAboutDialog;
import mx.com.mostrotouille.axolotl.swing.util.AxolotlFileFilter;

/**
 * @author � 2017 Edgar Soriano S�nchez
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MECSignerClient extends JFrame implements ActionListener {

    public static final String VERSION = "1.1";

    private static String getApplicationTitle() {
        return "MEC Signer [" + VERSION + "]";

    }

    public static void main(String[] ar) {
        final MECSignerClient client = new MECSignerClient();
        client.setVisible(true);
    }

    private static String parseExtensionArrayToDescriptionMessage(String[] extensionArray) {
        final StringBuffer result = new StringBuffer();
        result.append("Archivos (");

        for (int i = 0; i < extensionArray.length; i++) {
            result.append("*.");
            result.append(extensionArray[i]);
            result.append(i < (extensionArray.length - 1) ? ", " : "");
        }

        result.append(")");

        return result.toString();
    }

    public static String sign(String keyPath, String password, String toSign) throws Exception {

        final PKCS8Key pkcs8Key = new PKCS8Key(toByteArray(keyPath), password.toCharArray());

        final PrivateKey privateKey = pkcs8Key.getPrivateKey();

        final Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(toSign.getBytes("UTF-8"));

        return Base64.encodeBase64String(signature.sign());
    }

    public static String verifySign(String cerPath, String toVerify, String sign) {

        String resultado = null;
        Boolean blnResultado = false;
        try (InputStream cer = new FileInputStream(new File(cerPath))) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate cert = (X509Certificate) cf.generateCertificates(cer).iterator().next();

            final Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(cert.getPublicKey());
            signature.update(toVerify.getBytes("UTF-8"));

            blnResultado = signature.verify(Base64.decodeBase64(sign.getBytes("UTF-8")));

        } catch (Exception e) {
            e.printStackTrace();

        }
        if (blnResultado.equals(Boolean.FALSE)) {
            resultado = new String("Firma Incorrecta");
        } else {
            resultado = new String("Firma Correcta");
        }
        return resultado;
    }

    private static byte[] toByteArray(String filePath) throws Exception {
        File f = new File(filePath);

        FileInputStream fis = new FileInputStream(f);

        byte[] fbytes = new byte[(int) f.length()];

        fis.read(fbytes);
        fis.close();

        return fbytes;
    }

    private JButton bttnCer;
    private JButton bttnCer2;
    private JButton bttnKey;
    private JButton bttnKey2;
    private JButton bttnReset;
    private JButton bttnSign;
    private File currentDirectory;
    private JPasswordField psswrdFldPass;
    private JPasswordField psswrdFldPass2;
    public JTextArea txtArSign;
    private JTextArea txtArToSign;
    private JTextField txtFldCer;
    private JTextField txtFldCer2;
    private JTextField txtFldKey;
    private JTextField txtFldKey2;

    private JButton bttnCerVerify;
    private JButton bttnVerifySign;
    private JButton bttnVerifyReset;
    private JTextField txtFldCerVerify;
    private JTextArea txtArToVerify;
    private JTextArea txtArVerify;
    private JTextArea txtArOriginal;

    public MECSignerClient() {
        super(getApplicationTitle());

        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        JTabbedPane tabPanel = new JTabbedPane();

        final JPanel pnlContent2 = getContentVerifySign();
        final JPanel pnlContent = getContentSign();

        JMenuItem menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });

        JMenuItem menuItemAcercaDe = new JMenuItem("Acerca de...");
        menuItemAcercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                final ArrayList<String> headerLabelList = new ArrayList<String>();
                headerLabelList.add("Secretaría de Educación Pública");
                headerLabelList.add("Dirección General del Sistema de Información y Gestión Educativa");
                headerLabelList.add("");
                headerLabelList.add(getApplicationTitle());
                headerLabelList.add("2020 SEP-DGSIGED");

                JAboutDialog.showDialog(MECSignerClient.this, true, headerLabelList, (Image) null);
            }
        });

        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.add(menuItemSalir);

        JMenu menuAyuda = new JMenu("Ayuda");
        menuAyuda.add(menuItemAcercaDe);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuArchivo);
        menuBar.add(menuAyuda);

        getContentPane().setLayout(new GridLayout(1, 1));

        // getContentPane().add(pnlContent);
        tabPanel.addTab("Sign", pnlContent);
        tabPanel.addTab("Verify Sign", pnlContent2);
        getContentPane().add(tabPanel);
        setJMenuBar(menuBar);
        setSize((int) (0.75 * screenSize.getWidth()), (int) (0.75 * screenSize.getHeight()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel getContentVerifySign() {

        txtFldCerVerify = new JTextField();
        txtFldCerVerify.setEnabled(false);

        bttnCerVerify = new JButton("Seleccionar...");
        bttnCerVerify.addActionListener(this);

        bttnVerifySign = new JButton("Ejecutar");
        bttnVerifySign.addActionListener(this);

        bttnVerifyReset = new JButton("Limpiar");
        bttnVerifyReset.addActionListener(this);

        txtArToVerify = new JTextArea();

        txtArVerify = new JTextArea();

        txtArOriginal = new JTextArea();

        final JPanel pnlA = new JPanel(new BorderLayout());
        pnlA.add(new JLabel("Llave pública (archivo CER)"), BorderLayout.NORTH);
        pnlA.add(txtFldCerVerify, BorderLayout.CENTER);
        pnlA.add(bttnCerVerify, BorderLayout.EAST);

        final JPanel pnlD = new JPanel(new BorderLayout());
        pnlD.add(new JLabel("Firma a Verificar"), BorderLayout.NORTH);
        pnlD.add(new JScrollPane(txtArToVerify), BorderLayout.CENTER);

        final JPanel pnlE = new JPanel(new BorderLayout());
        pnlE.add(new JLabel("Cadena Original"), BorderLayout.NORTH);
        pnlE.add(new JScrollPane(txtArOriginal), BorderLayout.CENTER);

        final JPanel pnlF = new JPanel(new BorderLayout());
        pnlF.add(new JLabel("Resultado"), BorderLayout.NORTH);
        pnlF.add(new JScrollPane(txtArVerify), BorderLayout.CENTER);

        final JPanel pnlG = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlG.add(bttnVerifySign);
        pnlG.add(bttnVerifyReset);

        final JPanel pnlABC = new JPanel(new GridLayout(1, 1));
        pnlABC.add(pnlA);
        // pnlABC.add(pnlB);
        // pnlABC.add(pnlC);

        final JPanel pnlDE = new JPanel(new GridLayout(3, 1));
        pnlDE.add(pnlD);
        pnlDE.add(pnlE);
        pnlDE.add(pnlF);

        JPanel pnlContent = new JPanel(new BorderLayout());
        pnlContent.add(pnlABC, BorderLayout.NORTH);
        pnlContent.add(pnlDE, BorderLayout.CENTER);
        pnlContent.add(pnlG, BorderLayout.SOUTH);
        return pnlContent;
    }

    private JPanel getContentSign() {

        txtFldCer = new JTextField();
        txtFldCer.setEnabled(false);

        txtFldKey = new JTextField();
        txtFldKey.setEnabled(false);

        txtFldCer2 = new JTextField();
        txtFldCer2.setEnabled(false);

        txtFldKey2 = new JTextField();
        txtFldKey2.setEnabled(false);
        
        psswrdFldPass = new JPasswordField();
        psswrdFldPass2 = new JPasswordField();

        txtArToSign = new JTextArea();

        txtArSign = new JTextArea();

        bttnCer = new JButton("Seleccionar...");
        bttnCer.addActionListener(this);

        bttnKey = new JButton("Seleccionar...");
        bttnKey.addActionListener(this);
        
        bttnCer2 = new JButton("Seleccionar...");
        bttnCer2.addActionListener(this);

        bttnKey2 = new JButton("Seleccionar...");
        bttnKey2.addActionListener(this);

        bttnSign = new JButton("Ejecutar");
        bttnSign.addActionListener(this);

        bttnReset = new JButton("Limpiar");
        bttnReset.addActionListener(this);

        final JPanel pnlA = new JPanel(new BorderLayout());
        pnlA.add(new JLabel("Llave pública (archivo CER)"), BorderLayout.NORTH);
        pnlA.add(txtFldCer, BorderLayout.CENTER);
        pnlA.add(bttnCer, BorderLayout.EAST);
        
        final JPanel pnlA2 = new JPanel(new BorderLayout());
        pnlA2.add(new JLabel("Llave pública (archivo CER)"), BorderLayout.NORTH);
        pnlA2.add(txtFldCer2, BorderLayout.CENTER);
        pnlA2.add(bttnCer2, BorderLayout.EAST);
        
        final JPanel pnlB = new JPanel(new BorderLayout());
        pnlB.add(new JLabel("Llave privada (archivo KEY)"), BorderLayout.NORTH);
        pnlB.add(txtFldKey, BorderLayout.CENTER);
        pnlB.add(bttnKey, BorderLayout.EAST);
        
        final JPanel pnlB2 = new JPanel(new BorderLayout());
        pnlB2.add(new JLabel("Llave privada (archivo KEY)"), BorderLayout.NORTH);
        pnlB2.add(txtFldKey2, BorderLayout.CENTER);
        pnlB2.add(bttnKey2, BorderLayout.EAST);

        final JPanel pnlC = new JPanel(new BorderLayout());
        pnlC.add(new JLabel("Contraseña"), BorderLayout.NORTH);
        pnlC.add(psswrdFldPass, BorderLayout.CENTER);
        
        final JPanel pnlC2 = new JPanel(new BorderLayout());
        pnlC2.add(new JLabel("Contraseña"), BorderLayout.NORTH);
        pnlC2.add(psswrdFldPass2, BorderLayout.CENTER);

        final JPanel pnlD = new JPanel(new BorderLayout());
        pnlD.add(new JLabel("Cadena de texto a firmar"), BorderLayout.NORTH);
        pnlD.add(new JScrollPane(txtArToSign), BorderLayout.CENTER);

        final JPanel pnlE = new JPanel(new BorderLayout());
        pnlE.add(new JLabel("Resultado"), BorderLayout.NORTH);
        pnlE.add(new JScrollPane(txtArSign), BorderLayout.CENTER);

        final JPanel pnlF = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlF.add(bttnSign);
        pnlF.add(bttnReset);

        final JPanel pnlABC = new JPanel(new GridLayout(3, 1));
        pnlABC.add(pnlA);
        pnlABC.add(pnlA2);
        pnlABC.add(pnlB);
        pnlABC.add(pnlB2);
        pnlABC.add(pnlC);
        pnlABC.add(pnlC2);

        final JPanel pnlDE = new JPanel(new GridLayout(2, 1));
        pnlDE.add(pnlD);
        pnlDE.add(pnlE);

        JPanel pnlContent = new JPanel(new BorderLayout());
        pnlContent.add(pnlABC, BorderLayout.NORTH);
        pnlContent.add(pnlDE, BorderLayout.CENTER);
        pnlContent.add(pnlF, BorderLayout.SOUTH);
        return pnlContent;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource().equals(bttnCer)) {
            selectFile(txtFldCer, new String[]{"cer"});

            temporal tm = new temporal();
            String Recepcion = tm.getTexto();
            txtArToSign.setText(Recepcion);
            txtArOriginal.setText(Recepcion);
            //txtArToSign.setEnabled(false);

        } else if (ev.getSource().equals(bttnCer2)) {
            selectFile(txtFldCer2, new String[]{"cer"});
        }else if (ev.getSource().equals(bttnKey)) {
            selectFile(txtFldKey, new String[]{"key"});
        }else if (ev.getSource().equals(bttnKey2)) {
            selectFile(txtFldKey2, new String[]{"key"});
        } else if (ev.getSource().equals(bttnSign)) {
            try {
                if (txtFldCer.getText().length() <= 0 || txtFldKey.getText().length() <= 0
                        || psswrdFldPass.getPassword().length <= 0 || txtArToSign.getText().length() <= 0
                        || psswrdFldPass2.getPassword().length <= 0 || txtFldCer2.getText().length() <= 0 || txtFldKey2.getText().length() <= 0) {
                    throw new CaptureException(null, "Debe seleccionar/capturar todos los valores necesarios.");
                } else {
                    StringBuffer result = new StringBuffer();
                    result.append("Archivo 1 CER (base 64):\n");
                    result.append(Base64.encodeBase64String(toByteArray(txtFldCer.getText())));
                    result.append("\n");
                    result.append("Firma 1 (base 64):\n");
                    result.append(
                            sign(txtFldKey.getText(), new String(psswrdFldPass.getPassword()), txtArToSign.getText()));
                    result.append("\n");
                    result.append("\n");
                    StringBuffer result2 = new StringBuffer();
                    result.append("Archivo 2 CER (base 64):\n");
                    result.append(Base64.encodeBase64String(toByteArray(txtFldCer2.getText())));
                    result.append("\n");
                    result.append("Firma 2 (base 64):\n");
                    result.append(
                            sign(txtFldKey2.getText(), new String(psswrdFldPass2.getPassword()), txtArToSign.getText()));
                    
                    txtArSign.setText(result.toString());
                    
                    
                    
        temporal tm = new temporal();
        String Recepcion = tm.getTexto();
        String Matricula = tm.getMatricula();
        String[] xml = new String[45];
        int i = 1;
        StringTokenizer st = new StringTokenizer(Recepcion, "|");
        while (st.hasMoreTokens()) {
            //System.out.println(i + "-" + st.nextToken());
            xml[i] = "\"" + st.nextToken() + "\"";
            System.out.println(i + "-" + xml[i]);
            i++;
        }

        try {
            String ruta = "/home/genaro/Documentos/TituloElectronico_" + Matricula + ".xml";
            String contenido = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + "<TituloElectronico xmlns=\"https://www.siged.sep.gob.mx/titulos/\" version=\"1.0\" folioControl="+xml[2]+" xmlns:dec=\"https://www.siged.sep.gob.mx/titulos/\">\n"
                    + "  <FirmaResponsables>\n"
                    + "    <FirmaResponsable nombre=\"MIGUEL\" primerApellido=\"OSORIO\" segundoApellido=\"RAMOS\" curp=\"OORM631231HDFSMG03\" idCargo=\"1\" cargo=\"DIRECTOR\" abrTitulo=\"LIC.\" sello=\"" + sign(txtFldKey.getText(), new String(psswrdFldPass.getPassword()), txtArToSign.getText()) + "\" certificadoResponsable=\"" + Base64.encodeBase64String(toByteArray(txtFldCer.getText())) + "\" noCertificadoResponsable=\"00001000000412846216\"/>\n"
                    + "    <FirmaResponsable nombre=\"JORGE\" primerApellido=\"BERRUETA\" segundoApellido=\"VIDEGARAY\" curp=\"BEVJ691029HGTRDR09\" idCargo=\"3\" cargo=\"RECTOR\" abrTitulo=\"ING.\" sello=\"" + sign(txtFldKey2.getText(), new String(psswrdFldPass2.getPassword()), txtArToSign.getText()) + "\" certificadoResponsable=\"" + Base64.encodeBase64String(toByteArray(txtFldCer2.getText())) + "\" noCertificadoResponsable=\"00001000000100164040\"/>\n"
                    + "  </FirmaResponsables>\n"
                    + "  <Institucion cveInstitucion="+xml[11]+" nombreInstitucion="+xml[12]+"/>\n"
                    + "  <Carrera cveCarrera="+xml[13]+" nombreCarrera="+xml[14]+" fechaInicio="+xml[15]+" fechaTerminacion="+xml[16]+" idAutorizacionReconocimiento="+xml[17]+" autorizacionReconocimiento="+xml[18]+" numeroRvoe="+xml[19]+"/>\n"                    
                    + "  <Profesionista curp="+xml[20]+" nombre="+xml[21]+" primerApellido="+xml[22]+" segundoApellido="+xml[23]+" correoElectronico="+xml[24]+"/>"
                    + "  <Expedicion fechaExpedicion="+xml[25]+" idModalidadTitulacion="+xml[26]+" modalidadTitulacion="+xml[27]+" fechaExencionExamenProfesional="+xml[28]+" cumplioServicioSocial="+xml[29]+" idFundamentoLegalServicioSocial="+xml[30]+" fundamentoLegalServicioSocial="+xml[31]+" idEntidadFederativa="+xml[32]+" entidadFederativa="+xml[33]+"/>\n"
                    + "  <Antecedente institucionProcedencia="+xml[34]+" idTipoEstudioAntecedente="+xml[35]+" tipoEstudioAntecedente="+xml[36]+" idEntidadFederativa="+xml[37]+" entidadFederativa="+xml[38]+" fechaInicio="+xml[39]+" fechaTerminacion="+xml[40]+" noCedula="+xml[41]+"/>\n"
                    + "</TituloElectronico>";

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
            JOptionPane.showMessageDialog(null, "XML Generado en la ruta : " + ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }

        abrirarchivo("/home/genaro/Documentos/");
                    
      

                }
            } catch (Exception ex) {
                AxolotlSwingToolkit.showExceptionDialog(MECSignerClient.this, ex, true);
            }
        } else if (ev.getSource().equals(bttnReset)) {
            txtFldCer.setText("");
            txtFldKey.setText("");
            txtFldCer2.setText("");
            txtFldKey2.setText("");
            psswrdFldPass.setText("");
            psswrdFldPass2.setText("");
            txtArToSign.setText("");
            txtArSign.setText("");
        } else if (ev.getSource().equals(bttnCerVerify)) {
            selectFile(txtFldCerVerify, new String[]{"cer"});

        } else if (ev.getSource().equals(bttnVerifySign)) {
            try {
                if (txtFldCerVerify.getText().length() <= 0 || txtArToVerify.getText().length() <= 0 || txtArOriginal.getText().length() <= 0) {
                    throw new CaptureException(null, "Debe seleccionar/capturar todos los valores necesarios.");
                } else {
                    StringBuffer result = new StringBuffer();
                    result.append("Archivo CER (base 64):\n");
                    result.append(Base64.encodeBase64String(toByteArray(txtFldCerVerify.getText())));
                    result.append("\n");
                    result.append("\n");
                    result.append("Firma (base 64):\n");
                    result.append(verifySign(txtFldCerVerify.getText(), txtArOriginal.getText(), txtArToVerify.getText()));

                    txtArVerify.setText(result.toString());
                    txtArToVerify.setEnabled(false);
                }
            } catch (Exception ex) {
                AxolotlSwingToolkit.showExceptionDialog(MECSignerClient.this, ex, true);
            }
        } else if (ev.getSource().equals(bttnVerifyReset)) {
            txtFldCerVerify.setText("");
            txtArToVerify.setText("");
            txtArOriginal.setText("");
            txtArVerify.setText("");
        }
    }

    private void selectFile(JTextField txtfld, String[] extensionArray) {
        final JFileChooser flchsr = new JFileChooser(currentDirectory);
        flchsr.setFileFilter(
                new AxolotlFileFilter(extensionArray, parseExtensionArrayToDescriptionMessage(extensionArray)));

        final int option = flchsr.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            txtfld.setText(flchsr.getSelectedFile().getAbsolutePath());

            currentDirectory = flchsr.getCurrentDirectory();
        }
    }


    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}


/*
<?xml version="1.0" encoding="UTF-8"?>
<TituloElectronico xmlns="https://www.siged.sep.gob.mx/titulos/" version="1.0" folioControl=xml[2] xmlns:dec="https://www.siged.sep.gob.mx/titulos/">
  <FirmaResponsables>
    <FirmaResponsable nombre="Miguel" primerApellido="Osorio" segundoApellido="Ramos" curp="OORM631231HDFSMG03" idCargo="1" cargo="DIRECTOR" abrTitulo="LIC." sello= certificadoResponsable= noCertificadoResponsable="30303030313030303030"/>
    <FirmaResponsable nombre="Jorge" primerApellido="Berrueta" segundoApellido="Videgaray" curp="BEVJ691029HGTRDR09" idCargo="3" cargo="RECTOR" abrTitulo="ING." sello= noCertificadoResponsable="30303030313030303030"/>
  </FirmaResponsables>
  <Institucion cveInstitucion=xml[11] nombreInstitucion=xml[12]/>
  <Carrera cveCarrera=xml[13] nombreCarrera=xml[14] fechaInicio=xml[15] fechaTerminacion=xml[16] idAutorizacionReconocimiento=xml[17] autorizacionReconocimiento=xml[18] numeroRvoe="pendiente"/>
  <Profesionista curp=xml[19] nombre=xml[20] primerApellido=xml[21] segundoApellido=xml[22] correoElectronico=xml[23]/>
  <Expedicion fechaExpedicion=xml[24] idModalidadTitulacion=xml[25] modalidadTitulacion=xml[26] fechaExencionExamenProfesional=xml[27] cumplioServicioSocial=xml[28] idFundamentoLegalServicioSocial=xml[29] fundamentoLegalServicioSocial=xml[30] idEntidadFederativa=xml[31] entidadFederativa=xml[32]/>
  <Antecedente institucionProcedencia=xml[33] idTipoEstudioAntecedente=xml[34] tipoEstudioAntecedente=xml[35] idEntidadFederativa=xml[36] entidadFederativa=xml[37] fechaInicio=xml[38] fechaTerminacion=xml[39] noCedula="pendiente"/>
</TituloElectronico>
*/
