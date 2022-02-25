package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {

	
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		for(int i=0; i<10; i++) {
			persons.add(new Person(UUID.randomUUID().toString().substring(0, 7),
					i*60/0.05));
		}
		System.out.println(persons);
		List<String> names = persons
				.stream()
				.map((p)->
				p.getFirstName())
				.collect(Collectors.toList());
		System.out.println(names);
		names = names.stream().sorted().collect(Collectors.toList());
		System.out.println(names);
		names = names.stream().sorted((o1, o2)->-o1.compareTo(o2)).collect(Collectors.toList());
		System.out.println(names);
		
		persons = persons.stream().filter(p->p.getGrade()>2000).collect(Collectors.toList());
		System.out.println(persons);
		
		persons = persons.stream().sorted((o1, o2)->(int)(-o1.getGrade()-o2.getGrade())).collect(Collectors.toList());
		System.out.println(persons);
		
		
		
		
		
		
		
		
		
	}
}
