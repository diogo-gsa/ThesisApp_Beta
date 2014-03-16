package thesis;

// lib wiki: http://www.mkyong.com/java/json-simple-example-read-and-write-json/
// lib wiki: https://code.google.com/p/json-simple/
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

    public static void main(String[] args) {

        System.out.println("Hello!");
        //String test = "lakasbdkasbd";
        String test = "{    \"id\":   \"C8:A0:30:AC:3F:AA\", \"name\": \"Núcleo 14\"," + "\n"
                + "\"timestamp\":    1394970785," + "\n" + " \"phases\":   {" + "\n"
                + "\"1\":    {" + "\n" + "\"voltage\":  229, " + "\n" + "\"current\":  0.4, "
                + "\n" + "\"powerfactor\":  0.05 " + "\n" + "} ," + "\n" + "\"2\":    {" + "\n"
                + "\"voltage\":  231," + "\n" + "\"current\":  0.5," + "\n"
                + "\"powerfactor\":  0.68" + "\n" + "} ," + "\n" + "\"3\":    {" + "\n"
                + "\"voltage\":  235," + "\n" + "\"current\":  0.6," + "\n"
                + "\"powerfactor\":  0.47" + "\n" + "}" + "\n" + "}" + "\n" + "}";

        SensorMeasure sm = new SensorMeasure(test);
        System.out.println(""+sm.toString());

    }


    public SensorMeasure(String measureJSON) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject measureJSONobject = (JSONObject) parser.parse(measureJSON);
            id = (String) measureJSONobject.get("id");
            name = (String) measureJSONobject.get("name");
            ts = (long) measureJSONobject.get("timestamp");
            phase1 = parsePhaseJSONobject(measureJSONobject, "1");
            phase2 = parsePhaseJSONobject(measureJSONobject, "2");
            phase3 = parsePhaseJSONobject(measureJSONobject, "3");
        } catch (ParseException e) {
            System.err
                    .println("[Diogo] Constructor JavaMeasure.Java: probably malformed JSON file...");
            e.printStackTrace();
        }
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long geTimestamp() {
        return ts;
    }

    public long getVoltagePhase1() {
        return phase1.getVoltage();
    }

    public double getCurrentPhase1() {
        return phase1.getCurrent();
    }

    public double getPowerFactorPhase1() {
        return phase1.getPowerFactor();
    }

    public long getVoltagePhase2() {
        return phase2.getVoltage();
    }

    public double getCurrentPhase2() {
        return phase2.getCurrent();
    }

    public double getPowerFactorPhase2() {
        return phase2.getPowerFactor();
    }

    public long getVoltagePhase3() {
        return phase3.getVoltage();
    }

    public double getCurrentPhase3() {
        return phase3.getCurrent();
    }

    public double getPowerFactorPhase3() {
        return phase3.getPowerFactor();
    }

    @Override
    public String toString() {
        return "[Measure Dump] \n| id: " + id + "\n| name:" + name + "\n| ts:" + ts + "\n| phase1:"
                + phase1.toString() + "\n| phase2:" + phase2.toString() + "\n| phase3:"
                + phase3.toString();
    }

    private Phase parsePhaseJSONobject(JSONObject obj, String phaseNumber) {
        JSONObject phases = (JSONObject) obj.get((String) "phases");
        JSONObject specificPhase = (JSONObject) phases.get(phaseNumber);
        Phase result = new Phase((long) specificPhase.get("voltage"),
                (double) specificPhase.get("current"), (double) specificPhase.get("powerfactor"));
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
        public String toString() {
            return " voltage: " + voltage + " | current: " + current + " | powerfactor: "
                    + powerFactor;
        }

    }

}
