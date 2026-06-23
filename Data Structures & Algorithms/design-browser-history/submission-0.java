class BrowserHistory {
    private String[] history;
    private int currentIndex;
    private int maxIndex;

    public BrowserHistory(String homepage) {
        history = new String[5005];
        history[0] = homepage;
        currentIndex = 0;
        maxIndex = 0;
    }
    
    public void visit(String url) {
        currentIndex++;
        history[currentIndex] = url;
        maxIndex = currentIndex;
    }
    
    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history[currentIndex];
    }
    
    public String forward(int steps) {
        currentIndex = Math.min(maxIndex, currentIndex + steps);
        return history[currentIndex];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */