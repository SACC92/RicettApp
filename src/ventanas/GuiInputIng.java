package ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funciones.Ingrediente;
import funciones.Receta;

public class GuiInputIng extends JFrame implements ActionListener {

    protected JPanel jPanel1;
    protected JTextField t1;
    protected JButton bAgregar;

    protected JPanel jPanel2;
    protected JButton bPasos;

    protected Receta receta;

    public GuiInputIng(String title, Receta receta) {

        super(title);
        this.setLayout(new FlowLayout());

        bAgregar = new JButton("Agregar Ingrediente");
        bAgregar.addActionListener(this);
        t1 = new JTextField("ingrediente");
        jPanel1 = new JPanel();

        jPanel1.add(t1);
        jPanel1.add(bAgregar);

        bPasos = new JButton("Agregar Instrucciones");
        bPasos.addActionListener(this);
        jPanel2 = new JPanel();

        jPanel2.add(bPasos);

        this.add(jPanel1);
        this.add(jPanel2);
        this.receta = receta;

        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 150);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bAgregar) {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNombre(t1.getText());
            this.receta.getIngredientes().add(ingrediente);
        }

        if (e.getSource() == bPasos) {
            GuiInputPasos guiPasos = new GuiInputPasos("Instrucciones", this.receta);
            setVisible(false);
            guiPasos.setVisible(true);
        }

    }
}
