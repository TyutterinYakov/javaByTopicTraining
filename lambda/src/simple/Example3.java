package simple;

import java.util.ArrayList;
import java.util.List;

public class Example3 {
	
	
	public static void main(String[] args) {
		List<Client> clients = new ArrayList<>();
		clients.add(new Client("Yasha", 11, false));
		clients.add(new Client("Yasha", 9, true));
		clients.add(new Client("Yasha", 4, false));
		clients.add(new Client("Yasha", 5, true));
		clients.add(new Client("Yasha", 7, false));
		clients.add(new Client("Yasha", 3, true));
		
		clients.forEach(c->{
			c.setSum(c.getSum()-1);
			System.out.println(c.getSum());
			});
		
		int pay = clients.stream()
				.filter(c->c.getSum()>5)
				.filter(Client::isActive)
				.reduce(0, (integer, client)->integer+client.getSum(), Integer::sum);
		System.out.println("Balance: "+pay);
	}
	
}
