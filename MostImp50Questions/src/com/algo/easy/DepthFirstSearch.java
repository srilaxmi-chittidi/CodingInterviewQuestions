package com.algo.easy;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> array = new ArrayList<>();
	}

	static class Node{
		String name;
		List<Node> children = new ArrayList<>();
		public Node(String name) {
			this.name = name;
		}
		public List<String> depthFirstSearch(List<String> array){
			array.add(name);
			children.forEach(child->child.depthFirstSearch(array));
			return array;
		}
		public Node addNode(String name) {
			Node node = new Node(name);
			children.add(node);
			return this;
		}
	}
}
