package com.arrays.algo;

import java.util.ArrayList;
import java.util.List;

public class MoveToEnd {

	public static void main(String[] args) {
		
		List<Integer> in = new ArrayList<>();
		in.add(2);
		in.add(1);in.add(2);in.add(2);in.add(2);in.add(3);in.add(4);in.add(2);
		List<Integer> list = moveToEnd(in,2);
		list.stream().forEach(x->System.out.print(x+" "));
	}
	
	public static List<Integer> moveToEnd(List<Integer> list, int idx){
		int moveToIdx =0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i) != idx) {
				swap(list,i,moveToIdx);
				moveToIdx++;
			}
		}
		return list;
	}
	public static void swap(List<Integer> list, int i , int idx) {
		int temp  = list.get(i);
		list.set(i,list.get(idx));
		list.set(idx,temp);
	}

}
