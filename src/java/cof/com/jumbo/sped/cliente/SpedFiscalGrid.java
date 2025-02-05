/*
* The MIT License
* 
* Copyright: Copyright (C) 2014 T2Ti.COM
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
* 
* The author may be contacted at: t2ti.com@gmail.com
*
* @author Claudio de Barros (T2Ti.com)
* @version 2.0
*/
package cof.com.jumbo.sped.cliente;

import adm.com.jumbo.cadastros.java.ContadorVO;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.util.client.ClientUtils;

public class SpedFiscalGrid extends InternalFrame {

    private SpedFiscalGridController controller;

    /** Creates new form SpedContabilGrid */
    public SpedFiscalGrid(SpedFiscalGridController controller) {
        initComponents();

        this.controller = controller;

        ContadorGridController contadorController = new ContadorGridController();
        gridControlContador.setController(contadorController);
        gridControlContador.setGridDataLocator(contadorController);

        comboVersaoSped.addItem("008 - Versão 1.07 Ato COTEPE 01/01/2014");
        comboVersaoSped.addItem("007 - Versão 1.06 Ato COTEPE 01/01/2013");
        comboVersaoSped.addItem("006 - Versão 1.05 Ato COTEPE 01/07/2012");
        comboVersaoSped.addItem("005 - Versão 1.04 Ato COTEPE 01/01/2012");
        comboVersaoSped.addItem("004 - Versão 1.03 Ato COTEPE 01/01/2011");
        comboVersaoSped.addItem("003 - Versão 1.02 Ato COTEPE 01/01/2010");
        comboVersaoSped.addItem("002 - Versão 1.01 Ato COTEPE 01/01/2009");
        comboVersaoSped.addItem("001 - Versão 1.00 Ato COTEPE 01/01/2008");

        comboFinalidadeSped.addItem("0 - Remessa do arquivo original");
        comboFinalidadeSped.addItem("1 - Remessa do arquivo substituto");

        comboPerfilSped.addItem("A - Perfil A");
        comboPerfilSped.addItem("B - Perfil B");
        comboPerfilSped.addItem("C - Perfil C");

        comboInventário.addItem("00 - Sem Inventário");
        comboInventário.addItem("01 - No final no período");
        comboInventário.addItem("02 - Na mudança de forma de tributação da mercadoria (ICMS)");
        comboInventário.addItem("03 - Na solicitação da baixa cadastral, paralisação temporária e outras situações");
        comboInventário.addItem("04 - Na alteração de regime de pagamento - condição do contribuinte");
        comboInventário.addItem("05 - Por determinação dos fiscos");

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        dateControlInicio = new org.openswing.swing.client.DateControl();
        dateControlFim = new org.openswing.swing.client.DateControl();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboVersaoSped = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        comboFinalidadeSped = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboPerfilSped = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        gridControlContador = new org.openswing.swing.client.GridControl();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn3 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn6 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn7 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn8 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn9 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn10 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn11 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn12 = new org.openswing.swing.table.columns.client.TextColumn();
        integerColumn13 = new org.openswing.swing.table.columns.client.IntegerColumn();
        textColumn14 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn15 = new org.openswing.swing.table.columns.client.TextColumn();
        jLabel10 = new javax.swing.JLabel();
        comboInventário = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setTitle("JUMBO - Sped Fiscal");
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(dateControlInicio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(dateControlFim, gridBagConstraints);

        jLabel2.setText("Período Inicial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Período Final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel7.setText("Versão de Leiaute:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(comboVersaoSped, gridBagConstraints);

        jLabel8.setText("Finalidade do Arquivo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(comboFinalidadeSped, gridBagConstraints);

        jLabel9.setText("Perfil de Apresentação do Arquivo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(comboPerfilSped, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        gridControlContador.setFunctionId("contador");
        gridControlContador.setValueObjectClassName("adm.com.jumbo.cadastros.java.ContadorVO");
        gridControlContador.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn2.setColumnName("nome");
        textColumn2.setHeaderColumnName("Nome");
        textColumn2.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn2.setPreferredWidth(200);
        gridControlContador.getColumnContainer().add(textColumn2);

        textColumn3.setColumnName("inscricaoCrc");
        textColumn3.setHeaderColumnName("Inscricao Crc");
        textColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn3);

        textColumn4.setColumnName("ufCrc");
        textColumn4.setHeaderColumnName("Uf Crc");
        textColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn4);

        textColumn5.setColumnName("fone");
        textColumn5.setHeaderColumnName("Fone");
        textColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn5);

        textColumn6.setColumnName("fax");
        textColumn6.setHeaderColumnName("Fax");
        textColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn6);

        textColumn7.setColumnName("logradouro");
        textColumn7.setHeaderColumnName("Logradouro");
        textColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn7);

        textColumn8.setColumnName("numero");
        textColumn8.setHeaderColumnName("Numero");
        textColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn8);

        textColumn9.setColumnName("complemento");
        textColumn9.setHeaderColumnName("Complemento");
        textColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn9);

        textColumn10.setColumnName("bairro");
        textColumn10.setHeaderColumnName("Bairro");
        textColumn10.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn10);

        textColumn11.setColumnName("cidade");
        textColumn11.setHeaderColumnName("Cidade");
        textColumn11.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn11);

        textColumn12.setColumnName("cep");
        textColumn12.setHeaderColumnName("Cep");
        textColumn12.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn12);

        integerColumn13.setColumnName("municipioIbge");
        integerColumn13.setHeaderColumnName("Municipio Ibge");
        integerColumn13.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(integerColumn13);

        textColumn14.setColumnName("uf");
        textColumn14.setHeaderColumnName("Uf");
        textColumn14.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn14);

        textColumn15.setColumnName("email");
        textColumn15.setHeaderColumnName("Email");
        textColumn15.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlContador.getColumnContainer().add(textColumn15);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(gridControlContador, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

        jLabel10.setText("Inventário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(comboInventário, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton1.setText("Gerar Sped Fiscal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (dateControlInicio.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Informe a data inicial", "Informação do Sistema", JOptionPane.WARNING_MESSAGE);
        } else if (dateControlFim.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Informe a data final", "Informação do Sistema", JOptionPane.WARNING_MESSAGE);
        } else if (gridControlContador.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um contador", "Informação do Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            JFileChooser chooser = new JFileChooser();
            int resposta = chooser.showSaveDialog(this);
            if (resposta == JFileChooser.APPROVE_OPTION) {
                try {
                    Date dataInicial = dateControlInicio.getDate();
                    Date dataFinal = dateControlFim.getDate();
                    String versao = comboVersaoSped.getSelectedItem().toString().substring(0, 3);
                    String finalidade = comboFinalidadeSped.getSelectedItem().toString().substring(0, 1);
                    String perfil = comboPerfilSped.getSelectedItem().toString().substring(0, 1);
                    int inventario = comboInventário.getSelectedIndex();
                    ContadorVO contador = (ContadorVO) gridControlContador.getVOListTableModel().getObjectForRow(gridControlContador.getSelectedRow());
                    controller.geraSpedFiscal(dataInicial, dataFinal, versao, finalidade, perfil, inventario, contador, chooser.getSelectedFile());
                    ClientUtils.displayURL(chooser.getSelectedFile().toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Ocorreu um erro ao gerar o Sped Fiscal\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboFinalidadeSped;
    private javax.swing.JComboBox comboInventário;
    private javax.swing.JComboBox comboPerfilSped;
    private javax.swing.JComboBox comboVersaoSped;
    private org.openswing.swing.client.DateControl dateControlFim;
    private org.openswing.swing.client.DateControl dateControlInicio;
    private org.openswing.swing.client.GridControl gridControlContador;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn13;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn10;
    private org.openswing.swing.table.columns.client.TextColumn textColumn11;
    private org.openswing.swing.table.columns.client.TextColumn textColumn12;
    private org.openswing.swing.table.columns.client.TextColumn textColumn14;
    private org.openswing.swing.table.columns.client.TextColumn textColumn15;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn6;
    private org.openswing.swing.table.columns.client.TextColumn textColumn7;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.table.columns.client.TextColumn textColumn9;
    // End of variables declaration//GEN-END:variables
}
