import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;

import org.json.JSONArray;
import org.json.JSONObject;

public class BitcoinMovement {

    public static void main(String args[]) {

        // converting 1000 Euro to US Dollar
        System.out.println("price: " + findExchangeRateAndConvert("2019-02-17T00:00:00Z"));

        // converting 1000 US Dollar to Euro
        System.out.println("Avgprice " + AvgExchangeRateAndConvert("2019-02-17T00:00:00Z","2017-06-18T00:00:00Z" ));

        // converting 1000 US Dollar to Indian Rupee
        //System.out.println("US Dollar/Indian Rupee: " + findExchangeRateAndConvert("USD", "INR"));

        // converting 1000 Indian Rupee to US Dollar
        //System.out.println("Indian Rupee/US Dollar: " + findExchangeRateAndConvert("INR", "USD"));
    }
   
    private static String findExchangeRateAndConvert( String time) {
        try {
            //read url
            URL url = new URL("https://www.coinbase.com/api/v2/prices/BTC-USD/historic?period=all");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();

            JSONObject jsonOb = new JSONObject(line);
            JSONObject arrJson=jsonOb.getJSONObject("data");
            JSONArray pricedData=arrJson.getJSONArray("prices");
            for(int i=0;i<pricedData.length();){
            //System.out.println(pricedData.get(i));
            	
            	System.out.println(pricedData.getJSONObject(i).getString("time"));
            if(pricedData.getJSONObject(i).getString("time").equals(time)){
            	System.out.println(pricedData.getJSONObject(i).getString("time"));
            	return pricedData.getJSONObject(i).getString("price");
            }
            
            }
           // System.out.println(line.length());
          /*  if (line.length() > 0) {
                return line;
            }*/
            reader.close();
        } catch (Exception e) {
           // System.out.println(e.getMessage());
        }
        return null;
    }
    
    private static double AvgExchangeRateAndConvert( String time1,String time2 ) {
    	double v1 = 0,v2 = 0,v3 = 0;
    	try {
            //read url
            URL url = new URL("https://www.coinbase.com/api/v2/prices/BTC-USD/historic?period=all");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();

            JSONObject jsonOb = new JSONObject(line);
            JSONObject arrJson=jsonOb.getJSONObject("data");
            JSONArray pricedData=arrJson.getJSONArray("prices");
            
            for(int i=0;i<pricedData.length();i++){
            //System.out.println(pricedData.get(i));
            	
            	System.out.println(pricedData.getJSONObject(i).getString("time"));
            if(pricedData.getJSONObject(i).getString("time").equals(time1)){
            	//System.out.println(pricedData.getJSONObject(i).getString("time"));
            	 v1= Double.parseDouble(pricedData.getJSONObject(i).getString("price"));
            }
            	System.out.println(pricedData.getJSONObject(i).getString("time"));
                if(pricedData.getJSONObject(i).getString("time").equals(time1))
                {
                	System.out.println(pricedData.getJSONObject(i).getString("time"));
                	 v2= Double.parseDouble(pricedData.getJSONObject(i).getString("price"));
                	}
                v3= (v1+v2)/2;
                           }
            
            
            
           // System.out.println(line.length());
          /*  if (line.length() > 0) {
                return line;
            }*/
            reader.close();
        } catch (Exception e) {
           // System.out.println(e.getMessage());
        }
        return v3;
    }
    
    
}