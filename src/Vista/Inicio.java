
package Vista;

/**
 *
 * @author almudenaflores
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSalir = new java.awt.Button();
        label9 = new java.awt.Label();
        label11 = new java.awt.Label();
        irActores = new javax.swing.JButton();
        irPeliculas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/85th-academy-awards-the-oscars-85O_OscarVert_LR_rgb_0.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.setText("IR");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(490, 350));
        setName("Inicio"); // NOI18N
        setPreferredSize(new java.awt.Dimension(450, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setFont(new java.awt.Font("STSong", 1, 18)); // NOI18N
        btnSalir.setLabel("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 100, 40));

        label9.setBackground(new java.awt.Color(0, 0, 0));
        label9.setFont(new java.awt.Font("STSong", 1, 24)); // NOI18N
        label9.setForeground(new java.awt.Color(255, 255, 255));
        label9.setText("PELÍCULAS");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        label11.setBackground(new java.awt.Color(0, 0, 0));
        label11.setFont(new java.awt.Font("STSong", 1, 24)); // NOI18N
        label11.setForeground(new java.awt.Color(255, 255, 255));
        label11.setText("ACTORES");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        irActores.setBackground(new java.awt.Color(0, 0, 0));
        irActores.setFont(new java.awt.Font("STSong", 1, 18)); // NOI18N
        irActores.setText("Ir");
        irActores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irActoresActionPerformed(evt);
            }
        });
        getContentPane().add(irActores, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, 40));

        irPeliculas.setBackground(new java.awt.Color(0, 0, 0));
        irPeliculas.setFont(new java.awt.Font("STSong", 1, 18)); // NOI18N
        irPeliculas.setText("Ir");
        irPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irPeliculasActionPerformed(evt);
            }
        });
        getContentPane().add(irPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 100, 40));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/85th-academy-awards-the-oscars-85O_OscarVert_LR_rgb_0.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    int valor;
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       //this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void irActoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irActoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_irActoresActionPerformed

    private void irPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irPeliculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_irPeliculasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public java.awt.Button btnSalir;
    public javax.swing.JButton irActores;
    public javax.swing.JButton irPeliculas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.Label label11;
    private java.awt.Label label9;
    // End of variables declaration//GEN-END:variables
}
