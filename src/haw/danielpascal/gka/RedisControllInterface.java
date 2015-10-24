package haw.danielpascal.gka;

import redis.clients.jedis.Jedis;

public class RedisControllInterface {

	public RedisControllInterface() {
		Jedis jedisServer = new Jedis("87.106.85.71", 447);
		jedisServer.set("foo", "bar");
		System.out.println(jedisServer.get("foo"));
		
	}
	
	
}
