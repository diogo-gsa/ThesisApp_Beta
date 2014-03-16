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
    private Phase phase1;
    private Phase phase2;
    private Phase phase3;

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
        SensorMeasure measure = new SensorMeasure(test);
        
        try {                             
            /*
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
            */
            //if(phaseOneJSONobject == null) { System.out.println("=(");} else {System.out.println("=D");}

            JSONObject measureJSONobject = (JSONObject) parser.parse(test);
            String id = (String)  measureJSONobject.get("id");
            String name = (String)  measureJSONobject.get("name");
            long ts = (long)  measureJSONobject.get("timestamp");
            Phase phase1 = measure.parsePhaseJSONobject(measureJSONobject, "1");
            Phase phase2 = measure.parsePhaseJSONobject(measureJSONobject, "2");
            Phase phase3 = measure.parsePhaseJSONobject(measureJSONobject, "3");

            
            
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
    }
    

    public SensorMeasure(String measureJSON){
        JSONParser parser = new JSONParser();
        try {
            JSONObject measureJSONobject = (JSONObject) parser.parse(measureJSON);            
            id = (String)  measureJSONobject.get("id");
            name = (String)  measureJSONobject.get("name");
            ts = (long)  measureJSONobject.get("timestamp");
            phase1 = parsePhaseJSONobject(measureJSONobject, "1");
            phase2 = parsePhaseJSONobject(measureJSONobject, "2");
            phase3 = parsePhaseJSONobject(measureJSONobject, "3");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Phase parsePhaseJSONobject(JSONObject obj, String phaseNumber){
        JSONObject phases = (JSONObject) obj.get((String) "phases");
        JSONObject specificPhase = (JSONObject) phases.get(phaseNumber);       
        Phase result = new Phase((long)specificPhase.get("voltage"), (double)specificPhase.get("current"), (double)specificPhase.get("powerfactor"));
        return result;
    }

    private class Phase {
        private long voltage;
        private double current;
        private double powerFactor;

        public Phase(long v, double c, double pf) {
            voltage = v;
            current = c;
            powerFactor = pf;
        }

        public long getVoltage() {
            return voltage;
        }

        public double getCurrent() {
            return current;
        }

        public double getPowerFactor() {
            return powerFactor;
        }
    
        @Override
        public String toString(){
            return " voltage: "+voltage+" | current: "+current+" | powerfactor: "+powerFactor;
        }
    
    }

}
