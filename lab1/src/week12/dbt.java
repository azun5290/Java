package week12;

public static void dbt(int X, double x0, double y0, double stemLength, double theta) {
	{
		if (X>0) {
			double x1 = x0 + stemLength*Math.cos(theta);
			double y1 = y0 + stemLength*Math.sin(theta);
			StdDraw.line(x0, y0, x1, y1); //root stem
			dbt(X-1, x1, y1, 0.75*stemLength, theta*Math.random());
			dbt(X-1, x1, y1, 0.75*stemLength, theta + (Math.PI -theta)*Math.random());
		}
	}
	public static void main(String[] args){
		dbt (10, 0.5, 0.0, 0.25, 0.5*Math.PI);
	}
}