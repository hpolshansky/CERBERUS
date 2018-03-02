import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		COBS encoder = new COBS();
		Random random = new Random();
		for(int i = 0; i<1000000;i++)
		{
			int len = random.nextInt(100 - 1 + 1) + 1; //Max 127 because java uses signed bytes
			byte[] test = new byte[len];
			new Random().nextBytes(test);
			//byte[] test = {0x01,0x01,0x03,0x00,0x04};
			byte[] msg =encoder.Encode(test);
			//System.out.println(Arrays.toString(test));
			//System.out.println(Arrays.toString(msg));
			byte[] rx_buf = ChanSim(msg);
			int input_buf_len = len+2;
			byte[] loc_rx_buf = new byte[input_buf_len];
			//init loc buf
			for(int k =0;k<loc_rx_buf.length;k++)
			{
				loc_rx_buf[k] = 0x01;
			}
			byte[] msgDec = new byte[msg.length];
			for(int k =0;k<rx_buf.length;k++) //simulate main hero loop
			{
				// slide in data
				byte nextByte = rx_buf[k];
				for(int j = 0;j<loc_rx_buf.length-1;j++)
				{
					loc_rx_buf[j]=loc_rx_buf[j+1];
				}
				loc_rx_buf[loc_rx_buf.length-1] = nextByte;
				
				//Check if in place
				if(loc_rx_buf[loc_rx_buf.length-1] == 0x00) //TODO: Make so isn't frame size specific
				{
					msgDec = encoder.Decode(loc_rx_buf);
				}
			}
			//byte[] msgDec = encoder.Decode(msg);
			//System.out.println(Arrays.toString(msgDec));
			if(!Arrays.equals(msgDec,test)) {
				//System.out.println(Arrays.equals(msgDec,test));
				System.out.println("Failed");
			}
		}
		System.out.println("Works");
	}

	
	public static byte[] ChanSim(byte[] tx_data) {
		Random random = new Random();
		int len_bef = random.nextInt(100 - 30 + 1) + 30;
		int len_aft = random.nextInt(100 - 30 + 1) + 30;
		int resLen = len_bef + len_aft + tx_data.length;
		byte[] res = new byte[resLen];
		for(int i = 0;i<resLen;i++)
		{
			if((i<len_bef)||(i>(len_bef+tx_data.length-1)))
			{
				res[i] = 0x01; //Rand value-Not zero
			}
			else
			{
				res[i] = tx_data[(i-len_bef)];
			}
		}
		return res;
	}
}
