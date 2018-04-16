package cerberusMonitor;

public class COBS {
	public COBS() {
		//Nothing todo
	}
	public byte[] Encode(byte[] data) {
		//TODO: Add check for count > 254
		byte[] tmp = new byte[data.length];
		for(int i = 0; i<data.length; i++)
		{
			tmp[i] = data[i];
		}
		int count = 0;
		for(int i = data.length-1;i>=0;i--)
		{
			count++; 
			if(data[i] == 0)
			{
				tmp[i] = (byte)count;
				count = 0; //will be added next time in loop
			}
		}
		count++;
		byte[] res = new byte[tmp.length + 2]; //One byte overhead + one byte end of packet indicator(0x00)
		res[0] = (byte)count;
		res[tmp.length + 1] = 0x00;
		for(int i = 0;i<tmp.length;i++)
		{
			res[1+i] = tmp[i];
		}
		return res;
	}
	
	public byte[] Decode(byte[] frame) {
		//Assumes the zero end of packet is included
		//TODO: Add check for valid frame
		byte[] data = new byte[frame.length-2];
		byte count = frame[0];
		int ind = 0; //Start right after overhead
		while(count > 0)
		{
			ind++;
			count--;
			if(count == 0)
			{
				if(frame[ind] != 0x00)
				{
					//Not Done. Replace with zero
					count = frame[ind];
					data[ind-1] = 0x00;
				}
			}
			else
			{
				try{
					data[ind-1] = frame[ind];
				}
				catch(ArrayIndexOutOfBoundsException exception)
				{
					System.out.println("Fail");
				}
			}
		}
		return data;
	}
}
