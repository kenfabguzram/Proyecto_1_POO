/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.awt.Color;
import java.util.Random;
/**
 *
 * @author Kendall_Guzmán
 */
public class Amenaza extends Cuadricula{
    Random rnd;
    private int numero;
    public Amenaza(int fila,int columna,int numero){
        super(fila,columna);
        this.numero=numero;
        rnd=new Random();
        setAmenaza(true);
        setBackground(Color.red);
        vida=10;
    }
    public Cuadricula[][] actionPerformed(Cuadricula[][] mapa){
        if (vida==0){    
            if(numero==1){
                mapa=eliminarAmenaza(mapa, fila, columna);
                mapa=colocarAmenaza(mapa);
            }
            if(numero==2){
                mapa=eliminarAmenaza(mapa, fila-1, columna);
                mapa=colocarAmenaza(mapa);
            }
            if(numero==3){
                mapa=eliminarAmenaza(mapa, fila, columna-1);
                mapa=colocarAmenaza(mapa);
            }
            if(numero==4){
                mapa=eliminarAmenaza(mapa, fila-1, columna-1);
                mapa=colocarAmenaza(mapa);
            }
        }
        return mapa;
    }
    private Cuadricula[][] colocarAmenaza(Cuadricula[][] mapa){
        int fila;
        int columna;
        int i=0;
        while(i<4){
            fila=rnd.nextInt(48 - 1 + 1) + 1;      
            columna=rnd.nextInt(48 - 1 + 1) + 1;
            if (mapa[fila][columna].isVacio()
            &mapa[fila+1][columna].isVacio()
            &mapa[fila][columna+1].isVacio()
            &mapa[fila+1][columna+1].isVacio()){
                mapa[fila][columna]=new Amenaza(fila,columna,1);
                mapa[fila+1][columna]=new Amenaza(fila+1,columna,2);
                mapa[fila][columna+1]=new Amenaza(fila,columna+1,3);
                mapa[fila+1][columna+1]=new Amenaza(fila+1,columna+1,4);
                i=i+4;

            }
        }
        return mapa;
    }
    private Cuadricula[][] eliminarAmenaza(Cuadricula[][] mapa,int fila,int columna){
        mapa[fila][columna]=new Cuadricula(fila,columna);
        mapa[fila+1][columna]=new Cuadricula(fila+1,columna);
        mapa[fila][columna+1]=new Cuadricula(fila,columna+1);
        mapa[fila+1][columna+1]=new Cuadricula(fila+1,columna+1);
        return mapa;
    }

}
