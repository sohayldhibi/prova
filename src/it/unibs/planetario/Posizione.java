package it.unibs.planetario;



public class Posizione {
	double X;
	double Y;
	
	public Posizione(double x, double y) {
		X=x;
		Y=y;
	}
	
	public double getX() {
		return X;
	}
	public double getY() {
		return Y;
	}


        public String toString() {                 

                  return "X = "+X+" Y = "+Y;

        }
	
}
