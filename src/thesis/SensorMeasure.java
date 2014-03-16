package thesis;

//lib wiki: http://www.mkyong.com/java/json-simple-example-read-and-write-json/
//lib wiki: https://code.google.com/p/json-simple/
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class SensorMeasure {

    private String id;
    private String name;
    private long ts;
    private Phase phaseOne;
    private Phase phaseTwo;
    private Phase phaseThree;

    public static void main(String[] args){
        
        System.out.println("Hello!");
        String test = "{    \"id\":   \"C8:A0:30:AC:3F:AA\", \"name\": \"Núcleo 14\","
                          +"\n"+ "\"timestamp\":    1394970785,"
                          +"\n"+ " \"phases\":   {"
                          +"\n"+    "\"1\":    {"
                          +"\n"+        "\"voltage\":  229, "
                          +"\n"+        "\"current\":  0.4, "
                          +"\n"+        "\"powerfactor\":  0.05 "
                          +"\n"+    "} ,"
                          +"\n"+    "\"2\":    {"
                          +"\n"+        "\"voltage\":  231,"
                          +"\n"+        "\"current\":  0.5,"
                          +"\n"+        "\"powerfactor\":  0.68"
                          +"\n"+    "} ,"
                          +"\n"+    "\"3\":    {"
                          +"\n"+        "\"voltage\":  235,"
                          +"\n"+        "\"current\":  0.6,"
                          +"\n"+        "\"powerfactor\":  0.47"
                          +"\n"+    "}"
                          +"\n"+ "}"
                          +"\n"+ "}";
        
        //System.out.println(test);
        JSONParser parser = new JSONParser();
        
        try {        
            JSONObject measureJSONobject = (JSONObject) parser.parse(test);
            String id = (String)  measureJSONobject.get("id");
            String name = (String)  measureJSONobject.get("name");
            long ts = (long)  measureJSONobject.get("timestamp");
            System.out.println(id+" | "+name+" | "+ts);
            
            
            JSONObject phasesJSONobject = (JSONObject) measureJSONobject.get((String) "phases");
            JSONObject phaseOneJSONobject = (JSONObject) phasesJSONobject.get((String) "1");
            JSONObject phaseTwoJSONobject = (JSONObject) phasesJSONobject.get((String) "2");
            JSONObject phaseThreeJSONobject = (JSONObject) phasesJSONobject.get((String) "3");
            
            long voltagePhaseOne = (long) phaseOneJSONobject.get("voltage");
            System.out.println("v: "+voltagePhaseOne);
            
            //if(phaseOneJSONobject == null) { System.out.println("=(");} else {System.out.println("=D");}
            

            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    private 
    

    public SensorMeasure(String jsonString){
        
        JSONParser parser = new JSONParser();
        
        
        
        
    }


    private class Phase {
        private int voltage;
        private float current;
        private float powerFactor;

        public Phase(int v, int c, int pf) {
            voltage = v;
            current = c;
            powerFactor = pf;
        }

        public int getVoltage() {
            return voltage;
        }


        public float getCurrent() {
            return current;
        }

        public float getPowerFactor() {
            return powerFactor;
        }
    }

}


/*
 * Measure Example { "id": "C8:A0:30:AC:3F:AA", "name": "Núcleo 14", "timestamp":
 * 1394897303, "phases": { "1": { "voltage": 233, "current": 0.4, "powerfactor": 0.18 },
 * "2": { "voltage": 235, "current": 0.5, "powerfactor": 0.70 }, "3": { "voltage": 240,
 * "current": 0.7, "powerfactor": 0.55 } } }
 */
