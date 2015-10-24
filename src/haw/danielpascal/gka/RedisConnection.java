package haw.danielpascal.gka;

import redis.clients.jedis.Jedis;

public class RedisConnection {

	// Hier wird die Verbindung zur Datenbank aufgebaut
	// Entweder direkt hier die Funktionalität programmieren, dass wir CityEntries von hier in die DB schreiben
	// oder einfach nur den Jedis Server zur Verfügung stellen und dann machen wir das selber im Hauptprogramm (So als Idee)
	
	public RedisConnection() {
		Jedis jedisServer = new Jedis("87.106.85.71", 447);
		jedisServer.set("foo", "bar");
		System.out.println(jedisServer.get("foo"));		
	}
	
}
