package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodeURL {
	
	private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final String BASE = "http://tinyurl.com/";

    private static Map<String, String> keyToURL = new HashMap<>();
    private static Map<String, String> urlToKey = new HashMap<>();
	public EncodeURL() {
		// TODO Auto-generated constructor stub
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (longUrl == null || longUrl.isEmpty()) {
            return null;
        }
        if (urlToKey.containsKey(longUrl)) {
            return BASE + urlToKey.get(longUrl);
        }

        StringBuilder key = null;

        // keep generating keys until a unique one is found
        do {
            key = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int)(Math.random() * SEED.length());
                key.append(SEED.charAt(r));
            }
        } while (keyToURL.containsKey(key));

        keyToURL.put(key.toString(), longUrl);
        urlToKey.put(longUrl, key.toString());

        return BASE + key;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		if (shortUrl == null || shortUrl.isEmpty()) {
            return "";
        }
        String[] shortUrlSplits = shortUrl.split("/");
        return keyToURL.get(shortUrlSplits[shortUrlSplits.length - 1]);
	}
}
//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.decode(codec.encode(url));