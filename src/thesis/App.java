package thesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.io.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class App {

    //private static String url = "http://www.apache.org/";

    public static void main(String[] args) throws Exception {

        fetchSensorReading_HTTPS("https://172.20.70.229/reading", "root", "root");
        Thread.sleep(2000);
        fetchSensorReading_HTTPS("https://172.20.70.229/reading", "root", "root");
        Thread.sleep(2000);
        fetchSensorReading_HTTPS("https://172.20.70.229/reading", "root", "root");
        Thread.sleep(2000);
        fetchSensorReading_HTTPS("https://172.20.70.229/reading", "root", "root");
        Thread.sleep(2000);
        fetchSensorReading_HTTPS("https://172.20.70.229/reading", "root", "root");
        Thread.sleep(2000);
        fetchSensorReading_HTTPS("https://172.20.70.229/reading", "root", "root");
                
    }

    
    public static void fetchSensorReading_HTTPS(String url, String username, String password) {
        
        // Sensor server uses HTTPS and use a self-signed certificate, then we must
        // create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}
            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        } };
        
        // Install the all-trusting trust manager
        try{
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }catch (NoSuchAlgorithmException e) {e.printStackTrace();}
         catch (KeyManagementException e) {e.printStackTrace();}
     
        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
     
        // now we are prepared to make HTTPS requests to a server with 
        // self signed certificates
        try {
            URL siteURL = new URL(url);
            URLConnection connectionURL = siteURL.openConnection();
           
            //Setting the doInput flag to indicate that the application intends to read data from the URL connection.
            connectionURL.setDoInput (true);
            String userNamePasswordBase64 = "Basic " + base64Encode(username + ":" + password);
            connectionURL.setRequestProperty ("Authorization", userNamePasswordBase64);
            //connectionURL.connect(); //connection is already open
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connectionURL.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String base64Encode (String string)    {
        String encodedString = "";
        byte bytes [] = string.getBytes ();
        int i = 0;
        int pad = 0;
        while (i < bytes.length) {
          byte b1 = bytes [i++];
          byte b2;
          byte b3;
          if (i >= bytes.length) {
             b2 = 0;
             b3 = 0;
             pad = 2;
             }
          else {
             b2 = bytes [i++];
             if (i >= bytes.length) {
                b3 = 0;
                pad = 1;
                }
             else
                b3 = bytes [i++];
             }
          byte c1 = (byte)(b1 >> 2);
          byte c2 = (byte)(((b1 & 0x3) << 4) | (b2 >> 4));
          byte c3 = (byte)(((b2 & 0xf) << 2) | (b3 >> 6));
          byte c4 = (byte)(b3 & 0x3f);
          encodedString += base64Array [c1];
          encodedString += base64Array [c2];
          switch (pad) {
           case 0:
             encodedString += base64Array [c3];
             encodedString += base64Array [c4];
             break;
           case 1:
             encodedString += base64Array [c3];
             encodedString += "=";
             break;
           case 2:
             encodedString += "==";
             break;
           }
          }
          return encodedString;
      }
    
    private final static char base64Array [] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
        'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '+', '/'
    };
    
}
