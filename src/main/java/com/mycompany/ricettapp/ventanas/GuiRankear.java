package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.GestorJSON;
import com.mycompany.ricettapp.funciones.Receta;
import com.mycompany.ricettapp.funciones.Recetario;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiRankear extends JFrame implements ActionListener {

    protected JPanel panel;
    protected JButton oneStar;
    protected JButton twoStar;
    protected JButton threeStar;
    protected JButton fourStar;
    protected JButton fiveStar;
    private int indice;

    public GuiRankear(String title, int indice) {
        super(title);
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        this.indice= indice;

        this.panel = new JPanel();
        //botones
        this.oneStar = new JButton("1 Star");
        this.twoStar = new JButton("2 Star");
        this.threeStar = new JButton("3 Star");
        this.fourStar = new JButton("4 Star");
        this.fiveStar = new JButton("5 Star");

        this.oneStar.addActionListener(this);
        this.twoStar.addActionListener(this);
        this.threeStar.addActionListener(this);
        this.fourStar.addActionListener(this);
        this.fiveStar.addActionListener(this);

        panel.add(oneStar);
        panel.add(twoStar);
        panel.add(threeStar);
        panel.add(fourStar);
        panel.add(fiveStar);

        this.add(panel);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == oneStar) {
            Recetario recetario = new Recetario();
            double valor = 1;
            recetario.recetas.get(indice).rankear(valor);
            try {                
                Receta receta = recetario.recetas.get(indice);
                GestorJSON.borrarRecetaArchivo(recetario.recetas.get(indice).getNombre());
                GestorJSON.agregarRecetaArchivo(receta);
                 
            } catch (IOException ex) {
                //error
            }
            setVisible(false);
        }
        if (e.getSource() == twoStar) {
            double valor = 2;
            Recetario recetario = new Recetario();
            recetario.recetas.get(indice).rankear(valor);
             try {                
                Receta receta = recetario.recetas.get(indice);
                GestorJSON.borrarRecetaArchivo(recetario.recetas.get(indice).getNombre());
                GestorJSON.agregarRecetaArchivo(receta);
                 
            } catch (IOException ex) {
                //error
            }
            setVisible(false);
        }
        if (e.getSource() == threeStar) {
            double valor = 3;
            Recetario recetario = new Recetario();
            recetario.recetas.get(indice).rankear(valor);
             try {                
                Receta receta = recetario.recetas.get(indice);
                GestorJSON.borrarRecetaArchivo(recetario.recetas.get(indice).getNombre());
                GestorJSON.agregarRecetaArchivo(receta);
                 
            } catch (IOException ex) {
                //error
            }
            setVisible(false);
        }
        if (e.getSource() == fourStar) {
            double valor = 4;
            Recetario recetario = new Recetario();
            recetario.recetas.get(indice).rankear(valor);
             try {                
                Receta receta = recetario.recetas.get(indice);
                GestorJSON.borrarRecetaArchivo(recetario.recetas.get(indice).getNombre());
                GestorJSON.agregarRecetaArchivo(receta);
                 
            } catch (IOException ex) {
                //error
            }
            setVisible(false);
        }
        if (e.getSource() == fiveStar) {
            double valor = 5;
            Recetario recetario = new Recetario();
            recetario.recetas.get(indice).rankear(valor);
             try {                
                Receta receta = recetario.recetas.get(indice);
                GestorJSON.borrarRecetaArchivo(recetario.recetas.get(indice).getNombre());
                GestorJSON.agregarRecetaArchivo(receta);
                 
            } catch (IOException ex) {
                //error
            }
            setVisible(false);
        }
    }

}
