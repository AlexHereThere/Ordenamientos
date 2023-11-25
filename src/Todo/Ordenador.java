/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Todo;

import MDO.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Stack;

/**
 *clase para realizar todos los experimentos,aqui se generan los valores que se ordenaran
 * @author ACR
 */
public final class Ordenador {
    final int LONGITUDES_DE_ARREGLO[] = {100,500,1000,1500,2000,3000,4000,5000,7000,10000};
    final int NUM_ARREGLOS = 10;
    //constructor
    public Ordenador() throws IOException
    {
    File fileOS = new File("src//resources//resultados_quicksort.txt");
    File fileMS = new File("src//resources//resultados_mergesort.txt");
    File fileS = new File("src//resources//resultados_sort.txt");
    File filePS = new File("src//resources//resultados_parallelsort.txt");
    fileOS.createNewFile();
    fileMS.createNewFile();//crear archivos
    fileS.createNewFile();
    filePS.createNewFile();
    }
 
    /**
     * metodo para volver a realizar los experimentos con nuevos valores
     * @throws java.io.IOException
     */
    public void realizarExperimentos() throws IOException
    {
      Ordenacion[] original = new Ordenacion[NUM_ARREGLOS];
       Random rmd = new Random();
       int i=0;//iterador para ordenaciones
       for(int longitud :LONGITUDES_DE_ARREGLO)
       {
            int[] valores = new int[longitud]; //crear los arreglos
            for(int j=0;j<valores.length;j++)
            {
           valores[j] = rmd.nextInt();
            }
            original[i] = new Ordenacion(valores.clone());
            i++;
       }
       Ordenacion[] ordenado = regresarOrdenado(original.clone());
       Ordenacion[] volteado = regresarVolteado(ordenado.clone());
       
       
       MDOMergeSort mergesort = new MDOMergeSort(original.clone(),ordenado.clone(),volteado.clone());
       mergesort.actualizarArchivo();
       MDOSort javasort = new MDOSort(original.clone(),ordenado.clone(),volteado.clone());
       javasort.actualizarArchivo();
       MDOParallelSort parallelsort = new MDOParallelSort(original.clone(),ordenado.clone(),volteado.clone());  
       parallelsort.actualizarArchivo();
       MDOQuickSort quicksort = new MDOQuickSort(original.clone(),ordenado.clone(),volteado.clone());
       quicksort.actualizarArchivo();
       
    }
    //metodo para regresar el original ordenado
    public Ordenacion[] regresarOrdenado(Ordenacion[] viejo)
    {
        Ordenacion[] nuevo = new Ordenacion[viejo.length];//crear nuevo
        for (int i=0;i<nuevo.length;i++) 
        {
            int[] valores = viejo[i].getValores(); //se crea nuevo arreglo de los valores aleatorios del original
            quickSortConNums(valores,valores.length);//ordena los valores
            nuevo[i] = new Ordenacion(valores);
        }
        return nuevo;
    }
    
      /**
       * metodo de ordenamiento quicksort para nums
       * @param datos
       * @param numElementos 
       */
    //se decidio ordenar con quicksort para los valores ordenados
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
    /**
     * metodo para voltear los arreglos originales y crear nuevos en base eso
     * @param viejo
     * @return 
     */
    public Ordenacion[] regresarVolteado(Ordenacion[] viejo)
    {
      Ordenacion[] nuevo = new Ordenacion[viejo.length];//crear nuevo
      for (int i=0;i<nuevo.length;i++) 
      {
        int[] valores = viejo[i].getValores(); //se crea nuevo arreglo de los valores ordenados  
        voltearOrden(valores);
        nuevo[i] = new Ordenacion(valores);
      }
      return nuevo;
    }
    /**
     * metodo para voltear orden del un arreglo numerico
     * @param valores 
     */
    public void voltearOrden(int[] valores)
    {
        Stack<Integer> nuevo = new Stack<>();//uso de pila para invertir orden
        for(int i=0;i<valores.length;i++)nuevo.push(valores[i]);
        for(int j=0;j<valores.length;j++)valores[j]=nuevo.pop();
    }
}


