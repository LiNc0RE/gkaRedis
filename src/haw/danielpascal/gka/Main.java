package haw.danielpascal.gka;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedisConnection redisCon = new RedisConnection();
		redisCon.writeEntries(JsonParser.loadJSON("plz.data"));
		//JsonParser.loadJSON("plz.data");
	}

}
