function [Xn] = N7(A,b,X)
  
A = [ 4 -1 0;
     -1  4 -1;
      0 -1 4;]
        
b = [2; 6; 2] 

X=randn(3,1)+100

epsilon = 1e-10;

  r = b - A*X;
  mr = -r;
  Amr = A*mr;
  
  c = (r'*mr);
  d = (mr'*Amr);
  a = c/d;
  
  Xn = X + a*mr;

    while  (i = 1:size(A,1))
    r = r - a*Amr;
      if( norm(r) < epsilon )
      break;
    
    end
  
    B = (r'*Amr)/(mr'*Amr);
    mr = -r + B*mr;
    Amr = A*mr;
    a = (r'*mr)/(mr'*Amr);
    Xn = Xn + a*mr;
    end

 end