package offset;

public class Temp2 extends OffsetData
{
	public static final int LEN_TIME = 8;
	public static final int LEN_NUMBER1 = 4;
	public static final int LEN_NUMBER2 = 4;

	public static final int OFFSET_TIME = 0;
	public static final int OFFSET_NUMBER1 = OFFSET_TIME + LEN_TIME;
	public static final int OFFSET_NUMBER2 = OFFSET_NUMBER1 + LEN_NUMBER1;

	public static final int LEN_PACKET = OFFSET_NUMBER2 + LEN_NUMBER2;

	public long time;
	public int number1;
	public int number2;

	private byte[] bytearr = new byte[LEN_PACKET];

	public Temp2()
	{
		for (int i = 0; i < bytearr.length; i++)
		{
			bytearr[i] = 0x00;
		}
	}

	public Temp2(byte[] buff)
	{
		for (int i = 0; i < bytearr.length; i++)
		{
			bytearr[i] = 0x00;
		}

		this.time = bytesToLong(buff, OFFSET_TIME);
		this.number1 = bytesToInt(buff, OFFSET_NUMBER1);
		this.number2 = bytesToInt(buff, OFFSET_NUMBER2);
	}

	public void setTime(long time)
	{
		this.time = time;
		System.arraycopy(longToBytes(time), 0, bytearr, OFFSET_TIME, LEN_TIME);
	}

	public void setNumber1(int number1)
	{
		this.number1 = number1;
		System.arraycopy(intToBytes(number1), 0, bytearr, OFFSET_NUMBER1, LEN_NUMBER1);
	}

	public void setNumber2(int number2)
	{
		this.number2 = number2;
		System.arraycopy(intToBytes(number2), 0, bytearr, OFFSET_NUMBER2, LEN_NUMBER2);
	}

	@Override
	public byte[] getBytes()
	{
		return bytearr;
	}
}
