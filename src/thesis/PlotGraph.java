package thesis;

import java.awt.Color;
import javax.swing.JFrame;

//wiki: http://jchart2d.sourceforge.net/usage.shtml
import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.traces.Trace2DLtd;


public class PlotGraph {

    Chart2D chart;
    final ITrace2D trace1;
    final ITrace2D trace2;
    final ITrace2D trace3;    
    final ITrace2D trace4;    
    final ITrace2D trace5;    
    final ITrace2D trace6;
    final ITrace2D trace7;
    final ITrace2D trace8;    
    final ITrace2D trace9;    
    
  
    JFrame frame;
    long m_starttime;
    
    public PlotGraph(int xPosition, int yPosition, int xSize, int ySize) {
        chart = new Chart2D();
        chart.setGridColor(Color.GRAY);
        chart.setBackground(Color.BLACK);
        chart.setForeground(Color.WHITE);
        
        
        chart.setUseAntialiasing(true);
        trace1 = new Trace2DLtd(5000000);
        trace2 = new Trace2DLtd(5000000);
        trace3 = new Trace2DLtd(5000000);
        trace4 = new Trace2DLtd(5000000);
        trace5 = new Trace2DLtd(5000000);
        trace6 = new Trace2DLtd(5000000);
        trace7 = new Trace2DLtd(5000000);
        trace8 = new Trace2DLtd(5000000);
        trace9 = new Trace2DLtd(5000000);
        
        trace1.setColor(Color.RED);
        trace2.setColor(Color.GREEN);
        trace3.setColor(Color.BLUE);
        trace4.setColor(Color.YELLOW);
        trace5.setColor(Color.MAGENTA);
        trace6.setColor(Color.CYAN);
        trace7.setColor(Color.ORANGE);
        trace8.setColor(Color.PINK);
        trace9.setColor(Color.GRAY);
        
       
        chart.addTrace(trace1);
        chart.addTrace(trace2);
        chart.addTrace(trace3);
        chart.addTrace(trace4);
        chart.addTrace(trace5);
        chart.addTrace(trace6);
        chart.addTrace(trace7);
        chart.addTrace(trace8);
        chart.addTrace(trace9);
        
        frame = new JFrame("MinimalDynamicChart");
        frame.getContentPane().add(chart);
        frame.setBounds(xPosition, yPosition, xSize, ySize);        
        frame.setVisible(true); 
        m_starttime = System.currentTimeMillis();
    }
    
    /*
    public PlotGraph(String colorTrace, int xPosition, int yPosition, int xSize, int ySize) {
        chart = new Chart2D();
        chart.setBackground(Color.BLACK);
        chart.setForeground(Color.WHITE);
        chart.setUseAntialiasing(true);
        trace1 = new Trace2DLtd(5000);
        trace2 = null;
        trace3 = null;
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
    }*/
    /*
    public PlotGraph(String colorTrace1, String colorTrace2, int xPosition, int yPosition, int xSize, int ySize) {
        chart = new Chart2D();
        chart.setBackground(Color.BLACK);
        chart.setForeground(Color.WHITE);
        chart.setUseAntialiasing(true);
        trace1 = new Trace2DLtd(200); 
        trace2 = new Trace2DLtd(200); 
        trace3 = null;
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
    }*/
    
    /*
    public PlotGraph(String colorTrace1, String colorTrace2, String colorTrace3, int xPosition, int yPosition, int xSize, int ySize) {
        chart = new Chart2D();
        chart.setBackground(Color.BLACK);
        chart.setForeground(Color.WHITE);
        chart.setUseAntialiasing(true);
        trace1 = new Trace2DLtd(200); 
        trace2 = new Trace2DLtd(200); 
        trace3 = new Trace2DLtd(200);         
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
        
        if(colorTrace3.equals("red")) trace3.setColor(Color.RED); 
        if(colorTrace3.equals("green")) trace3.setColor(Color.GREEN); 
        if(colorTrace3.equals("blue")) trace3.setColor(Color.BLUE);
        if(colorTrace3.equals("yellow")) trace3.setColor(Color.YELLOW);
        
      
        //traceMax.setColor(Color.MAGENTA);
        //traceMin.setColor(Color.CYAN);
        chart.addTrace(trace1);
        chart.addTrace(trace2);
        chart.addTrace(trace3);
        
        frame = new JFrame("MinimalDynamicChart");
        frame.getContentPane().add(chart);
        //frame.setSize(1200,250);
        frame.setBounds(xPosition, yPosition, xSize, ySize);
        frame.setVisible(true); 
        m_starttime = System.currentTimeMillis();
    }*/
    
    private static double foo(SensorMeasure sm){
        double measuresPhase1 = sm.getVoltagePhase1()*sm.getCurrentPhase1()*sm.getPowerFactorPhase1();
        double measuresPhase2 = sm.getVoltagePhase1()*sm.getCurrentPhase1()*sm.getPowerFactorPhase2();
        double measuresPhase3 = sm.getVoltagePhase1()*sm.getCurrentPhase1()*sm.getPowerFactorPhase3();            
     
        return measuresPhase1 + measuresPhase2 + measuresPhase3;
    }
    
    public void drawPlotPoint(double newPoint/*, double maxPoint, double minPoint*/){
        trace1.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint);
        trace1.setPhysicalUnits("Power", "Time");
        trace1.setName("*** Label1 ***");
    }
    
    public void drawTwoPlotPoint(double newPoint1, double newPoint2){
        trace1.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint1);
        trace2.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint2);
        
        trace1.setPhysicalUnits("Power", "Time");
        trace1.setName("*** Label1 ***");
    }
    
    public void drawThreePlotPoint(double newPoint1, double newPoint2, double newPoint3){
        trace1.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint1);
        trace2.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint2);       
        trace3.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), newPoint3);    
        trace1.setPhysicalUnits("Power", "Time");
        trace1.setName("*** Label1 ***");
    }
    
    public void drawNinePlotPoint(SensorMeasure np1, SensorMeasure np2, SensorMeasure np3, SensorMeasure np4, SensorMeasure np5, SensorMeasure np6, SensorMeasure np7, SensorMeasure np8, SensorMeasure np9){
        
        
        
        trace1.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np1));
        trace2.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np2));       
        trace3.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np3));
        trace4.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np4));
        trace5.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np5));
        trace6.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np6));
        trace7.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np7));
        trace8.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np8));
        trace9.addPoint( ((double) System.currentTimeMillis() - this.m_starttime), foo(np9));
        
        trace1.setPhysicalUnits("Power", "Time");
        
        trace1.setName(""+np1.getName());
        trace2.setName(""+np2.getName());
        trace3.setName(""+np3.getName());
        trace4.setName(""+np4.getName());
        trace5.setName(""+np5.getName());
        trace6.setName(""+np6.getName());
        trace7.setName(""+np7.getName());
        trace8.setName(""+np8.getName());
        trace9.setName(""+np9.getName());
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
