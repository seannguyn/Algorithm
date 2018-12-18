package coding_Challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


/*
 * 		given a list of points, and a vertex, and a value k.
 * 
 * 		find the distance that is k smallest from the vertex, and return all the points with that points
 * 
 * 
 */

public class Problem_13 {
	
	public static void main(String[] args) {
		Problem_13 t = new Problem_13();
		
		Point p1 = t.new Point(1,2);
		Point p2 = t.new Point(2,1);
		Point p3 = t.new Point(4,4);
		Point p4 = t.new Point(-1,-1);
		Point p5 = t.new Point(-3,-3);
		Point p6 = t.new Point(-4,-4);
		Point p7 = t.new Point(-5,-5);
		Point vertex = t.new Point(2,2);
		
		ArrayList<Point> pointList = new ArrayList<Point>();
		pointList.add(p1);
		pointList.add(p2);
		pointList.add(p3);
		pointList.add(p4);
		pointList.add(p5);
		pointList.add(p6);
		pointList.add(p7);
		
		HashMap<Float, LinkedList<Point>> distanceHash = vertex.computeHashSet(vertex, pointList);
		ArrayList<Float> distance = new ArrayList<Float>(distanceHash.keySet());
		
		
		float dist = vertex.find_kth_smallest_point(distance, 0, distance.size()-1, 1);
		LinkedList<Point> points= distanceHash.get(dist);
		System.out.println();
		
		System.out.println("distance is:   "+dist);
		for (Point p : points) {
			System.out.println(" ("+p.x+","+p.y+") ");
		}
	}
	
	public class Point {
		int x;
		int y;
		public Point (int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public float distance(Point p1, Point p2) {

			float distance = (float) Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)); 
			return distance;
		}
		
		public HashMap<Float, LinkedList<Point>>computeHashSet(Point p1, ArrayList<Point> pointList) {
			
			HashMap<Float,LinkedList<Point>> distancePoint = new HashMap<Float,LinkedList<Point>>();
			
			for (Point p : pointList) {
				
				float distance = distance(p1,p);
				LinkedList<Point> pointLinkedList;
				
				if (distancePoint.get(distance) == null) {
					pointLinkedList = new LinkedList<Point>();
					pointLinkedList.add(p);
					distancePoint.put(distance, pointLinkedList);
				} else {
					pointLinkedList=distancePoint.get(distance);
					pointLinkedList.add(p);
				}
				
			}
			
			return distancePoint;
		}
		
		public float find_kth_smallest_point(ArrayList<Float> distance, int left, int right, int k) {
			if ( k > 0 && k <= right - left + 1) {
				
				int position = partition(distance, left, right);
				
				if (position - left == k - 1) {
					return distance.get(position);
				} else if (position - left > k - 1) {
					return find_kth_smallest_point(distance, left, position - 1, k);
				}
				return find_kth_smallest_point(distance, position+1, right, k - position + left - 1);
			}
			return Integer.MAX_VALUE;
		}
		
		public int partition(ArrayList<Float> distance, int left, int right) {
			
			float pivot = distance.get(right);
			int i = left - 1;
			
			for (int j = left; j <= right - 1; j++) {
				float current_j = distance.get(j);
				if (current_j < pivot) {
					i++;
					
					// swap
					float current_i = distance.get(i);
					distance.set(i, current_j);
					distance.set(j, current_i);
				}
			}
			
			float current_i = distance.get(i+1);
			distance.set(i+1, pivot);
			distance.set(right, current_i);
			
			return i+1;
		}
	}
	
}
