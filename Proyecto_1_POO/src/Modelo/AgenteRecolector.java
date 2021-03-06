/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Kendall_Guzmán
 */
public class AgenteRecolector extends AgenteBase{
    public AgenteRecolector(int fila,int columna){
        super(fila,columna);
    }
    protected AgenteBase retornarAgente(int fila, int columna){
        if(fila==0 & columna==0){
            System.out.println("Este es un agente recolector imposible");
        }
        return new AgenteRecolector(fila,columna);
    }
    protected Cuadricula[][] reaccionarAAmenaza(Cuadricula[][] mapa){
        if(indiceDireccion==0)
            setIndiceDireccion(2);
        if(indiceDireccion==1)
            setIndiceDireccion(3);
        if(indiceDireccion==2)
            setIndiceDireccion(0);
        if(indiceDireccion==3)
            setIndiceDireccion(1);
        mapa=caminar(mapa);
        return mapa;
    }
    protected void reaccionarAAmenaza2(int direccion){
        if(direccion==0)
            cambiarDireccionDerechaAbajo();
        if(direccion==1)
            setIndiceDireccion(2);
        if(direccion==2)
            cambiarDireccionIzquierdaAbajo();
        if(direccion==3)
            setIndiceDireccion(3);
        if(direccion==4)
            setIndiceDireccion(1);
        if(direccion==5)
            cambiarDireccionDerechaArriba();
        if(direccion==6)
            setIndiceDireccion(0);
        if(direccion==7)
            cambiarDireccionIzquierdaArriba();
    }
}