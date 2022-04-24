
package Vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

import Modelo.Amenaza;
import Modelo.Base;
import Modelo.Cuadricula;
import Modelo.Obstaculo;
import Modelo.Recurso;

/**
 *
 * @author Kendall_Guzmán
 */
public class Mapa extends JPanel{ 
    
    Cuadricula[][] mapa = new Cuadricula [50][50];
    Random rnd;
    Mapa(){
        super(new GridLayout(50,50));
        rnd=new Random();
        generarCuadriculas();

        colocarObstaculos();
        colocarRecursos();
        colocarAmenazas();
        colocarBase();
        cambiarColoresCuadriculas();
        agregarCuadriculasAlPanel();

    }
    private void generarCuadriculas(){
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){
                    mapa[i][j] = new Cuadricula(i,j);
            }
        }
    }
    private void colocarObstaculos(){
        int fila;
        int columna;
        int i=0;
        while(i<40){
            fila=rnd.nextInt(48 - 1 + 1) + 1;      
            columna=rnd.nextInt(48 - 1 + 1) + 1;
            if (mapa[fila][columna].isVacio()
            &mapa[fila+1][columna].isVacio()
            &mapa[fila][columna+1].isVacio()
            &mapa[fila+1][columna+1].isVacio()){
                colocarObstaculo(fila, columna,i);
                i=i+4;

            }
        }
    }
    private void colocarRecursos(){
        int fila;
        int columna;
        int i=0;
        while(i<40){
            fila=rnd.nextInt(48 - 1 + 1) + 1;      
            columna=rnd.nextInt(48 - 1 + 1) + 1;
            if (mapa[fila][columna].isVacio()
            &mapa[fila+1][columna].isVacio()
            &mapa[fila][columna+1].isVacio()
            &mapa[fila+1][columna+1].isVacio()){
                colocarRecurso(fila, columna,i);
                i=i+4;

            }
        }
    }
    private void colocarAmenazas(){
        int fila;
        int columna;
        int i=0;
        while(i<40){
            fila=rnd.nextInt(48 - 1 + 1) + 1;      
            columna=rnd.nextInt(48 - 1 + 1) + 1;
            if (mapa[fila][columna].isVacio()
            &mapa[fila+1][columna].isVacio()
            &mapa[fila][columna+1].isVacio()
            &mapa[fila+1][columna+1].isVacio()){
                colocarAmenaza(fila, columna,i);
                i=i+4;

            }
        }
    }
    private void colocarBase(){
        mapa[0][0]=new Base();
    }
    private void agregarCuadriculasAlPanel(){
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){
                add(mapa[i][j]);
            }
        }
    }
    public void actionPerformed(){
        removeAll();
        revalidate();
        repaint();
        actualizarDatosCuadriculas();
        
        cambiarColoresCuadriculas();
        agregarCuadriculasAlPanel();
        repaint();
    }
    private void actualizarDatosCuadriculas(){
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){
                mapa=mapa[i][j].actionPerformed(mapa);
            }
        }
    }
    private void cambiarColoresCuadriculas(){
        for(int i = 0; i < 50; i++){
                for(int j = 0; j < 50; j++){
                    if (mapa[i][j].isVacio())
                        mapa[i][j].setBackground(Color.white);
                    if (mapa[i][j].isAgente()||mapa[i][j].isBase())
                        mapa[i][j].setBackground(Color.black);
                    if (mapa[i][j].isAmenaza())
                        mapa[i][j].setBackground(Color.red);
                    if (mapa[i][j].isObstaculo())
                        mapa[i][j].setBackground(Color.lightGray);
                }
         }
    }

    private void colocarAmenaza(int fila,int columna, int n){
            mapa[fila][columna]=new Amenaza(fila,columna,1);
            mapa[fila+1][columna]=new Amenaza(fila+1,columna,2);
            mapa[fila][columna+1]=new Amenaza(fila,columna+1,3);
            mapa[fila+1][columna+1]=new Amenaza(fila+1,columna+1,4);
    }
    private void colocarObstaculo(int fila,int columna,int n){
        mapa[fila][columna]=new Obstaculo(fila,columna);
        mapa[fila+1][columna]=new Obstaculo(fila+1,columna);
        mapa[fila][columna+1]=new Obstaculo(fila,columna+1);
        mapa[fila+1][columna+1]=new Obstaculo(fila+1,columna+1);


    }
    private void colocarRecurso(int fila,int columna,int n){
        mapa[fila][columna]=new Recurso(fila,columna,1);
        mapa[fila+1][columna]=new Recurso(fila+1,columna,2);
        mapa[fila][columna+1]=new Recurso(fila,columna+1,3);
        mapa[fila+1][columna+1]=new Recurso(fila+1,columna+1,4); 
    }
}
