package ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funciones.Receta;

public class GuiAgregarReceta extends JFrame implements ActionListener {

    protected JPanel jPanel1;
    protected JLabel jLabel1;
    protected JTextField t1;

    protected JPanel jPanel2;
    protected JButton bAgrIng;

    public GuiAgregarReceta(String title) {

        super(title);
        this.setLayout(new FlowLayout());

        jPanel1 = new JPanel();
        jLabel1 = new JLabel("Nombre");
        t1 = new JTextField("nombre");

        jPanel2 = new JPanel();
        bAgrIng = new JButton("Agregar Ingredientes");
        bAgrIng.addActionListener(this);

        jPanel1.add(jLabel1);
        jPanel1.add(t1);

        jPanel2.add(bAgrIng);

        this.add(jPanel1);
        this.add(jPanel2);

        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 150);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bAgrIng) {
            Receta receta = new Receta();
            String nombre = t1.getText();
            receta.setNombre(nombre);

            GuiInputIng guiIng = new GuiInputIng("Ingredientes", receta);
            guiIng.setVisible(true);
        }

    }
}
