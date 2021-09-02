/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package view;

import controller.FileController;
import controller.GraphController;
import controller.InputController;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import model.Graph;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public final class MainView extends javax.swing.JFrame {

    boolean isSave;
    FileController fileController = new FileController();
    String curDir = System.getProperty("user.home"); // curDir store folder that open recently
    UndoManager undoManager = new UndoManager();
    Graph graph;
    GraphController canvas = new GraphController();

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        checkSave();
        initDocumentListener();
        this.setTitle("Untitled.txt");
        pnDisplay.setLayout(new BorderLayout());
        pnDisplay.add(canvas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGraphName = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        pnDisplay = new javax.swing.JPanel();
        btnVisualize = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_File = new javax.swing.JMenu();
        mnNew = new javax.swing.JMenuItem();
        mnOpen = new javax.swing.JMenuItem();
        mnSave = new javax.swing.JMenuItem();
        mnSaveAs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGraphName.setText("Graph");

        btnSave.setText("Save graph as Image");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtInput.setColumns(20);
        txtInput.setRows(5);
        txtInput.setText("TrafficLight{\n\t//vertices\n\tR [label=\"RED\",color=\"red\"]\n\tG [label=\"GREEN\",color=\"green\"]\n\tY [label=\"YELLOW\",color=\"yellow\"]\n\t\n\t//edges\n\tR->G [label=\"45\"]\n\tG->Y [label=\"65\"]\n\tY->R [label=\"5\"]\n}");
        jScrollPane1.setViewportView(txtInput);

        pnDisplay.setBackground(new java.awt.Color(255, 255, 255));
        pnDisplay.setPreferredSize(new java.awt.Dimension(450, 470));

        javax.swing.GroupLayout pnDisplayLayout = new javax.swing.GroupLayout(pnDisplay);
        pnDisplay.setLayout(pnDisplayLayout);
        pnDisplayLayout.setHorizontalGroup(
            pnDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        pnDisplayLayout.setVerticalGroup(
            pnDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        btnVisualize.setText("Visualize");
        btnVisualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizeActionPerformed(evt);
            }
        });

        jMenu_File.setText("File");

        mnNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnNew.setText("New");
        mnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNewActionPerformed(evt);
            }
        });
        jMenu_File.add(mnNew);

        mnOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnOpen.setText("Open");
        mnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenActionPerformed(evt);
            }
        });
        jMenu_File.add(mnOpen);

        mnSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnSave.setText("Save");
        mnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveActionPerformed(evt);
            }
        });
        jMenu_File.add(mnSave);

        mnSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnSaveAs.setText("Save As");
        mnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveAsActionPerformed(evt);
            }
        });
        jMenu_File.add(mnSaveAs);

        jMenuBar1.add(jMenu_File);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVisualize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(196, 196, 196)
                            .addComponent(btnClose)
                            .addContainerGap())
                        .addComponent(lblGraphName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblGraphName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btnVisualize, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * action when click button Close
     *
     * @param evt
     */
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        initExit();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnVisualizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizeActionPerformed
        try {
            InputController inputController = new InputController(txtInput.getText());
            graph = inputController.getGraphData();
            graph.setName(inputController.getNameGraph());
            lblGraphName.setText("Graph - " + inputController.getNameGraph());
            graph.setCoorinateForListVertex();

            canvas.setEnabled(true);
            canvas.setGraph(graph);
            canvas.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVisualizeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if(graph == null){
                JOptionPane.showMessageDialog(this, "You haven't drawn anything yet!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            saveGraphAsImage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void mnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNewActionPerformed
        if (isSave) {
            newFile();
        } else {
            int opt = JOptionPane.showConfirmDialog(this,
                    "Do you want to save changes to " + this.getTitle() + " ?",
                    "My Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                fileController.saveFile(curDir + "\\" + getTitle(), txtInput.getText());
                newFile();
            } else if (opt == JOptionPane.NO_OPTION) {
                newFile();
            }
        }
    }//GEN-LAST:event_mnNewActionPerformed

    private void mnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOpenActionPerformed
        if (isSave) {
            openFile();
        } else {
            int opt = JOptionPane.showConfirmDialog(this,
                    "Do you want to save changes to " + this.getTitle() + " ?",
                    "My Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                fileController.saveFile(curDir + "\\" + getTitle(), txtInput.getText());
                openFile();
            } else if (opt == JOptionPane.NO_OPTION) {
                openFile();
            }
        }
    }//GEN-LAST:event_mnOpenActionPerformed

    private void mnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveActionPerformed
        isSave = true;
        fileController.saveFile(curDir + "\\" + getTitle(), txtInput.getText());
    }//GEN-LAST:event_mnSaveActionPerformed

    private void mnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveAsActionPerformed
        JFileChooser chooser = new JFileChooser(curDir);
        chooser.setDialogTitle("Save as");
        /* add default JFileChooser is txt file */
        chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
        /* yes option*/
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String filepath = chooser.getSelectedFile().getPath() + ".txt";
            fileController.saveFile(filepath, txtInput.getText());
            this.setTitle(chooser.getSelectedFile().getName());
        }
    }//GEN-LAST:event_mnSaveAsActionPerformed

    public void newFile() {
        setTitle("Untitled.txt");
        isSave = true;
        txtInput.setText("");
    }

    public void initExit() {
        if (isSave) {
            System.exit(0);
        } else {
            int opt = JOptionPane.showConfirmDialog(this,
                    "Do you want to save changes to " + getTitle() + " ?",
                    "My Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                fileController.saveFile(curDir + "\\" + this.getTitle(), txtInput.getText());
            } else if (opt == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }

    private void openFile() {
        JFileChooser chooser = new JFileChooser(curDir);
        chooser.setDialogTitle("Open");

        /* add default JFileChooser is txt file */
        chooser.setFileFilter(new FileNameExtensionFilter("*.txt", ".txt"));
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            txtInput.setText("");
            /* get path of choose file*/
            String filePath = chooser.getSelectedFile().getPath();
            /* set name of Frame*/
            setTitle(chooser.getSelectedFile().getName());
            /* display in to txtDisplay*/
            txtInput.setText(fileController.getFileContent(filePath));
            txtInput.setCaretPosition(0);
            isSave = true;
        }
    }

    public void checkSave() {
        isSave = !undoManager.canUndo();
    }

    public void initDocumentListener() {
        txtInput.getDocument().addUndoableEditListener((UndoableEditEvent e) -> {
            undoManager.addEdit(e.getEdit());
            checkSave();
        });
        txtInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkSave();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkSave();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkSave();
            }
        });
    }

    public void saveGraphAsImage() throws IOException {
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        canvas.paint(graphics2D);
        canvas.analyzeDrawing(graphics2D);
        JFileChooser chooser = new JFileChooser(curDir);
        chooser.setDialogTitle("Save image");

        /* add default JFileChooser is png file */
        chooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        /* yes option */
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String filePath = chooser.getSelectedFile().getPath() + ".png";
            ImageIO.write(image, "png", new File(filePath));
        }
    }

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnVisualize;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_File;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGraphName;
    private javax.swing.JMenuItem mnNew;
    private javax.swing.JMenuItem mnOpen;
    private javax.swing.JMenuItem mnSave;
    private javax.swing.JMenuItem mnSaveAs;
    private javax.swing.JPanel pnDisplay;
    private javax.swing.JTextArea txtInput;
    // End of variables declaration//GEN-END:variables
}