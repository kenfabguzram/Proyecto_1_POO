/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.awt.Color;
/**
 *
 * @author Kendall_Guzmán
 */
public class Obstaculo extends Cuadricula {
    public Obstaculo(int fila,int columna){
        super(fila,columna);
        setObstaculo(true);
        setBackground(Color.lightGray);
    }
    
}
