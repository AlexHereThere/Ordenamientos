/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Todo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import static org.jfree.chart.ChartPanel.DEFAULT_HEIGHT;
import static org.jfree.chart.ChartPanel.DEFAULT_WIDTH;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *clase para graficar los resultados de los ordenamentos, con una grafica
 * usando JFreeChart.
 * @author ACR
 */
public class Graficador {
   String dato;
   String[] datoCVS;
   ArrayList<XYSeries> datos;
   JPanel paraGrafica;
   Color[] colors ={Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,
       Color.RED,Color.YELLOW,Color.getHSBColor(20, 60, 70),//extras colores son cafe y aqua blue
       Color.getHSBColor(180, 100, 100),Color.BLACK,Color.WHITE};
    
    public Graficador(JPanel paraGrafica)
    {
        datos = new ArrayList<>();   
        this.paraGrafica = paraGrafica;
    }
    
    
    
    public void graficar()
    { 
    XYSeriesCollection todo = new XYSeriesCollection();    
        for(XYSeries serie :datos)
        {
            todo.addSeries(serie);//anadir los comportamientos de ordenacion que se consideraron 
        }//mostrar
        
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Velocidad de Algoritmos (Tipos de Ordenamiento)"
                , "Num. De Datos", 
                "tiempo (ns)", 
                todo,PlotOrientation.VERTICAL,true,true,false);
        
        XYPlot todoPlot = chart.getXYPlot();
        XYLineAndShapeRenderer decorador = new XYLineAndShapeRenderer();
        for(int i=0;i<datos.size();i++)
        {
        decorador.setSeriesPaint(i, colors[i]);
        decorador.setSeriesStroke(i, new BasicStroke(3.0f));
        }
        todoPlot.setRenderer(decorador); //asignar caracteristicas
        ChartPanel panel = new ChartPanel(chart);
       panel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        paraGrafica.add(panel);//definir la grafica XY con algunas caracteristicas
    }   
    /**
     * metodo para dejar vacio la grafica
     */
    public void limpiar()
    {
        paraGrafica.removeAll();
        datos.clear();
    }
    
    /**
     * metodo para tomar los resultados de quicksort para graficarlo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void agregarResultadosQuickSort() throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("src//resources//resultados_quicksort.txt"));
       int numLineasExperimentos=10;
       
       
       int numLineasInnecesarias=4;
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries quickSortD = new XYSeries("QuickSort Con Valores Desordenado");
        for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          quickSortD.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(quickSortD);
        
        
        numLineasInnecesarias=2;//brincarse la lineas inecesarias
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries quickSortO = new XYSeries("QuickSort Con Valores Ordenado");
           for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          quickSortO.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(quickSortO);
        
         numLineasInnecesarias=2;//brincarse la lineas inecesarias
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries quickSortM = new XYSeries("QuickSort Con Valores Mayor al Menor");
           for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          quickSortM.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(quickSortM);
    }
    
    /**
     * metodo para tomar los resultados de mergesort para graficarlo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void agregarResultadosMergeSort() throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("src//resources//resultados_mergesort.txt"));
       int numLineasExperimentos=10;
       
       
       int numLineasInnecesarias=4;
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries mergeSortD = new XYSeries("MergeSort Con Valores Desordenado");
        for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          mergeSortD.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(mergeSortD);
        
        
        numLineasInnecesarias=2;//brincarse la lineas inecesarias
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries mergeSortO = new XYSeries("MergeSort Con Valores Ordenado");
           for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          mergeSortO.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(mergeSortO);
        
         numLineasInnecesarias=2;//brincarse la lineas inecesarias
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries mergeSortM = new XYSeries("MergeSort Con Valores Mayor al Menor");
           for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          mergeSortM.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(mergeSortM);
    }
    
    /**
     * metodo para tomar los resultados de sort() para graficarlo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void agregarResultadosSort() throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("src//resources//resultados_sort.txt"));
       int numLineasExperimentos=10;
       
       
       int numLineasInnecesarias=4;
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries SortD = new XYSeries("Sort() Con Valores Desordenado");
        for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          SortD.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(SortD);
        
        
        numLineasInnecesarias=2;//brincarse la lineas inecesarias
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries SortO = new XYSeries("Sort() Con Valores Ordenado");
           for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          SortO.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(SortO);
        
         numLineasInnecesarias=2;//brincarse la lineas inecesarias
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries SortM = new XYSeries("Sort() Con Valores Mayor al Menor");
           for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          SortM.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(SortM);
    }
    
    /**
     * metodo para tomar los resultados de parallelsort para graficarlo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void agregarResultadosParallelSort() throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("src//resources//resultados_parallelsort.txt"));
       int numLineasExperimentos=10;
       
       
       int numLineasInnecesarias=4;
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries parallelSortD = new XYSeries("ParallelSort() Con Valores Desordenado");
        for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          parallelSortD.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(parallelSortD);
        
        
        numLineasInnecesarias=2;//brincarse la lineas inecesarias
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries parallelSortO = new XYSeries("ParallelSort() Con Valores Ordenado");
           for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          parallelSortO.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(parallelSortO);
        
         numLineasInnecesarias=2;//brincarse la lineas inecesarias
        for(int i=0;i<numLineasInnecesarias;i++)reader.readLine();
        XYSeries parallelSortM = new XYSeries("ParallelSort() Con Valores Mayor al Menor");
           for(int i=0;i<numLineasExperimentos;i++)
        {
          dato =reader.readLine();
          datoCVS = dato.split(",");//tiempo / num de datos
          parallelSortM.add(Integer.parseInt(datoCVS[1]),Integer.parseInt(datoCVS[2]));
        }
        datos.add(parallelSortM);
    }
}

