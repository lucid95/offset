package offset;

import java.util.Arrays;

public class Temp1 extends OffsetData
{
	public static final int LEN_TIME = 4;
	public static final int LEN_NUMBER1 = 4;
	public static final int LEN_PARAMSTRING = 8;
	public static final int LEN_NUMBER2 = 4;

	public static final int OFFSET_TIME = 0;
	public static final int OFFSET_NUMBER1 = OFFSET_TIME + LEN_TIME;
	public static final int OFFSET_PARAMSTRING = OFFSET_NUMBER1 + LEN_NUMBER1;
	public static final int OFFSET_NUMBER2 = OFFSET_PARAMSTRING + LEN_PARAMSTRING;

	public static final int LEN_PACKET = OFFSET_NUMBER2 + LEN_NUMBER2;

	public int time;
	public int number1;
	public String paramString;
	public int number2;

	private byte[] bytearr = new byte[LEN_PACKET];

	public Temp1()
	{
		for (int i = 0; i < bytearr.length; i++)
		{
			bytearr[i] = 0x00;
		}
	}

	public Temp1(byte[] buff)
	{
		for (int i = 0; i < bytearr.length; i++)
		{
			bytearr[i] = 0x00;
		}

		this.time = bytesToInt(buff, OFFSET_TIME);
		this.number1 = bytesToInt(buff, OFFSET_NUMBER1);
		this.paramString = extractString(buff, OFFSET_PARAMSTRING, LEN_PARAMSTRING);
		this.number2 = bytesToInt(buff, OFFSET_NUMBER2);
	}

	public void setTime(int time)
	{
		this.time = time;
		System.arraycopy(intToBytes(time), 0, bytearr, OFFSET_TIME, LEN_TIME);
	}

	public void setNumber(int number)
	{
		this.number1 = number;
		System.arraycopy(intToBytes(number), 0, bytearr, OFFSET_NUMBER1, LEN_NUMBER1);
	}

	public void setParamStaring(String paramString)
	{
		this.paramString = paramString;
		System.arraycopy(paramString.getBytes(), 0, bytearr, OFFSET_PARAMSTRING, paramString.length());
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

	@Override
	public String toString()
	{
		return "Temp1 [time=" + time + ", number=" + number1 + ", paramString=" + paramString + ", number2=" + number2
				+ ", bytearr=" + Arrays.toString(bytearr) + "]";
	}

}
