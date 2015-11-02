package haw.danielpascal.gka;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedisConnection redisCon = new RedisConnection();
		redisCon.writeEntries(JsonParser.loadJSON("plz.data"));
		idAnfrage(redisCon);
	}
	
	private static void idAnfrage(RedisConnection redisCon){
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		System.out.println(id);
		redisCon.getCityAndState(id);
		scanner.close();
		
	}

}
