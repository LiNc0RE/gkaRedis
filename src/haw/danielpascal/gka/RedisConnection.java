package haw.danielpascal.gka;

import haw.danielpascal.gka.datencontainer.CityEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class RedisConnection {

	// Hier wird die Verbindung zur Datenbank aufgebaut
	// Entweder direkt hier die Funktionalität programmieren, dass wir
	// CityEntries von hier in die DB schreiben
	// oder einfach nur den Jedis Server zur Verfügung stellen und dann machen
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
			for (int x = 0; x < loc.length; x++) {
				locAsString += String.valueOf(loc[x]);
			//	System.out.println(locAsString);
			}
			mapEntry.put("loc", locAsString);
			jedisServer.hmset(entries.get(i).getId(), mapEntry);
			
			//TestRückgabe | Nach jedem Schreiben, holt er sich einmal den Stadtnamen aus der Datenbank wieder raus! 
			List<String> result = jedisServer.hmget(entries.get(i).getId(),
					"city", "loc");
			for (String res : result) {
				System.out.println(res);
			}
		}
	}

}
