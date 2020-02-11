package leetcode;

import java.util.Arrays;
import java.util.Comparator;

import javafx.util.Pair;

public class WardInRiver {
	public static void main(String[] args) {
		int n = 10;
		int l = 5;
		Pair[] all = new Pair[n];
		for (int i = 0; i < n; i++) {

		}
		// sort by left value, then traverse by right value counted by
		Arrays.sort(all, new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				if ((int) a.getKey() == (int) b.getKey()) {
					return (int) a.getValue() - (int) b.getValue();
				} else {
					return (int) a.getKey() - (int) b.getKey();
				}
			}
		});
		if ((int) all[0].getKey() > 0) {
			System.out.println(-1);
			return;
		} else {
			int right = 0;
			int pos = 0;
			int max_len = 0;
			int ans = 0;
			while (true) {
				if (right >= l) {
					break;
				}
				for (int i = pos; i < n; i++) {
					if ((int) all[i].getKey() <= right && (int) all[i].getValue() > max_len) {
						pos = i;
						max_len = (int)all[i].getValue();
					}
					if((int)all[i].getKey() > right) {
						break;
					}
				}
				if(max_len == right) {
					System.out.println(-1);
					return;
				}
				right = max_len;
				ans++;
			}
			System.out.println(ans);
		}
	}
}

//int main(){
//	cin>>n>>l;for(
//	int i = 0;i<n;++i){
//        cin>>arg[i].l>>arg[i].r;
//    }
//	sort(arg, arg+n);
//    if(arg[0].l>0){
//        cout<<-1<<endl;
//        return 0;
//    }
//    int right = 0, pos = 0, max_len = 0;
//    int ans=0;
//    while(true){
//        if(right >= l){
//            break;
//        }
//        for(int i=pos;i<n;++i){
//            if(arg[i].l<=right && arg[i].r > max_len){
//                pos = i;
//                max_len = arg[i].r;
//            }
//            if(arg[i].l>right){
//                break;
//            }
//        }
//        if(max_len == right){
//            cout<<-1<<endl;
//            return 0;
//        }
//        right = max_len;
//        ++ans;
//    }
// 
//    cout<<ans<<endl;
//}
