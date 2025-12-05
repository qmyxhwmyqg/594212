public class NegativeNumberException extends Exception{
    public NegativeNumberException(double negativeNumber) {
        super("错误：输入了负数 " + negativeNumber);
    }
}
