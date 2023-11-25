/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MDO;

import Todo.Ordenacion;
import java.io.FileWriter;
import java.io.IOException;

/**
 *clase para realizar los experimentos de ordenar con mergesort y guardar los resultados en un CSV
 * @author ACR
 */
public final class MDOMergeSort implements MetodoDeOrdenamiento {
 FileWriter datos;
    Ordenacion[] normal;
    Ordenacion[] ordenado;
    Ordenacion[] alrevez;
    long startTime;
    long endTime;
    //constructor
    public MDOMergeSort(Ordenacion[] normal,Ordenacion[] ordenado,Ordenacion[] alrevez) {
        
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
        datos = new FileWriter("src//resources//resultados_mergesort.txt");  
        } catch(IOException e){ 
            System.out.println("Y archivo?");
        }
        datos.write("""
                    RESULTADOS DE EXPERIMENTOS CON MERGESORT
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
    mergeSort(valores,valores.length);    
    }
    
    public void mergeSort(int[] valores,int longitud)
    {
    if(longitud<2)return;//si solo hay 1 elemento, no hacer nada
    int mid = longitud / 2;
    int[] left = new int[mid];//divide el arreglo
    int[] right = new int[longitud-mid];
    for(int i=0;i<mid;i++)left[i]=valores[i];
    for(int i=mid;i<longitud;i++)right[i-mid]=valores[i];
    mergeSort(left,mid);
    mergeSort(right,longitud-mid);//hacer lo mismo con las mitades
    merge(valores,left,right,mid,longitud-mid);
    }
    
    public void merge
        (int[] valores,int[] leftV,int[] rightV,int leftL,int rightL)
    {
        int i=0,j=0,k=0;
        while(i<leftL && j<rightL)//decidir orden
        {
            if(leftV[i]<=rightV[j])
            { 
                valores[k]=leftV[i];
                k++;i++;
            }
            else
            {
                valores[k]=rightV[j];
                k++;j++;
            }
        }
        while(i<leftL)//por si se acaban los elementos de uno de los lados
        {
            valores[k]=leftV[i];
            k++;i++;
        }
        while(j<rightL)
        {
            valores[k]=rightV[j];
            k++;j++;
        }
    }
}
