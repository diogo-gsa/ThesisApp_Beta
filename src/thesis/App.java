package thesis;

public class App {

    public static void main(String[] args) {

        PlotGraph plot1 = new PlotGraph(0, 0, 1366, 250);
           
        
        Sensor sensor1 = new Sensor("https://172.20.70.229/reading", "root", "root");
        Sensor sensor2 = new Sensor("https://172.20.70.231/reading", "root", "root");        
        Sensor sensor3 = new Sensor("https://172.20.70.232/reading", "root", "root");
        Sensor sensor4 = new Sensor("https://172.20.70.233/reading", "root", "root");
        Sensor sensor5 = new Sensor("https://172.20.70.234/reading", "root", "root");
        Sensor sensor6 = new Sensor("https://172.20.70.235/reading", "root", "root");
        Sensor sensor7 = new Sensor("https://172.20.70.236/reading", "root", "root");
        Sensor sensor8 = new Sensor("https://172.20.70.237/reading", "root", "root");
        Sensor sensor9 = new Sensor("https://172.20.70.238/reading", "root", "root");
       
        
        while(true) {
            plot1.drawNinePlotPoint(
                    sensor1.getNewMeasure(), 
                    sensor2.getNewMeasure(), 
                    sensor3.getNewMeasure(), 
                    sensor4.getNewMeasure(), 
                    sensor5.getNewMeasure(), 
                    sensor6.getNewMeasure(), 
                    sensor7.getNewMeasure(), 
                    sensor8.getNewMeasure(), 
                    sensor9.getNewMeasure());  
            try { Thread.sleep(5000); } 
            catch (InterruptedException e) { e.printStackTrace();}
            System.out.println("---");
        }
        
    }
    
}
