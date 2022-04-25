/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Random;

/**
 *
 * @author Kendall_Guzmán
 */
public class AgenteBase extends Cuadricula{
    protected Random rnd;
    protected int[] direccionesFila;
    protected int[] direccionesColumna;
    protected int[] direccionesFila8;
    protected int[] direccionesColumna8;
    public AgenteBase(int fila,int columna){
        super(fila,columna);
        setAgente(true);
        direccionesFila=new int[]{-1,0,1,0};
        direccionesColumna=new int[]{0,-1,0,1};
        direccionesFila8=new int[]{-1,-1,-1,0,0,1,1,1};
        direccionesColumna8=new int[]{-1,0,1,-1,1,-1,0,1};
        rnd=new Random();
        cambiarDireccionDerechaAbajo();
    }
    public Cuadricula[][] actionPerformed(Cuadricula[][] mapa){

        if(fila<49 & fila>0 & columna<49 & columna>0){
            mapa=validarCuadriculasAdyacentes(mapa,0,8,9,10,10);
        }
        if (fila==0){
            if(columna==49){
                mapa=validarCuadriculasAdyacentes(mapa,3,7,4,-1,-1);
            }
            if(columna==0){
                mapa=validarCuadriculasAdyacentes(mapa,3,7,4,-1,-1);
            }
            else{
                mapa=validarCuadriculasAdyacentes(mapa,3,8,9,-1,-1);
            }
        }
        if (fila==49){
            if(columna==0){
                mapa=validarCuadriculasAdyacentes(mapa,1,5,3,-1,-1);
            }
            if (columna==49){
                mapa=validarCuadriculasAdyacentes(mapa,0,4,2,-1,-1);
            }
            else{
                mapa=validarCuadriculasAdyacentes(mapa,0,5,6,-1,-1);
            }
        }
        else{
            if(columna==0){
                mapa=validarCuadriculasAdyacentes(mapa,1,8,0,3,5);
            }
            if (columna==49){
                mapa=validarCuadriculasAdyacentes(mapa,0,7,2,4,7);
            }
        }
        mapa=caminar(mapa);
        return mapa;
    }
    protected Cuadricula[][] validarCuadriculasAdyacentes(Cuadricula[][] mapa,int inicio,int finalizar,int excluir1,int excluir2,int excluir3){
        for (int i=inicio;i<finalizar;i++){
            if (i!=excluir1 & i!=excluir2 & i!=excluir3){
                System.out.println("------------------------------------------------------------------------");
                System.out.println(fila);
                System.out.println(columna);
                System.out.println(i);
                System.out.println(direccionesFila8[i]);
                System.out.println(direccionesColumna8[i]);
                if(mapa[fila+direccionesFila8[i]][columna+direccionesColumna8[i]].isAgente()){
                    if (isRecurso()){
                        if(mapa[fila+direccionesFila8[i]][columna+direccionesColumna8[i]].isRecurso()){
                            setIndiceDireccion(mapa[fila+direccionesFila8[i]][columna+direccionesColumna8[i]].getIndiceDireccion());
                        }
                    }
                }
                else if(mapa[fila+direccionesFila8[i]][columna+direccionesColumna8[i]].isRecurso()){
                    if (i==0)
                        cambiarDireccionIzquierdaArriba();
                    if (i==1)
                        setIndiceDireccion(0);
                    if (i==2)
                        cambiarDireccionDerechaArriba();
                    if (i==3)
                        setIndiceDireccion(1);
                    if (i==4)
                        setIndiceDireccion(3);
                    if (i==5)
                        cambiarDireccionIzquierdaAbajo();
                    if (i==6)
                        setIndiceDireccion(2);
                    if (i==7)
                        cambiarDireccionDerechaAbajo();
                }
                if(mapa[fila+direccionesFila8[i]][columna+direccionesColumna8[i]].isAmenaza()){
                    reaccionarAAmenaza2(i);
                }
            }
        }
        return mapa;
    }
    protected Cuadricula[][] caminar(Cuadricula[][] mapa){
        if(fila+direccionesFila[indiceDireccion]>=0 & fila+direccionesFila[indiceDireccion]<=49
        & columna+direccionesColumna[indiceDireccion]>=0 & columna+direccionesColumna[indiceDireccion]<=49){
            Cuadricula obs=mapa[fila+direccionesFila[indiceDireccion]][columna+direccionesColumna[indiceDireccion]];
            
            if(obs.isVacio()){
                mapa=reaccionarAVacio(mapa);
            }
            else if(obs.isAgente()){
                if(obs.isRecurso()){
                    mapa=reaccionarAAgenteConRecurso(mapa);
                }
                else{
                    mapa=reaccionarAAgenteSinRecurso(mapa);
                }
            }
            else if(obs.isRecurso()){
                mapa=reaccionarARecurso(mapa);
            }
            else if(obs.isObstaculo()){
                mapa=reaccionarAObstaculo(mapa);
            }
            else if(obs.isAmenaza()){
                mapa=reaccionarAAmenaza(mapa);
            }
            else if(obs.isBase()){
                mapa=reaccionarABase(mapa);
            }
            return mapa;
        }
        else{
            if(indiceDireccion==0)
            cambiarDireccionDerechaAbajo();
            if(indiceDireccion==1)
                setIndiceDireccion(2);
            if(indiceDireccion==2)
                cambiarDireccionIzquierdaAbajo();
            if(indiceDireccion==3)
                setIndiceDireccion(3);
            if(indiceDireccion==4)
                setIndiceDireccion(1);
            if(indiceDireccion==5)
                cambiarDireccionDerechaArriba();
            if(indiceDireccion==6)
                setIndiceDireccion(0);
            if(indiceDireccion==7)
                cambiarDireccionIzquierdaArriba();
            return mapa;
        }
    }
    protected Cuadricula[][] reaccionarAVacio(Cuadricula[][] mapa){

        if (!mapa[fila][columna].isAccionado()){
            mapa[fila+direccionesFila[indiceDireccion]][columna+direccionesColumna[indiceDireccion]]=this.retornarAgente(fila+direccionesFila[indiceDireccion],columna+direccionesColumna[indiceDireccion]);
            mapa[fila+direccionesFila[indiceDireccion]][columna+direccionesColumna[indiceDireccion]].setAccionado(true);
            mapa[fila][columna]=new Cuadricula(fila,columna);
        }
        if(!this.isRecurso()){
            sortearDireccionAzar();
        }
        else{
            cambiarDireccionIzquierdaArriba();
        }
        return mapa;

    }
    protected AgenteBase retornarAgente(int fila,int columna){return new AgenteBase(1,1);}
    protected Cuadricula[][] reaccionarAAgenteConRecurso(Cuadricula[][] mapa){
        Cuadricula obs=mapa[fila+direccionesFila[indiceDireccion]][columna+direccionesColumna[indiceDireccion]];
        if (this.isRecurso())
            setIndiceDireccion(obs.getIndiceDireccion());
        else
            cambiarDireccionAzar();
        mapa=caminar(mapa);
        return mapa;
    }
    protected Cuadricula[][] reaccionarAAgenteSinRecurso(Cuadricula[][] mapa){
        if(this.isRecurso()){
            cambiarDireccionIzquierdaArriba();
        }
        else{
            cambiarDireccionAzar();
        }
        mapa=caminar(mapa);
        return mapa;
    } 
    protected Cuadricula[][] reaccionarARecurso(Cuadricula[][] mapa){
        if (this.isRecurso()){
        setRecurso(true);
        mapa[fila+direccionesFila[indiceDireccion]][columna+direccionesColumna[indiceDireccion]].reducirCantidadRecursos();
        cambiarDireccionIzquierdaArriba();
        }
        else{
            cambiarDireccionAzar();
        }
        mapa=caminar(mapa);
        return mapa;
    }
    protected Cuadricula[][] reaccionarAObstaculo(Cuadricula[][] mapa){
        cambiarDireccionAzar();
        mapa=caminar(mapa);
        return mapa;
    }
    protected Cuadricula[][] reaccionarAAmenaza(Cuadricula[][] mapa){return mapa;}
    protected void reaccionarAAmenaza2(int direccion){}
    protected Cuadricula[][] reaccionarABase(Cuadricula[][] mapa){
        if(this.isRecurso()){
            mapa[0][0].addAgente(this);
            mapa[fila][columna]=new Cuadricula(fila,columna);
        }
        else{
            cambiarDireccionDerechaAbajo();
        }
        return mapa;
    }
    protected void cambiarDireccionDerechaAbajo(){
        indiceDireccion=rnd.nextInt(3 - 2 + 1) + 2;
    }
    protected void cambiarDireccionIzquierdaArriba(){
        indiceDireccion=rnd.nextInt(1 - 0 + 1) + 0;
    }
    protected void cambiarDireccionDerechaArriba(){
        int[] newDesicion={0,3};
        indiceDireccion=newDesicion[rnd.nextInt(1 - 0 + 1) + 0];
    }
    protected void cambiarDireccionIzquierdaAbajo(){
        indiceDireccion=rnd.nextInt(2 - 1 + 1) + 1;
    }
    protected void sortearDireccionAzar(){
        indiceDireccion=rnd.nextInt(3 - 0 + 1) + 0;
    }
    protected void cambiarDireccionAzar(){
        int newDireccion=indiceDireccion;
        while(newDireccion==indiceDireccion){
            indiceDireccion=rnd.nextInt(3 - 0 + 1) + 0;
        }
    }

}
