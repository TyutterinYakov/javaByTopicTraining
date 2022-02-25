package lambda2;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		Person p = new Person();
		p.setDateOfBirth(LocalDate.now());
		p.setGrade(100.1);
		p.setName("QWERTY");
		
		
		m.processHospital(p, 4, (g, d)->g*d/2);
		
		m.processAdditional(p, 6.5, (d, h)->d*h);
		
		
	}
	
	
	public void processHospital(Person person, Integer days, ProcessHospital ph) {
		Double summ = ph.process(person.getGrade(), days);
	}
	
	public void processAdditional(Person person, Double hours, ProcessAdditional pa) {
		Double summ = pa.process(person.getGrade(), hours);
		
		
	}
}


interface ProcessHospital {
	Double process(double grade, Integer days);
}

interface ProcessAdditional {
	Double process(double grade, Double hours);
}
