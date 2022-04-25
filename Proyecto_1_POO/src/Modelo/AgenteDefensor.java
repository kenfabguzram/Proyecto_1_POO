/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Kendall_Guzmán
 */
public class AgenteDefensor extends AgenteBase{
    public AgenteDefensor(int fila,int columna){
        super(fila,columna);
    }
    protected AgenteBase retornarAgente(int fila, int columna){
        return new AgenteDefensor(fila,columna);
    }
    protected Cuadricula[][] reaccionarAAmenaza(Cuadricula[][] mapa){return mapa;}
    protected void reaccionarAAmenaza2(int direccion){
        if(direccion==0)
            cambiarDireccionIzquierdaArriba();
        if(direccion==1)
            setIndiceDireccion(0);
        if(direccion==2)
            cambiarDireccionDerechaArriba();
        if(direccion==3)
            setIndiceDireccion(1);
        if(direccion==4)
            setIndiceDireccion(3);
        if(direccion==5)
            cambiarDireccionIzquierdaAbajo();
        if(direccion==6)
            setIndiceDireccion(2);
        if(direccion==7)
            cambiarDireccionDerechaAbajo();
    }

}
