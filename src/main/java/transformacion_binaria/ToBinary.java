package transformacion_binaria;

public class ToBinary {

    long binary;

    public ToBinary(long binary) {
        this.binary = binary;
    }


    public String toBinaryNumber() {
        StringBuilder binaryNumber = new StringBuilder();
        int number = 0;
        if(binary > 0) number = 0;
        else if( binary < 0) number = 1;

        binary = Math.abs(binary);

        do {
            if(binary % 2 == 0) binaryNumber.append("0");
            else if(binary % 2 == 1) binaryNumber.append("1");
            else binaryNumber.append("1");
            binary /= 2;
        } while (binary >= 1);

        binaryNumber.append(" ")
                .append(number);
        binaryNumber.reverse();

        return  binaryNumber.toString();
    }

    @Override
    public String toString() {
        return Long.toString(binary);
    }
}
