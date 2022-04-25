package Modelo;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Random;
public class Base extends Cuadricula{
    private ArrayDeque<AgenteBase> agentes;
    Random rnd;
    public Base(){
        super(0,0);
        this.setBase(true);
        this.setBackground(Color.black);
        rnd=new Random();
        agentes=new ArrayDeque<AgenteBase>(); 
        for(int i=0;i<20;i++){
            int azar=rnd.nextInt(1 - 0 + 1) + 0;
            if(azar==0){
                agentes.add(new AgenteDefensor(0,0));
            }
            else{
                agentes.add(new AgenteRecolector(0,0));
            }
        }
    }
    public Cuadricula[][] actionPerformed(Cuadricula[][] mapa){
        if(mapa[0][0].getCantidadAgentesBase()>0){
            if (mapa[0][1].isVacio()){
                mapa[0][1]=mapa[0][0].getAgente();
                mapa[0][1].setColumna(1);
            }
            if (mapa[1][0].isVacio()){
                mapa[1][0]=mapa[0][0].getAgente();
                mapa[1][0].setFila(1);
            }
        }
        return mapa;
    }
    public void addAgente(AgenteBase agente){
        if (agente.isRecurso()){
            agentes.add(agente);
        }
    }
    public AgenteBase getAgente(){
        AgenteBase agente=agentes.poll();
        agente.setRecurso(false);
        return agente;
    }
    public int getCantidadAgentesBase(){
        return agentes.size();
    }
}
