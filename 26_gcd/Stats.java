/*
   <PENDING TNPG> -- Yat long Chan / Samantha Hua / Lindsay Phung
   APCS
   HW26 -- GCD Three Ways
   2021-10-27
   time spent: 0.5 hours
   DISCO
   - There are many different different algos that can solve the same problem.
   QCC
   - Which method would be the quickest or most efficient?
   ALGO
    public static int gcdER(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcdER((a - b), b);
        } else {
            return gcdER((b - a), a);
        }
    }
 */

public class Stats {

    public static int gcd(int a, int b) {
        int i = 1;
        int ans = a;
        if (a > b) {
            while (i < b) {
                if (((b % i) == 0) && ((a % i) == 0)) {
                    ans = i;
                }
                i++;
            }
        } else if (a < b) {
            while (i < a) {
                if (((b % i) == 0) && ((a % i) == 0)) {
                    ans = i;
                }
                i++;
            }
        }
        return ans;
    }

    public static int gcdER(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcdER((a - b), b);
        } else {
            return gcdER((b - a), a);
        }
    }

    public static int gcdEW(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
    /* ===================OLD STATS==========================
     public static int mean(int a, int b) {
       return (a+b)/2; 
     }
     public static double mean(double a, double b) {
       return (a+b)/2;
     }
     public static int max(int a, int b) {
       if (a > b) {
         return a;
       } 
       else if (a < b) {
         return b;
       } 
       else {
         System.out.println("The two values are equal");
         return 0;
       }
     }
     public static double max(double a, double b) {
       if (a > b) {
         return a;
       } 
       else if (a < b) {
         return b;
       } 
       else {
         System.out.println("The two values are equal");
         return 0; 
       }
     }
     public static int geoMean(int a, int b) {
       double product = a * b;
       return (int) Math.sqrt(product); 
     }
     public static double geoMean(double a, double b) {
       return Math.sqrt(a * b);
     }
     public static int max(int a, int b, int c) {
       if (a == b && a == c) {
         System.out.println("All values are equal to each other");
         return 0;
       }
       else if (a > b) {
         if (a > c) {
           return a;
         }
         else if (a == c) {
           System.out.println("'a' and 'c' are equally as large");
           return 0;
         }
         else {
           return c;
         }
       }
       else if (b > c) {
           if (a == b) {
             System.out.println("'a' and 'b' are equally as large");
             return 0;
           }
           else {
             return b;
         }
       }
       else if (b == c) {
           System.out.println("'b' and 'c' are equally as large");
           return 0;
         }
         
       else {
           return c;
       }
     }
     
     public static double max(double a, double b, double c) {
       if (a == b && a == c) {
         System.out.println("All values are equal to each other");
         return 0;
       }
       else if (a > b) {
         if (a > c) {
           return a;
         }
         else if (a == c) {
           System.out.println("'a' and 'c' are equally as large");
           return 0;
         }
         else {
           return c;
         }
       }
       else if (b > c) {
           if (a == b) {
             System.out.println("'a' and 'b' are equally as large");
             return 0;
           }
           else {
             return b;
         }
       }
       else if (b == c) {
           System.out.println("'b' and 'c' are equally as large");
           return 0;
         }
         
       else {
           return c;
       }
     }
     public static int geoMean(int a, int b, int c) {
       int product = a * b * c;
       return (int) Math.pow(product, 1.0/3.0);
     }
     public static double geoMean(double a, double b, double c) {
       double product = a * b * c;
       return Math.pow(product, 1.0/3.0);
     }
     
     public static double harmonicMean(double a, double b, double c) {
       //harmonic mean is the reciprocal of the arithmetic mean of the reciprocals
       double __ = ((1/a)+(1/b)+(1/c))/3
     }
    ===================OLD STATS========================== */

    public static void main(String[] args) {
       //should all print 3, so six 3s in terminal
        System.out.println(gcd(9, 15)); //"brute force" a < b
        System.out.println(gcd(15, 9)); //"brute force" a > b
        
        System.out.println(gcdER(9, 15)); //recursive a < b
        System.out.println(gcdER(15, 9)); //recursive a > b
        
        System.out.println(gcdEW(9, 15)); //while loop a < b
        System.out.println(gcdEW(15, 9)); //while loop a > b

    }
}
