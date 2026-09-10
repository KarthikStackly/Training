public class StringBufferBuilder {

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer("Stackly");
        StringBuilder builder = new StringBuilder("Stackly");

// oh we're showing String Mutability here, because Strings by design are supposed to be immutable.
        buffer.append(" LLC");
        builder.append(" LLC");

        System.out.println("StringBuffer: " + buffer);
        System.out.println("StringBuilder: " + builder);

        buffer.insert(8, "PreyFox ");
        builder.insert(8, "PreyFox ");

//        WE're using the same strings for appending, inserting in between and reversing...
        System.out.println("After insert:");
        System.out.println("StringBuffer: " + buffer);
        System.out.println("StringBuilder: " + builder);

        buffer.reverse();
        builder.reverse();

        System.out.println("After reverse:");
        System.out.println("StringBuffer: " + buffer);
        System.out.println("StringBuilder: " + builder);
    }
}