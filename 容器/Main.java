//Main.java
package ceshi;
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		
		Student Tom = new Student("Tom", 1001);
		Student Jerry = new Student("Jerry", 1002);
		Student Mary = new Student("Mary", 1003);
		
		//使用数组
		Student[] s = new Student[10];
		s[0] = Tom;
		s[1] = Jerry;
		s[2] = Mary;
		
		int i = 0;
		while(s[i]!=null) {
			System.out.println(s[i].name);
			i++;
			
		}
		
		
		//使用List
		
		List<Student> stulist= new ArrayList<>(Arrays.asList(Tom,Jerry,Mary));
		System.out.println(stulist);
		
		
		// 使用Set
		Set<Student> stuset = new HashSet<>(Arrays.asList(Tom,Jerry,Mary));
		System.out.println(stuset);
		
		//使用Map
		Map<Integer,Student> stumap = new HashMap<>();
		for(int k = 0; k<3;k++)
		{
			stumap.put(k,s[k]);
			
		}
		System.out.println(stumap);
		
	}

}
