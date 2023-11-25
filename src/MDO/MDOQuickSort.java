/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MDO;

import Todo.Ordenacion;
import java.io.FileWriter;
import java.io.IOException;
/**
 *clase para realizar los experimentos de ordenar con quicksort y guardar los resultados en un CSV
 * @author ACR
 */
public final class MDOQuickSort implements MetodoDeOrdenamiento {
    FileWriter datos;
    Ordenacion[] normal;
    Ordenacion[] ordenado;
    Ordenacion[] alrevez;
    long startTime;
    long endTime;
    //constructor
    public MDOQuickSort(Ordenacion[] normal,Ordenacion[] ordenado,Ordenacion[] alrevez) {
        
        this.normal = normal;
        this.ordenado = ordenado;
        this.alrevez = alrevez;
        for(int i=0;i<normal.length;i++)//todos tienen el mismo tamano
        {
            startTime = System.nanoTime();
            ordenar(normal[i].getValores());
            endTime = System.nanoTime();
            normal[i].setTiempoDeDuracion(endTime-startTime);
            
            startTime = System.nanoTime();
            ordenar(ordenado[i].getValores()); //realizar los experimentos con los nuevos valores
            endTime = System.nanoTime();
            ordenado[i].setTiempoDeDuracion(endTime-startTime);
            
            startTime = System.nanoTime();
            ordenar(alrevez[i].getValores());
            endTime = System.nanoTime();
            alrevez[i].setTiempoDeDuracion(endTime-startTime);
        }
    }
    
    /**
     * metodo para actualizar el archivo de datos csv
     * @throws IOException 
     */
    public void actualizarArchivo() throws IOException
    {
        try{
        datos = new FileWriter("src//resources//resultados_quicksort.txt");  
        } catch(IOException e){ 
            System.out.println("Y archivo?");
        }
        datos.write("""
                    RESULTADOS DE EXPERIMENTOS CON QUICKSORT
                    (PARA ANALISIS DE VELOCIDAD DE ALGORITMOS DE ORDENAMIENTO)
                    Experimentos valores Desordenados
                    no. exp,dimension del arreglo,tiempo(ns)
                    """);
        for(int i=0;i<normal.length;i++)
        {
        datos.write(""+(i+1)+","+normal[i].getValores().length+","+normal[i].getTiempoDeDuracion()+"\n");
        }
        datos.write("""
                    Experimentos valores Ordenados
                    no. exp,dimension del arreglo,tiempo(ns)
                    """);
        for(int i=0;i<ordenado.length;i++)
        {
        datos.write(""+(i+1)+","+ordenado[i].getValores().length+","+ordenado[i].getTiempoDeDuracion()+"\n");
        }
         datos.write("""
                    Experimentos valores Ordenado Mayor a Menor
                    no. exp,dimension del arreglo,tiempo(ns)
                    """);
        for(int i=0;i<alrevez.length;i++)
        {
        datos.write(""+(i+1)+","+alrevez[i].getValores().length+","+alrevez[i].getTiempoDeDuracion()+"\n");
        }
        datos.close();
    }
    
    @Override
    public void ordenar(int[] valores) 
    {
    quickSortConNums(valores,valores.length);    
    }
    /**
     * metodo para ordenar con quicksort
     * @param datos
     * @param numElementos 
     */
     public void quickSortConNums(int[] datos,int numElementos)
    {
        recursivoQS(datos,0,numElementos-1);
    }
    
    public void recursivoQS(int[] datos,int inicio,int fin)
    {
        int aux,izq=inicio,der=fin,pos=inicio,b=1;
        while(b==1)
        {
            b=0;
            while(datos[pos]<=datos[der] && pos!=der)
            {
                der=der-1;
            }
            if(pos!=der)
            {
                aux=datos[pos];
                datos[pos]=datos[der];
                datos[der]=aux;
                pos=der;
                while(datos[pos]>=datos[izq] && pos!=izq)
                {
                    izq=izq+1;
                }
                if(pos!=izq)
                {
                    b=1;
                    aux=datos[pos];
                    datos[pos]=datos[izq];
                    datos[izq]=aux;
                    pos=izq;
                }
            }
        }
        if(pos-1>inicio)
        {
            recursivoQS(datos,inicio,pos-1);
        }
        if(fin>pos+1)
        {
            recursivoQS(datos,pos+1,fin);
        }
    }
    
   
}
