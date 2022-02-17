package simple;

import java.util.function.Consumer;

public class Example5 {

	public static void main(String[] args) {
		Client client = new Client("Yasha", 23, true);
		let(client, c ->{
			System.out.println(c.getName());
		});
		ViewModel viewModel = new ViewModel();
		viewModel.change(c->{
			c.setName("Yasha");
		});
	}
	
	
	public static <T> void let(T param, Consumer<T> consumer) {
		if(param!=null) {
			consumer.accept(param);
		}
	}
	
	static class ViewModel {
		private Client client = new Client("Yasha", 9, true);
		
		public void change(Consumer<Client> consumer) {
			consumer.accept(client);
			updateSubscribers();
		}
		
		private void updateSubscribers() {
			System.out.println("Изменение имени");
		}
	}
	
	
}
