package Todo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * clase para modelar una ordenacion, donde tambien guarda cuanto duro.
 * @author ACR
 */
public class Ordenacion {
    int[] valores;
    long tiempoDeDuracion;

    //constructor
    public Ordenacion(int[] valores)
    {
        this.valores=valores;
    }
    //getters
    public int[] getValores() {
        return valores;
    }
    public long getTiempoDeDuracion() {
        return tiempoDeDuracion;
    }
    
    //setters
    public void setValores(int[] valores) {
        this.valores = valores;
    }
    public void setTiempoDeDuracion(long tiempoDeDuracion) {
        this.tiempoDeDuracion = tiempoDeDuracion;
    }

   
    
}
