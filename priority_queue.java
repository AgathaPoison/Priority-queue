package priority_queue;
import java.util.*;

public class priority_queue<E extends Comparable <E>> {
	private ArrayList<E> Queue;
	
	public priority_queue() {//���������� �������
		Queue = new ArrayList<E>();
	}
	
	public int Count() {//�����, ������������ ���������� ��������� � �������
		return Queue.size();
	}
	
	public void Add(E e) {//���������� �������� � �������
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
	
	public void print() {//����� �� �����
		for (int i =0; i<Queue.size();i++) {
			System.out.print(Queue.get(i).toString()+" ");
		}
	}
	
	public boolean isEmpty() {//�������� ������� �� �������
		if (Queue.isEmpty()) {
			return true;
		}
		else return false;
	}
	
	public E delete() {//�������� ��������
		if (Queue.isEmpty()) {//���� � ������� ��� ���������
			throw new NoSuchElementException();//����� ����������� ����������
		}
		E ret = Queue.get(0);//�������� ������ ������� �������
		Queue.set(0, Queue.get((Queue.size()-1)));//��������� ������� �� ������ �����
		Queue.remove(Queue.size()-1);//������ ��������� ������� �� �������
		int curr = 0;//curr - ������ ������� �������� �������, ������ ��� ��������� ��������� �������
		int left = 2*curr +1;//����� ������� �������� ��������
		
		while (left<Queue.size()) {//���� �� ������� ��� ������ ���������
			int max = left; //����������� ��� ����� ������� ������ ��������
			int right = left+1;//������ ������� �������
			
			if( right<Queue.size() && Queue.get(right).compareTo(Queue.get(curr))>0 ) {//���� �� ����� ������ � ���� ������ ������� ��� �� ������ �������� ��������
				max = right;//������ ������� ������� �� max
			}
			if (right<Queue.size() && Queue.get(left).compareTo(Queue.get(right))>0) {//��������� ������� � ����� ��������. ���� ����� ������ ��� ������
				max=left;//������ ������ ������� �� max
			}
			if (Queue.get(curr).compareTo(Queue.get(max))<0) {//���� ������� ������� ������ ������ �������, ��� �������� �������
				E temp = Queue.get(curr);
				Queue.set(curr, Queue.get(max));
				Queue.set(max, temp);
				curr = max;//���� ������ ���� �� ������
				left = 2*curr+1;//������ ������ �������
			}
			else break;
		}		
		return ret;//������� �������� �� �������
	}
	
	public E getMax() {//������� ������������� �������� � �������
		return Queue.get(0);
	}
	
	public void deleteAll() {//������� ��� �������� � �������
		Queue.removeAll(Queue);
	}		
}
