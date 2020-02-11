package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public TextJustification() {
		// TODO Auto-generated constructor stub
	}

	List<String> res = new ArrayList();
//	public List<String> fullJustify(String[] words, int maxWidth) {
//		buildText(words, 0, maxWidth);
//		return res;
//	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
        //List<String> res = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            int len = 0;
            List<String> mid = new ArrayList<>();
            while (i < words.length && 
                    (len+mid.size()+words[i].length()) <= maxWidth) {
                mid.add(words[i]); len += words[i].length(); ++i;
            }
            if (i == words.length || mid.size() <= 1) {
                // last line or one String line
                StringBuilder line = new StringBuilder();
                for (int k = 0; k < mid.size()-1; k++) {
                    line.append(mid.get(k)); line.append(' ');
                }
                line.append(mid.get(mid.size()-1));
                int space = maxWidth-line.length();
                for (int k = 0; k < space; k++) line.append(' ');
                res.add(line.toString());
                if (i == words.length) break;
            } else {
                // lines
                StringBuilder line = new StringBuilder();
                int space = (maxWidth-len)/(mid.size()-1);
                int evenl = (maxWidth-len)%(mid.size()-1);
                for (int k = 0; k < mid.size()-1; k++) {
                    line.append(mid.get(k));
                    for (int h = 0; h < space; h++) line.append(' ');
                    if (evenl > 0) { line.append(' '); --evenl; }
                }
                line.append(mid.get(mid.size()-1));
                res.add(line.toString());
            }
            --i;
        }
        
        return res;
    }
	
	public void buildText(String[] words, int index, int max) {
		if(index >= words.length) {
			String word = res.remove(res.size()-1);
			int count = word.length();
			while(count < max) {
				word += " ";
				count++;
			}
			res.add(word);
			return;
		}
		if(res.size() == 0) {
			String tmp = words[index];
			res.add(tmp);
			buildText(words, index+1, max);
		}else {
			String tmp = res.get(res.size()-1);
			if(max-tmp.length() > words[index].length()) {
				//the current line can hold it
				String s = res.remove(res.size()-1);
				s += " ";
				s += words[index];
				res.add(s);
				buildText(words, index+1, max);
			}else {
				//deal with the space
				String s = res.remove(res.size()-1);
				String[] word = s.split(" ");
				int l = word.length;
				if(l > 1) {
					int space = (max-s.length()+l-1)/(l-1);
					int evenl = (max-s.length()+l-1)%(l-1);
					StringBuilder line = new StringBuilder();
					for(int i=0;i<l-1;i++) {
						line.append(word[i]);
						for(int j=0;j<space;j++) {
							line.append(" ");
						}
						if(evenl > 0) {
							line.append(" ");
							evenl--;
						}
					}
					line.append(word[l-1]);
					res.add(line.toString());
				}else {
					int wordl = s.length();
					while(wordl < max) {
						s += " ";
						wordl++;
					}
					res.add(s);
				}

				res.add(words[index]);
				buildText(words, index+1, max);
			}
		}
		return;
	}
}
