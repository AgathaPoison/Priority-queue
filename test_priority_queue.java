package priority_queue;

import java.util.*;

public class test_priority_queue {

	public static void main(String[] args) {
		
		priority_queue<Integer> priority = new priority_queue<Integer>();//создание экземпл€ра класса "priority queue"
		
		Random RND = new Random();//целочисленна€ очередь заполн€етс€ случайными числами от 1 до 100
		for (int i = 0 ; i<10; i++) {
			priority.Add(RND.nextInt(100 - 1 + 1));
		}
		System.out.println("Random Integer Queue: ");
		priority.print();//печать результата		
		System.out.println("\nAdding some elements:");		
		priority.Add(107);//добавим несколько элементов
		priority.Add(11);
		priority.Add(7);
		priority.print();//вывод результата на экрае
		System.out.print("\n");
		System.out.print("Than delete first 3 times: ");
		priority.delete();//три удалени€
		System.out.print("\n");
		priority.print();
		priority.delete();
		System.out.print("\n");
		priority.print();//печать результата
		priority.delete();
		System.out.print("\n");
		priority.print();
		System.out.println("Integer Queue's size: " +priority.Count());
		System.out.println("Integer Queues's max element: " +priority.getMax());
		priority.deleteAll();
		
		priority_queue<Double> priority2 = new priority_queue<Double>();//создание экземпл€ра класса "priority queue"
		
		System.out.println("Double Queue: ");	
		System.out.println("\nAdding some elements:");		
		priority2.Add(11.1);
		priority2.Add(18.19);
		priority2.Add(3.011);
		priority2.Add(33.9);
		priority2.Add(90.90908);
		priority2.print();
		System.out.println("\nThan delete first: ");
		priority2.delete();
		priority2.print();
		System.out.println("\nFloat Queue's size: " +priority2.Count());
		System.out.println("Float Queues's max element: " +priority2.getMax());
		priority2.deleteAll();

		priority_queue<String> priority3 = new priority_queue<String>();//создание экземпл€ра класса "priority queue"
		
		System.out.println("\nString Queue: ");	
		System.out.println("\nAdding some elements:");		
		priority3.Add("a");
		priority3.Add("d");
		priority3.Add("r");
		priority3.Add("t");
		priority3.Add("b");
		priority3.print();
		System.out.println("\nThan delete first: ");
		priority3.delete();
		priority3.print();
		System.out.println("\nString Queue's size: " +priority3.Count());
		System.out.println("String Queues's max element: " +priority3.getMax());
		priority3.deleteAll();
		priority3.isEmpty();
	}
}
