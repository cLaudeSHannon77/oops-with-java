
public class AdditionDemo {

    public static void main(String[] args) {

        // Create Bean object
        AdditionBean bean = new AdditionBean();

        // Set the two numbers
        bean.setNum1(10);
        bean.setNum2(20);

        // Get and display the sum
        System.out.println("First Number: " + bean.getNum1());
        System.out.println("Second Number: " + bean.getNum2());
        System.out.println("Sum: " + bean.getSum());
    }
}

