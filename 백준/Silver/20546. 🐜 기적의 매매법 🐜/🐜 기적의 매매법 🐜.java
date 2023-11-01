import java.io.*;
import java.util.*;

public class Main {
	static class Stock{
		int junMoney, junStock, sungMoney, sungStock;
		public Stock(int junMoney, int junStock, int sungMoney, int sungStock) {
			this.junMoney = junMoney;
			this.junStock = junStock;
			this.sungMoney = sungMoney;
			this.sungStock = sungStock;
		}
	}
	static class ValuesCheck {
		int value, cnt;
		public ValuesCheck(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}
	}
	static int money;
	static Stock[] s = new Stock[14];
	static ValuesCheck[] values = new ValuesCheck[14];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		money = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 14; i++) {
			s[i] = new Stock(money, 0, money, 0);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 14; i++) {
			int value = Integer.parseInt(st.nextToken());
			values[i] = new ValuesCheck(value, 0);
			
			if(i == 0) {
				// 준현이 주식
				if(value > s[i].junMoney) continue;
				s[i].junStock = s[i].junMoney / value;
				s[i].junMoney %= value;
			}
			else {
				// 성민이 주식
				if(value > values[i-1].value) {
					if(values[i-1].cnt > 0) values[i].cnt = values[i-1].cnt + 1;
					else values[i].cnt = 1;
				}
				else if(value < values[i-1].value) {
					if(values[i-1].cnt < 0) values[i].cnt = values[i-1].cnt - 1;
					else values[i].cnt = -1;
				}
				else {
					values[i].value = values[i-1].value;
					values[i].cnt = values[i-1].cnt;
				}
				// 이전값 세팅
				s[i].sungMoney = s[i-1].sungMoney;
				s[i].sungStock = s[i-1].sungStock;
				if(values[i].cnt <= -3) {
					if(value <= s[i].sungMoney) {
						s[i].sungStock = s[i].sungMoney / value;
						s[i].sungMoney %= value;
					}
				}
				else if(3 <= values[i].cnt) {
					s[i].sungMoney += s[i].sungStock * value;
					s[i].sungStock = 0;
				}
				
				// 준현이 주식
				// 이전값 세팅
				s[i].junMoney = s[i-1].junMoney;
				s[i].junStock = s[i-1].junStock;
				if(value > s[i].junMoney) continue;
				s[i].junStock = s[i].junMoney / value;
				s[i].junMoney %= value;
			}
		}
		
		int jun = s[13].junMoney + (values[13].value * s[13].junStock);
		int sung = s[13].sungMoney + (values[13].value * s[13].sungStock);
		if(jun < sung) System.out.println("TIMING");
		else if(jun > sung) System.out.println("BNP");
		else System.out.println("SAMESAME");
	}
}