package stream;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import stream.model.Department;
import stream.model.Employee;
import stream.model.Event;
import stream.model.Position;

public class Main {

	private static List<Employee> employes = List.of(
		new Employee(1L, "Yasha", "Tyutterin", 20, Position.WORKER),
		new Employee(2L, "John", "Whatson", 27, Position.MANAGER),
		new Employee(3L, "Maksim", "Antonov", 30, Position.WORKER),
		new Employee(4L, "Sasha", "Kotov", 24, Position.WORKER),
		new Employee(5L, "Andrey", "Makarov", 21, Position.MANAGER),
		new Employee(6L, "Artem", "Krotov", 17, Position.WORKER),
		new Employee(7L, "Y", "Tyuttn", 19, Position.WORKER),
		new Employee(8L, "asha", "Ttein", 18, Position.MANAGER),
		new Employee(9L, "ha", "ter", 16, Position.WORKER),
		new Employee(10L, "sha", "Tterin", 19, Position.MANAGER),
		new Employee(11L, "Ya", "Tyin", 22, Position.WORKER),
		new Employee(12L, "Yaha", "Tyutt", 25, Position.MANAGER),
		new Employee(13L, "Ysha", "utterin", 35, Position.WORKER),
		new Employee(14L, "Yash", "Terin", 29, Position.WORKER),
		new Employee(15L, "Yasa", "Tyerin", 44, Position.MANAGER)
			);
	
	
	private static List<Department> departments = List.of(
		new Department(1L, 0, "Geramany"),
		new Department(2L, 1, "Russia"),
		new Department(3L, 3, "Japan"),
		new Department(4L, 4, "China"),
		new Department(5L, 5, "USA"),
		new Department(6L, 7, "Armenia"),
		new Department(7L, 2, "Sweden"),
		new Department(8L, 3, "France"),
		new Department(9L, 5, "Ukraine"),
		new Department(10L, 4, "England")
			);
	
	
	public static void main(String[] args) throws IOException {
		
		Stream<String> lines = Files.lines(Paths.get("/Users/asatutterin/Desktop/simple.txt"));
		Stream<Path> paths = Files.list(Paths.get("./"));
		Stream<Path> walk = Files.walk(Paths.get("./"), 4);
		
		IntStream intStream = IntStream.of(1,2,3,4,5);
		DoubleStream doubleStream = DoubleStream.of(1.2,5.3,4.6);
		IntStream range = IntStream.range(10, 100); //10 .. 99
		IntStream intStream2 = IntStream.rangeClosed(10, 100); //10 .. 100
		
		int[] ints = {1,2,3,4};
		IntStream stream = Arrays.stream(ints);
		Stream<String> stringStream = Stream.of("1","2","3", "3.3", "1");
		Stream<? extends Serializable> streams = Stream.of("1","2",3, 3.3, 1L);
		
		Stream<String> build = Stream
								.<String>builder()
								.add("")
								.add("")
								.build();
		
		Stream<Employee> emp = employes.stream();
		Stream<Employee> empparal = employes.parallelStream();
		
		
		Stream<Event> events = Stream.generate(()->
			new Event(UUID.randomUUID(), LocalDateTime.now(), "Hello"));
		Stream<Integer> years = Stream.iterate(1950,  val-> val+3);
		
		Stream<String> strings = Stream.concat(stringStream, build);
		
		
		Long count = employes.stream().count();
		
		employes.stream().forEach(employ->System.out.print(employ+" "));
		employes.stream().forEachOrdered(employ->System.out.print(employ+" "));
		
		employes.stream().collect(Collectors.toSet());
		employes.stream().toArray();
		employes.stream().collect(Collectors.toMap(
				Employee::getId, 
				em->String.format("%s %s %s", 
						em.getFirstName(), 
						em.getLastName(), 
						em.getPosition().name())
				)
			);
		IntStream intsStream = IntStream.of(3,4,5,3,32,23,354,56,78,543);
		intStream.reduce((left, rigth)->left+rigth).orElse(0);
		
		departments.stream().map(d->d.getName().startsWith("R")).collect(Collectors.toList()).forEach(dep->System.out.print(dep+" "));
		System.out.print("\n");
		departments.stream().filter(d->d.getName().startsWith("R")).collect(Collectors.toList()).forEach(dep->System.out.print(dep));
		System.out.print("\n");
		departments.stream().filter(d->d.getParent()==3).collect(Collectors.toList()).forEach(dep->System.out.println(dep));
		System.out.println(employes.stream().max(Comparator.comparingInt(Employee::getAge)).get().getAge());
		employes.stream().findFirst();
		System.out.println(employes.stream().noneMatch(y->y.getAge()>60)); //Все не соответствуют
		System.out.println(employes.stream().allMatch(y->y.getPosition().equals(Position.MANAGER))); //Все соответствуют или нет
		System.out.println(employes.stream().allMatch(y->y.getId()>100)); //Хотя бы один соответствует
		
		employes.stream()
					.sorted(Comparator.comparingInt(Employee::getAge));
		
		employes.stream().takeWhile(empl->empl.getAge()<40).forEach(System.out::println); //Цикл выполняется,
																			//пока выполняется условие
		employes.stream().dropWhile(empl->empl.getAge()<40).forEach(System.out::println); //Цикл отбрасывает элементы, 
							//пока не встретит первый подходящий элемент и выводит все остальные без фильтра
		
	}
	
	
	
	
}
