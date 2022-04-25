package Vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Interfaz extends JFrame implements ActionListener {
    Mapa mapa;
    JPanel panelBoton;
    JButton boton;
    
   public Interfaz(){
        super();
        inicializarComponentes();
        agregarComponentes();
        configurarComponentes();    
   }
   private void inicializarComponentes(){
       mapa = new Mapa();
       panelBoton= new JPanel(new GridLayout(1,1));
       boton=new JButton("Siguiente acción");

   }
   private void configurarComponentes(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1300,700));
        pack();
        setVisible(true);
   }
   private void agregarComponentes(){
        panelBoton.add(boton);
        boton.addActionListener(this);
        add(mapa,BorderLayout.CENTER);
        add(panelBoton,BorderLayout.EAST);
   }

   @Override
   public void actionPerformed(ActionEvent e){
        mapa.actionPerformed();
   }

   
 
   
}