/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Todo;

import java.io.File;
import java.io.IOException;

/**
 *clase para probar cosas del programa
 * @author ACR
 */
public class Demo {
    public static void main(String[] args) throws IOException
    {
       
//        try (FileWriter filew = new FileWriter(file)) {
//            filew.write("""
//                                    RESULTADOS DE EXPERIMENTOS CON QUICKSORT
//                                    (PARA ANALISIS DE VELOCIDAD DE ALGORITMOS DE ORDENAMIENTO)
//                                    Experimentos valores desordenados
//                                    no. exp,dimension del arreglo,tiempo
//                                    """);
//        }
        
        Ordenador exps = new Ordenador();
        exps.realizarExperimentos();
        
    }
}
