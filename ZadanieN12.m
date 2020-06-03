f=@(x)sin(x^2+log(x))+tan(x);
dfdx = @(x) cos(log(x)+x^2)*(2*x+1/x)+(1/cos(x)^2);
format long;
epsilon=1e-10;

a=9.85;
b=10.0;
iteracje=0;

x=(a+b)/2;

%Metoda bisekcji

while (abs(f(x))>epsilon)
  if (f(x)*f(b))<0
    a=x;
    else
    b=x;
    end
    x=(a+b)/2;
 
 x0=x;
 iteracje=iteracje+1;
 end
 disp("Metoda bisekcji: ")
 x0
 iteracje
 
 
%Metoda Newtona
 
x0=9.90;
x=x0;
iteracje=0;

fx=f(x);

while (abs(fx)>epsilon)
  try
  x0=x;
  x0;
  x=x-(fx)/dfdx(x);
  end
  fx=f(x);
  iteracje=iteracje+1;
  end
  disp("\nMetoda Newtona: ")
  x0
  iteracje
  
%Metoda siecznych

x0 = 9.85;
x1 = 10.0;
iteracje=0;

fx0 = f(x0);
fx1 = f(x1);

while abs(fx1) > epsilon
   try
   mianownik = (fx1 - fx0)/(x1 - x0);
   x = x1 - (fx1)/mianownik;
  
   end
   x0 = x1;
   x1 = x;
   fx0 = fx1;
   fx1 = f(x1);
   iteracje=iteracje+1;
   
   end
   disp("\nMetoda siecznych: ")
   x0
   iteracje