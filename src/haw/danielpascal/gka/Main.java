package haw.danielpascal.gka;

import haw.danielpascal.gka.datencontainer.CityEntry;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedisConnection redisCon = new RedisConnection();
		ArrayList<CityEntry> list=JsonParser.loadJSON("plz.data");
		//redisCon.writeEntries(JsonParser.loadJSON("plz.data"));
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
