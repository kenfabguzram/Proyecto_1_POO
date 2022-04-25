
package Modelo;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;

/**
 *
 * @author Kendall_Guzmán
 */
public class Cuadricula extends JLabel{
    protected int fila;
    protected int columna;
    protected int cantidadRecurso;
    protected int vida;
    protected int indiceDireccion;
    protected boolean recurso,obstaculo,amenaza,agente,base,atacando;
    public Cuadricula(int fila,int columna){
        super();
        setOpaque(true);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        recurso=obstaculo=amenaza=agente=base=atacando=false;
        vida=cantidadRecurso=10;
        this.fila=fila;
        this.columna=columna;
    }
    public void addAgente(AgenteBase agente){}
    public Cuadricula[][] actionPerformed(Cuadricula[][] mapa){
        return mapa;
    }
    public void setVacio(){
        setBackground(Color.WHITE);
        recurso=obstaculo=amenaza=agente=false;
        fila=columna=0;
        vida=cantidadRecurso=10;
        fila=0;
        columna=0;
    }
    public boolean isVacio() {
        return (!isAgente()&!isAmenaza()&!isObstaculo()&!isRecurso());
    }
    public void reducirVida(){
        vida--;
    }
    public void reducirCantidadRecursos(){
        cantidadRecurso--;
    }
    public AgenteBase getAgente(){return new AgenteBase(1,1);}
    public int getCantidadAgentesBase(){
        return 0;
    }
    public boolean isBase() {
        return base;
    }
    public void setBase(boolean base) {
        this.base = base;
    }
    
    
    public String getDireccion() {return "";}
    public int getIndiceDireccion() {
        return indiceDireccion;
    }

    public void setIndiceDireccion(int indiceDireccion) {
        this.indiceDireccion = indiceDireccion;
    }
    
    
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
    public int getCantidadRecurso() {
        return cantidadRecurso;
    }
    public void setCantidadRecurso(int cantidadRecurso) {
        this.cantidadRecurso = cantidadRecurso;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public boolean isRecurso() {
        return recurso;
    }
    public void setRecurso(boolean tieneRecurso) {
        this.recurso = tieneRecurso;
    }
    public boolean isObstaculo() {
        return obstaculo;
    }
    public void setObstaculo(boolean tieneObstaculo) {
        this.obstaculo = tieneObstaculo;
    }
    public boolean isAmenaza() {
        return amenaza;
    }
    public void setAmenaza(boolean tieneAmenaza) {
        this.amenaza = tieneAmenaza;
    }
    public boolean isAgente() {
        return agente;
    }
    public void setAgente(boolean tieneAgente) {
        this.agente = tieneAgente;
    }
    
}