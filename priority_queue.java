package priority_queue;
import java.util.*;

public class priority_queue<E extends Comparable <E>> {
	private ArrayList<E> Queue;
	
	public priority_queue() {//конструтор очереди
		Queue = new ArrayList<E>();
	}
	
	public int Count() {//метод, возвращающий количество элементов в очереди
		return Queue.size();
	}
	
	public void Add(E e) {//добавление элемента в очередь
		Queue.add(e);
		int s = Queue.size() - 1;
		while (s>0) {
			int curr = (s-1)/2;
			E element = Queue.get(s);
			E parent = Queue.get(curr);
			if(element.compareTo(parent)>0) {
				Queue.set(s, parent);
				Queue.set(curr, element);
				s = curr;
			}
			else break;
		}
	}
	
	public void print() {//вывод на экран
		for (int i =0; i<Queue.size();i++) {
			System.out.print(Queue.get(i).toString()+" ");
		}
	}
	
	public boolean isEmpty() {//проверка очереди на пустоту
		if (Queue.isEmpty()) {
			return true;
		}
		else return false;
	}
	
	public E delete() {//удаление элемента
		if (Queue.isEmpty()) {//если в очереди нет элементов
			throw new NoSuchElementException();//метод выбрасывает исключение
		}
		E ret = Queue.get(0);//заполним первый элемент очереди
		Queue.set(0, Queue.get((Queue.size()-1)));//Последний элемент на первое место
		Queue.remove(Queue.size()-1);//удалим последний элемент из очереди
		int curr = 0;//curr - индекс первого элемента очереди, сейчас там находится последний элемент
		int left = 2*curr +1;//левый потомок текущего элемента
		
		while (left<Queue.size()) {//пока не пройдем все дерево полностью
			int max = left; //предположим что левый потомок больше текущего
			int right = left+1;//индекс правого потомка
			
			if( right<Queue.size() && Queue.get(right).compareTo(Queue.get(curr))>0 ) {//если не конец дерева и если правый потомок все же больше текущего элеиента
				max = right;//примем правого потомка за max
			}
			if (right<Queue.size() && Queue.get(left).compareTo(Queue.get(right))>0) {//сравнение правого и левых потомков. Если левый больше чем правый
				max=left;//примем левого потомка за max
			}
			if (Queue.get(curr).compareTo(Queue.get(max))<0) {//если текущий элемент меньше своего потомка, они меняются местами
				E temp = Queue.get(curr);
				Queue.set(curr, Queue.get(max));
				Queue.set(max, temp);
				curr = max;//идем дальше вниз по дереву
				left = 2*curr+1;//индекс левого потомка
			}
			else break;
		}		
		return ret;//возврат элемента из очереди
	}
	
	public E getMax() {//возврат максимального значения в очереди
		return Queue.get(0);
	}
	
	public void deleteAll() {//удалить все элементы в очереди
		Queue.removeAll(Queue);
	}		
}
