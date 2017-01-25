

class stackImp {
    public static void main(String[] args) {
        stackImplementation s1 = new stackImplementation(10);
        s1.push(1.0);
        s1.push(2.0);
        s1.push(3.0);
        System.out.println(s1.pop());
        System.out.println(s1.top());
        System.out.println(s1.pop());
        System.out.println(s1.pop());

    }
}

    class stackImplementation {
        private double[] arr;
        private int pointer;
        private int size;

        public stackImplementation(int s){
            size = s;
            arr = new double[size];
            pointer = 0;
        }

        public void push(double d){
            arr[pointer] = d;
            pointer++;
        }

        public double pop(){
            pointer--;
            return arr[pointer];
            
        }

        public double top(){
            return arr[pointer - 1];
        }

    }



