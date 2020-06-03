import Jama.Matrix;

public class N6
{
	public static double[][] tab = { {4, -1, 0},
			                         {-1, 4, -1},
			                         {0, -1, 4} };

	public static double[][] tab2 = { {0, 0, 0},
			                          {-1, 0, 0},
			                          {0, -1, 0} };

	public static double[][] tab3 = { {4, 0, 0},
			                          {0, 4, 0},
			                          {0, 0, 4} };

	public static double[][] tab4 = { {0, -1, 0},
				                      {0, 0, -1},
                                      {0, 0, 0} };

	public static double[][] tab5 = { {0}, {0}, {0} };

	public static double[][] tab6 = { {2}, {6}, {2} };

	/*MJ*/
	public static Matrix A = new Matrix(tab);
	public static Matrix L = new Matrix(tab2);
	public static Matrix D = new Matrix(tab3);
	public static Matrix U = new Matrix(tab4);
	public static Matrix X = new Matrix(tab5);
	public static Matrix b = new Matrix(tab6);
	public static Matrix N = D.inverse(); //N w mJ i D_1 w GS

	public static Matrix minusD = N.uminus();
	public static Matrix LU = L.plus(U);
	public static Matrix M = minusD.times(LU); //M

	public static Matrix Nb = N.times(b);
	public static Matrix Mx = M.times(X);
	public static Matrix Xn;
	public static Matrix Xn1;

	/*GS*/
	public static Matrix Xn2;
	public static Matrix Xn21;
	public static Matrix Xpomo;
	public static Matrix DL = D.plus(L);
	public static Matrix DL_1 = DL.inverse(); //G
	public static Matrix minusU = U.uminus();
	public static Matrix minusUX = minusU.times(X);
	public static Matrix minusUXb = minusUX.plus(b); //S

	/*SOR*/
	public static Matrix Xn3;
	public static double w = 1.2;
	public static double o = 1-w;
	public static Matrix wU = U.times(w);
	public static Matrix DwU = D.plus(wU);
	public static Matrix DmwU = D.minus(wU);
	public static Matrix oD = D.times(o);
	public static Matrix oDmwU = oD.minus(wU);

	public static Matrix wL = L.times(w);
	public static Matrix DwL = D.plus(wL);
	public static Matrix DwL_1 = DwL.inverse();
	public static Matrix DwL_1b = DwL_1.times(b);

	public static Matrix B = DwL_1.times(oDmwU);
	public static Matrix Bw = B.times(w);
	public static Matrix Bwx = Bw.times(X);
	public static Matrix c = DwL_1b.times(w);

	/*Metoda relaksacyjna*/
	public static Matrix Xn4;
	public static double y = 0.2;
	public static Matrix AX = A.times(X);
	public static Matrix bAX = b.minus(AX);
	public static Matrix ybAX = bAX.times(y);
	public static Matrix AXn;
	public static Matrix bAXn;
	public static Matrix ybAXn;

	public static void metodaJacobiego() //24 iteracje
	{
		for(int i=0; i<24; i++)
		{
			Xn=Mx.plusEquals(Nb);
			Mx = M.times(Xn);
			Nb = N.times(b);
		}
	}

	public static void metodaGaussaSeidela()
	{
		for(int i=0; i<13; i++) //13 iteracji
		{
			Xn2=DL_1.times(minusUXb);
			minusUX = minusU.times(Xn2);
			minusUXb = minusUX.plus(b);
		}

	}

	public static void SOR()
	{
		for(int i=0; i<3; i++) //Wiecej niz 100 iteracji.
		{
			Xn3 = Bwx.plus(c);
			Bwx = Bw.times(Xn3);

		}

	}

	public static void metodarelaksacyjna() //34 iteracje
	{
		for(int i=0; i<34; i++)
		{

			Xn4 = X.plus(ybAX);
			X=Xn4;
			AXn=A.times(Xn4);
			bAXn = b.minus(AXn);
			ybAXn = bAXn.times(y);
			ybAX=ybAXn;
		}
	}


	public static void main(String[] args)
	{

		System.out.println("Metoda relaksacyjna:");
		metodarelaksacyjna();
		Xn4.print(1, 10);

		System.out.println("Metoda Jacobiego:");
		metodaJacobiego();
		Xn.print(1, 10);

		System.out.println("Metoda Gaussa-Seidela:");
		metodaGaussaSeidela();
		Xn2.print(1, 10);

		System.out.println("Successive OverRelaxation:");
		SOR();
		Xn3.print(1, 10);


	}
}
