#include <iostream>
#include <cmath>
#include <fstream>

using namespace std;

 double f(double x) {
    return exp(x);
 }

double w_przod(int x, double h)
{
    return (f(x+h) - f(x))/h;
}

double pieciopunktowy(int x, double h)
{
    return (-f(x+2*h) + 8*f(x+h) - 8*f(x-h) + f(x-2*h))/(12*h);
}

int main()
{

    int x=1;
    double h=0.001;

    cout.precision(20);
    cout<<w_przod(x,h)<<endl;
    cout<<pieciopunktowy(x,h)<<endl;

/*
    double wyniki, wyniki2, e=exp(1.0);
    ofstream plik;
	plik.open("plik.txt");

    for (h = pow(10.0, -18.0); h <1; h *= 1.01)
	{
        wyniki = log10 (abs(w_przod(x,h) - e));
        wyniki2 = log10 (abs(pieciopunktowy(x,h) - e));
		plik << log10(h)<<"  "<< wyniki <<"  "<< wyniki2 <<"\n";
		cout << log10(h)<<"  "<< wyniki <<"  "<< wyniki2 <<"\n";
	}

	plik.close();
	cout << endl;

*/

    return 0;
}

