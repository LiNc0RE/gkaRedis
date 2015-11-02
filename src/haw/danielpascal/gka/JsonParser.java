package haw.danielpascal.gka;

import haw.danielpascal.gka.datencontainer.CityEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

//Hier die JSON Datei einlesen und die Daten in ein Array!?/Eine Liste aus CityEntries packen und die Sammlung per Getter zur Verfügung stellen

public class JsonParser {
	
	public static ArrayList<CityEntry> loadJSON(String filepath){
		ArrayList<CityEntry> ergebnis = new ArrayList<CityEntry>();
		String id;
		String city;
		double[] loc;
		int pop;
		String state;
			
		try {
			FileReader reader = new FileReader(filepath);
			BufferedReader br = new BufferedReader(reader);
			boolean read=true;
			do{
				String line = br.readLine();
				if(line!=null){
					JSONObject json = new JSONObject(line);
					id= json.getString("_id");
					city= json.getString("city");
					JSONArray locJSON = json.getJSONArray("loc");
					loc = new double[2];
					loc[0]=locJSON.getDouble(0);
					loc[1]=locJSON.getDouble(1);
					pop= json.getInt("pop");
					state = json.getString("state");
					//TESTAUSGABE
					//System.out.println(id + city + loc[0]+loc[1] + pop + state);
					ergebnis.add(new CityEntry(id,city,loc,pop,state));
				}
				else{
					read=false;
				}
				
			}while(read);
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ergebnis;
	}

}
