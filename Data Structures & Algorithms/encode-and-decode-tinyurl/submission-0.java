class Solution {
    private Map<String, String> urls = new HashMap<>();
    private int next = 0;
    public String encode(String longUrl) {
        String shortUrl = "https://tiny.url/" + (++next);
        urls.put(shortUrl, longUrl);
        return shortUrl;
    }
    public String decode(String shortUrl) {
        return urls.get(shortUrl);
    }
}
