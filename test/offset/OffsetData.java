package offset;

public abstract class OffsetData
{
	public abstract byte[] getBytes();

	protected String extractString(byte[] buff, int offset, int len)
	{
		return new String(buff, offset, len).trim();
	}

	protected String strval(String str, int len)
	{
		String rt = str;
		for (int i = str.length(); i < len; i++)
			rt += " ";

		return rt;
	}

	protected byte[] byteval(String str, int stringlen, int bytelen)
	{
		byte[] rt = new byte[bytelen];

		for (int i = 0; i < bytelen; i++)
			rt[i] = 0x00;
		System.arraycopy(str.getBytes(), 0, rt, 0, stringlen);

		return rt;
	}

	public static byte[] longToBytes(long value)
	{
		byte[] result = new byte[8];
		result[0] = (byte) (int) (value >> 56 & 255L);
		result[1] = (byte) (int) (value >> 48 & 255L);
		result[2] = (byte) (int) (value >> 40 & 255L);
		result[3] = (byte) (int) (value >> 32 & 255L);
		result[4] = (byte) (int) (value >> 24 & 255L);
		result[5] = (byte) (int) (value >> 16 & 255L);
		result[6] = (byte) (int) (value >> 8 & 255L);
		result[7] = (byte) (int) (value & 255L);
		return result;
	}

	public static byte[] unsignedIntToBytes(long value)
	{
		byte[] result = new byte[4];
		result[0] = (byte) (int) (value >> 24 & 0xffL);
		result[1] = (byte) (int) (value >> 16 & 0xffL);
		result[2] = (byte) (int) (value >> 8 & 0xffL);
		result[3] = (byte) (int) (value & 0xffL);
		return result;
	}

	public static byte[] booleanToBytes(boolean value)
	{
		if (value)
			return intToBytes(1);
		else
			return intToBytes(0);
	}

	public static byte[] intToBytes(int value)
	{
		byte[] result = new byte[4];
		result[0] = (byte) (value >> 24 & 0xff);
		result[1] = (byte) (value >> 16 & 0xff);
		result[2] = (byte) (value >> 8 & 0xff);
		result[3] = (byte) (value & 0xff);
		return result;
	}

	public static byte[] shortToBytes(short value)
	{
		byte[] result = new byte[2];
		result[0] = (byte) (value >> 8 & 0xff);
		result[1] = (byte) (value & 0xff);
		return result;
	}

	public static long bytesToLong(byte[] bytes)
	{
		return bytesToLong(bytes, 0);
	}

	public static long bytesToLong(byte[] bytes, int offset)
	{
		long result = 0x0000000000000000;

		int length = 0;
		if (bytes.length - offset < 8)
			length = bytes.length - offset;
		else
			length = 8;

		int end = offset + length;
		for (int i = 0; i < length; i++)
		{
			result |= (bytes[end - i - 1] & 0xffL) << (8 * i);
		}

		return result;
	}

	public static long bytesToUnsignedInt(byte[] bytes)
	{
		return bytesToUnsignedInt(bytes, 0);
	}

	public static long bytesToUnsignedInt(byte[] bytes, int offset)
	{
		long result = 0x0000000000000000;

		int length = 0;
		if (bytes.length - offset < 4)
			length = bytes.length - offset;
		else
			length = 4;

		int end = offset + length;
		for (int i = 0; i < length; i++)
		{
			result |= (bytes[end - i - 1] & 0xffL) << (8 * i);
		}

		return result;
	}

	public static int bytesToInt(byte[] bytes)
	{
		return bytesToInt(bytes, 0);
	}

	public static int bytesToInt(byte[] bytes, int offset)
	{
		int result = 0x00000000;

		int length = 0;
		if (bytes.length - offset < 4)
			length = bytes.length - offset;
		else
			length = 4;

		int end = offset + length;
		for (int i = 0; i < length; i++)
		{
			result |= (bytes[end - i - 1] & 0xff) << (8 * i);
		}
		return result;
	}

	public static short bytesToShort(byte[] bytes)
	{
		return bytesToShort(bytes, 0);
	}

	public static short bytesToShort(byte[] bytes, int offset)
	{
		short result = 0x0000;
		int end = offset + 2;
		for (int i = 0; i < 2; i++)
		{
			result |= (bytes[end - i - 1] & 0xff) << (8 * i);
		}
		return result;
	}

	public static byte intToOctet(int value)
	{
		return (byte) (value & 0xFF);
	}

	public static int octetToInt(byte[] bytes, int offset)
	{
		return (int) (bytes[offset] & 0xFF);
	}

	public static byte[] intToTriOctets(int value)
	{
		byte[] result = new byte[3];
		result[0] = (byte) (value >> 16 & 0xff);
		result[1] = (byte) (value >> 8 & 0xff);
		result[2] = (byte) (value & 0xff);
		return result;
	}

	public static int triOctetsToInt(byte[] bytes, int offset)
	{
		int result = 0x00000000;

		int length = 0;
		if (bytes.length - offset < 3)
			length = bytes.length - offset;
		else
			length = 3;

		int end = offset + length;
		for (int i = 0; i < length; i++)
			result |= (bytes[end - i - 1] & 0xff) << (8 * i);

		return result;
	}

	public static boolean bytesToBoolean(byte[] bytes, int offset)
	{
		int result = bytesToInt(bytes, 0);

		if (result > 0)
			return true;
		else
			return false;
	}

}
