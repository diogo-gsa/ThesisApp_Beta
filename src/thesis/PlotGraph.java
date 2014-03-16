package thesis;

import java.awt.Color;
import javax.swing.JFrame;

import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.traces.Trace2DLtd;


public class PlotGraph {

    Chart2D chart;
    final ITrace2D trace1;
    final ITrace2D trace2;    
    final ITrace2D traceMax; 
    final ITrace2D traceMin;
    JFrame frame;
    long m_starttime;
    
    /*
    public void initTraceMinMax(){
    }*/
    
    
    public PlotGraph(String colorTrace, int xPosition, int yPosition, int xSize, int ySize) {
        chart = new Chart2D();
        chart.setBackground(Color.BLACK);
        chart.setForeground(Color.WHITE);
        chart.setUseAntialiasing(true);
        trace1 = new Trace2DLtd(5000);
        trace2 = null;
        traceMax = new Trace2DLtd(5000);
        traceMin = new Trace2DLtd(5000);
        if(colorTrace.equals("red")) trace1.setColor(Color.RED); 
        if(colorTrace.equals("green")) trace1.setColor(Color.GREEN); 
        if(colorTrace.equals("blue")) trace1.setColor(Color.BLUE);
        if(colorTrace.equals("yellow")) trace1.setColor(Color.YELLOW);
        
        if(colorTrace.equals("magenta")) trace1.setColor(Color.MAGENTA);
        if(colorTrace.equals("cyan")) trace1.setColor(Color.CYAN);
        
        chart.addTrace(trace1);
        frame = new JFrame("MinimalDynamicChart");
        frame.getContentPane().add(chart);
        //frame.setBounds(0, 0, 950, 250);
        frame.setBounds(xPosition, yPosition, xSize, ySize);        
        frame.setVisible(true); 
        m_starttime = System.currentTimeMillis();
    }
    
    public PlotGraph(String colorTrace1, String colorTrace2, int xPosition, int yPosition, int xSize, int ySize) {
        chart = new Chart2D();
        chart.setBackground(Color.BLACK);
        chart.setForeground(Color.WHITE);
        chart.setUseAntialiasing(true);
        trace1 = new Trace2DLtd(200); 
        trace2 = new Trace2DLtd(200); 
        traceMax = new Trace2DLtd(5000);
        traceMin = new Trace2DLtd(5000);
        if(colorTrace1.equals("red")) trace1.setColor(Color.RED); 
        if(colorTrace1.equals("green")) trace1.setColor(Color.GREEN); 
        if(colorTrace1.equals("blue")) trace1.setColor(Color.BLUE);
        if(colorTrace1.equals("yellow")) trace1.setColor(Color.YELLOW);
        if(colorTrace2.equals("red")) trace2.setColor(Color.RED); 
        if(colorTrace2.equals("green")) trace2.setColor(Color.GREEN); 
        if(colorTrace2.equals("blue")) trace2.setColor(Color.BLUE);
        if(colorTrace1.equals("yellow")) trace2.setColor(Color.YELLOW);
        
        if(colorTrace1.equals("magenta")) trace1.setColor(Color.MAGENTA);
        if(colorTrace2.equals("magenta")) trace2.setColor(Color.MAGENTA);
        if(colorTrace1.equals("cyan")) trace1.setColor(Color.CYAN);
        if(colorTrace2.equals("cyan")) trace2.setColor(Color.CYAN);
        
        //traceMax.setColor(Color.MAGENTA);
        //traceMin.setColor(Color.CYAN);
        chart.addTrace(trace1);
        chart.addTrace(trace2);
        frame = new JFrame("MinimalDynamicChart");
        frame.getContentPane().add(chart);
        //frame.setSize(1200,250);
        frame.setBounds(xPosition, yPosition, xSize, ySize);
        frame.setVisible(true); 
        m_starttime = System.currentTimeMillis();
    }
    
    
    public void drawPlotPoint(double newPoint/*, double maxPoint, double minPoint*/){
        trace1.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint);
    }
    
    public void drawPlotPointBuffer(int newPoint1, int newPoint2){
        trace1.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint1);
        trace2.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint2);
    }
    
    public void drawPlotPointAVG(double newPoint/*, double maxPoint, double minPoint*/){
        trace1.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint);
    }
    public void drawPlotPointMaxAvg(double newPoint/*, double maxPoint, double minPoint*/){
        trace2.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint);
    }
    
    /*//DEBUG -------------------------------
    public static void main(String[] args ){
        PlotGraph plot = new PlotGraph();
        for(int i = 0; i < 999999999; i++ ){
            plot.drawPlotPoint((double) i);
        }
    }*/
    
    
}
