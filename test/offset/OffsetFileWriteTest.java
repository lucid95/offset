package offset;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class OffsetFileWriteTest
{
	@Test
	public void testTemp1() throws IOException
	{
		String outFileName = "d:\\test1.dat";

		FileOutputStream out = new FileOutputStream(outFileName);

		Temp1 temp1 = new Temp1();

		temp1.setTime(1511249982);
		temp1.setNumber(500);
		temp1.setParamStaring("sensor1");
		temp1.setNumber2(1511249982);

		out.write(temp1.getBytes());
		out.close();
	}

	@Test
	public void testReadTemp1() throws IOException
	{
		String outFileName = "d:\\test1.dat";

		File outFile = new File(outFileName);
		FileInputStream in = new FileInputStream(outFile);

		long fileLength = outFile.length();
		byte[] buffer = new byte[(int) fileLength];

		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length && (numRead = in.read(buffer, offset, buffer.length - offset)) >= 0)
		{
			offset += numRead;
		}
		in.close();

		Temp1 temp1 = new Temp1(buffer);

		System.out.println(temp1.toString());
	}

	@Test
	public void testTemp2() throws IOException
	{
		String outFileName = "d:\\test2.dat";

		FileOutputStream out = new FileOutputStream(outFileName);

		Temp2 temp2 = new Temp2();

		temp2.setTime(1511249882000L);
		temp2.setNumber1(400);
		temp2.setNumber2(600);

		out.write(temp2.getBytes());
		out.close();
	}

	@Test
	public void testTemp3() throws IOException
	{
		String outFileName = "d:\\test3.dat";

		FileOutputStream out = new FileOutputStream(outFileName);

		Temp1 temp1 = new Temp1();

		temp1.setTime(1511248882);
		temp1.setNumber(400);
		temp1.setParamStaring("sensor1");
		temp1.setNumber2(600);

		out.write(temp1.getBytes());

		temp1.setTime(1511248982);
		temp1.setNumber(500);
		temp1.setParamStaring("sensor1");
		temp1.setNumber2(700);

		out.write(temp1.getBytes());

		out.close();
	}

	@Test
	public void testTemp4() throws IOException
	{
		String outFileName = "d:\\test4.dat";

		FileOutputStream out = new FileOutputStream(outFileName);

		Temp2 temp2 = new Temp2();

		temp2.setTime(1511248882000L);
		temp2.setNumber1(400);
		temp2.setNumber2(600);

		out.write(temp2.getBytes());

		temp2.setTime(1511248982000L);
		temp2.setNumber1(500);
		temp2.setNumber2(700);

		out.write(temp2.getBytes());

		out.close();
	}

	@Test
	public void testTemp5() throws IOException
	{
		String outFileName = "d:\\test5.dat";

		FileOutputStream out = new FileOutputStream(outFileName);

		out.write("0512M".getBytes());

		out.close();
	}

	@Test
	public void testTempIntegerWrite() throws IOException
	{
		String outFileName = "d:\\testInt.dat";
		FileOutputStream out = new FileOutputStream(outFileName);

		int i = 1511249982;
		DataOutputStream os = new DataOutputStream(out);

		os.writeInt(i);

		os.close();
		out.close();
	}

	@Test
	public void testTempIntegerRead() throws IOException
	{
		String outFileName = "d:\\testInt.dat";
		FileInputStream in = new FileInputStream(outFileName);

		DataInputStream is = new DataInputStream(in);

		int i = is.readInt();
		System.out.println(i);

		is.close();
		in.close();
	}
}
