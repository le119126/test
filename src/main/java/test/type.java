package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class type {
	
	static class Point {
	     int x;
	     int y;
	     Point() { x = 0; y = 0; }
	     Point(int a, int b) { x = a; y = b; }
	 }

    public int maxPoints(Point[] points) {
        int ret=0;
        for(int i=0;i<points.length;i++){
            Map<Double,Integer> map=new HashMap<Double,Integer>();//过i点的直线的斜率-key 
            int count=1;//与i点重合的点，它自身算一个
            for(int j=i+1;j<points.length;j++){
                double dx=points[j].x-points[i].x;
                double dy=points[j].y-points[i].y;
                Double xl=0.0;
                if(dx==0){
                     if(dy!=0) xl=Double.MAX_VALUE;
                     else   {
                    	count++;//重复点 
                    	continue;
                     }
                }
                else{
                	xl=dy/dx;
                }
                if (!map.containsKey(xl)) {  
                    map.put(xl, 1);
                }
                else{
                    map.put(xl, map.get(xl)+1);
                    
                }
            }
            ret=ret<count?count:ret; //只有一个点的时候，下面for循环没有执行，ret等于0.所以要加这一句
            //一定要最后来统计最大值，应为如果后面的都是重复点呢，count一直加加呢
            for (double key : map.keySet()) {  
                ret = Math.max((count + map.get(key)), ret);   
            }  
        }
        return ret;
    }

    public String reverseWords(String s) {
        s=s.trim();
        int start=0;
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();){
            if(sb.charAt(i)==' '){
                sb=revereWords(sb,start,i-1);
                start=i+1;
                //删除后面的空格
                while( (++i)<sb.length() && sb.charAt(i)==' ' ){
                	sb.deleteCharAt(i);
                	--i;//一定要减去，因为删除后面一个，所有后面的前移一个
                }
            }
            else
            	i++;
        }
        if(start!=0)
        	sb=revereWords(sb,start,sb.length()-1);//最后的如“abc ccd” 翻转ccd
        return revereWords(sb,0,sb.length()-1).toString();
    }
    public StringBuilder revereWords(StringBuilder sb,int start,int end){
        if(end<=start)
            return sb;
        int dx=(end+1-start)/2;
        for(int i=0;i<dx;i++){
            char c=sb.charAt(i+start);
            sb.setCharAt(i+start,sb.charAt(end-i));
            sb.setCharAt(end-i,c);
        }
        return sb;
    }
    
	public static void main(String args[])
	{
		Point[] ps=new Point[3];
		ps[0]=new Point();
		ps[1]=new Point(1,1);
		ps[2]=new Point(1,-1);
		type t=new type();
		String c=t.reverseWords("hello world!");
		double aa=0.0/-1;
		String tt=new String();
		tt+=aa;
		System.out.println( aa ==(0/1));
		System.out.println(c);
		Stack<Integer> st=new Stack<Integer>();
		st.push(11);
		
	}

}
