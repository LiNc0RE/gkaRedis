package haw.danielpascal.gka;

import haw.danielpascal.gka.datencontainer.CityEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class RedisConnection {

	// Hier wird die Verbindung zur Datenbank aufgebaut
	// Entweder direkt hier die Funktionalit�t programmieren, dass wir
	// CityEntries von hier in die DB schreiben
	// oder einfach nur den Jedis Server zur Verf�gung stellen und dann machen
	// wir das selber im Hauptprogramm (So als Idee)

	Jedis jedisServer;

	public RedisConnection() {
		jedisServer = new Jedis("87.106.85.71", 447);
		jedisServer.set("foo", "bar");
		System.out.println(jedisServer.get("foo"));
	}

	public void writeEntries(ArrayList<CityEntry> entries) {
		//TODO Bug, die Entries die aus dem Parser kommen haben (warum auch immer) alle die gleiche Location "-133.18479.." obwohl beim schreiben vom Parser
		//alles richtig ausschaut. Strange. 
		for (int i = 0; i < entries.size(); i++) {
			Map<String, String> mapEntry = new HashMap<String, String>();
			mapEntry.put("city", entries.get(i).getCity());
			mapEntry.put("pop", String.valueOf(entries.get(i).getPop()));
			mapEntry.put("state", entries.get(i).getState());
			double[] loc = entries.get(i).getLoc();
			String locAsString = new String();
			locAsString=loc[0]+", "+loc[1];
			mapEntry.put("loc", locAsString);
			jedisServer.hmset(entries.get(i).getId(), mapEntry);
			//Extra Eintrag um sp�ter auf die Stadt zugreifen zu k�nnen
			jedisServer.set(entries.get(i).getCity(), entries.get(i).getId());
			//Debug:
			System.out.println("Eintrag" +i+": "+"loc: "+locAsString);
		}
		System.out.println("Eintragung vollst�ndig");
	}
	
	public void getCityAndState(String id){
		List<String> result = jedisServer.hmget(id,
				"city", "state");
		for (String res : result) {
			System.out.println(res);
		}
	}
	
	public int getID(String city){
		return Integer.valueOf(jedisServer.get(city));
	}

}
