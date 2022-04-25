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
public class Recurso extends Cuadricula{
    Random rnd;
    private int numero;
    public Recurso(int fila,int columna,int numero){
        super(fila,columna);
        rnd=new Random();
        this.numero=numero;
        setRecurso(true);
        setBackground(Color.green);
        cantidadRecurso=10;
    }
    public Cuadricula[][] actionPerformed(Cuadricula[][] mapa){
        if (vida==0){    
            if(numero==1){
                eliminarRecurso(mapa, fila, columna);
                colocarRecursos(mapa);
            }
            if(numero==2){
                eliminarRecurso(mapa, fila-1, columna);
                colocarRecursos(mapa);
            }
            if(numero==3){
                eliminarRecurso(mapa, fila, columna-1);
                colocarRecursos(mapa);
            }
            if(numero==4){
                eliminarRecurso(mapa, fila-1, columna-1);
                colocarRecursos(mapa);
            }
        }
        return mapa;
    }
    private void colocarRecursos(Cuadricula[][] mapa){
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
                mapa[fila][columna]=new Recurso(fila,columna,1);
                mapa[fila+1][columna]=new Recurso(fila+1,columna,2);
                mapa[fila][columna+1]=new Recurso(fila,columna+1,3);
                mapa[fila+1][columna+1]=new Recurso(fila+1,columna+1,4);
                i=i+4;

            }
        }
    }
    private void eliminarRecurso(Cuadricula[][] mapa,int fila,int columna){
        mapa[fila][columna]=new Cuadricula(fila,columna);
        mapa[fila+1][columna]=new Cuadricula(fila+1,columna);
        mapa[fila][columna+1]=new Cuadricula(fila,columna+1);
        mapa[fila+1][columna+1]=new Cuadricula(fila+1,columna+1);
    }

}

