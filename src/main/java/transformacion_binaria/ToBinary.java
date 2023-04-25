package transformacion_binaria;

public class ToBinary {

    long binary;

    public ToBinary(long binary) {
        this.binary = binary;
    }


    public String toBinaryNumber() {
        StringBuilder binaryNumber = new StringBuilder();
        if(binary > 0) binaryNumber.append("0");
        else if( binary < 0) binaryNumber.append("1");

        return  binaryNumber.append(Long.toBinaryString(binary)).toString();
    }

    @Override
    public String toString() {
        return Long.toString(binary);
    }
}
