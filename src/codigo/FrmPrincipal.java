/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package codigo;

import static codigo.Tokens.mayorIgual;
import static codigo.Tokens.numero;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import codigo.SemanticAnalyzer;
import codigo.Sintax;
import java.awt.Color;

/**
 *
 * @author ben10
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    private SemanticAnalyzer semanticAnalyzer;

    public FrmPrincipal() {
        initComponents();
        semanticAnalyzer = new SemanticAnalyzer();
    }

    private void analizarLexico() throws IOException {
    int cont = 1;
    String expr = (String) txtArchivoContenido.getText();
    Lexer lexer = new Lexer(new StringReader(expr));
    String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
    while (true) {
        Tokens token = lexer.yylex();
        if (token == null) {
            txtAnalizarLex.setText(resultado);
            // Mostrar tabla de símbolos después de analizar
            //jTextAreaTablaSimbolos.setText(semanticAnalyzer.getSymbolTable());
            return;
        }
        semanticAnalyzer.analyzeToken(token, lexer.lexer);
            switch (token) {
                case linea: cont++; resultado += "LINEA " + cont + "\n"; break;
                case comillaSimple: resultado += "  <comillaSimple>\t\t" + lexer.lexer + "\n"; break;
                case igual: resultado += "  <igual>\t\t" + lexer.lexer + "\n"; break;
                case comillaDoble: resultado += "  <comillaDoble>\t\t" + lexer.lexer + "\n"; break;
                case string: resultado += "  <String>\t\t" + lexer.lexer + "\n"; break;
                case entero: resultado += "  <entero>\t\t" + lexer.lexer + "\n"; break;
                case decimal: resultado += "  <decimal>\t\t" + lexer.lexer + "\n"; break;
                case bool: resultado += "  <bool>\t\t" + lexer.lexer + "\n"; break;
                case si: resultado += "  <si>\t\t" + lexer.lexer + "\n"; break;
                case sino: resultado += "  <sino>\t\t" + lexer.lexer + "\n"; break;
                case mientras: resultado += " <­mientras>\t\t" + lexer.lexer + "\n"; break;
                case suma: resultado += "  <suma>\t\t" + lexer.lexer + "\n"; break;
                case resta: resultado += "  <resta>\t\t" + lexer.lexer + "\n"; break;
                case producto: resultado += "  <producto>\t\t" + lexer.lexer + "\n"; break;
                case division: resultado += "  <division>\t\t" + lexer.lexer + "\n"; break;
                case y: resultado += "  <y>\t\t" + lexer.lexer + "\n"; break;
                case o: resultado += "  <o>\t\t" + lexer.lexer + "\n"; break;
                case no: resultado += "  <no>\t\t" + lexer.lexer + "\n"; break;
                case igualA: resultado += "  <igualA>\t\t" + lexer.lexer + "\n"; break;
                case diferenteA: resultado += "  <diferenteA>\t\t" + lexer.lexer + "\n"; break;
                case verdadero: resultado += "  <verdadero>\t\t" + lexer.lexer + "\n"; break;
                case falso: resultado += "  <falso>\t\t" + lexer.lexer + "\n"; break;
                case menorQue: resultado += "  <Operador menor que>\t\t" + lexer.lexer + "\n"; break;
                case mayorQue: resultado += "  <Operador mayor que>\t\t" + lexer.lexer + "\n"; break;
                case menorIgual: resultado += "  <Operador menor que>\t\t" + lexer.lexer + "\n"; break;
                case mayorIgual: resultado += "  <Operador mayor igual\t\t" + lexer.lexer + "\n"; break;
                case parentesisA: resultado += "  <Parentesis de apertura>\t\t" + lexer.lexer + "\n"; break;
                case parentesisC: resultado += "  <Parentesis de cierre>\t\t" + lexer.lexer + "\n"; break;
                case llaveA: resultado += "  <Llave de apertura>\t\t" + lexer.lexer + "\n"; break;
                case llaveC: resultado += "  <Llave de cierre>\t\t" + lexer.lexer + "\n"; break;
                case funcMain: resultado += "  <Reservada main>\t\t" + lexer.lexer + "\n"; break;
                case finLinea: resultado += "  <Punto y coma>\t\t" + lexer.lexer + "\n"; break;
                case letra: resultado += "  <letra>\t\t" + lexer.lexer + "\n"; break;
                case numero: resultado += "  <Numero>\t\t" + lexer.lexer + "\n"; break;
                case numeroDecimal: resultado += "<Numero decimal>\t\t" + lexer.lexer + "\n"; break;
                case tipoStr: resultado += "<Tipo string>\t\t" + lexer.lexer + "\n"; break;
                case imprimir: resultado += "  <imprimir>\t\t" + lexer.lexer + "\n"; break;
                default: resultado += "  < " + lexer.lexer + " >\n"; break;
            }
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

        btnAnalizarLex = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnArchivo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArchivoContenido = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnAnalizarSin = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaTablaSimbolos = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAnalizarLex.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAnalizarLex.setText("Analizar Lex");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane1.setViewportView(txtAnalizarLex);

        btnArchivo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnArchivo.setText("Abrir archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtArchivoContenido.setColumns(20);
        txtArchivoContenido.setRows(5);
        jScrollPane2.setViewportView(txtArchivoContenido);

        jLabel1.setText("ANALIZADOR SINTACTICO");

        btnAnalizarSin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAnalizarSin.setText("Analizar Sin");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        jLabel2.setText("ANALIZADOR LEXICO");

        jTextAreaTablaSimbolos.setColumns(20);
        jTextAreaTablaSimbolos.setRows(5);
        jScrollPane4.setViewportView(jTextAreaTablaSimbolos);

        jLabel3.setText("Tabla de simbolos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnArchivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAnalizarLex)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnalizarSin)
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1)
                        .addContainerGap(825, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(949, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(403, 403, 403)
                    .addComponent(jLabel2)
                    .addContainerGap(838, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAnalizarLex)
                                .addComponent(btnArchivo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(btnAnalizarSin)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(245, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jLabel2)
                    .addContainerGap(586, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
            //jTextAreaTablaSimbolos.setText(semanticAnalyzer.getSymbolTable());
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtArchivoContenido.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        String ST = txtArchivoContenido.getText();
        LexerCup lexerCup = new codigo.LexerCup(new StringReader(ST));
        Sintax s = new Sintax(lexerCup);
        Semantica sem = new Semantica();
        try {
            s.parse(); 
            s.setSemantica(sem);
            
            txtAnalizarSin.setText("Análisis sintáctico y semántico correcto");
            jTextAreaTablaSimbolos.setText(semanticAnalyzer.getSymbolTable());
            semanticAnalyzer = new SemanticAnalyzer(); // Reiniciar el analizador semántico 
            
        } catch(ErrorSemantica err) {
            txtAnalizarSin.setText("Error Semántico: " + err.getMessage());
            txtAnalizarSin.setForeground(Color.red);
        }
        catch (Exception ex) {
            Symbol sym = s.getS();
            semanticAnalyzer = new SemanticAnalyzer();
            txtAnalizarSin.setText("Error de sintaxis. Línea: " + (sym.right + 1) + " columna: " + (sym.left + 1) + " , Texto: \"" + sym.value + "\"");
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaTablaSimbolos;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtArchivoContenido;
    // End of variables declaration//GEN-END:variables
}
