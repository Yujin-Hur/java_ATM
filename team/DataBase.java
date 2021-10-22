package javaATM;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

	public class DataBase {

	    private static Map<String, Integer> info = new HashMap <String, Integer>();
		private static Map<String, Long> account = new HashMap <String, Long>();
		
	
		public DataBase() {
			info.put("00000-00000", 0000);
			account.put("00000-00000", (long)10000000);
			info.put("11111-11111", 1111);
			account.put("11111-11111", (long)20000);
			info.put("22222-22222", 2222);
			account.put("22222-22222", (long)30000);
		}  
	   
	
		static long getBalance(String id) {
			return account.get(id);
		}

		static void setBalance(String id, long cash) {
			
			account.put(id, cash);

		}
1
		static boolean matchingPassword(String id, int password) {
			
			if(password == info.get(id)) { 
				
				return true;}
			else { 
				
				return false;}
		}

		static boolean checkingId(String id) {
			if(info.containsKey(id)) {
				return true;
			}
			return false;
		}
	}
