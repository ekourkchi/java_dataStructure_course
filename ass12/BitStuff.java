import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;


class BitStuff
{
    // Get bit "n" from an integer "b"
    static int getBit(int b, int n)
    {
        // Move the bit we want to check into bit position 0 by
        // shifting "n" bits to the right...
        b = b >> n;

        // There may be other bits above the bit we're interested
        // in, so mask those off by "anding" with 1.
        b = b & 1;

        // This will either be 0 or 1.
        return b;
    }

    // Extracts a byte from within a 4-byte integer value. The "msb"
    // parameters is the offset of the most significant bit (MSb).
    static int extractByte(int bits, int msb)
    {
        int     b = 0;

        // Since a byte is 8-bits, loop 8 times.
        for (int i = 0; i < 8; i++)
        {
            // Scoot the current value left by one bit.  Note that the
            // first iteration of this loop really does nothing since
            // the value "b" was initialized to 0; shifting 0 by any
            // number still results in 0.
            b = b << 1;

            // Bitwise "or" in the the next bit in the sequence;
            b = b | getBit(bits, msb - i);
        }

        return b;
    }

    public static void main(String[] args)
    {
        try
        {
            FileInputStream         fin = new FileInputStream(args[0]);
            int                     cnt = 0;
            int                     b;

            cnt = cnt | fin.read() << 24;
            cnt = cnt | fin.read() << 16;
            cnt = cnt | fin.read() << 8;
            cnt = cnt | fin.read() << 0;

            System.out.println( "b=" + cnt );

            b = fin.read();
            System.out.println("bit=" + getBit(b, 4) );
            System.out.println("bit=" + getBit(b, 5) );


            // v = 1010 1110 1001 0111 
            int v = 0xAE97;

            // Build a byte from the value "v" starting at the offset from the
            // MOST SIGNIFICANT BIT 2.
            // Extract the byte within the brackets: 10[10 1110 10]01 0111
            // The value of the byte should be 0xBA (or 186 decimal)
            b = extractByte(v, 13);
            System.out.println("b=" + b);
        }
        catch (FileNotFoundException fne)
        {

        }
        catch (IOException ioe)
        {

        }
    }
}