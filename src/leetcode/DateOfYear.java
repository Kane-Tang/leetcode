package leetcode;

public class DateOfYear {

	public DateOfYear() {
		// TODO Auto-generated constructor stub
	}

	public int dayOfYear(String date) {
		String[] data = date.split("-");
		int year = Integer.parseInt(data[0]);
		int month = Integer.parseInt(data[1]);
		int day = Integer.parseInt(data[2]);
		int ans = 0;
		if (month == 1)
			return day;
		else {
			for (int i = 1; i < month; i++)
				switch (i) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					ans += 31;
					break;
				case 2:
					if ((year % 4 == 0) && (year % 100 != 0))
						ans += 29;
					else
						ans += 28;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					ans += 30;
					break;
				default:
					break;
				}
			ans += day;
		}
		return ans;
	}
}
