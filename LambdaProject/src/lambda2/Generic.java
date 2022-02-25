package lambda2;

import java.util.function.BiFunction;

public class Generic {

	public static void main(String[] args) {
		
		
		Person person = new Person();
		Generic generic = new Generic();
		person.setGrade(1000.1);
		person.setName("3fdsfghdfs");
		
	
		Double d = generic.process(4.5, person, (h, g)->h*g);
		System.out.println(d);
		
		
		System.out.println(generic.process2(12, person, (day, g)->g*day));
		
	}
	
	
	public Double process(Double hours, Person p, Process<Double, Double, Double> proc) {
		return proc.process(hours, p.getGrade());
	}
	
	
	public Double process2(Integer day, Person p, BiFunction<Integer, Double, Double> func) {
		return func.apply(day, p.getGrade());
	}
	
}



interface Process<P1, P2, R>{
	
	R process(P1 p1, P2 p2);
}
