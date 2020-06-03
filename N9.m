A = [ 1 2 3;
     2 4 5;
     3 5 -1;];
     
x = [1; 1; 1];
q=x;
j=x;
     
T=A;
epsilon = 1e-8;
test=max(max(abs(tril(A, -1))));

 %Metoda QR 
  while test>epsilon
     
    [Q, R] = qr (T);
    T=R*Q;
     
    test=max(max(abs(tril(T, -1))));
     
  end
  disp("QR:")
  lambda1=T(1,1)
  lambda2=T(2,2)
  lambda3=T(3,3)
 
 %Metoda potegowa
 do

  y=A*x;
  x=y/norm(y);
  
  yk=A*x;
  xk=yk/norm(yk);
  
  z=(A-3*eye(3))\q;
  q=z/norm(z);
  
  o=(A-(-4)*eye(3))\j;
  j=o/norm(o);
  
  
  until((xk-x)<epsilon)

disp("\nMetoda potegowa: ")
lambda1=x'*A*x/norm(x)^2
lambda2=o'*A*o/norm(o)^2
lambda3=z'*A*z/norm(z)^2

%Metoda Rayleigha
  mi = 200;
  
  x= x/norm(x);
  y=(A - mi * eye(rows(A)))\ x; 
  lambda = y' * x;
  mi = mi + 1 / lambda;
  blad = norm(y - lambda * x)/norm(y);

  do
  
    x = y / norm(y);
    
    y = (A - mi * eye(rows(A)))\x;
    lambda = y' * x;
    mi = mi + 1/lambda;
    
    z=(A-(-4)*eye(rows(A)))\q;
    q=z/norm(z);
   
    o=(A-0*eye(rows(A)))\j;
    j=o/norm(o);
    
    blad = norm(y - lambda * x)/norm(y);
    
  until(blad<epsilon)
  
  lambda1=mi;
  lambda2=o'*A*o/norm(o)^2;  
  lambda3=z'*A*z/norm(z)^2;

   disp("\nMetoda Rayleigha: ")
   lambda1
   lambda2
   lambda3
   